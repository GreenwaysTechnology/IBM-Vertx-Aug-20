package com.ibm.reactive.threading;

import io.reactivex.rxjava3.core.Observable;

public class ThreadClassAndReactive {
    public static void main(String[] args) throws InterruptedException {
        Observable<String> mono = Observable.just("Hello World");
        //Create a custom Thread
        Thread thread = new Thread(() -> {
            mono.map(msg -> msg + " thread  ")
                    .subscribe(res -> System.out.println(res + Thread.currentThread().getName()));
        });
        thread.start();
        thread.join();

    }
}
