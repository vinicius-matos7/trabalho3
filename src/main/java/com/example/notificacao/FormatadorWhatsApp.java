package com.example.notificacao;

public class FormatadorWhatsApp implements MensagemFormatador {
    @Override
    public String formatar(Evento evento) {
        return "[WHATSAPP] Evento: " + evento.getDescricao();
    }
}
