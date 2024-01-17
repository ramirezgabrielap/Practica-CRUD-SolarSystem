package com.example.restservice.planet;

import com.example.restservice.repository.PlanetRepository;
import javax.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
public class PlanetController2Test {
    
    @Autowired
    private MockMvc mockMvc;
   
    @MockBean
    PlanetRepository planetRepository;
    
    
    //https://docs.spring.io/spring-framework/reference/testing/webtestclient.html#webtestclient-json
    //https://github.com/spring-projects/spring-framework/blob/main/spring-test/src/test/java/org/springframework/test/web/servlet/samples/standalone/ResponseBodyTests.java
    
    //MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new TestController())
//		.apply(sharedHttpSession())
//		.build();

/*
    
    @Test
    public void testSavePlanet() throws Exception {
        
        
        
        
        
        
        
        mockMvc.perform(MockMvcRequestBuilders. post("/planets")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"name\": \"TierraTest\", \"radio\": 123456, \"mass\": 98765}"))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

    
    
    @Test
    public void testEditPlanet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/planets/{id}", 14)
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"name\": \"Tierra\", \"radio\": 1234, \"mass\": 4567}"))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }    
    
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
    public void testDeletePlanet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/planets/{id}", 15))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testCountPlanets() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/planets/count"))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }
   */
}
