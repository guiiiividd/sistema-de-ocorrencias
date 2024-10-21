package com.fatec.ocorrencia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.ocorrencia.entities.Funcionario;
import com.fatec.ocorrencia.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> listarFuncionarios() {
        return funcionarioRepository.findByNativeQuery();
    }

    public Funcionario listarFuncionario(Integer id) {
        return funcionarioRepository.findByIdByNativeQuery(id);
    }

    public Integer salvarFuncionario(Funcionario funcionario) {
        return funcionarioRepository.insertByNativeQuery(funcionario.getNome(), funcionario.getCargo());
    }

    public Integer atualizarFuncionario(int id, Funcionario funcionarioEditado) {
        Funcionario funcionario = listarFuncionario(id);

        funcionario.setNome(funcionarioEditado.getNome());
        funcionario.setCargo(funcionarioEditado.getCargo());

        return funcionarioRepository.updateByNativeQuery(funcionario.getNome(), funcionario.getCargo(), id);
    }
}
