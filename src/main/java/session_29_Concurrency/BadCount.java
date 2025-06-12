package session_29_Concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BadCount {
    public static int count = 0;

    public static synchronized void increment(){
        int aux = count;
        aux = aux + 1;
        count = aux;
        System.out.println(count);
    }

    private static final Object LOCK = new Object();

    public static synchronized void incrementWithLock(){
        synchronized (LOCK){
            count = count + 1;
            System.out.println(count);
        }
    }

    private static final Lock lock = new ReentrantLock();

    public static synchronized void incrementWithReentrantLock(){
        if (lock.tryLock()){
            try {
                count++;
            } finally {
                lock.unlock();
            }
            System.out.println(count);
        } else {
            System.out.println("Is already locked " + Thread.currentThread().getName());
        }
    }


    public static void main(String[] args) {
        for (int i = 0; i <= 1000; i++){
            new Thread(BadCount::increment).start();
        }

        for (int i = 0; i <= 1000; i++){
            new Thread(BadCount::incrementWithLock).start();
        }

        for (int i = 0; i <= 1000; i++){
            new Thread(BadCount::incrementWithReentrantLock).start();
        }
    }
}
