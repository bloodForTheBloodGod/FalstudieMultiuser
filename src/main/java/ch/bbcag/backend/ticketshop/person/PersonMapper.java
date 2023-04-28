package ch.bbcag.backend.ticketshop.person;


import ch.bbcag.backend.ticketshop.event.Event;
import ch.bbcag.backend.ticketshop.person.Person;
import ch.bbcag.backend.ticketshop.person.PersonResponseDTO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PersonMapper {

    public static PersonResponseDTO toDTO(Person person) {
        PersonResponseDTO personResponseDTO = new PersonResponseDTO();
        personResponseDTO.setId(person.getId());
        personResponseDTO.setEmail(person.getEmail());


        if (person.getEvents() != null) {
            List<Integer> eventIds = person
                    .getEvents()
                    .stream()
                    .map(Event::getId)
                    .toList();

            personResponseDTO.setEventIds(eventIds);
        }

        return personResponseDTO;

    }

    public static Person fromDTO(PersonRequestDTO personRequestDTO) {
        Person person = new Person();

        person.setEmail(personRequestDTO.getEmail());
        person.setPassword(personRequestDTO.getPassword());
        person.setId(personRequestDTO.getId());

        Set<Event> events = new HashSet<Event>();

        for (int i = 1; i <= 3; i++) {
            Event event = new Event();
            event.setId(i);
            events.add(event);
        }

        person.setEvents(events);

        return person;
    }
}










