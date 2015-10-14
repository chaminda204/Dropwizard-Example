package com.chaminda.destination.core;


public class DestinationBuilder {

    private int id;

    private String name;

    private String description;


    public DestinationBuilder withId(int id){
        this.id= id;
        return this;
    }

    public DestinationBuilder withName(String name){
        this.name = name;
        return this;
    }

    public DestinationBuilder withDescription(String description){
        this.description = description;
        return this;
    }

    public Destination build(){
        Destination destination = new Destination();
        destination.setId(id);
        destination.setDescription(description);
        destination.setName(name);
        return destination;
    }
}
