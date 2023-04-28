package ch.bbcag.backend.ticketshop.mapperTests;


import ch.bbcag.backend.ticketshop.event.Event;
import ch.bbcag.backend.ticketshop.event.EventDTO;
import ch.bbcag.backend.ticketshop.event.EventMapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import ch.bbcag.backend.ticketshop.event.Event;
import ch.bbcag.backend.ticketshop.event.EventDTO;
import ch.bbcag.backend.ticketshop.event.EventMapper;
import ch.bbcag.backend.ticketshop.util.DataDTOUtil;
import ch.bbcag.backend.ticketshop.util.DataUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventMapperTest {
    @Test
    public void toDTO_isWorking() {
        Event event = DataUtil.getTestEvent();
        EventDTO expected = DataDTOUtil.getTestEventDTO();

        EventDTO actual = EventMapper.toDTO(event);


        assertEquals(expected, actual);
    }

    @Test
    public void fromDTO_isWorking() {
        Event expected = DataUtil.getTestEvent();
        EventDTO eventDTO = DataDTOUtil.getTestEventDTO();

        Event actual = EventMapper.fromDTO(eventDTO);
        assertEquals(actual.getName(), expected.getName());
        assertEquals(actual.getDescription(), expected.getDescription());
        assertEquals(expected.getDate(), actual.getDate());
        assertEquals(actual.getOwner(), expected.getOwner());


    }
}