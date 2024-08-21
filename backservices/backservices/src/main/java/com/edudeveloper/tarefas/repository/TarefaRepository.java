package com.edudeveloper.tarefas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edudeveloper.tarefas.entity.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    @Query("SELECT T FROM Tarefa T WHERE T.concluido <> TRUE AND T.status <> 'CANCELADO'")
    List<Tarefa> buscarTarefasInicioPendente();

    @Query("SELECT T FROM Tarefa T WHERE T.status = 'CANCELADO'")
    List<Tarefa> buscarTarefasCanceladas();

}
