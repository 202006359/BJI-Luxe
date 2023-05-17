package edu.comillas.icai.pat.ejemplopat.dao;


import org.springframework.data.relational.core.mapping.Table;

@Table(value = "HOMBRES")
public class PrendaHombre extends Prenda{


    public PrendaHombre(Long id, String nombre, String url, Float precio) {
        super(id, nombre, url, precio);
    }

    
}
