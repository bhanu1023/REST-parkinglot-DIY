package com.example.parkinglot.repositories;

import com.example.parkinglot.models.Ticket;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TicketRepository {
    private Map<Long, Ticket> tickets = new HashMap<>();
    private Long idSequence = 0L;
    public Ticket save(Ticket ticket){
        idSequence++;
        ticket.setId(idSequence);
        tickets.put(idSequence, ticket);

        return ticket;
    }

    public List<Ticket> getAll(){
        return new ArrayList<>(tickets.values());
    }
}
