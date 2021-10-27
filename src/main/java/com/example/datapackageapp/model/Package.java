package com.example.datapackageapp.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "package")
public class Package {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    private String packageName;
    @NonNull
    private String packageDesc;
    @NonNull
    private int packageFee;


    private Timestamp createdAt;


    @OneToMany(targetEntity = Activation.class, mappedBy = "pack",  cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Activation> activations;

    public Package() {
    }

    public Package(Integer id, @NonNull String packageName, @NonNull String packageDesc, int packageFee,@NonNull Timestamp createdAt,  Set<Activation> activations) {
        this.id = id;
        this.packageName = packageName;
        this.packageDesc = packageDesc;
        this.packageFee = packageFee;
        this.activations = activations;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NonNull
    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(@NonNull String packageName) {
        this.packageName = packageName;
    }

    @NonNull
    public String getPackageDesc() {
        return packageDesc;
    }

    public void setPackageDesc(@NonNull String packageDesc) {
        this.packageDesc = packageDesc;
    }

    public int getPackageFee() {
        return packageFee;
    }

    public void setPackageFee(int packageFee) {
        this.packageFee = packageFee;
    }

    public Set<Activation> getActivations() {
        return activations;
    }

    public void setActivations(Set<Activation> activations) {
        this.activations = activations;
    }

    @NonNull
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(@NonNull Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
