package com.example.parkinglot.services;

import com.example.parkinglot.exceptions.SpotNotFoundException;
import com.example.parkinglot.models.Ticket;
import com.example.parkinglot.models.Vehicle;
import com.example.parkinglot.models.VehicleType;
import com.example.parkinglot.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TicketService {
    TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }
    public Ticket generateTicket(String vehiclenumber, VehicleType vehicleType, long gateId) throws SpotNotFoundException {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleType(vehicleType);
        vehicle.setVehiclenumber(vehiclenumber);

        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());
        ticket.setVehicle(vehicle);

        this.ticketRepository.save(ticket);
        return ticket;
    }

    public List<Ticket> getTickets() {
        return this.ticketRepository.getAll();
    }
}
