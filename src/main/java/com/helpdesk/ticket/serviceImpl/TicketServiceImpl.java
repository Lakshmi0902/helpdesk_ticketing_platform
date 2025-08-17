package com.helpdesk.ticket.serviceImpl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.helpdesk.ticket.dto.TicketDto;
import com.helpdesk.ticket.dto.TicketMessageDto;
import com.helpdesk.ticket.entity.Ticket;
import com.helpdesk.ticket.entity.TicketMessage;
import com.helpdesk.ticket.entity.TicketStatus;
import com.helpdesk.ticket.mapper.TicketMapper;
import com.helpdesk.ticket.repository.TicketEventRepository;
import com.helpdesk.ticket.repository.TicketMessageRepository;
import com.helpdesk.ticket.repository.TicketRepository;
import com.helpdesk.ticket.service.TicketService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepo;
    private final TicketMessageRepository messageRepo;
    private final TicketEventRepository eventRepo;
    private final TicketMapper mapper;
    private final SimpMessagingTemplate ws;

    @Override
    public TicketDto createTicket(TicketDto dto) {
        Ticket ticket = mapper.toEntity(dto);
        ticket.setStatus(TicketStatus.OPEN);
        Ticket saved = ticketRepo.save(ticket);
        ws.convertAndSend("/topic/tickets", mapper.toDto(saved));
        return mapper.toDto(saved);
    }

    @Override
    public TicketDto updateTicket(Long id, TicketDto dto) {
        Ticket ticket = ticketRepo.findById(id).orElseThrow();
        ticket.setTitle(dto.getTitle());
        ticket.setDescription(dto.getDescription());
        ticket.setStatus(TicketStatus.valueOf(dto.getStatus()));
        ticket.setAssignee(dto.getAssignee());
        Ticket saved = ticketRepo.save(ticket);
        ws.convertAndSend("/topic/tickets/" + id, mapper.toDto(saved));
        return mapper.toDto(saved);
    }

    @Override
    public void sendMessage(Long ticketId, String sender, String content) {
        Ticket ticket = ticketRepo.findById(ticketId).orElseThrow();

        TicketMessage msg = TicketMessage.builder()
            .ticket(ticket)
            .sender(sender)
            .content(content)
            .build();

        messageRepo.save(msg);


        TicketMessageDto mDto = new TicketMessageDto();
        mDto.setId(msg.getId());
        mDto.setContent(msg.getContent());
        mDto.setSender(msg.getSender());

        ws.convertAndSend("/topic/tickets/" + ticketId + "/messages", mDto);
    }


    @Override
    public List<TicketDto> listTickets() {
        return ticketRepo.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public TicketDto getTicket(Long id) {
        return mapper.toDto(ticketRepo.findById(id).orElseThrow());
    }

    @Override
    public void deleteTicket(Long id) {
        if (!ticketRepo.existsById(id)) throw new NoSuchElementException("Ticket not found");
        ticketRepo.deleteById(id);
        ws.convertAndSend("/topic/tickets/deleted", id);
    }
    
    @Override
    public TicketDto getTicketWithMessages(Long ticketId) {
        Ticket ticket = ticketRepo.findById(ticketId)
            .orElseThrow();

        TicketDto dto = mapper.toDto(ticket);

        List<TicketMessage> messages = messageRepo.findByTicketId(ticketId);

        
        List<TicketMessageDto> messageDtos = messages.stream()
            .map(msg -> {
                TicketMessageDto mDto = new TicketMessageDto();
                mDto.setId(msg.getId());
                mDto.setContent(msg.getContent());
                mDto.setSender(msg.getSender());
                return mDto;
            })
            .collect(Collectors.toList());

        dto.setMessages(messageDtos);

        return dto;
    }


}