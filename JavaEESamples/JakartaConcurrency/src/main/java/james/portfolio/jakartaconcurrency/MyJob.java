package james.portfolio.jakartaconcurrency;

public class MyJob implements Runnable {

    private int id;

    public MyJob(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Running Job: " + id);
    }
}
