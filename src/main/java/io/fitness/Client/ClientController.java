package io.fitness.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping("/Clients")
    public List<Client> getAllClients(){
        return clientService.getAllClients();
    }

    @RequestMapping("/Clients/{id}")
    public Client getClient(@PathVariable int id){
        return clientService.getClient(id);
    }

    @RequestMapping(method=RequestMethod.POST, value="/Clients")
    public void addClient(Client client){
        clientService.addClient(client);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/Clients/{id}")
    public void updateClient(@PathVariable int id,  Client client){
        clientService.updateClient(id, client);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/Clients/{id}")
    public void removeClient(@PathVariable int id){
        clientService.removeClient(id);
    }

    //set recommended macros automatically?

    //set custom macros in a put

    //create a page that shows total macros left in a day (tracking macros)

    //take into account desire to bulk/maintain/lose weight
}
