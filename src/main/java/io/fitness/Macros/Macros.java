package io.fitness.Macros;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Macros {

    private String id;
    @Id
    private String typeAndID;
    private int calories;
    private int carbs;
    private int fats;
    private int protein;

    public Macros(){}

    public Macros(String id, String typeAndID, int calories, int carbs, int fats, int protein){
        if(id.length() > 0){
            this.id = id;
        }
        if(typeAndID.length() > 0){
            this.typeAndID = typeAndID;
        }
        this.calories = calories;
        this.carbs = carbs;
        this.fats = fats;
        this.protein = protein;
    }

    public Macros(int calories, int carbs, int fats, int protein){
        this.calories = calories;
        this.carbs = carbs;
        this.fats = fats;
        this.protein = protein;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeAndID() {
        return typeAndID;
    }

    public void setTypeAndID(String typeAndID) {
        this.typeAndID = typeAndID;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getCarbs() {
        return carbs;
    }

    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }

    public int getFats() {
        return fats;
    }

    public void setFats(int fats) {
        this.fats = fats;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public Macros subtract(String id, Macros mealMacros) {
        return new Macros(
                this.id = id,
                this.typeAndID = id + "-D",
                this.calories - mealMacros.getCalories(),
                this.carbs - mealMacros.getCarbs(),
                this.fats - mealMacros.getFats(),
                this.protein - mealMacros.getProtein()
        );
    }
}
