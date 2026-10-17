# Mega-Seninha — Atividade 1 (Paradigmas / FNR)

Solução **puramente imperativa** em Java, conforme o PDF em `docs/`.
Equipe: Pedro Nascimento e Yago Barbosa.

## O que o programa faz

1. Lê `APOSTAS.TXT`
2. Compara cada aposta com os 6 números sorteados
3. Grava em `GANHADORES.TXT` o CPF dos que acertaram os 6 números (com pontuação)

## Como compilar e executar

Na pasta do projeto (onde estão `MegaSeninha.java` e `APOSTAS.TXT`), com Java 8 ou superior:

```bash
javac MegaSeninha.java
java MegaSeninha
```

Exemplo do PDF — saída esperada em `GANHADORES.TXT`:

```
123.456.789-09
519.087.236-02
```

## Funções do programa

- `main` — lê `APOSTAS.TXT`, confere cada aposta e grava `GANHADORES.TXT`
- `lerNumeros` — transforma a linha `"14 23 53 56 57 60"` em um vetor de 6 inteiros
- `acertouTodos` — conta quantos números da aposta estão entre os sorteados (precisa ser 6)
- `formatarCpf` — formata `12345678909` → `123.456.789-09`

## Entrega por email

- **Para:** lin.tse.min@gmail.com
- **Prazo:** 18/out (domingo)
- **Assunto:** `FNR-Paradigmas. Atividade 1: Pedro Nascimento e Yago Barbosa`
- **Corpo:** nome completo + matrícula dos dois + estas instruções de compilar/executar
- **Anexo:** `MegaSeninha.java`
