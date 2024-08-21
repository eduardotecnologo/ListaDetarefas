package com.edudeveloper.tarefas.entity;

import java.time.LocalTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "tarefa")
@Data
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nomeTarefa;

    @Temporal(TemporalType.DATE)
    private Date dataInicio = new Date();

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date dataFim;

    private String descricaoTarefa;
    
    private LocalTime tempoTotal;

    private boolean concluido;

    private String status; // "PENDENTE", "REALIZADO", "CANCELADO"

    private String observacao;
}
