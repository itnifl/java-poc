package io.ticket.sales.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.ticket.sales.api.controllers.entities.Ticket;
import io.ticket.sales.api.controllers.entities.TicketRepository;
import io.ticket.sales.config.GlobalConstants;
import io.ticket.sales.dto.TicketDto;

import javax.annotation.security.RolesAllowed;


@EnableWebSecurity
@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired // This means to get the bean called userRepository -- which is auto-generated by Spring, we will use it to handle the data
    private TicketRepository ticketRepository;

    @GetMapping(path="/all")
    @RolesAllowed({GlobalConstants.Roles.ADMIN, GlobalConstants.Roles.USER})
    public @ResponseBody Iterable<Ticket> GetTicket(Integer userId) {

        if(userId != null) {
            return ticketRepository.findByCreatedByUserId(userId);
        } else {
            return ticketRepository.findAll();
        }
    }

    
    @DeleteMapping
    @RolesAllowed({GlobalConstants.Roles.ADMIN, GlobalConstants.Roles.USER})
    public void DeleteTicket(Iterable<Integer> tickedId) {
         ticketRepository.deleteAllById(tickedId);
    }

    @PostMapping(path="/new")
    @RolesAllowed({GlobalConstants.Roles.USER})
    public void PostTicket(TicketDto ticket) {

        if(ticket != null) {
            Ticket ticketEntity = new Ticket();
            ticketEntity.setName(ticket.getName());
            ticketEntity.setPrice(ticket.Price);
            ticketEntity.setDescription(ticket.Description);
            ticketEntity.setCreatedByUserId(ticket.getSeller().getId());
            ticketRepository.save(ticketEntity);
        } 
    }

}
