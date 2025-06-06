package com.example.notificacao;

public class Notificador {
    private final RegraNotificacao primeiraRegra;

    public Notificador(RegraNotificacao primeiraRegra) {
        this.primeiraRegra = primeiraRegra;
    }

    public void notificar(Evento evento) {
        if (primeiraRegra != null) {
            primeiraRegra.processar(evento);
        }
    }
}
