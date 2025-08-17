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
public class TicketEventDto {
    private Long id;
    private Long ticketId;
    private String eventType;
    private String performedBy;
    private String eventData;
    private LocalDateTime eventTime;
}

