package edu.comillas.icai.pat.ejemplopat.service;
import java.util.List;
import edu.comillas.icai.pat.ejemplopat.dao.Prenda;

public interface MujerService 
{
    List<Prenda> getPrendas();

    List<Prenda> getPrendasHombre();
    public Prenda getById(Long id);

}
