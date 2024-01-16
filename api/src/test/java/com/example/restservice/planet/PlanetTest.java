package com.example.restservice.planet;

import com.example.restservice.model.Planet;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PlanetTest {
    
    @Test
    public void testPlanetConstruction() {
        Planet planet = new Planet();
        assertNotNull(planet);
    }

    @Test
    public void testPlanetGetterAndSetter() {
        Planet planet = new Planet();
        planet.setId(1);
        planet.setName("Krypton");
        planet.setRadio(63710);
        planet.setMass(5551);

        assertEquals(1, planet.getId());
        assertEquals("Krypton", planet.getName());
        assertEquals(63710, planet.getRadio());
        assertEquals(5551, planet.getMass());
    }
   
}

