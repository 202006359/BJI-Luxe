package edu.comillas.icai.pat.ejemplopat.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import edu.comillas.icai.pat.ejemplopat.dao.Prenda;
import edu.comillas.icai.pat.ejemplopat.dao.PrendaHombre;
import edu.comillas.icai.pat.ejemplopat.service.RopaService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@Slf4j
public class RopaController 
{
    @Autowired
    private RopaService ropaService; 

    
    @CrossOrigin("http://127.0.0.1:5501/")
    @GetMapping(path="api/ropaMujer")
    public ResponseEntity<List<Prenda>> getPrendas()
    {
        return ResponseEntity.ok().body(ropaService.getPrendas());
    }

    @CrossOrigin("http://127.0.0.1:5501/")
    @GetMapping(path="api/ropaHombre")
    public ResponseEntity<List<PrendaHombre>> getAllPrendrasHombre()
    {
        log.info("Controller: Entrando en getAllPrendrasHombre");
        return ResponseEntity.ok().body(ropaService.getPrendasHombre());
    }

    @GetMapping("api/prenda/{id}")
    public ResponseEntity<Prenda> getPrendaById(@PathVariable Long id)
    {
        return new ResponseEntity<Prenda>(ropaService.getById(id), HttpStatus.OK);
        
    }

    @GetMapping("api/prendaHombre/{id}")
    public ResponseEntity<PrendaHombre> getPrendaHombreById(@PathVariable Long id)
    {
        return new ResponseEntity<PrendaHombre>(ropaService.getPrendaHombreById(id), HttpStatus.OK);
        
    }


}