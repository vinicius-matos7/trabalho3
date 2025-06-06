package com.example.notificacao;

import java.time.LocalDate;

public class RegraPrioridadeAlta extends RegraNotificacao {
    public RegraPrioridadeAlta(MensagemFormatador formatador,
                               MensagemEnviador enviador,
                               GoogleCalendarService calendar) {
        super(formatador, enviador, calendar);
    }

    @Override
    protected boolean condicao(Evento evento) {
        return evento.getPrioridade() == 10 && evento.iniciaEm(LocalDate.now());
    }
}
