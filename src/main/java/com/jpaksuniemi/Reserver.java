package com.jpaksuniemi;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Reserver {

    @Id
    @SequenceGenerator(name = "reserver_seq_gen", sequenceName = "RESERVER_SEQ", allocationSize = 1)
    @GeneratedValue 
    private Long id;
    private String name;
    private String email;

    public Reserver() {}

    public Reserver(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Email: " + email;
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
}
