package com.example.full_stack_project_backend.model;

public class PersonData {
    private int id;
    private int clientId;
    private int lastprice;
    private int generalprice;
    private String favouritedish;


    public  PersonData() {}

    public PersonData(int clientId, int lastprice, int generalprice, String favouritedish) {
        this.clientId = clientId;
        this.lastprice = lastprice;
        this.generalprice = generalprice;
        this.favouritedish = favouritedish;
    }

    public int getId() {
        return id;
    }

    public int getClientId() {
        return clientId;
    }

    public int getLastprice() {
        return this.lastprice;
    }

    public int getGeneralprice() {
        return this.generalprice;
    }

    public String getFavouritedish() {
        return favouritedish;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void setLastprice(int lastprice) {
        this.lastprice = lastprice;
    }

    public void setGeneralprice(int generalprice) {
        this.generalprice = generalprice;
    }

    public void setFavouritedish(String favouritedish) {
        this.favouritedish = favouritedish;
    }

    @Override
    public String toString() {
        return "PersonData{" +
                "id=" + id +
                ", client id=" + clientId +
                ", last price='" + lastprice + '\'' +
                ", general price=" + generalprice +
                ", favourite dish='" + favouritedish + '\'' +
                '}';
    }
}
