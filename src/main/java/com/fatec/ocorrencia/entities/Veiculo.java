package com.fatec.ocorrencia.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "veiculo")
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_veiculo;
    private String placa_veiculo;
    private String tipo_veiculo;
    private Integer capacidade_veiculo;
    private String tipo_ocorrencia_tratada;
    private String status_veiculo;

    public Integer getId_veiculo() {
        return id_veiculo;
    }

    public void setId_veiculo(Integer id_veiculo) {
        this.id_veiculo = id_veiculo;
    }

    public String getTipo_veiculo() {
        return tipo_veiculo;
    }

    public void setTipo_veiculo(String tipo_veiculo) {
        this.tipo_veiculo = tipo_veiculo;
    }

    public Integer getCapacidade_veiculo() {
        return capacidade_veiculo;
    }

    public void setCapacidade_veiculo(Integer capacidade_veiculo) {
        this.capacidade_veiculo = capacidade_veiculo;
    }

    public String getTipo_ocorrencia_tratada() {
        return tipo_ocorrencia_tratada;
    }

    public void setTipo_ocorrencia_tratada(String tipo_ocorrencia_tratada) {
        this.tipo_ocorrencia_tratada = tipo_ocorrencia_tratada;
    }

    public String getPlaca_veiculo() {
        return placa_veiculo;
    }

    public void setPlaca_veiculo(String placa_veiculo) {
        this.placa_veiculo = placa_veiculo;
    }

    public String getStatus_veiculo() {
        return status_veiculo;
    }

    public void setStatus_veiculo(String status_veiculo) {
        this.status_veiculo = status_veiculo;
    }

}
