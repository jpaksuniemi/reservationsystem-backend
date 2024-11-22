package com.jpaksuniemi;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class DiningTable {

    private @Id @GeneratedValue long id;
    private int seats;
    
    public DiningTable() {}

    public DiningTable(int seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Table with " + seats + " seats";
    }

    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
