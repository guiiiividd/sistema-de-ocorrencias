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

import com.fatec.ocorrencia.entities.Funcionario;
import com.fatec.ocorrencia.services.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
@CrossOrigin
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<Funcionario> listarFuncionarios(){
        return funcionarioService.listarFuncionarios();
    }

    @GetMapping("{id}")
    public Funcionario listarFuncionario(@PathVariable int id){
        return funcionarioService.listarFuncionario(id);
    }

    @PostMapping()
    public Integer salvarFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioService.salvarFuncionario(funcionario);
    }

    @PutMapping("{id}")
    public Integer editarFuncionario(@PathVariable int id, @RequestBody Funcionario funcionarioEditado) {
        return funcionarioService.atualizarFuncionario(id, funcionarioEditado);
    }
}
