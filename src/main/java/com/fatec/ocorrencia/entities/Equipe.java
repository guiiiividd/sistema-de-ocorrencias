package com.fatec.ocorrencia.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipe")
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_equipe;
    private Integer cod_primeiro_integrante;
    private Integer cod_segundo_integrante;
    private Integer cod_terceiro_integrante;
    private Integer cod_quarto_integrante;

    public Integer getId_equipe() {
        return id_equipe;
    }

    public void setId_equipe(Integer id_equipe) {
        this.id_equipe = id_equipe;
    }

    public Integer getCod_primeiro_integrante() {
        return cod_primeiro_integrante;
    }

    public void setCod_primeiro_integrante(Integer cod_primeiro_integrante) {
        this.cod_primeiro_integrante = cod_primeiro_integrante;
    }

    public Integer getCod_segundo_integrante() {
        return cod_segundo_integrante;
    }

    public void setCod_segundo_integrante(Integer cod_segundo_integrante) {
        this.cod_segundo_integrante = cod_segundo_integrante;
    }

    public Integer getCod_terceiro_integrante() {
        return cod_terceiro_integrante;
    }

    public void setCod_terceiro_integrante(Integer cod_terceiro_integrante) {
        this.cod_terceiro_integrante = cod_terceiro_integrante;
    }

    public Integer getCod_quarto_integrante() {
        return cod_quarto_integrante;
    }

    public void setCod_quarto_integrante(Integer cod_quarto_integrante) {
        this.cod_quarto_integrante = cod_quarto_integrante;
    }

}
