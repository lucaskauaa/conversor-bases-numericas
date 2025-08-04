# 🔢 Conversor de Bases Numéricas

Projeto feito em **Java**, no qual o usuário pode inserir um número inteiro e o algoritmo calcula e exibe o número convertido para outras bases numéricas.

## ✅ Funcionalidades

1. Lê um número inserido pelo usuário.  
2. Converte e exibe o número nas bases **binária**, **octal**, **decimal** e **hexadecimal**.

## ▶️ Como Executar

1. Ter o **Java** (*versão 21*) e o editor de código **Eclipse** instalados no computador.  
2. Baixar o arquivo `.zip` ou clonar o repositório: https://github.com/lucaskauaa/conversor-bases-numericas.git (é necessário ter o Git instalado).  
3. Abrir a pasta do projeto no Eclipse → acessar o arquivo `src/application/Main.java` → clicar com o botão direito → **Run As** → **Java Application**.

## 🧪 Exemplo de Uso

```
Insira o número que você quer converter: AF11

Indique a base do número que você inseriu: 
[10] Decimal
[2] Binário
[8] Octal
[16] Hexadecimal
16

Número inserido: AF11 base 16

Resultado da conversão:

Decimal: 44817
Binário: 1010111100010001
Octal: 127421
Hexadecimal: AF11

Converter novamente ? s/n n
```

## 🧠 Tecnologias Utilizadas

- Java  
- Programação Orientada a Objetos

## 📁 Estrutura do Projeto

```
src/
├── application/
│ └── Main.java
└── util/
└── Converter.java
```

- `Main.java`: Responsável pela interação com o usuário.
- `Converter.java`: Contém a lógica de conversão utilizando métodos estáticos como `convertToDecimal()` e `convertDecimalToAnotherBase()`.

## 🧑‍💻 Autor

Desenvolvido por **Lucas Kauã**.
