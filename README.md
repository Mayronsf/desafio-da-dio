# Desafio POO DIO — Abstraindo um Bootcamp com Java

Modelagem de um Bootcamp aplicando os pilares da Orientação a Objetos.

## Pilares aplicados
- **Abstração**: `Conteudo`, `Curso`, `Mentoria`, `Bootcamp` e `Dev` representam o domínio real.
- **Encapsulamento**: atributos privados com getters/setters; os conteúdos do `Dev` só mudam via `inscreverBootcamp()` e `progredir()`.
- **Herança**: `Curso` e `Mentoria` estendem a classe abstrata `Conteudo`.
- **Polimorfismo**: cada conteúdo implementa `calcularXp()` à sua maneira.

## Evoluções
- Validação da carga horária do curso
- XP total do bootcamp (`Bootcamp.calcularXpTotal()`)
- Percentual de progresso do dev (`Dev.calcularProgresso()`)
- Ranking dos devs por XP

## Como executar
```bash
javac -encoding UTF-8 -d out $(find src -name "*.java")
java -cp out br.com.dio.desafio.Main
```
