# Padrão Visitor

## Situação Problema
Em um sistema de tributação de mercadorias, diferentes produtos (alimentos, bebidas, cigarros) possuem regras de taxação variáveis (ex: impostos federais, isenções). Implementar cada cálculo de taxa diretamente nas classes de produtos geraria alto acoplamento e dificultaria a adição de novas políticas tributárias. Além disso, modificar as classes de produtos sempre que uma nova taxa surgisse violaria o princípio Open/Closed.

---

## Problema Resolvido pelo Padrão Visitor  
O padrão Visitor resolve a necessidade de executar operações distintas em uma estrutura de objetos complexa (como hierarquias de classes) sem alterar suas classes. Sem ele, a lógica de taxação estaria espalhada nas classes de produtos, tornando o código inflexível e difícil de manter.

---

## Solução do Padrão Visitor
O padrão separa algoritmos (cálculo de taxas) dos objetos (mercadorias) através de dois componentes:  
1. **Elementos (`Mercadoria` e subclasses)**: Implementam o método `aceitar()`, que delega a operação ao Visitor.  
2. **Visitor (`Taxador` e implementações)**: Define métodos `visitar()` para cada tipo de mercadoria, aplicando a lógica específica (ex: `TaxadorFederal` calcula impostos altos para cigarros).  

Isso permite adicionar novas taxas (como `TaxadorEstadual`) sem modificar as classes de produtos.

---

## Benefícios do Padrão
1. **Separação de responsabilidades**: A lógica de taxação fica isolada nos Visitors.  
2. **Extensibilidade**: Novos Visitors podem ser criados sem alterar as classes de produtos.  
3. **Reuso de operações**: Algoritmos complexos são centralizados em um único lugar.  
4. **Flexibilidade**: Diferentes políticas tributárias coexistem (ex: federal vs. isenção).  

---

## Desvantagens do Padrão
1. **Complexidade de implementação**: Adicionar novos elementos (ex: `Eletronico`) exige atualizar todos os Visitors existentes.  
2. **Violação do encapsulamento**: Visitors podem acessar atributos internos dos elementos (como `custo`).  
3. **Dificuldade de depuração**: A hierarquia de chamadas (`aceitar()` → `visitar()`) pode ser confusa.  

---

## Conclusão
O padrão Visitor foi aplicado para calcular impostos sobre mercadorias de forma desacoplada. Cada produto (`Alimento`, `Cerveja`, etc.) delega o cálculo ao `Taxador`, que implementa regras específicas. Isso permite adicionar políticas tributárias sem modificar as classes de produtos, garantindo flexibilidade e manutenibilidade.