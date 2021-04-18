package io.fitness.Client;

import io.fitness.Macros.Macros;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ClientService {

    List<Client> clients = new ArrayList<>(Arrays.asList(
            new Client("Cody", "Parker", "5'9", 180, 26, ClientExtras.MALE, ClientExtras.MODERATE),
                new Client("Donald", "McFarland", "5'10", 208, 38, ClientExtras.MALE, ClientExtras.EXTREME),
                new Client("test", "test", "6'", 190, 32, ClientExtras.FEMALE, "test")
        ));

    public List<Client> getAllClients(){
        return clients;
    }

    public Client getClient(String id){
        return clients.stream().filter(c -> c.getId().equalsIgnoreCase(id)).findFirst().get();
    }

    public Response addClient(Client client){
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

    public Response setClientRecommendedMacros(String id, String weightDesire) {
        Client client = clients.stream().filter(c -> c.getId().equalsIgnoreCase(id)).findFirst().get();

        if(client != null){
            double multiplier = 1.0;
            if(weightDesire.equalsIgnoreCase("lose")){
                multiplier = ClientExtras.LOSE_WEIGHT;
            } else if(weightDesire.equalsIgnoreCase("gain")){
                multiplier = ClientExtras.GAIN_WEIGHT;
            }

            client.setGoalMacros(calculateRecommendedMacros(client, multiplier));
            return Response.status(Response.Status.OK).entity(client).build();
        }
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    public Response setClientCustomMacros(String id, Macros macros){
        Client client = clients.stream().filter(c -> c.getId().equalsIgnoreCase(id)).findFirst().get();

        if(client != null){
            client.setGoalMacros(macros);
            return Response.status(Response.Status.OK).entity(client).build();
        }
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    public Response resetMacros(String id) {
        Client client = clients.stream().filter(c -> c.getId().equalsIgnoreCase(id)).findFirst().get();

        if(client != null){
            client.setDailyMacros(client.getGoalMacros());
            return Response.status(Response.Status.OK).entity(client).build();
        }
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    public Response updateDailyMacros(String id, Macros mealMacros){
        Client client = clients.stream().filter(c -> c.getId().equalsIgnoreCase(id)).findFirst().get();

        if(client != null){
            client.setDailyMacros(client.getDailyMacros().subtract(mealMacros));
            return Response.status(Response.Status.OK).entity(client).build();
        }
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    public Macros calculateRecommendedMacros(Client client, Double weightDesire){
        double calories = calculateRecommendedCalories(client.getGender(), client.getAge(), client.getWeight(), client.getHeight(), client.getActivityLevel()) * weightDesire;
        int carbs = (int) ((calories * .40)/ClientExtras.CARBS_CALORIES);
        int fats = (int) ((calories * .25)/ClientExtras.FATS_CALORIES);
        int protein = (int) ((calories * .35)/ClientExtras.PROTEIN_CALORIES);
        return new Macros((int) calories, carbs, fats, protein);
    }

    private double calculateRecommendedCalories(String gender, int age, double weight, String height, String activityLevel){
        double cmHeight = getCMHeight(height);
        double kilosWeight = weight * ClientExtras.KILO_CONVERSION;
        double calories = (10 * kilosWeight) + (6.25 * cmHeight) - (5 * age);
        if(gender.equalsIgnoreCase("MALE")){
            calories += 5;
        } else {
            calories-= 161;
        }

        if (activityLevel.equalsIgnoreCase(ClientExtras.EXTREME)){
            calories *= ClientExtras.EXTREME_MULTIPLIER;
        } else if(activityLevel.equalsIgnoreCase(ClientExtras.MODERATE)){
            calories *= ClientExtras.MODERATE_MULTIPLIER;
        } else if(activityLevel.equalsIgnoreCase(ClientExtras.LIGHT)){
            calories *= ClientExtras.LIGHT_MULTIPLIER;
        } else {
            calories *= ClientExtras.SEDENTARY_MULTIPLIER;
        }
        return calories;
    }

    private double getCMHeight(String height) {
        String[] splitHeight = height.split("'");

        int inchesHeight;
        if(splitHeight.length > 1) {
            inchesHeight = (Integer.parseInt(splitHeight[0]) * 12) + (Integer.parseInt(splitHeight[1]));
        } else {
            inchesHeight = Integer.parseInt(splitHeight[0]) * 12;
        }
        return inchesHeight * ClientExtras.CM_CONVERSION;
    }
}
