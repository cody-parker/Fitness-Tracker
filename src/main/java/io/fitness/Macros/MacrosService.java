package io.fitness.Macros;

import io.fitness.Client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;

@RestController
public class MacrosService {

    public Response setRecommendedMacros(String id, String weightDesire) {
//        Client client = clientRepository.findById(id).orElse(null);
        Client client = null;

        if(client != null){
            double multiplier = 1.0;
            if(weightDesire.equalsIgnoreCase("lose")){
                multiplier = MacrosExtras.LOSE_WEIGHT;
            } else if(weightDesire.equalsIgnoreCase("gain")){
                multiplier = MacrosExtras.GAIN_WEIGHT;
            }

            Macros goalMacros = calculateRecommendedMacros(client, multiplier);
            Macros dailyMacros = new Macros(
                    goalMacros.getId(),
                    goalMacros.getId() + "-D",
                    goalMacros.getCalories(),
                    goalMacros.getCarbs(),
                    goalMacros.getFats(),
                    goalMacros.getProtein()
            );
//            macrosRepository.save(goalMacros);
//            macrosRepository.save(dailyMacros);
            return Response.status(Response.Status.OK).entity(goalMacros).build();
        }
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    public Response setCustomMacros(String id, Macros macros){
        if(id != null && id.length() > 0 && macros != null){
            Macros goalMacros = new Macros(
                    id,
                    id+"-G",
                    macros.getCalories(),
                    macros.getCarbs(),
                    macros.getFats(),
                    macros.getProtein()
            );
            Macros dailyMacros = new Macros(
                    id,
                    id+"-D",
                    macros.getCalories(),
                    macros.getCarbs(),
                    macros.getFats(),
                    macros.getProtein()
            );

//            macrosRepository.save(goalMacros);
//            macrosRepository.save(dailyMacros);
            return Response.status(Response.Status.OK).entity(goalMacros).build();
        }
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    public Response resetMacros(String id) {
        if(id != null && id.length() > 0){
//            Macros dailyMacros = macrosRepository.findById(id+"-D").orElse(null);
//            Macros goalMacros = macrosRepository.findById(id+"-G").orElse(null);
            //reset the macros (firstName-lastName-D) to be the same values as (firstName-lastName-G)
            return Response.status(Response.Status.OK).build();
        }
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    public Response updateDailyMacros(String id, Macros mealMacros){

        if(id != null && id.length() > 0 && mealMacros != null){
            //Pull the firstName-lastName-D value from DB
            //Update the macros entry in the db based on food values entered
            //Update the new Macros entry to DB
            return Response.status(Response.Status.OK).build();
        }
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    public Macros calculateRecommendedMacros(Client client, Double weightDesire){
        double calories = calculateRecommendedCalories(client.getGender(), client.getAge(), client.getWeight(), client.getHeight(), client.getActivityLevel()) * weightDesire;
        int carbs = (int) ((calories * .40)/MacrosExtras.CARBS_CALORIES);
        int fats = (int) ((calories * .25)/MacrosExtras.FATS_CALORIES);
        int protein = (int) ((calories * .35)/MacrosExtras.PROTEIN_CALORIES);
        return new Macros(client.getFirstName() + '-' + client.getLastName(),
                client.getFirstName() + '-' + client.getLastName() + "-G",
                (int) calories, carbs, fats, protein);
    }

    private double calculateRecommendedCalories(String gender, int age, double weight, String height, String activityLevel){
        double cmHeight = getCMHeight(height);
        double kilosWeight = weight * MacrosExtras.KILO_CONVERSION;
        double calories = (10 * kilosWeight) + (6.25 * cmHeight) - (5 * age);
        if(gender.equalsIgnoreCase("MALE")){
            calories += 5;
        } else {
            calories-= 161;
        }

        if (activityLevel.equalsIgnoreCase(MacrosExtras.EXTREME)){
            calories *= MacrosExtras.EXTREME_MULTIPLIER;
        } else if(activityLevel.equalsIgnoreCase(MacrosExtras.MODERATE)){
            calories *= MacrosExtras.MODERATE_MULTIPLIER;
        } else if(activityLevel.equalsIgnoreCase(MacrosExtras.LIGHT)){
            calories *= MacrosExtras.LIGHT_MULTIPLIER;
        } else {
            calories *= MacrosExtras.SEDENTARY_MULTIPLIER;
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
        return inchesHeight * MacrosExtras.CM_CONVERSION;
    }

}
