# Jamily-Ricardo Musical Interface - 1.0

O Jamily-Ricardo Musical Interface (JRMI) é uma linguagem de interfaceamento musical que permite representar músicas em forma de um conjunto de tags simples que representam elementos musicais, os quais podem ser notas musicais, ao especificar a sua base, oitava e tempo de duração, ou pausas, que recebem apenas o seu tempo de duração.

Todas as tags deste protocolo possuem `|>` no início e `;` no final.

## Metadados da música
Iniciam com uma palavra-chave que especifica o metadado que está sendo definido seguido de um parâmetro que indica o seu valor.

Exemplo: |>TITULO Alecrim Dourado;

### Título: TITULO

    Define o título da música e recebe um único parâmetro do tipo texto.

### Autor: AUTOR

    Define o nome do autor da música e recebe um único parâmetro do tipo texto.

### Descrição: DESC

    Define uma descrição para a música e recebe um único parâmetro do tipo texto.

## Elementos musicais
Iniciam com o símbolo que representa o elemento musical que será executado e é seguido por uma série de variáveis separadas por espaços, as quais alteram a natureza da execução.

Exemplo: |>X 1000; |>G 5 800; |>F 5 800; |>E 5 400;

### Nota dó: C

    Toca a nota dó e recebe os atributos oitava e tempo de duração em milissegundos, respectivamente (ambos números inteiros).

### Nota dó sustenido: C#
    
    Toca a nota dó sustenido e recebe os atributos oitava e tempo de duração em milissegundos, respectivamente (ambos números inteiros).

### Nota ré: D
    
    Toca a nota ré e recebe os atributos oitava e tempo de duração em milissegundos, respectivamente (ambos números inteiros).

### Nota ré sustenido: D#
    
    Toca a nota ré sustenido e recebe os atributos oitava e tempo de duração em milissegundos, respectivamente (ambos números inteiros).

### Nota mi: E
    
    Toca a nota mi e recebe os atributos oitava e tempo de duração em milissegundos, respectivamente (ambos números inteiros).

### Nota fá: F
    
    Toca a nota fá e recebe os atributos oitava e tempo de duração em milissegundos, respectivamente (ambos números inteiros).

### Nota fá sustenido: F#
    
    Toca a nota fá sustenido e recebe os atributos oitava e tempo de duração em milissegundos, respectivamente (ambos números inteiros).

### Nota sol: G
    
    Toca a nota sol e recebe os atributos oitava e tempo de duração em milissegundos, respectivamente (ambos números inteiros).

### Nota sol sustenido: G#
    
    Toca a nota sol sustenido e recebe os atributos oitava e tempo de duração em milissegundos, respectivamente (ambos números inteiros).

### Nota lá: A
    
    Toca a nota lá e recebe os atributos oitava e tempo de duração em milissegundos, respectivamente (ambos números inteiros).

### Nota lá sustenido: A#
    
    Toca a nota lá sustenido e recebe os atributos oitava e tempo de duração em milissegundos, respectivamente (ambos números inteiros).

### Nota si: B
    
    Toca a nota si e recebe os atributos oitava e tempo de duração em milissegundos, respectivamente (ambos números inteiros).

### Pausa: X

    Pausa a reprodução da música e recebe como atributo o tempo de duração em milissegundos.
