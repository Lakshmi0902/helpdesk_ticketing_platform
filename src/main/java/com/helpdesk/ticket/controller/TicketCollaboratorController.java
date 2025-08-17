package com.helpdesk.ticket.controller;


import com.helpdesk.ticket.dto.TicketCollaboratorDto;
import com.helpdesk.ticket.service.TicketCollaboratorService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/collaborators")
@RequiredArgsConstructor
public class TicketCollaboratorController {

    private final TicketCollaboratorService collaboratorService;

    @PostMapping
    public ResponseEntity<TicketCollaboratorDto> addCollaborator(@RequestBody TicketCollaboratorDto dto) {
        return ResponseEntity.ok(collaboratorService.addCollaborator(dto));
    }

    @GetMapping("/ticket/{ticketId}")
    public ResponseEntity<List<TicketCollaboratorDto>> getCollaboratorsByTicket(@PathVariable Long ticketId) {
        return ResponseEntity.ok(collaboratorService.getCollaboratorsByTicketId(ticketId));
    }
}

