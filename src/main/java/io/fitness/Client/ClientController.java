package io.fitness.Client;

import io.fitness.Macros.Macros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;
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
    public Client getClient(@PathVariable String id){
        return clientService.getClient(id);
    }

    @RequestMapping(method=RequestMethod.POST, value="/Clients")
    public void addClient(Client client){
        clientService.addClient(client);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/Clients/{id}")
    public void updateClient(@PathVariable String id,  Client client){
        clientService.updateClient(id, client);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/Clients/{id}")
    public Response removeClient(@PathVariable String id){
        if(clientService.removeClient(id)) {
            return Response.status(Response.Status.OK).build();
        }
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
