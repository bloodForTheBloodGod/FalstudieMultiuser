package ch.bbcag.backend.ticketshop.person;


import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    Person findPersonByEmail(String email);

    boolean existsByEmail(String mail);
}