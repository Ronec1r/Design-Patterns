# Padrão Observer

## Situação Problema  
Em um sistema de e-commerce, clientes desejam ser notificados quando um produto esgotado volta ao estoque. Sem um mecanismo eficiente, o produto precisaria manter uma lista fixa de clientes para notificar, gerando alto acoplamento. Além disso, adicionar ou remover notificações manualmente seria inviável, especialmente com muitos produtos e clientes.

---

## Problema Resolvido pelo Padrão Observer 
O padrão Observer resolve a necessidade de notificar múltiplos objetos dependentes sobre mudanças de estado em um objeto central (**Sujeito**), sem acoplamento rígido. Sem ele, o produto (**Produto**) precisaria gerenciar diretamente a lista de clientes (**Cliente**), violando o princípio de responsabilidade única e dificultando a escalabilidade.

---

## Solução do Padrão Observer
O padrão define dois componentes principais:  
1. **Sujeito (Produto)**: Mantém uma lista de observadores e notifica-os automaticamente quando seu estado muda (ex: estoque é reposto).  
2. **Observador (Cliente)**: Interface que define o método `atualizar()`, permitindo que os observadores reajam às mudanças do sujeito.  

Quando o `Produto` recebe novos itens (`adicionar()`), ele verifica se está disponível e notifica os `Clientes` inscritos, que então executam ações (ex: comprar o produto).

---

## Benefícios do Padrão
1. **Desacoplamento**: O `Produto` não conhece detalhes dos `Clientes`, apenas que são `Observadores`.  
2. **Extensibilidade**: Novos observadores podem ser adicionados sem modificar o `Sujeito`.  
3. **Comunicação dinâmica**: Observadores podem se inscrever ou cancelar inscrição em tempo de execução.  
4. **Reatividade**: Notificações automáticas garantem respostas imediatas a mudanças de estado.  

---

## Desvantagens do Padrão
1. **Notificações inesperadas**: Observadores podem receber atualizações irrelevantes.  
2. **Ordem de notificação**: A sequência de notificação não é controlada, podendo causar inconsistências.  
3. **Overhead de memória**: Manter listas grandes de observadores pode consumir recursos.  

---

## Conclusão
O padrão Observer foi aplicado para permitir que `Clientes` sejam notificados automaticamente quando um `Produto` tem seu estoque atualizado. O `Produto` atua como **Sujeito**, gerenciando inscrições e notificações, enquanto os `Clientes` implementam **Observador** para reagir às mudanças. Isso elimina acoplamento direto e facilita a adição de novos comportamentos, como promoções ou alertas personalizados.