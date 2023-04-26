package sn.esmt.CV.ws;



import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sn.esmt.CV.dao.CvRepository;
import sn.esmt.CV.entities.CvEntity;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping(value = "/appcv")
public class CvController {
    private CvRepository CvRepository;

    @PostMapping(path = "/save")
    public CvEntity save(@RequestBody CvEntity CvEntity) {
        return CvRepository.save(CvEntity);
    }

    @GetMapping(path = "/all")
    public List<CvEntity> getAll() {
        return CvRepository.findAll();
    }

    @GetMapping(path = "/login")
    public ApiLoginResponse login(@RequestParam String email,@RequestParam String adresse){
        CvEntity appCvEntity = CvRepository.findByEmailAndAdresse(email, adresse);
        if(appCvEntity != null){
            return new ApiLoginResponse("OK",email);
        }else{
            return new ApiLoginResponse("NOK",email);
        }
    }
}
