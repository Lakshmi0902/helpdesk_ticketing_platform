package com.helpdesk.ticket.mapper;

import com.helpdesk.ticket.dto.*;
import com.helpdesk.ticket.entity.*;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    TicketDto toDto(Ticket ticket);
    Ticket toEntity(TicketDto dto);

    TicketEventDto toDto(TicketEvent event);
    TicketEvent toEntity(TicketEventDto dto);

    TicketCollaboratorDto toDto(TicketCollaborator collaborator);
    TicketCollaborator toEntity(TicketCollaboratorDto dto);

    List<TicketDto> toDtoList(List<Ticket> tickets);
    List<TicketEventDto> toEventDtoList(List<TicketEvent> events);
    List<TicketCollaboratorDto> toCollaboratorDtoList(List<TicketCollaborator> collaborators);
}
