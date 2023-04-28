package ch.bbcag.backend.ticketshop.event;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public EventDTO create(EventDTO eventDTO) {
        Event event = new Event();
        return EventMapper.toDTO(eventRepository.save(event));
    }

    public EventDTO update(EventDTO eventDTO, Integer id) {
        Event existing = eventRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        return EventMapper.toDTO(eventRepository.save(existing));
    }

    public List<EventDTO> findAll() {
        return eventRepository.findAll().stream().map(EventMapper::toDTO).toList();
    }

    public EventDTO findById(Integer id) {
        return EventMapper.toDTO(eventRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    public void deleteById(Integer id) {
        eventRepository.deleteById(id);
    }
}