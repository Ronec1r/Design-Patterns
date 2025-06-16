# Padrão Interpreter

## Situação Problema
Um sistema de automação residencial precisa avaliar condições como:  
*"Se a temperatura > 25°C, ligue o ar-condicionado; se movimento for detectado, acenda a luz."*  
Essas regras envolvem expressões relacionais (ex: comparações) e ações sequenciais (ex: executar comandos). O desafio é interpretar essas regras dinamicamente, permitindo flexibilidade para adicionar novas condições e ações sem reescrever o código.

---

## Problema Resolvido pelo Padrão Interpreter
Interpretar uma gramática específica (como condições e comandos) de forma estruturada, evitando código complexo e repetitivo para análise de expressões. O padrão organiza a avaliação de regras em uma hierarquia de objetos, onde cada expressão sabe como se interpretar.

---

## Solução do Padrão Interpreter 
- **Expressões Terminais:** Representam elementos atômicos (ex: variáveis, comandos).  
  - Exemplo: `Variavel<T>` (armazena valores comparáveis) e `Executavel` (executa um comando).  
- **Expressões Não Terminais:** Combinam expressões para formar lógicas complexas.  
  - Exemplo: `ExpressaoRelacional` (comparações), `ExpressaoCondicional` (if-then), `ExpressaoSequencial` (execução em ordem).  
- Cada classe implementa `interpretar()`, encapsulando a lógica de avaliação ou execução.

---

## Benefícios 
1. **Extensibilidade:** Adicionar novas expressões (ex: `ExpressaoMenor`) é simples.  
2. **Estrutura Clara:** Separação entre terminais e não terminais facilita a compreensão.  
3. **Reuso:** Expressões podem ser combinadas livremente (ex: condições aninhadas).  
4. **Testabilidade:** Cada expressão pode ser testada isoladamente.

---

## Desvantagens
1. **Complexidade para Gramáticas Simples:** Overhead de classes para regras simples.  
2. **Manutenção Custo-Alto:** Alterar a gramática exige modificações em múltiplas classes.  
3. **Desempenho:** Interpretação baseada em objetos pode ser menos eficiente que abordagens diretas.

## Conclusão
O padrão Interpreter foi aplicado para modelar expressões condicionais e sequenciais, como `se temperatura > 25 então ligar ArCondicionado`. As classes `ExpressaoTerminal` e suas subclasses representam valores e variáveis, enquanto `ExpressaoCondicional` e `ExpressaoSequencial` compõem a lógica de controle. Isso permite que o sistema interprete comandos complexos de forma modular, facilitando a adição de novas regras e integração com outros padrões (ex: Command).