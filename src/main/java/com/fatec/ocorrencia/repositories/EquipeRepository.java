package com.fatec.ocorrencia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fatec.ocorrencia.entities.Equipe;

import jakarta.transaction.Transactional;

public interface EquipeRepository extends JpaRepository<Equipe, Integer>{
    @Query(value = "SELECT * FROM equipe", nativeQuery = true)
    List<Equipe> findByNativeQuery();

    @Query(value = "SELECT * FROM equipe WHERE id_equipe = :id_equipe", nativeQuery = true)
    Equipe findByIdByNativeQuery(@Param("id_equipe") Integer id_equipe);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO equipe(cod_primeiro_integrante, cod_segundo_integrante, cod_terceiro_integrante, cod_quarto_integrante) VALUES(:cod_primeiro_integrante, :cod_segundo_integrante, :cod_terceiro_integrante, :cod_quarto_integrante)", nativeQuery = true)
    Integer insertByNativeQuery(@Param("cod_primeiro_integrante") Integer cod_primeiro_integrante, @Param("cod_segundo_integrante") Integer cod_segundo_integrante, @Param("cod_terceiro_integrante") Integer cod_terceiro_integrante, @Param("cod_quarto_integrante") Integer cod_quarto_integrante);

    @Modifying
    @Transactional
    @Query(value = "UPDATE equipe SET cod_primeiro_integrante = :cod_primeiro_integrante, cod_segundo_integrante = :cod_segundo_integrante, cod_terceiro_integrante = :cod_terceiro_integrante, cod_quarto_integrante = :cod_quarto_integrante WHERE id_equipe = :id_equipe", nativeQuery = true)
    Integer updateByNativeQuery(@Param("cod_primeiro_integrante") Integer cod_primeiro_integrante, @Param("cod_segundo_integrante") Integer cod_segundo_integrante, @Param("cod_terceiro_integrante") Integer cod_terceiro_integrante, @Param("cod_quarto_integrante") Integer cod_quarto_integrante, @Param("id_equipe") Integer id_equipe);
}
