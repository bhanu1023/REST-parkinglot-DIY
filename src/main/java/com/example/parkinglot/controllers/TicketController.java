package com.example.parkinglot.controllers;

import com.example.parkinglot.dto.GenerateTicketRequestDto;
import com.example.parkinglot.dto.GenerateTicketResponseDto;
import com.example.parkinglot.dto.ResponseStatus;
import com.example.parkinglot.exceptions.SpotNotFoundException;
import com.example.parkinglot.models.Ticket;
import com.example.parkinglot.services.TicketService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketController {
    private TicketService ticketService;

    public  TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    @PostMapping("/generateticket")
    public GenerateTicketResponseDto generateTicket(@RequestBody GenerateTicketRequestDto generateTicketRequestDto){
        try {
//            System.out.println(generateTicketRequestDto.getVehicleNumber() + " " + generateTicketRequestDto.getVehicleType() + " " + generateTicketRequestDto.getGateid());

            Ticket ticket = ticketService.generateTicket(generateTicketRequestDto.getVehicleNumber(), generateTicketRequestDto.getVehicleType(), generateTicketRequestDto.getGateid());
            GenerateTicketResponseDto generateTicketResponseDto = new GenerateTicketResponseDto();
            generateTicketResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
            generateTicketResponseDto.setTicket(ticket);
            return generateTicketResponseDto;
        }catch (SpotNotFoundException exception){
            GenerateTicketResponseDto generateTicketResponseDto = new GenerateTicketResponseDto();
            generateTicketResponseDto.setResponseStatus(ResponseStatus.FAILURE);
            return generateTicketResponseDto;
        }

    }
    @GetMapping("/tickets")
    public List<Ticket> getTickets(){
        return ticketService.getTickets();
    }
}
