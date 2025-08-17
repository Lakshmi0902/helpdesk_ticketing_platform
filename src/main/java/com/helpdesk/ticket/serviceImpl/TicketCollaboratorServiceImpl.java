package com.helpdesk.ticket.serviceImpl;


import com.helpdesk.ticket.dto.TicketCollaboratorDto;
import com.helpdesk.ticket.entity.TicketCollaborator;
import com.helpdesk.ticket.mapper.TicketMapper;
import com.helpdesk.ticket.repository.TicketCollaboratorRepository;
import com.helpdesk.ticket.service.TicketCollaboratorService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketCollaboratorServiceImpl implements TicketCollaboratorService {

    private final TicketCollaboratorRepository collaboratorRepository;
    private final TicketMapper mapper;

    @Override
    public TicketCollaboratorDto addCollaborator(TicketCollaboratorDto dto) {
        TicketCollaborator collaborator = mapper.toEntity(dto);
        collaborator.setLastSeen(LocalDateTime.now());
        return mapper.toDto(collaboratorRepository.save(collaborator));
    }

    @Override
    public List<TicketCollaboratorDto> getCollaboratorsByTicketId(Long ticketId) {
        return mapper.toCollaboratorDtoList(collaboratorRepository.findByTicketId(ticketId));
    }
}

