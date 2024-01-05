package cajon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PlanetService {
    
    @Autowired
    PlanetRepository planetRepository;
    
    public ArrayList<PlanetModel> getPlanets(){
        return (ArrayList<PlanetModel>) planetRepository.findAll();
    }
    
    
    public PlanetModel savePlanet(PlanetModel planet){
        return planetRepository.save(planet);
    }
    
    
    public Optional<PlanetModel> getById(Long id){
        return planetRepository.findById(id);
    }
    
    
    public PlanetModel updateById(PlanetModel request, Long id){
        PlanetModel planet = planetRepository.findById(id).get();
        
        planet.setName(request.getName());
        
        return planet;
    }

    
    public Boolean deletePlanet(Long id){
        try{
            planetRepository.deleteById(id);
            return true;
        } catch (Exception ex){
            return false;
        }
    }
    
}
