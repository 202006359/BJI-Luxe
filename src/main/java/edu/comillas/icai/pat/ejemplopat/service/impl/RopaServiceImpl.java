package edu.comillas.icai.pat.ejemplopat.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.comillas.icai.pat.ejemplopat.dao.Prenda;
import edu.comillas.icai.pat.ejemplopat.dao.PrendaHombre;
import edu.comillas.icai.pat.ejemplopat.repository.RopaRepository;
import edu.comillas.icai.pat.ejemplopat.service.RopaService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RopaServiceImpl implements RopaService
{

    @Autowired
    private RopaRepository ropaRepository; 

    @Override
    public List<Prenda> getPrendas()
    {
        return ropaRepository.getPrendas();
    }

    @Override
    public List<PrendaHombre> getPrendasHombre() {
        log.info("Service: Entrando en getPrendrasHombre");

        return ropaRepository.getPrendasHombres();
    }

    @Override
    public Prenda getById(Long id)
    {
        return ropaRepository.getById(id);
    }

    @Override
    public PrendaHombre getPrendaHombreById(Long id)
    {
        return ropaRepository.getPrendaHombreById(id);
    }
    
}
