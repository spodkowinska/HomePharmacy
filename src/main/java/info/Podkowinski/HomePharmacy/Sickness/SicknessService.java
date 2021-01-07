package info.Podkowinski.HomePharmacy.Sickness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SicknessService {

    @Autowired
    private SicknessRepository sicknessRepository;

    public void save(Sickness sickness){
        sicknessRepository.save(sickness);
    }

    public List<Sickness> findAll(){
        return sicknessRepository.findAll();
    }

    public Sickness findById(int id){
        return sicknessRepository.getOne(Long.valueOf(id));
    }
    public void deleteById(int id){
        sicknessRepository.deleteById(Long.valueOf(id));
    }
}
