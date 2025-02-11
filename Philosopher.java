import java.util.concurrent.Semaphore;

class Philosopher extends Thread {
    private int id;
    private Object leftFork;
    private Object rightFork;
    private Semaphore table;
    private int cycles; // Número de ciclos de comer/pensar

    public Philosopher(int id, Object leftFork, Object rightFork, Semaphore table, int cycles) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.table = table;  // Semáforo para controlar quantos filósofos podem tentar pegar garfos
        this.cycles = cycles; // Armazena o número de ciclos
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
            for (int i = 0; i < cycles; i++) {  // Limitar o número de ciclos
                think();

                table.acquire(); // Garante que no máximo 4 filósofos tentem pegar garfos
                synchronized (leftFork) {
                    System.out.println("Filósofo " + id + " pegou o garfo esquerdo.");

                    synchronized (rightFork) {
                        System.out.println("Filósofo " + id + " pegou o garfo direito e está comendo.");
                        eat();
                    }

                    System.out.println("Filósofo " + id + " soltou o garfo direito.");
                }
                System.out.println("Filósofo " + id + " soltou o garfo esquerdo.");
                table.release(); // Libera espaço para outro filósofo tentar comer
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
