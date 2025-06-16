# Padrão State

---

## Situação Problema  
Em um jogo clássico do Mario, o personagem pode assumir diferentes estados (ex: pequeno, super, de fogo, voador) que alteram suas habilidades e reações a eventos. Sem uma estrutura adequada, o código ficaria repleto de condicionais para verificar o estado atual, tornando-o complexo e difícil de manter. O State resolve isso encapsulando cada estado em uma classe separada, permitindo que o Mario mude seu comportamento dinamicamente conforme interage com itens ou sofre danos.

---

## Problema que o State Resolve  
O padrão aborda:  
- **Condicionais complexas**: Evita múltiplas verificações de estado (ex: `if (estado == SUPER)`).  
- **Acoplamento alto**: Separa a lógica de cada estado em classes independentes.  
- **Dificuldade de extensão**: Facilita a adição de novos estados sem modificar o código existente.  

---

## Solução do State
A implementação segue os princípios do State:  
1. **Interface `EstadoMario`**: Define métodos comuns para todos os estados (ex: `pegarCogumelo()`, `sofrerDano()`).  
2. **Estados concretos**: `MarioPequeno`, `MarioSuper`, `MarioFogo`, `MarioVoador` e `MarioMorto` implementam a lógica específica de cada estado.  
3. **Classe `Mario`**: Mantém uma referência ao estado atual e delega ações para ele.  

---

## Benefícios do State
- **Organização**: Cada estado gerencia suas próprias transições e comportamentos.  
- **Flexibilidade**: Novos estados podem ser adicionados sem afetar outros.  
- **Legibilidade**: Elimina condicionais complexas, simplificando o código.  
- **Coesão**: A lógica de cada estado é centralizada em sua classe.  

---

## Desvantagens do State 
- **Número de classes**: Pode aumentar significativamente em sistemas com muitos estados.  
- **Complexidade de transições**: Gerenciar todas as mudanças de estado exige cuidado.  
- **Overhead**: Troca de estados pode impactar desempenho em sistemas críticos.  

---

## Conclusão
O State é ideal para sistemas onde objetos mudam de comportamento dinamicamente, como os estados do Mario. A implementação demonstra como delegar ações para classes de estado específicas, simplificando a lógica e facilitando a manutenção. Embora aumente o número de classes, o padrão oferece clareza e escalabilidade, sendo crucial para jogos ou sistemas com múltiplos estados interdependentes.