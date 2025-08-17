package com.helpdesk.ticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.helpdesk.ticket.entity.CollaboratorId;
import com.helpdesk.ticket.entity.TicketCollaborator;

@Repository
public interface TicketCollaboratorRepository extends JpaRepository<TicketCollaborator, CollaboratorId> {
	List<TicketCollaborator> findByTicketId(Long ticketId);
}