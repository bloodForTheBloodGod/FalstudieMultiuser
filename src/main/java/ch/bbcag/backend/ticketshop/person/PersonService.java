package ch.bbcag.backend.ticketshop.person;

import ch.bbcag.backend.ticketshop.event.Event;
import ch.bbcag.backend.ticketshop.event.EventDTO;
import ch.bbcag.backend.ticketshop.event.EventMapper;
import ch.bbcag.backend.ticketshop.event.EventRepository;
import ch.bbcag.backend.ticketshop.security.AuthRequestDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PersonService {


    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonResponseDTO findById(Integer id) {
        return PersonMapper.toDTO(personRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }
//    public boolean existsByEmail(String mail) {
//        return null;
//    }

    public PersonResponseDTO create(AuthRequestDTO authRequestDTO) {
        Person person = new Person();
        return PersonMapper.toDTO(personRepository.save(person));
    }

    public PersonResponseDTO update(PersonRequestDTO personRequestDTO, Integer id) {
        Person existing = personRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        existing.setPassword(personRequestDTO.getPassword());
        existing.setEmail(personRequestDTO.getEmail());


        return PersonMapper.toDTO(personRepository.save(existing));
    }



    public Person findByEmail(String email) throws EntityNotFoundException {
        Person person = (Person) personRepository.findPersonByEmail(email);
        if (person == null) {
            throw new EntityNotFoundException("Person with email " + email + " not found");
        }
        return person;
    }


    public boolean existsByEmail(String mail) {
        return personRepository.existsByEmail(mail);
    }


}
