package io.fitness.Client;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ClientService {

    List<Client> clients = new ArrayList<>(Arrays.asList(
            new Client(1, "Cody Parker", "5'9\"", 180),
                new Client(2, "Donald McFarland", "5'10\"", 208),
                new Client(3, "test test", "5'9\"", 190)
        ));

    public List<Client> getAllClients(){
        return clients;
    }

    public Client getClient(int id){
        return clients.stream().filter(c -> c.getId() == id).findFirst().get();
    }

    public void addClient(Client client){
        clients.add(client);
    }

    public void updateClient(int id, Client client) {
        for(int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getId() == id) {
                clients.set(i, client);
                return;
            }
        }
    }

    public void removeClient(int id) {
        clients.removeIf(c -> c.getId() == id);
    }
}
