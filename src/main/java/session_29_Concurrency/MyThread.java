package session_29_Concurrency;

public class MyThread extends Thread{

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            System.out.println(getName() + " step -> " + i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e){}
        }
    }

    public static void main(String[] args) {
        new MyThread("Thread-A").start();
        new MyThread("Thread-B").start();
    }
}
