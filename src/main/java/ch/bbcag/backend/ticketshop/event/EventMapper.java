package ch.bbcag.backend.ticketshop.event;



import ch.bbcag.backend.ticketshop.person.Person;
import ch.bbcag.backend.ticketshop.ticket.Ticket;

import java.net.Inet4Address;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class EventMapper {
    public static EventDTO toDTO(Event event) {

        EventDTO dto = new EventDTO();
        dto.setId(event.getId());
        dto.setName(event.getName());
        dto.setDescription(event.getDescription());
        dto.setDate(event.getDate());
        dto.setOwnerId(event.getOwner().getId());

        if (event.getTickets() != null) {
            List<Integer> ticketIds = event
                    .getTickets()
                    .stream()
                    .map(Ticket::getId)
                    .toList();
            dto.setTicketIds(ticketIds);
        }



        return dto;

    }

    public static Event fromDTO(EventDTO dto) {

        Person person = new Person();
        person.setId(dto.getOwnerId());

        String nme = dto.getName();


        Event event = new Event();
        event.setName(dto.getName());
        event.setDescription(dto.getDescription());
        event.setDate((Date) dto.getDate());
        event.setOwner(person);


// prozeduraler, imperativer Stil
        Set<Ticket> tickets = new HashSet<>();

        for (Integer id: dto.getTicketIds()
        ) {
            Ticket ticket = new Ticket();
            ticket.setId(id);
            tickets.add(ticket);
        }

// // funktionaler stil, macht das selbe
// Set<Ticket> tickets = dto.getTicketIds()
// .stream()
// .map(ticketId -> {
// Ticket ticket = new Ticket();
// ticket.setId(ticketId);
// return ticket;
// })
// .collect(Collectors.toSet());

        event.setTickets(tickets);


        return event;
    }


}