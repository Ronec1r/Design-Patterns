# Padrão Iterator

---

## Situação Problema  
Em um sistema de gerenciamento de playlists, é necessário percorrer músicas armazenadas de diferentes formas: uma playlist ordenada sequencialmente (`PlaylistMusicas`) e outra agrupada por artista (`PlaylistArtistas`). Sem uma abordagem unificada, o código cliente precisaria conhecer a estrutura interna de cada playlist para iterar sobre as músicas, gerando acoplamento e complexidade. O Iterator resolve isso fornecendo uma interface comum para percorrer elementos, independentemente de como estão organizados.

---

## Problema que o Iterator Resolve
O padrão aborda:  
- **Acoplamento alto**: Evita que o cliente dependa da estrutura interna das playlists.  
- **Diversidade de estruturas**: Permite iterar sobre coleções com organizações distintas (ex: lista simples vs. mapa por artista).  
- **Reusabilidade**: Oferece uma forma consistente de acesso a elementos, mesmo em coleções heterogêneas.  

---

## Solução do Iterator
A implementação segue os princípios do Iterator:  
1. **Interface `Agregador<G>`**: Define o método `criarIterador()`, que retorna um iterador específico para a coleção.  
2. **Interface `Iterador<G>`**: Declara métodos `proximo()` e `temProximo()`, implementados por classes como `IteradorMusicas` e `IteradorArtistas`.  
3. **Coleções concretas**: `PlaylistMusicas` (lista sequencial) e `PlaylistArtistas` (mapa por artista) implementam `Agregador<Musica>`.  
4. **Iteradores concretos**: `IteradorMusicas` percorre músicas em ordem de inserção, enquanto `IteradorArtistas` organiza por artista.  

---

## Benefícios do Iterator  
- **Desacoplamento**: O cliente não precisa conhecer a estrutura interna das playlists.  
- **Flexibilidade**: Novos tipos de iteração podem ser adicionados sem alterar o código existente.  
- **Uniformidade**: Oferece uma interface consistente para percorrer diferentes coleções.  

---

## Desvantagens do Iterator
- **Complexidade**: Introdução de classes adicionais (iteradores) pode aumentar a estrutura do código.  
- **Overhead**: Criação de iteradores pode impactar desempenho em sistemas de alta performance.  
- **Dificuldade de sincronização**: Em ambientes concorrentes, manter a consistência do iterador pode ser desafiador.  

---

## Conclusão
O Iterator é essencial para sistemas que demandam iteração flexível sobre coleções com estruturas variadas, como playlists de músicas. A implementação em `PlaylistArtistas` e `IteradorArtistas` demonstra como isolar a lógica de iteração, permitindo que o cliente acesse músicas sem conhecer detalhes internos. Embora introduza classes adicionais, o padrão promove desacoplamento e reusabilidade, sendo fundamental para cenários com múltiplas formas de percorrer dados.