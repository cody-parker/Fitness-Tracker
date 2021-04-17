package io.fitness.Client;

import io.fitness.Macros.MacrosModel;

import java.util.Date;

public class Client {

    private int id;
    private String name;
    private String height;
    private double weight;
    private Date dateJoined;
    private int clientDesire;
    private MacrosModel macros;

    public Client(){}

    public Client(int id, String name, String height, double weight){
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.dateJoined = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
