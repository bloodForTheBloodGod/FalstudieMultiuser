package ch.bbcag.backend.ticketshop.ticket;


import ch.bbcag.backend.ticketshop.event.Event;

public class TicketMapper {
    public static TicketDTO toDTO(Ticket ticket) {

        TicketDTO dto = new TicketDTO();
        dto.setId(ticket.getId());
        dto.setName(ticket.getName());
        dto.setDescription(ticket.getDescription());
        dto.setAmount(ticket.getAmount());
        dto.setEventId(ticket.getEvent().getId());

        return dto;

    }

    public static Ticket fromDTO(TicketDTO dto) {

        Ticket ticket = new Ticket();
        ticket.setName(dto.getName());
        ticket.setDescription(dto.getDescription());
        ticket.setAmount(dto.getAmount());
        Event event = new Event();
        event.setId(dto.getEventId());
        ticket.setEvent(event);

        return ticket;
    }

}
