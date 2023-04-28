package ch.bbcag.backend.ticketshop.person;

import java.util.List;
import java.util.Objects;

public class PersonResponseDTO {
    private Integer id;

    private String email;

    private String passpord;

    private List<Integer> eventIds;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Integer> getEventIds() {
        return eventIds;
    }

    public void setEventIds(List<Integer> eventIds) {
        this.eventIds = eventIds;
    }

    public String getPasspord() {
        return passpord;
    }

    public void setPasspord(String passpord) {
        this.passpord = passpord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonResponseDTO that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getPasspord(), that.getPasspord()) && Objects.equals(getEventIds(), that.getEventIds());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmail(), getPasspord(), getEventIds());
    }
}
