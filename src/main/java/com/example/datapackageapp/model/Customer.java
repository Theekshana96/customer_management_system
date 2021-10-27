package com.example.datapackageapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    private String name;
    @NonNull
    private String email;
    @NonNull
    private String nic;
    @NonNull
    private String phone;

    private Timestamp createdAt;

    @OneToMany(targetEntity = Activation.class,mappedBy = "customer",  cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Activation> actvations;

    public Customer() {
    }



    public Customer(Integer id, @NonNull String name, @NonNull String nic, @NonNull String phone, @NonNull String email,  Timestamp createdAt, Set<Activation> activations) {
        this.id = id;
        this.name = name;
        this.nic = nic;
        this.phone = phone;
        this.email = email;
        this.actvations = actvations;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    @NonNull
    public String getNic() {
        return nic;
    }

    public void setNic(@NonNull String nic) {
        this.nic = nic;
    }

    @NonNull
    public String getPhone() {
        return phone;
    }

    public void setPhone(@NonNull String phone) {
        this.phone = phone;
    }


    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Activation> getActvations() {
        return actvations;
    }

    public void setActvations(Set<Activation> actvations) {
        this.actvations = actvations;
    }
}
