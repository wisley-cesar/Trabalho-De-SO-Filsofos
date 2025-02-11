import java.util.concurrent.Semaphore;

public class DiningPhilosophers {
    public static void main(String[] args) {
        int numPhilosophers = 5;
        int cycles = 3;  // Número de vezes que cada filósofo irá comer/pensar antes de encerrar
        Object[] forks = new Object[numPhilosophers];
        Philosopher[] philosophers = new Philosopher[numPhilosophers];

        Semaphore table = new Semaphore(numPhilosophers - 1);

        // Criando os garfos como objetos compartilhados
        for (int i = 0; i < numPhilosophers; i++) {
            forks[i] = new Object();
        }

        // Criando os filósofos e associando os garfos
        for (int i = 0; i < numPhilosophers; i++) {
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % numPhilosophers];

            philosophers[i] = new Philosopher(i, leftFork, rightFork, table, cycles);
            philosophers[i].start();
        }

        // Esperar todas as threads finalizarem
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
