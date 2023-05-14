package edu.comillas.icai.pat.ejemplopat.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.comillas.icai.pat.ejemplopat.model.AccesorioModel;
import edu.comillas.icai.pat.ejemplopat.repository.AccesorioRepository;
import edu.comillas.icai.pat.ejemplopat.service.AccesorioService;

@Service
public class AccesorioServiceImpl implements AccesorioService {

    @Autowired
    private AccesorioRepository accesorio_repo;


    @Override
    public ArrayList<AccesorioModel> getAll()
    {
        return accesorio_repo.getAll();
    }

    @Override
    public AccesorioModel getById(Long id)
    {
        return accesorio_repo.getById(id);
    }
    
}
