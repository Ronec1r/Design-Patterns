# Padrão Template Method

---

## Situação Problema  
Um sistema de preparação de bebidas precisa definir um processo padrão para fazer café, chá e cappuccino. Essas bebidas compartilham etapas comuns (ex: preparar a xícara, adicionar água quente), mas diferem na adição de ingredientes específicos. Sem uma estrutura unificada, cada classe de bebida repetiria código para as etapas comuns, aumentando a redundância e dificultando a manutenção. O Template Method resolve isso definindo um esqueleto de algoritmo na superclasse, permitindo que subclasses personalizem apenas etapas específicas.

---

## Problema que o Template Method Resolve
O padrão aborda:  
- **Redundância de código**: Evitar repetição de etapas comuns (ex: preparar xícara) em múltiplas classes.  
- **Inconsistência**: Garantir que todas as bebidas sigam a mesma sequência de preparo.  
- **Dificuldade de manutenção**: Alterar etapas comuns exigiria modificações em todas as subclasses.  

---

## Solução do Template Method
A implementação segue os princípios do Template Method:  
1. **Classe abstrata `Bebida`**: Define o método `obterPreparo()`, que estrutura o algoritmo (preparar xícara → adicionar ingredientes → adicionar água).  
2. **Método abstrato `prepararIngredientes()`**: Implementado pelas subclasses (`Cafe`, `Cha`, `Cappuccino`) para personalizar a adição de ingredientes.  
3. **Métodos concretos na superclasse**: `prepararXicara()` e `prepararAguaQuente()` são reutilizados por todas as subclasses.  

---

## Benefícios do Template Method
- **Reusabilidade**: Etapas comuns são centralizadas na superclasse.  
- **Consistência**: Todas as bebidas seguem a mesma sequência de preparo.  
- **Flexibilidade**: Novas bebidas podem ser adicionadas estendendo `Bebida` e implementando `prepararIngredientes()`.  

---

## Desvantagens do Template Method
- **Rigidez**: Alterar a ordem das etapas exige modificar a superclasse, impactando todas as subclasses.  
- **Complexidade hierárquica**: Subclasses podem ficar acopladas à estrutura definida na superclasse.  
- **Limitações**: Não é adequado para algoritmos com muitas variações estruturais.  

---

## Conclusão
O Template Method é ideal para sistemas com algoritmos estruturados que variam apenas em etapas específicas, como a preparação de bebidas. A classe `Bebida` encapsula o processo geral, enquanto subclasses como `Cappuccino` personalizam a adição de ingredientes. O padrão reduz redundância e garante consistência, mas pode ser inflexível para cenários que demandam alterações profundas na sequência do algoritmo.