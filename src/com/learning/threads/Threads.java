package com.learning.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Threads {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService es = Executors.newSingleThreadExecutor();
        final long curr = System.currentTimeMillis();

        final Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println("print from thread t1 execute" + curr); 
            }
        };

        final Thread t2 = new Thread() {
            @Override
            public void run() {

                try {
                    System.out.println("print from thread t2 execute" + curr);
                    t1.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        es.execute(t1);
        es.execute(t2);

        System.out.println("after sleep" + (System.currentTimeMillis() - curr));

    }
    
    public class TestThread extends Thread{
        
    }
}
