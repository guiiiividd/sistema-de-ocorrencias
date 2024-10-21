package com.fatec.ocorrencia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.ocorrencia.entities.Equipe;
import com.fatec.ocorrencia.repositories.EquipeRepository;

@Service
public class EquipeService {
    @Autowired
    private EquipeRepository equipeRepository;

    public List<Equipe> listarEquipes() {
        return equipeRepository.findByNativeQuery();
    }

    public Equipe listarEquipe(Integer id) {
        return equipeRepository.findByIdByNativeQuery(id);
    }

    public Equipe salvarEquipe(Equipe equipe) {
        return equipeRepository.insertByNativeQuery(equipe.getCod_primeiro_integrante(), equipe.getCod_segundo_integrante(), equipe.getCod_terceiro_integrante(), equipe.getCod_quarto_integrante());
    }

    public Integer atualizarEquipe(int id, Equipe equipeEditada) {
        Equipe equipe = listarEquipe(id);

        equipe.setCod_primeiro_integrante(equipe.getCod_primeiro_integrante());
        equipe.setCod_segundo_integrante(equipe.getCod_segundo_integrante());
        equipe.setCod_terceiro_integrante(equipe.getCod_terceiro_integrante());
        equipe.setCod_quarto_integrante(equipe.getCod_quarto_integrante());

        return equipeRepository.updateByNativeQuery(equipe.getCod_primeiro_integrante(), equipe.getCod_segundo_integrante(), equipe.getCod_terceiro_integrante(), equipe.getCod_quarto_integrante(), id);
    }
}
