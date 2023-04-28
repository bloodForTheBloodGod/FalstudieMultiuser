package ch.bbcag.backend.ticketshop.ticket;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class TicketDTO {
    @NotNull
    private Integer eventId;

    private Integer amount;

    private String name;

    private String description;
    @NotNull
    private Integer id;

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(o instanceof TicketDTO ticketDTO)) return false;
        return Objects.equals(getEventId(), ticketDTO.getEventId()) && Objects.equals(getAmount(), ticketDTO.getAmount()) && Objects.equals(getName(), ticketDTO.getName()) && Objects.equals(getDescription(), ticketDTO.getDescription()) && Objects.equals(getId(), ticketDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEventId(), getAmount(), getName(), getDescription(), getId());
    }
}
