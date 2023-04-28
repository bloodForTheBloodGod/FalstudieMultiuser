package ch.bbcag.backend.ticketshop.person;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Person {


    private String email;
    private String password;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    private Set<ch.bbcag.backend.ticketshop.event.Event> events = new HashSet<>();

    public Person() {
    }

    public Set<ch.bbcag.backend.ticketshop.event.Event> getEvents() {
        return events;
    }

    public void setEvents(Set<ch.bbcag.backend.ticketshop.event.Event> events) {
        this.events = events;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String passwort) {
        this.password = passwort;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Objects.equals(getId(), person.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


}
