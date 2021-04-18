package io.fitness.Client;

import io.fitness.Macros.MacrosModel;

import java.util.Date;

public class Client {

    private String id;
    private String firstName;
    private String lastName;
    private String height;
    private double weight;
    private Date dateJoined;
    private int clientDesire;
    private MacrosModel macros;

    public Client(){}

    public Client(String firstName, String lastName, String height, double weight){
        this.id = firstName + '-' + lastName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.height = height;
        this.weight = weight;
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

    public MacrosModel getMacros() {
        return macros;
    }

    public void setMacros(MacrosModel macros) {
        this.macros = macros;
    }
}
