package com.ibm.lambda.rules;

class ThreadImpl implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

public class ThreadsRunnableLambda {
    public static void main(String[] args) {
        Thread thread = null;
        thread = new Thread(new ThreadImpl());
        thread.start();
        //annomus
        Runnable runner = null;
        runner = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        thread = new Thread(runner);
        thread.start();
        //Inline annonmous inner class
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());

            }
        });
        thread.start();

        //Lambda
        runner = () -> System.out.println(Thread.currentThread().getName());
        thread = new Thread(runner);
        thread.start();
        //inline lambda
        thread = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        thread.start();


    }
}
