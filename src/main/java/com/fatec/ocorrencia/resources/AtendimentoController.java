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

import com.fatec.ocorrencia.entities.Atendimento;
import com.fatec.ocorrencia.services.AtendimentoService;

@RestController
@RequestMapping("/atendimentos")
@CrossOrigin
public class AtendimentoController {
    @Autowired
    private AtendimentoService atendimentoService;

    @GetMapping
    public List<Atendimento> listarAtendimentos(){
        return atendimentoService.listarAtendimentos();
    }

    @GetMapping("{id}")
    public Atendimento listarAtendimento(@PathVariable int id){
        return atendimentoService.listarAtendimento(id);
    }

    @PostMapping()
    public Atendimento salvarAtendimento(@RequestBody Atendimento atendimento) {
        atendimento = atendimentoService.salvarAtendimento(atendimento);
        return atendimento;
    }

    @PutMapping("{id}")
    public Integer editarAtendimento(@PathVariable int id, @RequestBody Atendimento atendimentoEditado) {
        return atendimentoService.atualizarAtendimento(id, atendimentoEditado);
    }
}
