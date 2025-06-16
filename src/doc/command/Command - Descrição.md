# Padrão Command

## Situação Problema
Em um sistema de controle remoto para dispositivos domésticos (TV, luzes), cada botão precisa executar uma ação específica (ligar, desligar, mudar canal). Implementar essas ações diretamente no controle remoto resultaria em alto acoplamento entre o controle e os dispositivos, além de dificultar a adição de novos comandos ou a reutilização de funcionalidades (ex: programar macros).

---

## Problema Resolvido pelo Padrão Command
O padrão Command resolve a necessidade de encapsular solicitações como objetos, permitindo que operações sejam parametrizadas, enfileiradas ou desfeitas. Sem ele, o controle remoto precisaria conhecer detalhes internos de cada dispositivo, tornando o código inflexível e difícil de estender.

---

## Solução do Padrão Command
O padrão define quatro componentes principais:  
1. **Comando (`Comando`)**: Interface que declara o método `executar()`.  
2. **Comandos Concretos (`LigarTV`, `DesligarLuz`, etc.)**: Implementam `Comando`, encapsulando uma ação e seu receptor (ex: `Televisao`, `Luz`).  
3. **Receptor (`Televisao`, `Luz`)**: Executa a lógica real (ligar, desligar, mudar canal).  
4. **Invocador (`ControleRemoto`)**: Solicita a execução do comando sem conhecer seu receptor.  

Isso permite que o controle remoto opere qualquer dispositivo através de comandos genéricos.

---

## Benefícios do Padrão  
1. **Desacoplamento**: O `ControleRemoto` não depende diretamente dos dispositivos.  
2. **Flexibilidade**: Novos comandos podem ser adicionados sem alterar o código existente.  
3. **Operações complexas**: Macros (sequências de comandos) são facilmente implementadas.  
4. **Suporte a undo/redo**: Comandos podem armazenar estado para reversão.  

---

## Desvantagens do Padrão
1. **Proliferação de classes**: Cada ação requer uma classe de comando específica.  
2. **Complexidade aumentada**: Introdução de camadas indiretas pode dificultar a depuração.  

---

## Conclusão  
O padrão Command foi aplicado para desacoplar o `ControleRemoto` das ações específicas de dispositivos como `Televisao` e `Luz`. Cada comando (`LigarTV`, `DesligarLuz`) encapsula uma operação, permitindo que o controle execute comandos genéricos sem conhecer detalhes de implementação. Isso facilita a adição de novos dispositivos e comandos, além de possibilitar funcionalidades avançadas como macros ou histórico de ações.