package com.jpaksuniemi;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Reserver {

    private @Id @GeneratedValue long id;
    private String name;
    private String email;

    public Reserver() {}

    public Reserver(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "ID: " + id + " Name: " + name + " Email: " + email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
