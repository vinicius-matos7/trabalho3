package com.example.notificacao;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Evento {
    private final int prioridade;
    private final LocalDateTime inicio;
    private final LocalDateTime fim;
    private final String descricao;

    public Evento(int prioridade, LocalDateTime inicio, LocalDateTime fim, String descricao) {
        this.prioridade = prioridade;
        this.inicio = inicio;
        this.fim = fim;
        this.descricao = descricao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean iniciaEm(LocalDate dia) {
        return inicio.toLocalDate().equals(dia);
    }

    public boolean iniciaEntre(LocalDateTime inicio, LocalDateTime fim) {
        return (this.inicio.isEqual(inicio) || this.inicio.isAfter(inicio)) &&
               (this.inicio.isEqual(fim) || this.inicio.isBefore(fim));
    }
}
