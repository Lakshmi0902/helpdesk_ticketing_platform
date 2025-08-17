package com.helpdesk.ticket.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketCollaboratorDto {
    private Long ticketId;
    private String username;
    private LocalDateTime lastSeen;
}
