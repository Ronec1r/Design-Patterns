# Padrão Composite

---

## Situação Problema
Em um sistema de cardápio de restaurante, é necessário calcular o preço de itens individuais (ex: hambúrguer, batata frita) e combos que agrupam múltiplos itens (ex: combo "Refeição Completa"). Combos podem conter outros combos ou itens, formando uma estrutura hierárquica. Sem uma abordagem unificada, o cálculo do preço total seria complexo e redundante, especialmente para combos aninhados. O Composite resolve isso tratando itens individuais e combos de forma uniforme.

---

## Problema que o Composite Resolve 
O padrão aborda:  
- **Tratamento heterogêneo**: Dificuldade em processar estruturas de objetos simples e compostos com a mesma lógica.  
- **Hierarquias complexas**: Gerenciar combos que contêm outros combos ou itens de forma recursiva.  
- **Redundância de código**: Evitar implementações separadas para calcular preços de itens e combos.  

---

## Solução do Composite  
A implementação segue os princípios do Composite:  
1. **Componente abstrato (`Componente`)**: Define métodos comuns (`calcularPreco()`) para todos os objetos, sejam folhas (itens) ou compostos (combos).  
2. **Folha (`Item`)**: Representa elementos indivisíveis (ex: hambúrguer) e implementa `calcularPreco()` retornando seu valor fixo.  
3. **Composto (`Combo`)**: Agrupa outros `Componentes` (itens ou combos) e calcula o preço total somando os preços dos componentes internos.  

---

## Benefícios do Composite  
- **Uniformidade**: Itens e combos são tratados da mesma forma pelo código cliente.  
- **Extensibilidade**: Adicionar novos tipos de componentes não exige alterações na lógica existente.  
- **Simplicidade**: Cálculos recursivos são encapsulados na classe `Combo`.  

---

## Desvantagens do Composite  
- **Dificuldade em restringir tipos**: Não é fácil limitar os componentes que um `Combo` pode conter.  
- **Complexidade em hierarquias profundas**: Pode ser complicado depurar ou modificar estruturas muito aninhadas.  
- **Overhead**: Gerenciar listas de componentes pode adicionar complexidade ao código.  

---

## Conclusão 
O Composite é ideal para sistemas que envolvem hierarquias de objetos, como cardápios de restaurantes. A implementação em `Combo` e `Item` permite tratar combos e itens de forma uniforme, simplificando operações como cálculo de preço total. Embora possa introduzir complexidade em estruturas muito aninhadas, o padrão oferece clareza e reusabilidade, tornando-o essencial para cenários com composições recursivas.