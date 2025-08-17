package com.helpdesk.ticket.service;


import com.helpdesk.ticket.dto.TicketEventDto;

import java.util.List;

public interface TicketEventService {
    TicketEventDto logEvent(TicketEventDto dto);
    List<TicketEventDto> getEventsByTicketId(Long ticketId);
}

