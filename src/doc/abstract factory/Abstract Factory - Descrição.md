# Padrão Abstract Factory

---

## Situação Problema  
Um sistema de interface gráfica precisa suportar múltiplos temas (ex: Claro e Escuro), onde cada tema define cores e estilos específicos para componentes como botões, janelas e menus. Criar esses componentes manualmente para cada tema resultaria em código redundante e acoplado, dificultando a manutenção e a adição de novos temas. O Abstract Factory resolve isso encapsulando a criação de famílias de objetos relacionados (componentes de um mesmo tema) em uma única fábrica.

---

## Problema que o Abstract Factory Resolve
O padrão aborda:  
- **Dependência direta entre componentes e temas**: Evita que o código cliente precise conhecer classes concretas de cada componente.  
- **Inconsistência visual**: Garante que todos os componentes de um tema sejam compatíveis (ex: mesma paleta de cores).  
- **Dificuldade de escalabilidade**: Facilita a introdução de novos temas sem alterar o código existente.  

---

## Solução do Abstract Factory*
A implementação segue os princípios do padrão:  
1. **Interfaces de componentes**: `Botao`, `Janela`, `Menu` definem métodos comuns (ex: `obterCor()`).  
2. **Fábrica abstrata**: `FabricaInterfaceGrafica` declara métodos para criar cada componente.  
3. **Fábricas concretas**: `TemaClaro` e `TemaEscuro` (implícito em `implB`) implementam a fábrica, produzindo componentes específicos do tema.  
4. **Componentes concretos**: `BotaoClaro`, `JanelaClara`, `MenuEscuro`, etc., implementam as interfaces com comportamentos específicos.  

---

## Benefícios do Abstract Factory  
- **Consistência**: Componentes de um mesmo tema são criados juntos, garantindo harmonia visual.  
- **Desacoplamento**: O cliente interage apenas com interfaces, não com implementações concretas.  
- **Extensibilidade**: Adicionar um novo tema (ex: "Azul") requer apenas uma nova fábrica e componentes.  
- **Reusabilidade**: A lógica de criação de componentes é centralizada nas fábricas.  

---

## Desvantagens do Abstract Factory  
- **Complexidade**: Introduz múltiplas classes e interfaces, aumentando a curva de aprendizado.  
- **Rigidez**: Adicionar um novo tipo de componente (ex: `CaixaDialogo`) exige alterar todas as fábricas existentes.  
- **Overhead**: Pode ser excessivo para sistemas com poucas variações de temas.  

---

## Conclusão
O Abstract Factory é ideal para sistemas que demandam famílias de objetos relacionados, como temas de interface. A implementação em `TemaClaro` e `TemaEscuro` demonstra como isolar a criação de componentes, garantindo consistência e flexibilidade. No entanto, o padrão exige planejamento para evitar complexidade excessiva, especialmente em projetos com requisitos mutáveis.