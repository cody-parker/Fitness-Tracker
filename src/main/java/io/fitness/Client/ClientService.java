package io.fitness.Client;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ClientService {

    List<Client> clients = new ArrayList<>(Arrays.asList(
            new Client("Cody", "Parker", "5'9\"", 180),
                new Client("Donald", "McFarland", "5'10\"", 208),
                new Client("test", "test", "5'9\"", 190)
        ));

    public List<Client> getAllClients(){
        return clients;
    }

    public Client getClient(String id){
        return clients.stream().filter(c -> c.getId() == id).findFirst().get();
    }

    public void addClient(Client client){
        clients.add(client);
    }

    public void updateClient(String id, Client client) {
        for(int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getId() == id) {
                clients.set(i, client);
                return;
            }
        }
    }

    public void removeClient(String id) {
        clients.removeIf(c -> c.getId() == id);
    }
}
