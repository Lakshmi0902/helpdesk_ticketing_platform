package com.helpdesk.ticket.controller;


import com.helpdesk.ticket.dto.TicketEventDto;
import com.helpdesk.ticket.service.TicketEventService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class TicketEventController {

    private final TicketEventService eventService;

    @PostMapping
    public ResponseEntity<TicketEventDto> logEvent(@RequestBody TicketEventDto dto) {
        return ResponseEntity.ok(eventService.logEvent(dto));
    }

    @GetMapping("/ticket/{ticketId}")
    public ResponseEntity<List<TicketEventDto>> getEventsByTicket(@PathVariable Long ticketId) {
        return ResponseEntity.ok(eventService.getEventsByTicketId(ticketId));
    }
}
