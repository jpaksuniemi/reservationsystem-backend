package com.jpaksuniemi;

import java.util.concurrent.atomic.AtomicInteger;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Reserver {
    private static final AtomicInteger counter = new AtomicInteger();

    @Id
    private int id;
    private String name;
    private String email;

    public Reserver() {}

    public Reserver(String name, String email) {
        id = counter.incrementAndGet();
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
