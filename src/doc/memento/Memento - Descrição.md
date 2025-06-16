# Padrão Memento

## Situação Problema  
Em um jogo, o personagem do jogador perde saúde e vidas ao sofrer danos. Se o jogador cometer um erro (ex: perder uma vida por um ataque fatal), é necessário permitir que ele retorne a um estado anterior do jogo. Sem um mecanismo de salvamento e restauração, seria impossível desfazer ações ou recuperar progresso perdido, gerando frustração. Além disso, expor os atributos internos do jogo (como saúde e vidas) para salvar/restaurar estados violaria o encapsulamento.

---

## Problema Resolvido pelo Padrão Memento  
O padrão Memento resolve a necessidade de salvar e restaurar estados internos de um objeto sem expor sua estrutura interna. Sem ele, a recuperação de estados anteriores exigiria acesso direto aos atributos privados do objeto (como `saude` e `vidas` em `Jogo`), o que comprometeria o encapsulamento e aumentaria o acoplamento entre classes.

---

## Solução do Padrão Memento
O padrão introduz três componentes:  
1. **Originador (`Jogo`)**: Responsável por criar um `Memento` contendo seu estado atual e restaurar seu estado a partir de um `Memento`.  
2. **Memento (`Memento`)**: Armazena o estado interno do `Jogo` (saúde e vidas).  
3. **Caretaker (`Armazenador`)**: Gerencia e armazena os `Mementos`, sem manipulá-los diretamente.  

O `Jogo` cria um `Memento` ao salvar seu estado e o restaura quando necessário, enquanto o `Armazenador` mantém o histórico de estados.

---

## Benefícios do Padrão  
1. **Encapsulamento preservado**: O estado interno do `Jogo` não é exposto a outras classes.  
2. **Desacoplamento**: O `Armazenador` não precisa conhecer os detalhes do estado armazenado.  
3. **Histórico reversível**: Permite desfazer/resfazer operações (ex: restaurar vidas após um erro).  
4. **Flexibilidade**: Estados podem ser salvos em diferentes momentos (checkpoints).  

---

## Desvantagens do Padrão  
1. **Consumo de memória**: Armazenar muitos `Mementos` pode impactar o desempenho.  
2. **Complexidade adicional**: Introduz novas classes (`Memento`, `Armazenador`) ao sistema.  
3. **Gerenciamento de estados obsoletos**: O `Armazenador` pode acumular estados irrelevantes se não for limpo periodicamente.  

---

## Conclusão  
O padrão Memento foi aplicado para permitir que o estado do `Jogo` (saúde e vidas) seja salvo e restaurado de forma segura. O `Armazenador` gerencia o histórico de estados sem conhecer seus detalhes, preservando o encapsulamento. Isso é essencial para funcionalidades como "checkpoints" ou "desfazer ação" em jogos, garantindo flexibilidade e baixo acoplamento.