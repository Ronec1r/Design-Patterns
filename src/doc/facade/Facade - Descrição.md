# Padrão Facade

---

## Situação Problema
Um sistema de comércio eletrônico precisa gerenciar clientes, produtos e pedidos, envolvendo operações como registro de clientes, adição de produtos a pedidos, cálculo de total e fechamento de compra. Sem uma estrutura unificada, o cliente teria que interagir diretamente com múltiplas classes (como `Repositorio`, `GeradorID`, `Cliente`, `Pedido` e `Produto`), resultando em código complexo, repetitivo e acoplado. O Facade resolve isso oferecendo uma interface simplificada para operações complexas.

---

## Problema que o Facade Resolve
O padrão aborda:  
- **Complexidade de integração**: Coordenar múltiplas classes e subsistemas (repositórios, geração de IDs, entidades).  
- **Acoplamento alto**: O cliente depende de detalhes internos do sistema.  
- **Código redundante**: Repetição de lógica para operações comuns (ex: criar cliente e gerar ID).  

---

## Solução do Facade
A implementação segue os princípios do Facade:  
1. **Classe `Fachada`**: Centraliza operações como `registrarCliente()`, `escolherProduto()` e `fecharCompra()`, abstraindo a interação com `Repositorio`, `GeradorID` e entidades.  
2. **Encapsulamento**: Esconde detalhes como geração de IDs (`GeradorID`) e armazenamento em repositórios.  
3. **Simplificação**: Oferece métodos de alto nível (ex: `listarClientes()`) que encapsulam chamadas a subsistemas complexos.  

---

## Benefícios do Facade
- **Interface simplificada**: O cliente interage apenas com a `Fachada`, sem conhecer subsistemas internos.  
- **Redução de acoplamento**: Alterações nos subsistemas (ex: `Repositorio`) não afetam o cliente.  
- **Reusabilidade**: Operações complexas são centralizadas e podem ser reutilizadas.  
- **Organização**: Separa a lógica de negócio da interação com subsistemas.  

---

## Desvantagens do Facade  
- **Classe sobrecarregada**: Se o sistema crescer, a `Fachada` pode se tornar grande e difícil de manter.  
- **Flexibilidade limitada**: Esconde funcionalidades específicas que poderiam ser úteis para casos avançados.  
- **Dependência única**: A `Fachada` pode se tornar um ponto único de falha.  

---

### **Conclusão**  
O Facade é ideal para simplificar sistemas complexos, como o gerenciamento de um e-commerce. A classe `Fachada` encapsula a interação com repositórios, geração de IDs e entidades, oferecendo uma interface clara para o cliente. Embora possa se tornar grande em sistemas extensos, seu uso é crucial para reduzir a complexidade e melhorar a manutenibilidade. A implementação demonstra como centralizar operações críticas, garantindo coesão e desacoplamento.