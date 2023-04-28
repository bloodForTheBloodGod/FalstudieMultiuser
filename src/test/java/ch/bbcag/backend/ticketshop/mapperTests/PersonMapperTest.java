package ch.bbcag.backend.ticketshop.mapperTests;


import ch.bbcag.backend.ticketshop.person.Person;
import ch.bbcag.backend.ticketshop.person.PersonMapper;
import ch.bbcag.backend.ticketshop.person.PersonRequestDTO;
import ch.bbcag.backend.ticketshop.person.PersonResponseDTO;
import ch.bbcag.backend.ticketshop.util.DataDTOUtil;
import ch.bbcag.backend.ticketshop.util.DataUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PersonMapperTest {
    @Test
    public void toDTO_isWorking() {
        Person person = DataUtil.getTestPerson();
        PersonResponseDTO personResponseDTO = DataDTOUtil.getTestPersonResponseDTO();

        PersonResponseDTO actual = PersonMapper.toDTO(person);
        assertEquals( personResponseDTO, actual);
    }

    @Test
    public void fromDTO_isWorking() {
        Person expected = DataUtil.getTestPerson();
        PersonRequestDTO personRequestDTO = DataDTOUtil.getTestPersonRequestDTO();

        Person actual = PersonMapper.fromDTO(personRequestDTO);
        assertEquals(expected.getPassword(), actual.getPassword());
        assertEquals(actual.getEmail(), expected.getEmail());
    }
}