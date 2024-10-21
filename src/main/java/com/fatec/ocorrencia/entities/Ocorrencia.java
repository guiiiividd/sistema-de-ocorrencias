package com.fatec.ocorrencia.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ocorrencia")
public class Ocorrencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tipo_ocorrencia;
    private String estado_ocorrencia;
    private String descricao_ocorrencia;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo_ocorrencia() {
        return tipo_ocorrencia;
    }

    public void setTipo_ocorrencia(String tipo_ocorrencia) {
        this.tipo_ocorrencia = tipo_ocorrencia;
    }

    public String getEstado_ocorrencia() {
        return estado_ocorrencia;
    }

    public void setEstado_ocorrencia(String estado_ocorrencia) {
        this.estado_ocorrencia = estado_ocorrencia;
    }

    public String getDescricao_ocorrencia() {
        return descricao_ocorrencia;
    }

    public void setDescricao_ocorrencia(String descricao_ocorrencia) {
        this.descricao_ocorrencia = descricao_ocorrencia;
    }

}
