package com.example.notificacao;

import java.time.LocalDate;

public class RegraPrioridadeMedia extends RegraNotificacao {
    public RegraPrioridadeMedia(MensagemFormatador formatador,
                                MensagemEnviador enviador,
                                GoogleCalendarService calendar) {
        super(formatador, enviador, calendar);
    }

    @Override
    protected boolean condicao(Evento evento) {
        return evento.getPrioridade() >= 5 && evento.iniciaEm(LocalDate.now());
    }
}
