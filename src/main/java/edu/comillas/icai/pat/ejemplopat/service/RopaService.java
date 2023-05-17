package edu.comillas.icai.pat.ejemplopat.service;
import java.util.List;
import edu.comillas.icai.pat.ejemplopat.dao.Prenda;
import edu.comillas.icai.pat.ejemplopat.dao.PrendaHombre;

public interface RopaService 
{
    List<Prenda> getPrendas();
    List<PrendaHombre> getPrendasHombre();
   
    Prenda getById(Long id);
    PrendaHombre getPrendaHombreById(Long id);

}
