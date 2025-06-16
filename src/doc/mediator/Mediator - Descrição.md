# Padrão Mediator

## Situação Problema  
Em um aeroporto, diversas aeronaves solicitam pousos e decolagens simultaneamente. Cada aeronave precisaria verificar diretamente condições meteorológicas, estado da pista e manutenção, gerando acoplamento elevado entre classes. Isso resultaria em código complexo, difícil de manter e com riscos de inconsistências (ex: duas aeronaves tentando pousar na mesma pista). O sistema necessita de coordenação centralizada para gerenciar essas interações.

---

## Problema Resolvido pelo Padrão Mediator  
O padrão Mediator resolve a complexidade de comunicação entre múltiplos objetos que interagem diretamente, reduzindo dependências caóticas. Sem o mediador, os objetos (como `Aeronave`, `Metereologia`, e `Oficina`) teriam referências uns aos outros, aumentando acoplamento e dificultando modificações futuras.

---

## Solução do Padrão Mediator
Introduz um objeto mediador (`ControladorTrafego`) que encapsula todas as interações. Os colaboradores comunicam-se apenas com o mediador, que decide como processar solicitações (ex: verificar condições meteorológicas antes de autorizar pousos). Isso desacopla os objetos e centraliza a lógica de controle.

---

## Benefícios do Padrão  
1. **Redução de acoplamento**: Objetos não precisam conhecer outros colaboradores diretamente.  
2. **Centralização de regras**: Lógicas complexas (ex: prioridade de pousos) ficam no mediador.  
3. **Extensibilidade**: Novos colaboradores podem ser adicionados sem afetar os existentes.  
4. **Reutilização**: O mediador pode ser reaproveitado em outros contextos com interações similares.

---

## Desvantagens do Padrão  
1. **Complexidade do mediador**: Se o mediador crescer demais, pode se tornar um "Deus objeto", dificultando a manutenção.  
2. **Possível gargalo**: Todas as comunicações passam pelo mediador, o que pode impactar desempenho em sistemas muito concorridos.  

---

## Conclusão  
O padrão Mediator foi aplicado para coordenar as interações complexas entre aeronaves, condições meteorológicas e manutenção, centralizando a lógica no `ControladorTrafego`. Isso simplifica a comunicação, reduz acoplamento e facilita a evolução do sistema.