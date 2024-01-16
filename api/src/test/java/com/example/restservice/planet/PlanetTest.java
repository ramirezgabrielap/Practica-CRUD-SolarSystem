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
   
    /*
    
    @Test
    public void validatePlanetWithNameTooShort() {
        Planet planet = new Planet();
        planet.setName("E"); // Name is too short

        assertThat(validator.validate(planet))
            .hasSize(1)
            .extracting("message")
            .contains("not blank!", "not null!", "size must be between 2 and 200");
    }
    
    @Test
    public void validatePlanetWithNegativeRadio() {
        Planet planet = new Planet();
        planet.setRadio(-1); // Radio is negative

        assertThat(validator.validate(planet))
            .hasSize(1)
            .extracting("message")
            .contains("not null!", "must be greater than or equal to 1");
    }
    
    @Test
    public void validatePlanetWithNegativeMass() {
        Planet planet = new Planet();
        planet.setMass(-1); // Mass is negative

        assertThat(validator.validate(planet))
            .hasSize(1)
            .extracting("message")
            .contains("not null!", "must be greater than or equal to 1");
    }
    
    */
     
}

