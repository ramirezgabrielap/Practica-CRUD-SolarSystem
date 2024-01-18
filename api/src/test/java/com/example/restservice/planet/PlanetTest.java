package com.example.restservice.planet;

import com.example.restservice.model.Planet;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;


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
    
    
    private final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = validatorFactory.getValidator();

    @Test
    public void validatePlanetWithValidData() {
        Planet planet = new Planet();
        planet.setName("Earth");
        planet.setRadio(6371);
        planet.setMass(5);

        assertThat(validator.validate(planet)).isEmpty();
    }
    
    // tests for Name
    
    @Test
    public void validatePlanetWithNameNotNull() {
        Planet planet = new Planet();
        planet.setRadio(6371);
        planet.setMass(5);

        assertThat(validator.validate(planet))
            .hasSize(2)
            .extracting("message")
            .contains("no debe ser nulo"); 
    }
   
    @Test
    public void validatePlanetWithNameNotBlank() {
        Planet planet = new Planet();
        planet.setName("");
        planet.setRadio(6371);
        planet.setMass(5);

        assertThat(validator.validate(planet))
            .hasSize(2)
            .extracting("message")
            .contains("no debe estar vacío"); 
    }
    
    @Test
    public void validatePlanetWithNameMin() {
        Planet planet = new Planet();
        planet.setName("E"); 
        planet.setRadio(123);
        planet.setMass(234);
        
        assertThat(validator.validate(planet))
            .hasSize(1)
            .extracting("message")
            .contains("el tamaño debe estar entre 2 y 200"); 
    }
    
    @Test
    public void validatePlanetWithNameMax() {
        String name = "a".repeat(201);
        Planet planet = new Planet();
        planet.setName(name); 
        planet.setRadio(123);
        planet.setMass(234);
        
        assertThat(validator.validate(planet))
            .hasSize(1)
            .extracting("message")
            .contains("el tamaño debe estar entre 2 y 200"); 
    }    
   
    // tests for Radio
    
    @Test
    public void validatePlanetWithRadioNotNull() {
        Planet planet = new Planet();
        planet.setName("lalito1"); 
        planet.setMass(5); 

        assertThat(validator.validate(planet))
            .hasSize(1)
            .extracting("message")
            .contains("debe ser mayor que o igual a 1");
    }
    
    @Test
    public void validatePlanetWithNegativeRadio() {
        Planet planet = new Planet();
        planet.setName("lalito99"); 
        planet.setRadio(-1);
        planet.setMass(3);

        assertThat(validator.validate(planet))
            .hasSize(1)
            .extracting("message")
            .contains("debe ser mayor que o igual a 1");
    }
    
    // tests for Mass
    
    @Test
    public void validatePlanetWithMassNotNull() {
        Planet planet = new Planet();
        planet.setName("Sitro"); 
        planet.setRadio(888); 

        assertThat(validator.validate(planet))
            .hasSize(1)
            .extracting("message")
            .contains("debe ser mayor que o igual a 1");
    }
    
    @Test
    public void validatePlanetWithNegativeMass() {
        Planet planet = new Planet();
        planet.setName("Aurok3"); 
        planet.setRadio(123456);
        planet.setMass(-1); 

        assertThat(validator.validate(planet))
            .hasSize(1)
            .extracting("message")
            .contains("debe ser mayor que o igual a 1");
    }
        
}

