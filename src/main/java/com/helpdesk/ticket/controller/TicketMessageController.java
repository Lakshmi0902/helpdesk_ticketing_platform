package com.helpdesk.ticket.controller;

import com.helpdesk.ticket.dto.TicketMessageDto;
import com.helpdesk.ticket.service.TicketMessageService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class TicketMessageController {

    private final TicketMessageService messageService;

    @GetMapping("/ticket/{ticketId}")
    public ResponseEntity<List<TicketMessageDto>> getMessagesByTicket(@PathVariable Long ticketId) {
        return ResponseEntity.ok(messageService.getMessagesByTicketId(ticketId));
    }
}
