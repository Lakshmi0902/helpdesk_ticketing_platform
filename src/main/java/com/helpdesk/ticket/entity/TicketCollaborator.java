package com.helpdesk.ticket.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ticket_collaborators", schema = "helpdesk")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(CollaboratorId.class)
public class TicketCollaborator {
    @Id
    private Long ticketId;

    @Id
    private String username;

    private LocalDateTime lastSeen = LocalDateTime.now();
}


