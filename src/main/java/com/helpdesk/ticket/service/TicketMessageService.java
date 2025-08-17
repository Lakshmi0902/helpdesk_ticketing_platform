package com.helpdesk.ticket.service;


import com.helpdesk.ticket.dto.TicketMessageDto;

import java.util.List;

public interface TicketMessageService {
    List<TicketMessageDto> getMessagesByTicketId(Long ticketId);
}

