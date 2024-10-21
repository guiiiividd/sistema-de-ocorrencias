package com.fatec.ocorrencia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fatec.ocorrencia.entities.Veiculo;

import jakarta.transaction.Transactional;

public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {
    @Query(value = "SELECT * FROM veiculo", nativeQuery = true)
    List<Veiculo> findByNativeQuery();

    @Query(value = "SELECT * FROM veiculo WHERE id_veiculo = :id_veiculo", nativeQuery = true)
    Veiculo findByIdByNativeQuery(@Param("id") Integer id_veiculo);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO veiculo(placa_veiculo, tipo_veiculo, capacidade_veiculo, tipo_ocorrencia_tratada, status_veiculo) VALUES(:placa_veiculo, :tipo_veiculo, :capacidade_veiculo, :tipo_ocorrencia_tratada, :status_veiculo)", nativeQuery = true)
    Integer insertByNativeQuery(@Param("placa_veiculo") String placa_veiculo,
            @Param("tipo_veiculo") String tipo_veiculo, @Param("capacidade_veiculo") Integer capacidade_veiculo,
            @Param("tipo_ocorrencia_tratada") String tipo_ocorrencia_tratada, @Param("status_veiculo") String status);

    @Modifying
    @Transactional
    @Query(value = "UPDATE veiculo SET placa_veiculo = :placa_veiculo, tipo_veiculo = :tipo_veiculo, capacidade_veiculo = :capacidade_veiculo, tipo_ocorrencia_tratada = :tipo_ocorrencia_tratada, status_veiculo = :status_veiculo WHERE id_veiculo = :id_veiculo", nativeQuery = true)
    Integer updateByNativeQuery(@Param("placa_veiculo") String placa_veiculo,
            @Param("tipo_veiculo") String tipo_veiculo, @Param("capacidade_veiculo") Integer capacidade_veiculo,
            @Param("tipo_ocorrencia_tratada") String tipo_ocorrencia_tratada, @Param("status_veiculo") String status,
            @Param("id_veiculo") Integer id_veiculo);
}
