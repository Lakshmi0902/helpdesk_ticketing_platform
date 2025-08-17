package com.helpdesk.ticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.helpdesk.ticket.entity.TicketEvent;

@Repository
public interface TicketEventRepository extends JpaRepository<TicketEvent, Long> {
	 List<TicketEvent> findByTicketId(Long ticketId);
}
