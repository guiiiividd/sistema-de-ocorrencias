package com.fatec.ocorrencia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fatec.ocorrencia.entities.Turno;

import jakarta.transaction.Transactional;

public interface TurnoRepository extends JpaRepository<Turno, Integer> {
    @Query(value = "SELECT * FROM turno", nativeQuery = true)
    List<Turno> findByNativeQuery();

    @Query(value = "SELECT * FROM turno WHERE id_turno = :id_turno", nativeQuery = true)
    Turno findByIdByNativeQuery(@Param("id_turno") Integer id_turno);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO turno(hora_inicio, hora_fim, escala, id_equipe, id_veiculo) VALUES(:hora_inicio, :hora_fim, :escala, :id_equipe, :id_veiculo)", nativeQuery = true)
    Integer insertByNativeQuery(@Param("hora_inicio") String hora_inicio, @Param("hora_fim") String hora_fim,
            @Param("escala") String escala, @Param("id_equipe") Integer id_equipe,
            @Param("id_veiculo") Integer id_veiculo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE turno SET hora_inicio = :hora_inicio, hora_fim = :hora_fim, escala = :escala, id_equipe = :id_equipe, id_veiculo = :id_veiculo WHERE id_turno = :id_turno", nativeQuery = true)
    Integer updateByNativeQuery(@Param("hora_inicio") String hora_inicio, @Param("hora_fim") String hora_fim,
            @Param("escala") String escala, @Param("id_equipe") Integer id_equipe,
            @Param("id_veiculo") Integer id_veiculo, @Param("id_turno") Integer id_turno);
}
