# Padrão Builder

---

## Situação Problema
Uma loja de computadores precisa montar notebooks com configurações específicas (ex: Gamer, Ultra, básico). Cada configuração requer diferentes combinações de processador, RAM e armazenamento. Sem uma estrutura organizada, a criação desses objetos seria caótica: construtores com muitos parâmetros, repetição de código para cada tipo de notebook e dificuldade em adicionar novas configurações. O Builder resolve isso separando a construção do objeto de sua representação final.

---

## Problema que o Builder Resolve
O padrão Builder aborda:  
- **Construtores complexos**: Evita construtores com múltiplos parâmetros.  
- **Flexibilidade limitada**: Dificuldade em criar variações de um objeto.  
- **Código duplicado**: Repetição de lógica de criação para diferentes configurações.  

---

## Solução do Builder
A implementação segue os princípios do Builder:  
1. **Interface `Construtor`**: Define métodos para configurar partes do objeto (`definirProcessador()`, `definirRAM()`, etc.).  
2. **Builder concreto (`ConstrutorComputador`)**: Implementa a interface e armazena os atributos do `Computador`.  
3. **Classe `Computador`**: Representa o objeto complexo a ser construído.  
4. **Diretor (`Loja`)**: Define sequências de construção pré-configuradas (ex: `construirNotebookGamer()`).  

---

## Benefícios do Builder 
- **Controle granular**: Permite construir objetos passo a passo.  
- **Reutilização**: O mesmo processo de construção pode criar diferentes representações.  

- **Isolamento**: Separa a lógica de construção da classe do objeto.  
- **Legibilidade**: Evita construtores com dezenas de parâmetros.  

---

## Desvantagens do Builder
- **Complexidade**: Introduz múltiplas classes/interfaces.  
- **Overhead**: Desnecessário para objetos simples.  
- **Manutenção**: Mudanças na classe `Computador` exigem atualizações no Builder.  

---

## Conclusão
O Builder é ideal para cenários que envolvem objetos complexos com múltiplas configurações, como a montagem de computadores. Ele oferece flexibilidade e organização, mas deve ser usado com cautela para evitar complexidade excessiva. A implementação em `Loja` e `ConstrutorComputador` demonstra como centralizar a lógica de construção e permitir variações sem alterar o código do objeto (`Computador`).