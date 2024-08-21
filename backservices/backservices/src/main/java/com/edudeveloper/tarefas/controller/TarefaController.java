package com.edudeveloper.tarefas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edudeveloper.tarefas.entity.Tarefa;
import com.edudeveloper.tarefas.service.TarefaService;

@RestController
@RequestMapping("/api/tarefa")
public class TarefaController {
	
	@Autowired
	private TarefaService tarefaService;
	
	@GetMapping("/")
	public List<Tarefa> buscarTodos(){
		return tarefaService.buscarTodos();	
	}
	
	@GetMapping("/pendentes")
	public List<Tarefa> buscarTarefasInicioPendente(){
        return tarefaService.buscarTarefasInicioPendente();
    }

	@GetMapping("/canceladas")
    public List<Tarefa> buscarTarefasCanceladas(){
        return tarefaService.buscarTarefasCanceladas();
    }
	
	@PostMapping("/")
	public Tarefa inserir(@RequestBody Tarefa tarefa) {
		return tarefaService.inserir(tarefa);
	}
	
	// @PostMapping("/{id}")
	// public ResponseEntity<Void> cancelar(@PathVariable("id") Long id) {
    // tarefaService.cancelarTarefa(id);
    // return ResponseEntity.ok().build();
	// }
	@PutMapping("/{id}/cancelar")
		public ResponseEntity<Void> cancelar(@PathVariable("id") Long id) {
		tarefaService.cancelarTarefa(id);
		return ResponseEntity.ok().build();
	}


	@PutMapping("/")
	public Tarefa alterar(@RequestBody Tarefa tarefa) {
		return tarefaService.alterar(tarefa);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <Void> excluir(@PathVariable("id") Long id) {
		tarefaService.excluir(id);
		return ResponseEntity.ok().build();
	}
}
