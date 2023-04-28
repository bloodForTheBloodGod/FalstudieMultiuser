package ch.bbcag.backend.ticketshop.mapperTests;


import ch.bbcag.backend.ticketshop.ticket.Ticket;
import ch.bbcag.backend.ticketshop.ticket.TicketDTO;
import ch.bbcag.backend.ticketshop.ticket.TicketMapper;
import ch.bbcag.backend.ticketshop.util.DataUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketMapperTest {

    @Test
    public void testToDTO_DosExist() {
        Ticket ticket = DataUtil.getTestTicket();


        TicketDTO ticketDTO = TicketMapper.toDTO(ticket);

        Assertions.assertEquals(ticket.getId(), ticketDTO.getId());
        Assertions.assertEquals(ticket.getDescription(), ticketDTO.getDescription());
        Assertions.assertEquals(ticket.getName(), ticketDTO.getName());
    }


    @Test
    public void testFromDTO_DosExist() {
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setName("BobParty");

        ch.bbcag.backend.ticketshop.ticket.Ticket event = TicketMapper.fromDTO(ticketDTO);

        Assertions.assertEquals(ticketDTO.getName(), event.getName());
    }
}
