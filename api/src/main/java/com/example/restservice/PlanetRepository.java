package com.example.restservice;

import org.springframework.data.repository.CrudRepository;

import com.example.restservice.Planet;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface PlanetRepository extends CrudRepository<Planet, Integer> {

}