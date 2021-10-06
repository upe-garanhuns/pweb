<h1 align="center"> 
[Programação WEB com Java]
</h1>
<h4 align="center"> 
    Universidade de Pernambuco | Campus Garanhuns | Coordenação de Computação
</h4>
<h4 align="center"> 
 🚧 Java para WEB 🚀 em construção... 🚧
</h4>
<p align="center">
  <img alt="GitHub language count" src="https://img.shields.io/github/languages/count/tgmarinho/nlw1?color=%2304D361">
  <img alt="Repository size" src="https://img.shields.io/github/repo-size/tgmarinho/nlw1">
  <a href="https://github.com/tgmarinho/nlw1/commits/master">
    <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/tgmarinho/nlw1">
  </a>
</p>

## Estrutura

- [Sobre](#sobre)
- [Requisitos](#requisitos)
- [Configuração de Ambiente](#configuracao)
- [Licença](#license)
- [Autor](#autor)

---

## Objetivo

Vivenciar a experiência de construir soluções Java para WEB utilizando Spring Framework e ReactJS.

## Requisitos

- Git
- Java Virtual Machine 11
- Maven 3.6.3
- Eclipse IDE ou Visual Studio Code
- Spring Tool Suite 4 (plugin)
- Postgre SQL

---

## Configuração de Ambiente

### SDKMan

Existe um [BUG](https://github.com/sdkman/sdkman-cli/issues/593) no SDKMAN no Windows que não efetua corretamente a troca de versões dos sdks na pasta current. Para corrigi-lo é necessário fazer uma alteração no arquivo *.bashrc* que existe na sua pasta de usuário.

1. Abra o arquivo ```.bashrc```
2. Acrescente uma linha em branco no início do arquivo
3. Cole esta instrução ```export MSYS=winsymlinks:lnk``` na linha criada.
4. Salve o arquivo

### Máquina Virtual Java

O Eclipse 4.7, que é compatível com o Spring Tool Suite, precisa da JVM na versão 11

1. Abra o ConEmu(MinGW) e instale o sdk utilizando o seguinte comando ```sdk install java 11.0.8.j9-adpt```
2. Após a instalação o SDKMan já pergunta se você deseja tornar a versão instalada como padrão, é só aceitar escolhendo a opção ```Y```.
3. Execute ```java -version``` para ter certeza que o jdk foi atualizado e você consiga verificar qual a versão está sendo utilizada

### Maven

Execute ```mvn -version``` no terminal de comando para ter certeza que o Maven foi instalado corretamente

### GitHub

1. Faça o aceite do convide enviado para acesso ao repositório da disciplina.
2. Clique na URL do repositório para acessá-lo
3. Clique no botão "Code", copie a URL do repositório
4. Faça o clone da branch no seu workspace utilizando o link copiado

- Lembre-se de ter configurado as variáveis de usuário no seu arquivo global do git

  - ```git config --global user.email "you@example.com"```
  - ```git config --global user.name "Your Name"```

### Eclipse e Spring Tool Suite (STS)

1. O STS precisa do Eclipse na versão [4.7](https://www.eclipse.org/downloads/packages/release/2020-09/r/eclipse-ide-enterprise-java-developers)
2. Baixe, descompacte
3. Execute o Eclipse no workspace onde realizou o clone do projeto

### Spring Tool Suite

1. No Eclipse acesse o menu ```Help > Eclipse Marketplace``` e procure por ```Spring Tools 4```
2. Clique em ```install``` e execute os passos de instalação

---

## Licença

MIT License

Copyright (c) [2021] [Helaine Barreiros]

---

## Autor

- Twitter - [@hbarreiros_](https://twitter.com/hbarreiros_)

[Voltar](#estrutura)
