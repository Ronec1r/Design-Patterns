# Padrão Proxy

---

## Situação Problema
Em um sistema de gerenciamento de arquivos, é necessário restringir o acesso a operações como criação, leitura, escrita e remoção de arquivos com base nas permissões do usuário. Sem controle, usuários sem privilégios poderiam executar ações críticas, comprometendo a segurança. O Proxy resolve isso interpondo uma camada de verificação de permissões antes de permitir o acesso ao objeto real (`ArquivoReal`).

---

## Problema que o Proxy Resolve
O padrão aborda:  
- **Controle de acesso**: Restringir operações com base em permissões do usuário.  
- **Separação de responsabilidades**: Evitar que a lógica de segurança seja incorporada diretamente no objeto real.  
- **Flexibilidade**: Permitir adicionar funcionalidades (ex: logging, cache) sem modificar o objeto principal.  

---

## Solução do Proxy
A implementação segue os princípios do Proxy:  
1. **Interface comum (`Arquivo`)**: Define métodos como `criar()`, `recuperar()`, etc., implementados tanto pelo objeto real quanto pelo Proxy.  
2. **Objeto real (`ArquivoReal`)**: Executa operações de arquivo diretamente (ex: leitura/escrita via `Files`).  
3. **Proxy (`ArquivoProxy`)**: Controla o acesso ao `ArquivoReal` verificando permissões (`Permissao`) antes de delegar ações.  

---

## Benefícios do Proxy 
- **Segurança**: Impede acesso não autorizado a operações críticas.  
- **Transparência**: O cliente interage com a mesma interface, independente de usar Proxy ou objeto real.  
- **Extensibilidade**: Novas funcionalidades (ex: auditoria) podem ser adicionadas no Proxy.  

---

## Desvantagens do Proxy
- **Overhead**: Verificações adicionais podem impactar desempenho.  
- **Complexidade**: Introduz camadas extras ao sistema.  
- **Manutenção**: Alterações na interface exigem atualizações no Proxy e objeto real.  

---

## Conclusão
O Proxy é ideal para sistemas que exigem controle de acesso ou funcionalidades adicionais sem modificar o objeto principal. A implementação em `ArquivoProxy` demonstra como validar permissões antes de executar operações no `ArquivoReal`, garantindo segurança e flexibilidade. Embora introduza complexidade, o padrão é crucial para cenários onde o controle granular de acesso é necessário.