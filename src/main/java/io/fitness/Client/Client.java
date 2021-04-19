package io.fitness.Client;

import io.fitness.Macros.MacrosExtras;

import java.util.Date;

public class Client {

    private String id;
    private String firstName;
    private String lastName;
    private String height;
    private double weight;
    private int age;
    private String gender;
    private String activityLevel;
    private Date dateJoined;

    public Client(){}

    public Client(String firstName, String lastName, String height, double weight, int age, int gender, String activityLevel){
        this.id = firstName + '-' + lastName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.height = height;
        this.weight = weight;
        this.age = age;
        if(gender == ClientExtras.MALE){
            this.gender = "Male";
        } else if(gender == ClientExtras.FEMALE){
            this.gender = "Female";
        } else {
            this.gender = "";
        }
        if(activityLevel.equalsIgnoreCase(MacrosExtras.EXTREME)){
            this.activityLevel = activityLevel;
        } else if(activityLevel.equalsIgnoreCase(MacrosExtras.MODERATE)){
            this.activityLevel = activityLevel;
        } else if(activityLevel.equalsIgnoreCase(MacrosExtras.LIGHT)){
            this.activityLevel = activityLevel;
        } else {
            this.activityLevel = MacrosExtras.SEDENTARY;
        }
        this.dateJoined = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(String activityLevel) {
        this.activityLevel = activityLevel;
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }
}
