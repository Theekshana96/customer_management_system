package com.example.datapackageapp.repository;

import com.example.datapackageapp.model.Activation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivationRepository extends JpaRepository<Activation, Integer> {
    Activation findActivationById(Integer id);
}
