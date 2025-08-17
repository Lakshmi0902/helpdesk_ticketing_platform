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
public class TicketMessageDto {
    private Long id;
    private Long ticketId;
    private String sender;
    private String content;
    private LocalDateTime sentAt;
    
}
