package com.example.notificacao;

public class EnviadorWhatsApp implements MensagemEnviador {
    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando WhatsApp: " + mensagem);
    }
}
