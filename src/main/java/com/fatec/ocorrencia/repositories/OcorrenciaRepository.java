package com.fatec.ocorrencia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fatec.ocorrencia.entities.Ocorrencia;

import jakarta.transaction.Transactional;

public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Integer>{
    @Query(value = "SELECT * FROM ocorrencia", nativeQuery = true)
    List<Ocorrencia> findByNativeQuery();

    @Query(value = "SELECT * FROM ocorrencia WHERE id = :id", nativeQuery = true)
    Ocorrencia findByIdByNativeQuery(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ocorrencia(tipo_ocorrencia, estado_ocorrencia, descricao_ocorrencia) VALUES(:tipo_ocorrencia, :estado_ocorrencia, :descricao_ocorrencia)", nativeQuery = true)
    Integer insertByNativeQuery(@Param("tipo_ocorrencia") String tipo_ocorrencia, @Param("estado_ocorrencia") String estado_ocorrencia, @Param("descricao_ocorrencia") String descricao_ocorrencia);

    @Modifying
    @Transactional
    @Query(value = "UPDATE ocorrencia SET tipo_ocorrencia = :tipo_ocorrencia, estado_ocorrencia = :estado_ocorrencia, descricao_ocorrencia = :descricao_ocorrencia WHERE id = :id", nativeQuery = true)
    Integer updateByNativeQuery(@Param("tipo_ocorrencia") String tipo_ocorrencia, @Param("estado_ocorrencia") String estado_ocorrencia, @Param("descricao_ocorrencia") String descricao_ocorrencia, @Param("id") Integer id);
}
