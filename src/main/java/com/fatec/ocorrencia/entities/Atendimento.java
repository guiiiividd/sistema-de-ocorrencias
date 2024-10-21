package com.fatec.ocorrencia.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "atendimento")
public class Atendimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_atendimento;
    private Integer id_ocorrencia;
    private Integer id_equipe;

    public Integer getId_atendimento() {
        return id_atendimento;
    }

    public void setId_atendimento(Integer id_atendimento) {
        this.id_atendimento = id_atendimento;
    }

    public Integer getId_ocorrencia() {
        return id_ocorrencia;
    }

    public void setId_ocorrencia(Integer id_ocorrencia) {
        this.id_ocorrencia = id_ocorrencia;
    }

    public Integer getId_equipe() {
        return id_equipe;
    }

    public void setId_equipe(Integer id_equipe) {
        this.id_equipe = id_equipe;
    }

}
