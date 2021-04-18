package io.fitness.Client;

import io.fitness.Macros.Macros;

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
    private int clientDesire;
    private Macros goalMacros;
    private Macros dailyMacros;

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
        if(activityLevel.equalsIgnoreCase(ClientExtras.EXTREME)){
            this.activityLevel = activityLevel;
        } else if(activityLevel.equalsIgnoreCase(ClientExtras.MODERATE)){
            this.activityLevel = activityLevel;
        } else if(activityLevel.equalsIgnoreCase(ClientExtras.LIGHT)){
            this.activityLevel = activityLevel;
        } else {
            this.activityLevel = ClientExtras.SEDENTARY;
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

    public int getClientDesire(){
        return clientDesire;
    }

    public void setClientDesire(int desire){
        this.clientDesire = desire;
    }

    public Macros getGoalMacros() {
        return goalMacros;
    }

    public void setGoalMacros(Macros goalMacros) {
        this.goalMacros = goalMacros;
    }

    public Macros getDailyMacros() {
        return dailyMacros;
    }

    public void setDailyMacros(Macros dailyMacros) {
        this.dailyMacros = dailyMacros;
    }
}
