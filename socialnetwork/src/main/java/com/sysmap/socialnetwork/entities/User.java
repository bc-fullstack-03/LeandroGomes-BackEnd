package com.sysmap.socialnetwork.entities;

import java.util.UUID;

public class User {
    private UUID id;
    private String name;
    private String email;
    private String password;

    public User(String name, String email, String password){
        this.setId();
        this.name = name;
        this.email = email;
        this.password = password;
    }

    protected void setId(){
        this.id = UUID.randomUUID();
    }

    public UUID getId(){
        return this.id;
    }
}
