class Philosopher extends Thread {
    private int id;
    private Object leftFork;
    private Object rightFork;
    private boolean reverseOrder;

    public Philosopher(int id, Object leftFork, Object rightFork, boolean reverseOrder) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.reverseOrder = reverseOrder;  // Indica se deve pegar os garfos na ordem reversa
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
            while (true) {
                think();

                if (reverseOrder) {
                    synchronized (rightFork) {  
                        System.out.println("Filósofo " + id + " pegou o garfo direito.");
                        synchronized (leftFork) {  
                            System.out.println("Filósofo " + id + " pegou o garfo esquerdo e está comendo.");
                            eat();
                        }
                        System.out.println("Filósofo " + id + " soltou o garfo esquerdo.");
                    }
                    System.out.println("Filósofo " + id + " soltou o garfo direito.");
                } else {
                    synchronized (leftFork) {  
                        System.out.println("Filósofo " + id + " pegou o garfo esquerdo.");
                        synchronized (rightFork) {  
                            System.out.println("Filósofo " + id + " pegou o garfo direito e está comendo.");
                            eat();
                        }
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
