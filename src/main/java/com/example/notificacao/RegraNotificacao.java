package com.example.notificacao;

public abstract class RegraNotificacao {
    protected final MensagemFormatador formatador;
    protected final MensagemEnviador enviador;
    protected final GoogleCalendarService calendar;
    protected RegraNotificacao proxima;

    protected RegraNotificacao(MensagemFormatador formatador,
                               MensagemEnviador enviador,
                               GoogleCalendarService calendar) {
        this.formatador = formatador;
        this.enviador = enviador;
        this.calendar = calendar;
    }

    public void setProxima(RegraNotificacao proxima) {
        this.proxima = proxima;
    }

    public void processar(Evento evento) {
        if (condicao(evento)) {
            String mensagem = formatador.formatar(evento);
            calendar.adicionarEvento(mensagem);
            enviador.enviar(mensagem);
        } else if (proxima != null) {
            proxima.processar(evento);
        }
    }

    protected abstract boolean condicao(Evento evento);
}
