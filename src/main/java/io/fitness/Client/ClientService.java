package io.fitness.Client;

import io.fitness.Macros.MacrosExtras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    List<Client> clients = new ArrayList<>(Arrays.asList(
            new Client("Cody", "Parker", "5'9", 180, 26, ClientExtras.MALE, MacrosExtras.MODERATE),
                new Client("Donald", "McFarland", "5'10", 208, 38, ClientExtras.MALE, MacrosExtras.EXTREME),
                new Client("test", "test", "6'", 190, 32, ClientExtras.FEMALE, "test")
        ));

    public List<Client> getAllClients(){
        return (List<Client>) clientRepository.findAll();
    }

    public Client getClient(String id){
        return clients.stream().filter(c -> c.getId().equalsIgnoreCase(id)).findFirst().get();
    }

    public Response addClient(Client client){
        if(client == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else if(client.getFirstName() == null || client.getFirstName().length() < 1){
            //missing first name
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else if(client.getLastName() == null || client.getLastName().length() < 1){
            //missing last name
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        clients.add(client);
        return Response.status(Response.Status.OK).build();
    }

    public Response updateClient(String id, Client client) {
        for(int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getId().equalsIgnoreCase(id)) {
                clients.set(i, client);
                return Response.status(Response.Status.OK).build();
            }
        }
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    public boolean removeClient(String id) {
        return clients.removeIf(c -> c.getId().equalsIgnoreCase(id));
    }
}
