package com.fatec.ocorrencia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.ocorrencia.entities.Ocorrencia;
import com.fatec.ocorrencia.repositories.OcorrenciaRepository;

@Service
public class OcorrenciaService {
    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    public List<Ocorrencia> listarOcorrencias() {
        return ocorrenciaRepository.findByNativeQuery();
    }

    public Ocorrencia listarOcorrencia(Integer id) {
        return ocorrenciaRepository.findByIdByNativeQuery(id);
    }

    public Integer salvarOcorrencia(Ocorrencia ocorrencia) {
        return ocorrenciaRepository.insertByNativeQuery(ocorrencia.getTipo_ocorrencia(), ocorrencia.getEstado_ocorrencia(), ocorrencia.getDescricao_ocorrencia());
    }

    public Integer atualizarOcorrencia(int id, Ocorrencia ocorrenciaEditada) {
        Ocorrencia ocorrencia = listarOcorrencia(id);

        ocorrencia.setTipo_ocorrencia(ocorrenciaEditada.getTipo_ocorrencia());
        ocorrencia.setEstado_ocorrencia(ocorrenciaEditada.getEstado_ocorrencia());
        ocorrencia.setDescricao_ocorrencia(ocorrenciaEditada.getDescricao_ocorrencia());

        return ocorrenciaRepository.updateByNativeQuery(ocorrencia.getTipo_ocorrencia(), ocorrencia.getEstado_ocorrencia(), ocorrencia.getDescricao_ocorrencia(), id);
    }
}
