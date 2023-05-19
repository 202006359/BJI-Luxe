package edu.comillas.icai.pat.ejemplopat.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.comillas.icai.pat.ejemplopat.dao.Prueba;
import edu.comillas.icai.pat.ejemplopat.service.PruebaService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@Slf4j
public class PruebaController 
{
    @Autowired
    private PruebaService pruebaService; 

    
    @GetMapping(path="api/pruebas/ropaHombre")
    public ResponseEntity<List<Prueba>> getAllPrendrasHombre()
    {
        log.info("Controller: Entrando en getAllPrendrasHombre");
        return ResponseEntity.ok().body(pruebaService.getPrendasHombre());
    }


    @GetMapping("api/pruebas/prendaHombre/{id}")
    public ResponseEntity<Prueba> getPrendaHombreById(@PathVariable Long id)
    {
        return new ResponseEntity<Prueba>(pruebaService.getPrendaHombreById(id), HttpStatus.OK);
        
    }


}
