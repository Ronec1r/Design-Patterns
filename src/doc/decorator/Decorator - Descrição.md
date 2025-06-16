# Padrão Decorator

---

## Situação Problema  
Em uma cafeteria, os clientes podem personalizar bebidas adicionando ingredientes como leite, açúcar ou creme, cada um impactando o preço e a descrição final. Implementar todas as combinações possíveis como classes separadas (ex: `CafeComLeite`, `CafeComAcucar`, `CafeComLeiteEAçúcar`) levaria a uma explosão de classes, dificultando a manutenção e a escalabilidade. O Decorator resolve isso permitindo adicionar funcionalidades dinamicamente, sem criar subclasses para cada combinação.

---

## Problema que o Decorator Resolve
O padrão aborda:  
- **Explosão de classes**: Evita a criação de múltiplas subclasses para cada combinação de funcionalidades.  
- **Flexibilidade limitada**: Permite combinar comportamentos de forma dinâmica, não estática.  
- **Código redundante**: Centraliza a lógica comum em classes decoradoras reutilizáveis.  

---

## Solução do Decorator
A implementação segue os princípios do Decorator:  
1. **Interface `Component`**: Define métodos básicos (`custo()`, `getDescricao()`).  
2. **Componente concreto (`Cafe`)**: Implementa a interface para a bebida base.  
3. **Decoradores abstratos (`Decorator`)**: Mantém uma referência a `Component` e implementa a mesma interface, delegando ações ao componente encapsulado.  
4. **Decoradores concretos (`Leite`, `Acucar`, `Creme`)**: Adicionam funcionalidades específicas (ex: custo e descrição) ao componente base.  

---

## Benefícios do Decorator
- **Extensibilidade**: Adiciona novos ingredientes sem alterar o código existente.  
- **Composição flexível**: Combina decoradores em qualquer ordem.  
- **Reusabilidade**: Decoradores como `Leite` podem ser aplicados a qualquer `Component` (ex: chá, cappuccino).  
- **Clareza**: Separa responsabilidades entre a bebida base e os adicionais.  

---

## Desvantagens do Decorator
- **Complexidade de depuração**: Múltiplas camadas de decoradores podem dificultar o rastreamento.  
- **Dependência de ordem**: A sequência de aplicação dos decoradores afeta o resultado final.  
- **Overhead de objetos**: Cada decorador cria uma nova instância, aumentando o uso de memória.  

---

## Conclusão
O Decorator é ideal para sistemas que exigem adição dinâmica de funcionalidades, como personalização de bebidas em uma cafeteria. A implementação em `Leite`, `Acucar` e `Creme` demonstra como estender o comportamento de um objeto (`Cafe`) de forma modular, evitando a explosão de classes. Embora introduza camadas adicionais, o padrão oferece flexibilidade e reusabilidade, sendo essencial para cenários com combinações variáveis de características.