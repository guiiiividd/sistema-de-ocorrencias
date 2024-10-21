package com.fatec.ocorrencia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.ocorrencia.entities.Veiculo;
import com.fatec.ocorrencia.repositories.VeiculoRepository;

@Service
public class VeiculoService {
    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> listarVeiculos() {
        return veiculoRepository.findByNativeQuery();
    }

    public Veiculo listarVeiculo(Integer id) {
        return veiculoRepository.findByIdByNativeQuery(id);
    }

    public Integer salvarVeiculo(Veiculo veiculo) {
        return veiculoRepository.insertByNativeQuery(veiculo.getPlaca_veiculo(), veiculo.getTipo_veiculo(), veiculo.getCapacidade_veiculo(), veiculo.getTipo_ocorrencia_tratada(), veiculo.getStatus_veiculo());
    }

    public Integer atualizarVeiculo(int id, Veiculo veiculoEditado) {
        Veiculo veiculo = listarVeiculo(id);

        veiculo.setPlaca_veiculo(veiculoEditado.getPlaca_veiculo());
        veiculo.setTipo_veiculo(veiculoEditado.getTipo_veiculo());
        veiculo.setCapacidade_veiculo(veiculoEditado.getCapacidade_veiculo());
        veiculo.setTipo_ocorrencia_tratada(veiculoEditado.getTipo_ocorrencia_tratada());
        veiculo.setStatus_veiculo(veiculoEditado.getStatus_veiculo());

        return veiculoRepository.updateByNativeQuery(veiculo.getPlaca_veiculo(), veiculo.getTipo_veiculo(), veiculo.getCapacidade_veiculo(), veiculo.getTipo_ocorrencia_tratada(), veiculo.getStatus_veiculo(), id);
    }
}
