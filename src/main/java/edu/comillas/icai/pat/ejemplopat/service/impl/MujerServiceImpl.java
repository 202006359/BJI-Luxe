package edu.comillas.icai.pat.ejemplopat.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.comillas.icai.pat.ejemplopat.dao.Prenda;
import edu.comillas.icai.pat.ejemplopat.repository.MujerRepository;
import edu.comillas.icai.pat.ejemplopat.service.MujerService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MujerServiceImpl implements MujerService
{

    @Autowired
    private MujerRepository mujerRepository; 

    @Override
    public List<Prenda> getPrendas()
    {
        return mujerRepository.getPrendas();
    }

    @Override
    public List<Prenda> getPrendasHombre() {
        log.info("Service: Entrando en getPrendrasHombre");

        return mujerRepository.getPrendasHombres();
    }

    @Override
    public Prenda getById(Long id)
    {
        return mujerRepository.getById(id);
    }
    
}
