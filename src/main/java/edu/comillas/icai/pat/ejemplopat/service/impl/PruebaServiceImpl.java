package edu.comillas.icai.pat.ejemplopat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.comillas.icai.pat.ejemplopat.dao.Prueba;
import edu.comillas.icai.pat.ejemplopat.repository.PruebaRepository;
import edu.comillas.icai.pat.ejemplopat.service.PruebaService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PruebaServiceImpl implements PruebaService
{

    @Autowired
    private PruebaRepository ropaRepository; 

    @Override
    public List<Prueba> getPrendasHombre() {
        log.info("Service: Entrando en getPrendrasHombre");

        return ropaRepository.getPrendasHombres();
    }


    @Override
    public Prueba getPrendaHombreById(Long id)
    {
        return ropaRepository.getPrendaHombreById(id);
    }
    
}
