package ch.bbcag.backend.ticketshop.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {
    private TicketRepository ticketRepository;


    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public TicketDTO create(TicketDTO ticketDTO) {
        return TicketMapper.toDTO(ticketRepository.save(TicketMapper.fromDTO(ticketDTO)));
    }


    public TicketDTO findById(Integer id) {
        return TicketMapper.toDTO(ticketRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }


    public List<TicketDTO> findAll() {
        return ticketRepository.findAll().stream().map(TicketMapper::toDTO).toList();
    }

    public void deleteById(Integer id) {
        ticketRepository.deleteById(id);
    }

    public TicketDTO update(TicketDTO ticketDTO, Integer id) {
        Ticket existing = ticketRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        mergeTicket(existing, TicketMapper.fromDTO(ticketDTO));
        return TicketMapper.toDTO(ticketRepository.save(existing));
    }


    public List<TicketDTO> findAllUnsold() {
        return ticketRepository.findAllUnsold().stream().map(TicketMapper::toDTO).toList();
    }


    private void mergeTicket(Ticket existing, Ticket changing) {
        if (changing.getAmount() >= 0) {
            existing.setAmount(changing.getAmount());
        } else {
            throw new DataIntegrityViolationException("Amount must be greater than 0");
        }

        if (changing.getName() != null) {
            existing.setName(changing.getName());
        }

        if (changing.getDescription() != null) {
            existing.setDescription(changing.getDescription());
        }

        if (changing.getEvent() != null) {
            existing.setEvent(changing.getEvent());
        }
    }


    private void mergeTickets(List<Ticket> existingTickets, List<Ticket> changingTickets) {
        for (Ticket changingTicket : changingTickets) {
            Integer id = changingTicket.getId();
            Ticket existingTicket = existingTickets.stream()
                    .filter(ticket -> ticket.getId() == id)
                    .findFirst()
                    .orElseThrow(EntityNotFoundException::new);
            changingTicket.setAmount(existingTicket.getAmount() - changingTicket.getAmount());
            mergeTicket(existingTicket, changingTicket);
        }
    }


    public List<TicketDTO> buy(List<TicketDTO> ticketDTOs) {
        List<Integer> ticketIds = ticketDTOs.stream().map(TicketDTO::getId).collect(Collectors.toList());
        List<Ticket> tickets = ticketDTOs.stream().map(TicketMapper::fromDTO).collect(Collectors.toList());
        List<Ticket> foundTickets = ticketRepository.findAllById(ticketIds);

        if (foundTickets.size() < tickets.size()) {
            throw new EntityNotFoundException("Ticket not founded");
        }

        mergeTickets(foundTickets, tickets);
        List<Ticket> changedTickets = ticketRepository.saveAll(tickets);
        return changedTickets.stream().map(TicketMapper::toDTO).collect(Collectors.toList());
    }
}