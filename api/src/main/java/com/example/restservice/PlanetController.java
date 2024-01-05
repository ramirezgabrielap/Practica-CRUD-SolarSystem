package com.example.restservice;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;


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
        return planetRepository.findAll();
    }
    
    
    @GetMapping("/{id}")
    public Optional<Planet> get(@PathVariable Integer id) {
        return this.planetRepository.findById(id);
    }
    
    @PostMapping()
    public Planet save(@RequestBody Planet planet){
        return this.planetRepository.save(planet);
    }
    
    //@PostMapping
    //public Planet savePlanet(@RequestBody Planet planet){
    //    return this.planetService.savePlanet(planet);
    //}
    
   
       
    //@PutMapping(path = "/{id}")
    //public Planet updatePlanetById(@RequestBody Planet request, @PathVariable Long id){
    //    return this.planetService.updateById(request, id);
    //}
    
    
    //@DeleteMapping(path = "/{id}")
    //public String deleteById(@PathVariable("id") Long id){
    //    boolean ok = this.planetService.deletePlanet(id);
    //    
    //   if(ok){
    //        return "Planeta ID " + id + " Eliminado correctamente";
    //    } else {
    //        return "Error al Eliminar Planeta ID " + id;
    //    }
    //}
    
    
}
