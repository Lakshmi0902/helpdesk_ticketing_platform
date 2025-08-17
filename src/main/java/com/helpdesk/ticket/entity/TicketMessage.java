package com.helpdesk.ticket.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ticket_messages", schema = "helpdesk")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)  
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    private String sender;
    private String content;
    private LocalDateTime sentAt = LocalDateTime.now();
    
    @PrePersist
    public void prePersist() {
        this.sentAt  = LocalDateTime.now();
    }
    
}