package io.ticket.sales.api.controllers.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Component
public interface TicketRepository extends CrudRepository<Ticket, Integer> {
    Iterable<Ticket> findByCreatedByUserId(int createdByUserId);
}
