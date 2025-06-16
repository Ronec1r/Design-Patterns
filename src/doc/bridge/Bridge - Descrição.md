# Padrão Bridge

---

## Situação Problema 
Em um jogo como *Hollow Knight*, o movimento do personagem precisa ser renderizado de forma diferente em cada plataforma (Nintendo Switch, Xbox, PlayStation, PC), considerando características específicas de hardware, como taxa de FPS. Sem uma estrutura flexível, cada combinação de personagem e plataforma exigiria uma implementação única, gerando código redundante e acoplado. O Bridge resolve isso separando a lógica do objeto gráfico (abstração) da renderização (implementação), permitindo que ambas evoluam independentemente.

---

## Problema que o Bridge Resolve
O padrão aborda:  
- **Acoplamento rígido**: Evita que a classe do objeto gráfico dependa diretamente de implementações específicas de plataforma.  
- **Explosão de classes**: Elimina a necessidade de criar uma classe para cada combinação de objeto e plataforma.  
- **Dificuldade de manutenção**: Alterações em plataformas ou objetos exigiriam modificações em múltiplas classes.  

---

## Solução do Bridge
A implementação segue os princípios do Bridge:  
1. **Abstração (`ObjetoGrafico`)**: Define métodos de movimento (`moverDireita()`, `moverEsquerda()`, etc.) e mantém uma referência à interface `Plataforma`.  
2. **Implementação (`Plataforma`)**: Interface que define como a animação é calculada (`animar()`), implementada por classes como `NintendoSwitch` e `PC`.  
3. **Desacoplamento**: A classe `HollowKnight` (abstração concreta) delega a renderização para a `Plataforma` atual, sem conhecer detalhes internos.  
---

## Benefícios do Bridge
- **Flexibilidade**: Objetos gráficos e plataformas podem ser estendidos independentemente.  
- **Reusabilidade**: A mesma lógica de movimento funciona em qualquer plataforma.  
- **Organização**: Separa preocupações (lógica do jogo vs. renderização).  
- **Testabilidade**: Plataformas podem ser mockadas para testes.  

---

## Desvantagens do Bridge
- **Complexidade inicial**: Introduz mais classes e interfaces.  
- **Overhead de design**: Pode ser excessivo para sistemas simples.  
- **Curva de aprendizado**: Requer entendimento claro da separação entre abstração e implementação.  

---

## Conclusão
O Bridge é ideal para sistemas onde abstrações e implementações devem variar independentemente, como em jogos multiplataforma. A separação entre `ObjetoGrafico` e `Plataforma` permite que o *Hollow Knight* seja animado de forma diferente em cada plataforma, sem modificar sua lógica interna. A implementação demonstra como o padrão promove flexibilidade e desacoplamento, embora exija cuidado no design inicial para evitar complexidade desnecessária.