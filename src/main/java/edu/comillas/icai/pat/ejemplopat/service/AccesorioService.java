package edu.comillas.icai.pat.ejemplopat.service;

import java.util.ArrayList;

import edu.comillas.icai.pat.ejemplopat.model.AccesorioModel;

public interface AccesorioService{

    public ArrayList<AccesorioModel> getAll();
    public AccesorioModel getById(Long id);

    
}
