package com.helpdesk.ticket.service;

import java.util.List;

import com.helpdesk.ticket.dto.TicketDto;

public interface TicketService {
    TicketDto createTicket(TicketDto dto);
    TicketDto updateTicket(Long id, TicketDto dto);
    void sendMessage(Long ticketId, String sender, String content);

    List<TicketDto> listTickets();
    TicketDto getTicket(Long id);
    void deleteTicket(Long id);
    
    TicketDto getTicketWithMessages(Long ticketId);

}