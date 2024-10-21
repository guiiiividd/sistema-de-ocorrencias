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

import com.fatec.ocorrencia.entities.Equipe;
import com.fatec.ocorrencia.services.EquipeService;

@RestController
@RequestMapping("/equipes")
@CrossOrigin
public class EquipeController {
    @Autowired
    private EquipeService equipeService;

    @GetMapping
    public List<Equipe> listarEquipes(){
        return equipeService.listarEquipes();
    }

    @GetMapping("{id}")
    public Equipe listarEquipe(@PathVariable int id){
        return equipeService.listarEquipe(id);
    }

    @PostMapping()
    public Integer salvarEquipe(@RequestBody Equipe equipe) {
        return equipeService.salvarEquipe(equipe);
    }

    @PutMapping("{id}")
    public Integer editarEquipe(@PathVariable int id, @RequestBody Equipe equipeEditada) {
        return equipeService.atualizarEquipe(id, equipeEditada);
    }
}
