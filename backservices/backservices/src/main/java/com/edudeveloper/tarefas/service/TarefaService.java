package com.edudeveloper.tarefas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edudeveloper.tarefas.entity.Tarefa;
import com.edudeveloper.tarefas.repository.TarefaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TarefaService {
    @Autowired
    private TarefaRepository tarefaRepository;

    public List<Tarefa> buscarTodos(){
        return tarefaRepository.findAll();
    }

    public List<Tarefa> buscarTarefasInicioPendente(){
        return tarefaRepository.buscarTarefasInicioPendente();
    }

    public List<Tarefa> buscarTarefasCanceladas(){
        return tarefaRepository.buscarTarefasCanceladas();
    }

    public Tarefa inserir(Tarefa tarefa){
        if (!tarefa.isConcluido()) {
            tarefa.setStatus("pendente");
        } else {
            tarefa.setStatus("realizado");
        }
        return tarefaRepository.saveAndFlush(tarefa);
    }

    public Tarefa alterar(Tarefa tarefa){
        if (!tarefa.isConcluido()) {
            tarefa.setStatus("realizado");
        }
        return tarefaRepository.saveAndFlush(tarefa);
    }

    // public void cancelarTarefa(Long id) {
    //     Tarefa tarefa = tarefaRepository.findById(id)
    //             .orElseThrow(() -> new EntityNotFoundException("Tarefa não encontrada com ID: " + id));
    //     tarefa.setStatus("cancelado");
    //     tarefaRepository.save(tarefa);
    // }
    public void cancelarTarefa(Long id) {
        Tarefa tarefa = tarefaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        tarefa.setStatus("cancelado");
        tarefaRepository.save(tarefa);
    }
    

    public void excluir(Long id){
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tarefa não encontrada com ID: " + id));
        tarefaRepository.delete(tarefa);
    }
}
