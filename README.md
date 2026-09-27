# Jogo da Forca em Java

Implementação do clássico jogo da forca, desenvolvida em Java como parte de exercícios acadêmicos de Programação Orientada a Objetos.

## 💡 Sobre o projeto

O sistema simula uma partida de jogo da forca, controlando o número de erros permitidos, as letras já digitadas pelo jogador e o estado da palavra a ser descoberta.

## 🛠️ Tecnologias utilizadas

- Java

## 📂 Estrutura de classes

- **`Main.java`** — Classe principal, responsável por iniciar e coordenar o jogo.
- **`Teclado.java`** — Responsável pela leitura das entradas do jogador.
- **`BancoDePalavras.java`** — Armazena e fornece as palavras disponíveis para o jogo.
- **`Palavra`** — Representa a palavra a ser descoberta pelo jogador.
- **`Tracinhos`** — Controla a exibição da palavra com espaços/traços para as letras ainda não descobertas.
- **`ControladorDeErros`** — Controla a quantidade de erros cometidos durante a partida.
- **`ControladorDeLetrasJaDigitadas`** — Controla quais letras já foram digitadas, evitando repetições.

## ▶️ Como executar

1. Clone este repositório:
   ```bash
   git clone https://github.com/devJonas07/Classes-Java.git
   ```
2. Compile os arquivos `.java`:
   ```bash
   javac *.java
   ```
3. Execute a classe principal:
   ```bash
   java Main
   ```

## 📌 Status

Projeto desenvolvido para fins de estudo e prática de Programação Orientada a Objetos em Java.
