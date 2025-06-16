# Chain of Responsibility

## Situação Problema
Em um sistema de aprovação de empréstimos, uma solicitação precisa passar por múltiplas validações (ex: análise de risco, verificação de crédito e aprovação gerencial). Implementar todas essas verificações em uma única classe resultaria em código complexo e pouco flexível, dificultando a adição de novas regras ou alterações na ordem de processamento. Além disso, o acoplamento entre a requisição e os validadores seria elevado.

---

## Problema Resolvido pelo Padrão Chain of Responsibility  
O padrão Chain of Responsibility resolve a necessidade de desacoplar o emissor de uma requisição de seus receptores, permitindo que múltiplos objetos tenham a oportunidade de processar a requisição. Sem esse padrão, as validações estariam centralizadas em um único ponto, dificultando a manutenção e a extensibilidade.

---

## Solução do Padrão Chain of Responsibility 
O padrão organiza os validadores em uma cadeia de objetos (handlers), onde cada handler decide se processa a requisição ou a passa para o próximo na cadeia. No código:  
1. **Handler Abstrato (`Analisador`)**: Define a interface para processar requisições e mantém uma referência ao próximo handler.  
2. **Concrete Handlers (`AnalistaRisco`, `AnalistaCredito`, `Gerente`)**: Implementam regras específicas (ex: score de crédito mínimo, relação renda/valor do empréstimo).  
3. **Requisição (`RequisicaoEmprestimo`)**: Contém os dados necessários para as validações.  

A requisição percorre a cadeia até ser aprovada ou rejeitada por um handler.

---

## Benefícios do Padrão
1. **Desacoplamento**: A requisição não precisa conhecer qual handler a processará.  
2. **Flexibilidade**: Novos handlers podem ser adicionados sem modificar o código existente.  
3. **Separação de responsabilidades**: Cada handler cuida de uma validação específica.  
4. **Controle dinâmico da ordem**: A ordem dos handlers pode ser ajustada em tempo de execução.  

---

## Desvantagens do Padrão
1. **Risco de requisição não processada**: Se a cadeia não for configurada corretamente, a requisição pode não ser tratada.  
2. **Dificuldade de depuração**: Rastrear qual handler processou a requisição pode ser complexo.  
3. **Overhead de desempenho**: A passagem sequencial por múltiplos handlers pode ser ineficiente em cadeias longas.  

---

## Conclusão
O padrão Chain of Responsibility foi aplicado para estruturar a validação de empréstimos em uma cadeia de handlers, onde cada etapa (`AnalistaRisco`, `AnalistaCredito`, `Gerente`) realiza uma verificação específica. Isso permite que o sistema seja facilmente estendido (ex: adicionar novos validadores) e mantido, preservando a coesão e reduzindo o acoplamento entre componentes.