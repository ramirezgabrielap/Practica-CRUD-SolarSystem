package com.example.restservice.planet;

import javax.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class PlanetControllerTest {
    
    @Autowired
    private MockMvc mockMvc;  
    
    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/planets"))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetPlanetById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/planets/{id}", 5))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testCountPlanets() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/planets/count"))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
    /*@Test
    public void testSavePlanet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/planets")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"name\": \"TerrarioTest\", \"radio\": 123456, \"mass\": 98765}"))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }*/

    /*@Test
    public void testEditPlanet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/planets/{id}", 14)
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"name\": \"Tierrita\", \"radio\": 1234, \"mass\": 4567}"))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }*/
    
    /*@Test
    public void testDeletePlanet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/planets/{id}", 2))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }*/
   
}
