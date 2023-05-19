package edu.comillas.icai.pat.ejemplopat.service;
import java.util.List;
import edu.comillas.icai.pat.ejemplopat.dao.Prueba;

public interface PruebaService 
{
    List<Prueba> getPrendasHombre();
   
    Prueba getPrendaHombreById(Long id);

}
