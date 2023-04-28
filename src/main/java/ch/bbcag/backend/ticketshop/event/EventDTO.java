package ch.bbcag.backend.ticketshop.event;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class EventDTO {

    private String name;

    private String description;

    private List<Integer> ticketIds;

    private Integer id;

    private Date date;

    private Integer ownerId;

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

    public List<Integer> getTicketIds() {
        return ticketIds;
    }

    public void setTicketIds(List<Integer> ticketIds) {
        this.ticketIds = ticketIds;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EventDTO eventDTO)) return false;
        return Objects.equals(getName(), eventDTO.getName()) && Objects.equals(getDescription(), eventDTO.getDescription()) && Objects.equals(getTicketIds(), eventDTO.getTicketIds()) && Objects.equals(getId(), eventDTO.getId()) && Objects.equals(getDate(), eventDTO.getDate()) && Objects.equals(getOwnerId(), eventDTO.getOwnerId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), getTicketIds(), getId(), getDate(), getOwnerId());
    }
}
