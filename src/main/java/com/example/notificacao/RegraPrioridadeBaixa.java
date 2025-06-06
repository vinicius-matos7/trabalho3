package com.example.notificacao;

import java.time.LocalDateTime;

public class RegraPrioridadeBaixa extends RegraNotificacao {
    public RegraPrioridadeBaixa(MensagemFormatador formatador,
                                MensagemEnviador enviador,
                                GoogleCalendarService calendar) {
        super(formatador, enviador, calendar);
    }

    @Override
    protected boolean condicao(Evento evento) {
        LocalDateTime doisDiasAtras = LocalDateTime.now().minusDays(2);
        return evento.getPrioridade() >= 1 && evento.getPrioridade() < 5 &&
               evento.iniciaEntre(doisDiasAtras, LocalDateTime.now());
    }
}
