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

import com.fatec.ocorrencia.entities.Veiculo;
import com.fatec.ocorrencia.services.VeiculoService;

@RestController
@RequestMapping("/veiculos")
@CrossOrigin
public class VeiculoController {
    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public List<Veiculo> listarVeiculos(){
        return veiculoService.listarVeiculos();
    }

    @GetMapping("{id}")
    public Veiculo listarVeiculo(@PathVariable int id){
        return veiculoService.listarVeiculo(id);
    }

    @PostMapping()
    public Integer salvarVeiculo(@RequestBody Veiculo veiculo) {
        return veiculoService.salvarVeiculo(veiculo);
    }

    @PutMapping("{id}")
    public Integer editarVeiculo(@PathVariable int id, @RequestBody Veiculo veiculoEditado) {
        return veiculoService.atualizarVeiculo(id, veiculoEditado);
    }
}
