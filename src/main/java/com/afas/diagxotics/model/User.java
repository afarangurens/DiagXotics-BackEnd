package com.afas.diagxotics.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    private final UUID id;
    private final String name;

    public User(@JsonProperty("id") UUID id,
                @JsonProperty("name") String name){
        this.id = id;
        this.name = name;
    }

    public UUID getId(){
        return id;
    }

    public String getName(){
        return name;
    }
}
