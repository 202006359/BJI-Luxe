package edu.comillas.icai.pat.ejemplopat.repository;


import org.springframework.data.repository.CrudRepository;
import edu.comillas.icai.pat.ejemplopat.dao.Demo;

public interface DemoRepository extends CrudRepository<Demo, Integer> {
    
}
