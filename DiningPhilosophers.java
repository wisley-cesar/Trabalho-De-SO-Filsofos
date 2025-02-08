public class DiningPhilosophers {
    public static void main(String[] args) {
        int numPhilosophers = 5;
        Object[] forks = new Object[numPhilosophers];
        Philosopher[] philosophers = new Philosopher[numPhilosophers];

        // Criando os garfos como objetos compartilhados
        for (int i = 0; i < numPhilosophers; i++) {
            forks[i] = new Object();
        }

        // Criando os filósofos e associando os garfos
        for (int i = 0; i < numPhilosophers; i++) {
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % numPhilosophers];

            philosophers[i] = new Philosopher(i, leftFork, rightFork);
            philosophers[i].start();  // Inicia a Thread do filósofo
        }
    }
}
