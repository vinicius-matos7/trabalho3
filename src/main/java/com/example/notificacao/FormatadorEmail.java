package com.example.notificacao;

public class FormatadorEmail implements MensagemFormatador {
    @Override
    public String formatar(Evento evento) {
        return "[EMAIL] Evento: " + evento.getDescricao();
    }
}
