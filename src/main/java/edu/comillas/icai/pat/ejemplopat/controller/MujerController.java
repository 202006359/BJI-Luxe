package edu.comillas.icai.pat.ejemplopat.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.comillas.icai.pat.ejemplopat.dao.Prenda;
import edu.comillas.icai.pat.ejemplopat.service.MujerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import edu.comillas.icai.pat.ejemplopat.service.impl.*;


@RestController
public class MujerController
{
    @Autowired
    private MujerService mujerService; 

    @GetMapping(path="api/ropaMujer")
    public ResponseEntity<List<Prenda>> getAll()
    {
        return ResponseEntity.ok().body(mujerService.getPrendas());
    }

}
