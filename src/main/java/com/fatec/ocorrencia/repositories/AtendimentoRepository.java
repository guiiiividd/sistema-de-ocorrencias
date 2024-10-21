package com.fatec.ocorrencia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fatec.ocorrencia.entities.Atendimento;

import jakarta.transaction.Transactional;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Integer>{
    @Query(value = "SELECT * FROM atendimento", nativeQuery = true)
    List<Atendimento> findByNativeQuery();

    @Query(value = "SELECT * FROM atendimento WHERE id = :id", nativeQuery = true)
    Atendimento findByIdByNativeQuery(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO atendimento(id_ocorrencia, id_equipe) VALUES(:id_ocorrencia, :id_equipe)", nativeQuery = true)
    Integer insertByNativeQuery(@Param("id_ocorrencia") Integer id_ocorrencia, @Param("id_equipe") Integer id_equipe);

    @Modifying
    @Transactional
    @Query(value = "UPDATE atendimento SET id_ocorrencia = :id_ocorrencia, id_equipe = :id_equipe WHERE id_atendimento = :id_atendimento", nativeQuery = true)
    Integer updateByNativeQuery(@Param("id_ocorrencia") Integer id_ocorrencia, @Param("id_equipe") Integer id_equipe, @Param("id_atendimento") Integer id_atendimento);
}
