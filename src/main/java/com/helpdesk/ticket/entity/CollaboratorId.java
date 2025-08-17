package com.helpdesk.ticket.entity;


import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CollaboratorId implements Serializable {
    private Long ticketId;
    private String username;
}