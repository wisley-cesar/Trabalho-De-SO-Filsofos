# Jantar dos Filósofos - Solução em Java com Threads

## Autor
[Wisley César](https://github.com/wisley-cesar)

## Descrição
Este projeto implementa a solução para o problema do Jantar dos Filósofos utilizando Threads em Java. O problema foi originalmente proposto por Edsger Dijkstra em 1965 e serve como um estudo clássico de sincronização de processos concorrentes.

## Definição do Problema
Cinco filósofos estão sentados em uma mesa redonda, onde cada um tem um prato de espaguete. Para comer, um filósofo precisa pegar dois garfos, um à sua esquerda e outro à sua direita. No entanto, cada garfo só pode ser usado por um filósofo de cada vez. Os filósofos alternam entre os estados de "pensar" e "comer".

A solução deve garantir que:
- Nenhum filósofo passe fome (evitar inanição).
- Nenhum filósofo fique eternamente esperando os garfos (evitar deadlock).
- Os filósofos possam alternar entre comer e pensar de maneira ordenada.

## Implementação
A solução utiliza Threads para simular os filósofos e uma abordagem para gerenciar o acesso aos garfos de maneira segura, evitando condições de corrida e deadlocks.

### Tecnologias Utilizadas
- Java
- Threads e sincronização

## Como Executar
1. Clone este repositório:
   ```bash
   git clone https://github.com/wisley-cesar/nome-do-repositorio.git
   ```
2. Compile o código:
   ```bash
   javac JantarDosFilosofos.java
   ```
3. Execute o programa:
   ```bash
   java JantarDosFilosofos
   ```

## Resultados Esperados
O programa simula o jantar dos filósofos, demonstrando a alternância entre os estados de "pensar" e "comer" sem que nenhum filósofo fique bloqueado indefinidamente.

## Recursos Adicionais
- [Vídeo de apresentação](#) *(Inserir o link do vídeo aqui)*
- [Repositório no GitHub](https://github.com/wisley-cesar/nome-do-repositorio)

## Conclusão
Esta implementação aborda um problema clássico de sincronização e concorrência, utilizando conceitos fundamentais de programação paralela para evitar problemas como deadlocks e starvation.

---


