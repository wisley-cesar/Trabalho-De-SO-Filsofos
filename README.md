# Problema do Jantar dos Filósofos

Este projeto apresenta uma implementação do problema do Jantar dos Filósofos utilizando a linguagem Java e Threads para solucionar a questão de sincronização entre os filósofos.

## Autor

[Wisley César](https://github.com/wisley-cesar)

## Descrição do Problema

O problema do Jantar dos Filósofos foi proposto por Dijkstra em 1965 como um desafio de sincronização de processos. O problema consiste em cinco filósofos sentados em uma mesa redonda, onde cada um tem um prato de espaguete e um garfo ao lado. Para comer, um filósofo precisa pegar dois garfos: um à sua esquerda e outro à sua direita. Caso consiga, ele come durante um tempo e depois libera os garfos para voltar a pensar.

### Regras:
- Cada filósofo pode alternar entre pensar e comer.
- Para comer, ele precisa pegar dois garfos.
- Um garfo só pode ser usado por um filósofo por vez.
- Um filósofo só pode começar a comer quando possuir ambos os garfos.
- Após comer, o filósofo libera os garfos.

O desafio é implementar um algoritmo que evite condições de deadlock e starvation.

## Implementação

A solução foi implementada em Java utilizando Threads e Semáforos. Cada filósofo é representado como uma thread, e o acesso aos garfos é controlado para evitar conflitos simultâneos.

### Tecnologias Utilizadas
- **Java** (Threads e Semáforos para sincronização)
- **IDE sugerida:** IntelliJ IDEA ou Eclipse

## Código Fonte

```java
import java.util.concurrent.Semaphore;

public class DiningPhilosophers {
    public static void main(String[] args) {
        int numPhilosophers = 5;
        int cycles = 3;
        Object[] forks = new Object[numPhilosophers];
        Philosopher[] philosophers = new Philosopher[numPhilosophers];

        Semaphore table = new Semaphore(numPhilosophers - 1);

        for (int i = 0; i < numPhilosophers; i++) {
            forks[i] = new Object();
        }

        for (int i = 0; i < numPhilosophers; i++) {
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % numPhilosophers];
            philosophers[i] = new Philosopher(i, leftFork, rightFork, table, cycles);
            philosophers[i].start();
        }

        for (int i = 0; i < numPhilosophers; i++) {
            try {
                philosophers[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n🛑 Todos os filósofos terminaram suas refeições e o jantar acabou! 🛑");
    }
}
```

```java
import java.util.concurrent.Semaphore;

class Philosopher extends Thread {
    private int id;
    private Object leftFork;
    private Object rightFork;
    private Semaphore table;
    private int cycles;

    public Philosopher(int id, Object leftFork, Object rightFork, Semaphore table, int cycles) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.table = table;
        this.cycles = cycles;
    }

    private void think() throws InterruptedException {
        System.out.println("Filósofo " + id + " está pensando...");
        Thread.sleep((long) (Math.random() * 2000));
    }

    private void eat() throws InterruptedException {
        System.out.println("Filósofo " + id + " está comendo 🍝");
        Thread.sleep((long) (Math.random() * 2000));
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < cycles; i++) {
                think();
                table.acquire();
                synchronized (leftFork) {
                    System.out.println("Filósofo " + id + " pegou o garfo esquerdo.");
                    synchronized (rightFork) {
                        System.out.println("Filósofo " + id + " pegou o garfo direito e está comendo.");
                        eat();
                    }
                    System.out.println("Filósofo " + id + " soltou o garfo direito.");
                }
                System.out.println("Filósofo " + id + " soltou o garfo esquerdo.");
                table.release();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
```

## Como Executar

1. Baixe o código-fonte e abra em uma IDE compatível com Java.
2. Compile e execute a classe `DiningPhilosophers.java`.
3. O programa irá simular os filósofos comendo e pensando, garantindo a sincronização correta.

## Resultados

- A implementação evita deadlock permitindo que, no máximo, quatro filósofos tentem pegar os garfos ao mesmo tempo.
- Cada filósofo segue o ciclo de pensar, pegar garfos, comer e liberar os garfos sem interrupções indefinidas.
- Utilização de semáforos para garantir que não haja bloqueios simultâneos.

## Vídeo de Apresentação

[📹 Link para o vídeo explicativo](#)

## Repositório no GitHub

[🔗 Repositório no GitHub](#)

## Conclusão

Essa implementação mostra como é possível resolver o problema de sincronização do Jantar dos Filósofos com Java e Threads, garantindo que os filósofos consigam comer sem bloquear uns aos outros.

---

Caso tenha dúvidas ou sugestões, sinta-se à vontade para contribuir no repositório! 😊

