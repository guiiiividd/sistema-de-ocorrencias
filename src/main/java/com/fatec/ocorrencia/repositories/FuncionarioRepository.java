package com.fatec.ocorrencia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fatec.ocorrencia.entities.Funcionario;

import jakarta.transaction.Transactional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{
    @Query(value = "SELECT * FROM funcionario", nativeQuery = true)
    List<Funcionario> findByNativeQuery();

    @Query(value = "SELECT * FROM funcionario WHERE id_funcionario = :id_funcionario", nativeQuery = true)
    Funcionario findByIdByNativeQuery(@Param("id_funcionario") Integer id_funcionario);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO funcionario(nome, cargo) VALUES(:nome, :cargo)", nativeQuery = true)
    Integer insertByNativeQuery(@Param("nome") String nome, @Param("cargo") String cargo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE funcionario SET nome = :nome, cargo = :cargo WHERE id_funcionario = :id_funcionario", nativeQuery = true)
    Integer updateByNativeQuery(@Param("nome") String nome, @Param("cargo") String cargo, @Param("id_funcionario") Integer id_funcionario);
}
