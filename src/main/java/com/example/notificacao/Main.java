package com.example.notificacao;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        GoogleCalendarService calendar = new GoogleCalendarService();

        MensagemEnviador email = new EnviadorEmail();
        MensagemEnviador whats = new EnviadorWhatsApp();

        MensagemEnviador ambos = new EnviadorComposto(Arrays.asList(email, whats));

        RegraNotificacao alta = new RegraPrioridadeAlta(new FormatadorWhatsApp(), ambos, calendar);
        RegraNotificacao media = new RegraPrioridadeMedia(new FormatadorEmail(), email, calendar);
        RegraNotificacao baixa = new RegraPrioridadeBaixa(new FormatadorEmail(), mensagem -> {}, calendar);

        alta.setProxima(media);
        media.setProxima(baixa);

        Notificador notificador = new Notificador(alta);

        Evento e1 = new Evento(10, LocalDateTime.now(), LocalDateTime.now().plusHours(1), "Reuniao urgente");
        Evento e2 = new Evento(7, LocalDateTime.now(), LocalDateTime.now().plusHours(1), "Reuniao de equipe");
        Evento e3 = new Evento(3, LocalDateTime.now().minusDays(1), LocalDateTime.now().minusDays(1).plusHours(1), "Aviso de prova");

        notificador.notificar(e1);
        notificador.notificar(e2);
        notificador.notificar(e3);
    }
}
