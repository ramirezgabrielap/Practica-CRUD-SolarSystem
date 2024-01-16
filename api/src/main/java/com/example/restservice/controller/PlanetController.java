package com.example.restservice.controller;

import com.example.restservice.model.Planet;
import com.example.restservice.repository.PlanetRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/planets")
public class PlanetController {
    @Autowired 
    
    private final PlanetRepository planetRepository;
    
    public PlanetController(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    @GetMapping()
    public Iterable<Planet> getAll() {
        return planetRepository.findAll(Sort.by("id").ascending());
    }
    
    
    @GetMapping("/{id}")
    public Optional<Planet> get(@PathVariable Integer id) {
        return this.planetRepository.findById(id);
    }
    
    @PostMapping()
    public Planet save(@RequestBody Planet planet){
        return this.planetRepository.save(planet);
    }
    
    @PutMapping("/{id}")
    public Planet edit(@RequestBody Planet planet, @PathVariable Integer id){
        planet.setId(id);
        return this.planetRepository.save(planet);
    }
    
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        this.planetRepository.deleteById(id);
    }
    
 
    @GetMapping("/count")
    public Long countPlanets(){
        return planetRepository.count();
    }
}
