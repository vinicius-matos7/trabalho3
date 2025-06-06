# Padrões de Projeto Utilizados

## Chain of Responsibility

O `Notificador` delega o processamento para uma cadeia de objetos do tipo
`RegraNotificacao`. Cada regra verifica se deve tratar o evento e, em caso
afirmativo, executa o algoritmo de notificação. Caso contrário, passa o evento
para a próxima regra.

Participantes:
- `Notificador` – cliente que dispara a cadeia.
- `RegraNotificacao` – manipulador abstrato que mantém a referência para o
  próximo manipulador e define a operação `processar`.
- `RegraPrioridadeAlta`, `RegraPrioridadeMedia`, `RegraPrioridadeBaixa` –
  manipuladores concretos que verificam condições específicas.

## Template Method

A classe `RegraNotificacao` define o esqueleto do algoritmo de notificação em
`processar(Evento)`, contendo as etapas de formatação, adição ao Google Calendar
e envio da mensagem. Cada subclasse implementa apenas o método
`condicao(Evento)` para indicar quando a regra deve ser aplicada.

## Strategy

A formatação da mensagem e a forma de envio são estratégicas. As interfaces
`MensagemFormatador` e `MensagemEnviador` permitem a troca dinâmica dessas
responsabilidades. Implementações concretas, como `FormatadorEmail`,
`FormatadorWhatsApp`, `EnviadorEmail` e `EnviadorWhatsApp`, podem ser
combinadas livremente.

Para suportar múltiplos envios foi criado `EnviadorComposto`, que aplica o
padrão Composite/Decorator e encaminha a mensagem para vários
`MensagemEnviador`.

## Benefícios

Com esta estrutura, novas regras de notificação podem ser adicionadas sem
alterar as classes existentes. Também é possível incluir novos formatos ou
meios de envio implementando as interfaces correspondentes, mantendo a classe
`Notificador` simples e estável.
