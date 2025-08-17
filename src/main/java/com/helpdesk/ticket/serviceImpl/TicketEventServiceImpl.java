package com.helpdesk.ticket.serviceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.helpdesk.ticket.dto.TicketEventDto;
import com.helpdesk.ticket.entity.TicketEvent;
import com.helpdesk.ticket.mapper.TicketMapper;
import com.helpdesk.ticket.repository.TicketEventRepository;
import com.helpdesk.ticket.service.TicketEventService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketEventServiceImpl implements TicketEventService {

    private final TicketEventRepository eventRepository;
    private final TicketMapper mapper;

    @Override
    public TicketEventDto logEvent(TicketEventDto dto) {
        TicketEvent event = mapper.toEntity(dto);
        event.setEventTime(LocalDateTime.now());
        return mapper.toDto(eventRepository.save(event));
    }

    @Override
    public List<TicketEventDto> getEventsByTicketId(Long ticketId) {
        return mapper.toEventDtoList(eventRepository.findByTicketId(ticketId));
    }
}
