# Parcelamento - API

Olá, esse é o parcelamento API, uma API feita por mim para estudar alguns conceitos novos de forma geral que irei descrever mais abaixo.
Pretendo usar o README como forma de descrever meu aprendizado, porem colocarei infos sobre o projeto tambem.

## Sobre o Projeto

### Rodando o projeto

Após clonar o projeto recomendo usar o do clean install do maven, como abaixo.

```bash
mvn clean install
```

Após instalado todas as dependências basta pedir a sua IDE que rode o projeto.

![image](https://github.com/Catrofe/api-parcelamento/assets/82066310/535d01f5-9a09-47dc-b656-cb42668cf653)

Para facilitar com as chamadas implementei o Open-API swagger.

```bash
http://localhost:8080/swagger-ui/index.html
```

## Decisões técnicas Descritas

### Arquitetura utilizada

Para fim de estudos optei por utilizar a Arquitetura Hexagonal, caso não conheça muito sobre o tema como eu, deixarei um link que achei muito útil.

https://github.com/caelum/apostila-oo-avancado-em-java/blob/master/13-arquitetura-hexagonal.md

#### Meu aprendizado sobre Arquitetura Hexagonal

No meu aprendizado e aplicação entendi a importância de separar nossa regra de négocio dos nossos do resto de nossa estrutura. Da Isolei toda minha regra de négocio dentro dos meus services e qualquer alteração feita no meu
service não afetou de forma nenhuma nos meus adapters. Assim como vice-versa, a alteração nos adapters não causou nenhum impacto na minha regra de négocio pois eram ambientes completamente isolados.

Claro que o nivel da minha aplicação é bem pequena porem sinto que consegui entender bem o conceito. Facilmente posso implementar uma nova Port e Adapter e aceitar comandos via CLI sem quebrar ou gerar quaisquer problemas para meu sistema.
Ou até mesmo fornecer novos Endpoints para um client diferente.

Dito isto entendo que a facilidade de novas formas de conexões com nossa Regra de négocio se torna muito facil de criar, editar e etc.
Para a implementação da estrutura de pastar utilizei esse repositório:

https://github.com/roddramos/hexagonal_architecture_java/tree/master

### Padrões de Projeto

#### Inicialmente escolhi o Abstract Factory, por que?

Na minha forma de estudos gosto de me perguntar o que preciso e a pergunta que fiz a mim mesmo foi, **"O que eu preciso?"**

Bom, minha resposta foi algo como: "Preciso implementar algumas diferentes classes que vão ter métodos parecidos porem com implementações que podem variar em pequenos detalhes.". Para mim parecia óbvio nesse momento que o Abstract Factory faria sentido para mim.


#### Refatoração

Bom, durante a escrita dessa documentação fiquei pensativo sobre e talvez abstract factory já não me faz tanto sentido, visto que eu crio uma interface que todos vão implementar e algumas vão implementar o mesmo código sem diferença. O que me faz ferir o **DRY** e deixar meu código ruim.

Agora pensando melhor faria mais sentido ter uma classe e não uma interface, onde minhas demais classes vão extender, usar o que precisam e implementar quando precisarem novos metodos. Dito isso estarei iniciando meu refactor. 

Vou deixar registrado aqui meu ultimo commit antes da refatoração para fins de estudos: https://github.com/Catrofe/api-parcelamento/tree/e1622a2e469b3f15ac5f57a0229475969aef5e74


#### Finalmente o padrão Factory

Bom, após entender o erro que cometi fiz algumas modificações, em vez de uma interface eu implementei uma classe abstrata. Ai vem o **"Por que?"**

Básicamente faria mais sentido para minha aplicação visto que algumas funções são compartilhadas entre elas e antes estavam sendo repetidas em todas as funções. Agora não mais.

Alem disso eu ainda consegui fazer com que minhas demais classes implementassem ainda minhas funções obrigatórias mantendo algo parecido como o comportamento da interface. Atendendo as necessidades da minha demanda, mantendo o código mais limpo.


### Encerramento

Chegamos ao final, fiz um resumo dos meu aprendizados aqui, sem medo de expor minhas dificuldades, dúvidas nem nada. O importante é o progresso que venho buscando ao criar meus projetos.
Se leu até aqui, obrigado e fique a vontade para deixar Issues com sugestões, ou ensinamentos. Ficarei muito grato.

Esse projeto inclusive surgiu devido a uma Issue do meu projeto Watch-Recommendation, ainda não consegui implementar tudo lá, porem consegui uma parte e pretendo continuar correndo atrás para me desenvolver cada vez mais.

Vllw Pessoal ❤
