package com.helpdesk.ticket.serviceImpl;

import com.helpdesk.ticket.dto.TicketMessageDto;
import com.helpdesk.ticket.entity.Ticket;
import com.helpdesk.ticket.entity.TicketMessage;
import com.helpdesk.ticket.mapper.TicketMapper;
import com.helpdesk.ticket.repository.TicketMessageRepository;
import com.helpdesk.ticket.service.TicketMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TicketMessageServiceImpl implements TicketMessageService {

    private final TicketMessageRepository messageRepository;
    private final TicketMapper mapper;

    @Override
    public List<TicketMessageDto> getMessagesByTicketId(Long ticketId) {
        List<TicketMessage> messages = messageRepository.findByTicketId(ticketId);
        return messages.stream().map(this::toDto).collect(Collectors.toList());
    }

    private TicketMessageDto toDto(TicketMessage message) {
        return TicketMessageDto.builder()
                .id(message.getId())
                .ticketId(message.getTicket() != null ? message.getTicket().getId() : null)
                .sender(message.getSender())
                .content(message.getContent())
                .sentAt(message.getSentAt())
                .build();
    }

    private TicketMessage toEntity(TicketMessageDto dto) {
        return TicketMessage.builder()
                .id(dto.getId())
                .ticket(dto.getTicketId() != null ? Ticket.builder().id(dto.getTicketId()).build() : null)
                .sender(dto.getSender())
                .content(dto.getContent())
                .sentAt(dto.getSentAt())
                .build();
    }
}
