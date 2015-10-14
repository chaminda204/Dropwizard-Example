package com.chaminda.destination.core;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Destination {

    @JsonProperty
    private int id;

    @JsonProperty
    @NotNull
    @Size(min = 2, max = 64)
    private String name;

    @JsonProperty
    @NotNull
    @Size(min = 8, max = 160)
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
