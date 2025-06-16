## Padrão Adapter

---

## Situação Problema
Um sistema de gestão acadêmica precisa acessar dados de alunos armazenados em arquivos, porém esses dados estão em formatos incompatíveis: um arquivo retorna uma lista de strings (`RepositorioLista`), e outro retorna uma única string concatenada (`RepositorioString`). O sistema requer os dados no formato de mapa `<matrícula, nome>`, conforme definido pela interface `Repositorio`. O Adapter resolve essa incompatibilidade, permitindo que os dados sejam convertidos para o formato esperado sem modificar as classes originais.

---

## Problema que o Adapter Resolve 
O padrão aborda:  
- **Incompatibilidade de interfaces**: Classes existentes (`RepositorioLista`, `RepositorioString`) não seguem a interface requerida (`Repositorio`).  
- **Reutilização de código**: Evita reescrever classes legadas para se adequarem a novas interfaces.  
- **Integração de sistemas**: Permite que componentes com formatos distintos trabalhem juntos.

---

## Solução do Adapter
A implementação utiliza dois adaptadores:  
1. **`AdaptadorLista`**: Converte dados de `RepositorioLista` (lista de strings) em um mapa `<matrícula, nome>`.  
2. **`AdaptadorString`**: Converte dados de `RepositorioString` (string concatenada) no mesmo formato.  

---

## Benefícios do Adapter
- **Reusabilidade**: Permite integrar classes legadas sem modificá-las.  
- **Flexibilidade**: Suporta múltiplas fontes de dados (lista, string, etc.).  
- **Desacoplamento**: O cliente depende apenas da interface `Repositorio`, não das implementações concretas.  

---

## Desvantagens do Adapter  
- **Complexidade**: Introduz classes extras, aumentando a estrutura do código.  
- **Overhead**: Conversões podem impactar performance em grandes volumes de dados.  
- **Manutenção**: Mudanças nas classes adaptadas exigem atualizações nos adaptadores.  

---

## Conclusão
O Adapter é ideal para integrar componentes com interfaces incompatíveis, como no caso dos repositórios de alunos. As classes `AdaptadorLista` e `AdaptadorString` demonstram como converter dados brutos em um formato padronizado, garantindo que o sistema funcione sem alterar código legado. Embora adicione camadas ao código, o padrão é crucial para sistemas que precisam evoluir sem descartar funcionalidades existentes.