# Padrão Strategy

---

## Situação Problema
Um sistema de vendas de ingressos precisa aplicar diferentes tipos de descontos (ex: para estudantes, dia dos pais, ou nenhum desconto). Sem uma estrutura flexível, a lógica de cálculo de descontos estaria acoplada diretamente na classe `Ingresso`, exigindo modificações constantes no código sempre que um novo desconto fosse adicionado. O Strategy resolve isso encapsulando cada regra de desconto em uma classe separada, permitindo que o sistema altere dinamicamente a estratégia aplicada.

---

## Problema que o Strategy Resolve
O padrão aborda:  
- **Acoplamento alto**: Evita que a classe `Ingresso` dependa diretamente de regras de desconto específicas.  
- **Dificuldade de extensão**: Facilita a adição de novos descontos sem modificar código existente.  
- **Código inflexível**: Elimina a necessidade de condicionais complexas para selecionar descontos.  

---

## Solução do Strategy
A implementação segue os princípios do Strategy:  
1. **Interface `EstrategiaDesconto`**: Define o método `calcularDesconto()`, que retorna o percentual de desconto.  
2. **Estratégias concretas**: `EstrategiaIntegral`, `EstrategiaEstudante` e `EstrategiaDiaPais` implementam descontos de 0%, 50% e 60%, respectivamente.  
3. **Classe `Ingresso`**: Recebe uma estratégia de desconto via construtor e a utiliza para calcular o valor final.  

---

## Benefícios do Strategy  
- **Flexibilidade**: Novas estratégias podem ser adicionadas sem alterar a classe `Ingresso`.  
- **Desacoplamento**: Separa a lógica de negócio (cálculo de descontos) da entidade principal (Ingresso).  
- **Reusabilidade**: Estratégias podem ser compartilhadas entre diferentes partes do sistema.  

---

## Desvantagens do Strategy
- **Número de classes**: Pode aumentar com muitas estratégias.  
- **Complexidade do cliente**: O código cliente precisa conhecer todas as estratégias disponíveis.  
- **Overhead**: Troca de estratégias em tempo de execução pode ter custo adicional.  

---

## Conclusão
O Strategy é ideal para sistemas que exigem variação dinâmica de algoritmos, como descontos em ingressos. A implementação em `EstrategiaDesconto` e `Ingresso` demonstra como encapsular regras de desconto em classes independentes, promovendo flexibilidade e manutenibilidade. Embora aumente o número de classes, o padrão é crucial para cenários onde políticas de desconto mudam frequentemente ou são personalizáveis.