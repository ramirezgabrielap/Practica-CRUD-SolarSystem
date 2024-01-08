package com.example.restservice;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PlanetRepository extends JpaRepository<Planet, Integer> {

}