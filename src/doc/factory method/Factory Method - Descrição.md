# Padrão Factory Method

---

## Situação Problema  
Em um jogo de RPG, diferentes tipos de personagens (Anão, Elfo, Humano, Orc) possuem habilidades únicas de ataque, defesa e magia. Se o código do jogo instanciasse cada personagem diretamente, ele ficaria altamente acoplado às classes concretas, dificultando a adição de novos tipos de personagens e gerando repetição de lógica de criação. Por exemplo, um novo personagem como "Feiticeiro" exigiria modificações em múltiplas partes do código. O Factory Method resolve isso encapsulando a criação de objetos em uma fábrica centralizada.

---

## Problema que o Factory Method Resolve  
O padrão Factory Method aborda:  
- **Acoplamento alto**: O cliente depende diretamente de classes concretas.  
- **Dificuldade de extensão**: Adicionar novos tipos de objetos exige alterar código existente.  
- **Código repetitivo**: Lógica de criação espalhada em múltiplos lugares.

---

## Solução do Factory Method  
A implementação em `FabricaPersonagens` segue os princípios do Factory Method:  
1. **Interface `Personagem`**: Define métodos comuns (`atacar()`, `defender()`, `usarMagia()`).  
2. **Classes concretas**: `Elfo`, `Orc`, `Humano`, `Anao` implementam `Personagem` com comportamentos específicos.  
3. **Fábrica centralizada**: `FabricaPersonagens` encapsula a lógica de criação, retornando a implementação correta baseada no tipo solicitado.  

---

## Benefícios do Factory Method  
- **Baixo acoplamento**: O cliente depende apenas da interface `Personagem`, não das classes concretas.  
- **Extensibilidade**: Adicionar um novo personagem (ex: `Feiticeiro`) requer apenas criar uma nova classe e atualizar a fábrica.  
- **Centralização**: Toda a lógica de criação está em um único lugar.  
- **Organização**: Separa a criação do uso dos objetos.

---

## Desvantagens do Factory Method
- **Complexidade**: Introduz novas classes/interfaces, aumentando a estrutura do código.  
- **Manutenção**: A fábrica precisa ser atualizada para cada novo tipo de objeto.  
- **Flexibilidade limitada**: Se a criação exigir parâmetros dinâmicos, a fábrica pode se tornar sobrecarregada.

---

## Conclusão 
O Factory Method é ideal para sistemas que demandam flexibilidade na criação de objetos, como o jogo de RPG analisado. Ele reduz o acoplamento e facilita a extensão do código, embora introduza uma camada adicional de complexidade. A implementação em `FabricaPersonagens` demonstra como centralizar a lógica de criação, permitindo que novos personagens sejam adicionados sem impactar o código existente.