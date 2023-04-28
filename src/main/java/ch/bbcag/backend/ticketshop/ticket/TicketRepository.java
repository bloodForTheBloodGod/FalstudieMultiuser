package ch.bbcag.backend.ticketshop.ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketRepository extends JpaRepository <Ticket, Integer> {

    List<Ticket> findByNameContains(String name);

    @Query("SELECT t FROM Ticket t WHERE t.amount > 0")
    List<Ticket> findAllUnsold();
}
