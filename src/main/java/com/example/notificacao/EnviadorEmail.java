package com.example.notificacao;

public class EnviadorEmail implements MensagemEnviador {
    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando email: " + mensagem);
    }
}
