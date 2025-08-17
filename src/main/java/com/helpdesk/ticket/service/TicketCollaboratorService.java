package com.helpdesk.ticket.service;

import com.helpdesk.ticket.dto.TicketCollaboratorDto;

import java.util.List;

public interface TicketCollaboratorService {
    TicketCollaboratorDto addCollaborator(TicketCollaboratorDto dto);
    List<TicketCollaboratorDto> getCollaboratorsByTicketId(Long ticketId);
}
