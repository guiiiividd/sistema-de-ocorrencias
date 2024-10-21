package com.fatec.ocorrencia.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.ocorrencia.entities.Ocorrencia;
import com.fatec.ocorrencia.services.OcorrenciaService;

@RestController
@RequestMapping("/ocorrencias")
@CrossOrigin
public class OcorrenciaController {
    @Autowired
    private OcorrenciaService ocorrenciaService;

    @GetMapping
    public List<Ocorrencia> listarOcorrencias(){
        return ocorrenciaService.listarOcorrencias();
    }

    @GetMapping("{id}")
    public Ocorrencia listarOcorrencia(@PathVariable int id){
        return ocorrenciaService.listarOcorrencia(id);
    }

    @PostMapping()
    public Ocorrencia salvarOcorrencia(@RequestBody Ocorrencia ocorrencia) {
        ocorrencia = ocorrenciaService.salvarOcorrencia(ocorrencia);
        return ocorrencia;
    }

    @PutMapping("{id}")
    public Integer editarOcorrencia(@PathVariable int id, @RequestBody Ocorrencia ocorrenciaEditada) {
        return ocorrenciaService.atualizarOcorrencia(id, ocorrenciaEditada);
    }
}
