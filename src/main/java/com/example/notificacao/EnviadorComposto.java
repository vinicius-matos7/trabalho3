package com.example.notificacao;

import java.util.List;

public class EnviadorComposto implements MensagemEnviador {
    private final List<MensagemEnviador> enviadores;

    public EnviadorComposto(List<MensagemEnviador> enviadores) {
        this.enviadores = enviadores;
    }

    @Override
    public void enviar(String mensagem) {
        for (MensagemEnviador e : enviadores) {
            e.enviar(mensagem);
        }
    }
}
