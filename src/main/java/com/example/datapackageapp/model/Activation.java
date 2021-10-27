package com.example.datapackageapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "activation")
public class Activation {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JsonIgnore
    private Customer customer;

    @ManyToOne
    @JsonIgnore
    private Package pack;

    @NonNull
    private boolean isActive = true;


    private Timestamp createdAt;

    public Activation() {
    }

    public Activation(Integer id, Customer customer, Package pack, boolean isActive, Timestamp createdAt) {
        this.id = id;
        this.customer = customer;
        this.pack = pack;
        this.isActive = isActive;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Package getPack() {
        return pack;
    }

    public void setPack(Package pack) {
        this.pack = pack;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }


    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt( Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
