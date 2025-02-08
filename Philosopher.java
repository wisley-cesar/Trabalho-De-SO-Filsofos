class Philosopher extends Thread {
    private int id;
    private Object leftFork;
    private Object rightFork;

    public Philosopher(int id, Object leftFork, Object rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void think() throws InterruptedException {
        System.out.println("Filósofo " + id + " está pensando...");
        Thread.sleep((long) (Math.random() * 2000));  // Simula tempo de pensamento
    }

    private void eat() throws InterruptedException {
        System.out.println("Filósofo " + id + " está comendo 🍝");
        Thread.sleep((long) (Math.random() * 2000));  // Simula tempo de refeição
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();

                synchronized (leftFork) {  // Pega o garfo esquerdo
                    System.out.println("Filósofo " + id + " pegou o garfo esquerdo.");

                    synchronized (rightFork) {  // Pega o garfo direito
                        System.out.println("Filósofo " + id + " pegou o garfo direito e está pronto para comer.");
                        eat();

                        System.out.println("Filósofo " + id + " soltou o garfo direito.");
                    }

                    System.out.println("Filósofo " + id + " soltou o garfo esquerdo.");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
