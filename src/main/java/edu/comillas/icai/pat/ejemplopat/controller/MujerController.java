package edu.comillas.icai.pat.ejemplopat.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.comillas.icai.pat.ejemplopat.dao.Prenda;
import edu.comillas.icai.pat.ejemplopat.service.MujerService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


@RestController
@Slf4j
public class MujerController //Hay que cambiar todo lo que ponga MujerController, Service, Repo etc a PrendaControler. No tiene sentido repetir codigo
{
    @Autowired
    private MujerService mujerService; 

    
    @CrossOrigin("http://127.0.0.1:5501/")
    @GetMapping(path="api/ropaMujer")
    public ResponseEntity<List<Prenda>> getAll()
    {
        return ResponseEntity.ok().body(mujerService.getPrendas());
    }

    @CrossOrigin("http://127.0.0.1:5501/")
    @GetMapping(path="api/ropaHombre")
    public ResponseEntity<List<Prenda>> getAllPrendrasHombre()
    {
        log.info("Controller: Entrando en getAllPrendrasHombre");
        return ResponseEntity.ok().body(mujerService.getPrendasHombre());
    }



}