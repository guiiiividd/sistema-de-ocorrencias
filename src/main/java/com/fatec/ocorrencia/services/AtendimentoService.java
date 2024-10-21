package com.fatec.ocorrencia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.ocorrencia.entities.Atendimento;
import com.fatec.ocorrencia.repositories.AtendimentoRepository;

@Service
public class AtendimentoService {
    @Autowired
    private AtendimentoRepository atendimentoRepository;

    public List<Atendimento> listarAtendimentos() {
        return atendimentoRepository.findByNativeQuery();
    }

    public Atendimento listarAtendimento(Integer id) {
        return atendimentoRepository.findByIdByNativeQuery(id);
    }

    public Atendimento salvarAtendimento(Atendimento atendimento) {
        return atendimentoRepository.insertByNativeQuery(atendimento.getId_ocorrencia(), atendimento.getId_equipe());
    }

    public Integer atualizarAtendimento(int id, Atendimento atendimentoEditado) {
        Atendimento atendimento = listarAtendimento(id);

        atendimento.setId_ocorrencia(atendimentoEditado.getId_ocorrencia());
        atendimento.setId_equipe(atendimentoEditado.getId_equipe());

        return atendimentoRepository.updateByNativeQuery(atendimento.getId_ocorrencia(), atendimento.getId_equipe(), id);
    }
}
