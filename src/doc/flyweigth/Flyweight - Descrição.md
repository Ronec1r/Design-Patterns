# Padrão Flyweight

---

## Situação Problema
Em um jogo de construção com milhões de blocos (ex: Minecraft), cada bloco possui propriedades intrínsecas fixas (nome, se é quebrável, inflamável, etc.) e propriedades extrínsecas variáveis (posição x, y, z). Sem otimização, criar um objeto para cada bloco consumiria memória excessiva, pois os atributos intrínsecos se repetiriam. O Flyweight resolve isso compartilhando os estados intrínsecos entre múltiplos objetos, reduzindo drasticamente o consumo de recursos.

---

## Problema que o Flyweight Resolve
O padrão aborda:  
- **Alto consumo de memória**: Evita duplicação de dados intrínsecos (ex: tipo de bloco) em objetos similares.  
- **Ineficiência em sistemas com muitos objetos**: Reduz a criação de instâncias repetidas de classes com estados compartilháveis.  

---

## Solução do Flyweight
A implementação segue os princípios do Flyweight:  
1. **Estado intrínseco (`TipoBloco`)**: Armazena dados compartilhados (ex: `nome`, `quebravel`).  
2. **Estado extrínseco (`Bloco`)**: Armazena dados únicos (ex: coordenadas `x`, `y`, `z`).  
3. **Fábrica (`FabricaBlocos`)**: Gerencia a criação e reutilização de objetos `TipoBloco`, evitando duplicações.  

---

## Benefícios do Flyweight
- **Economia de memória**: Estados intrínsecos são compartilhados, não duplicados.  
- **Desempenho**: Reduz a inicialização de objetos e coleta de lixo.  
- **Escalabilidade**: Permite sistemas com milhões de objetos sem colapso de memória.  

---

## Desvantagens do Flyweight
- **Complexidade**: Exige separação clara entre estados intrínsecos e extrínsecos.  
- **Overhead de gerenciamento**: A fábrica e a lógica de compartilhamento aumentam o código.  
- **Limitações**: Não é útil se não houver estados compartilháveis.  

---

## Conclusão
O Flyweight é essencial em sistemas com alto volume de objetos similares, como jogos de construção. A implementação em `FabricaBlocos` e `TipoBloco` demonstra como compartilhar estados intrínsecos, enquanto `Bloco` gerencia dados únicos. O padrão otimiza memória e desempenho, mas requer cuidado na distinção entre estados compartilhados e não compartilhados.