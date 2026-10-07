# Mega-Seninha — Atividade 1 (Paradigmas / FNR)

Solução **puramente imperativa** em Java, conforme o PDF em `docs/`.

## O que o programa faz

1. Lê `APOSTAS.TXT`
2. Compara cada aposta com os 6 números sorteados
3. Grava em `GANHADORES.TXT` o CPF dos que acertaram os 6 números (com pontuação)

## Arquivos da entrega

| Arquivo | Função |
|---------|--------|
| `MegaSeninha.java` | código-fonte (procedimentos/funções `static`) |
| `APOSTAS.TXT` | arquivo de entrada (exemplo do enunciado) |
| `GANHADORES.TXT` | gerado na execução |

## Como compilar e executar

Na pasta do projeto (onde estão `MegaSeninha.java` e `APOSTAS.TXT`):

```bash
javac MegaSeninha.java
java MegaSeninha
```

Com Java 21 (PowerShell), se o `java` padrão for 8:

```powershell
$env:JAVA_HOME = "C:\Program Files\Java\jdk-21"
$env:Path = "$env:JAVA_HOME\bin;$env:Path"
javac MegaSeninha.java
java MegaSeninha
```

Saída esperada em `GANHADORES.TXT` (exemplo do PDF):

```
123.456.789-09
519.087.236-02
```

## Funções do programa

- `main` — inicia o processamento
- `processarApostas` — lê entrada e grava saída
- `converterLinhaEmNumeros` — transforma a linha em vetor de inteiros
- `acertouTodos` — confere se os 6 números batem
- `contemNumero` — procura um número no vetor
- `formatarCpf` — formata `12345678909` → `123.456.789-09`

## Entrega por email

- **Para:** lin.tse.min@gmail.com
- **Prazo:** 18/out (domingo)
- **Assunto:** `FNR-Paradigmas. Atividade 1: <nome1> e <nome2>`
- **Corpo:** nome completo + matrícula dos dois + estas instruções de compilar/executar
- **Anexo:** `MegaSeninha.java` (e, se quiser, `APOSTAS.TXT`)
