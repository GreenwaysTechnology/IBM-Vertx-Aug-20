package com.ibm.reactive.threading;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ReactiveSchedulers {

    public static void main(String[] args) {
        Scheduler scheduler = Schedulers.newThread();
        Observable stream = Observable.just("Hello Scheduler")
                .map(message -> {
                    System.out.println("First Map : " + Thread.currentThread().getName());
                    return message;
                }).observeOn(Schedulers.computation()) //will apply to all down stream
                .map(newMessage -> {
                    System.out.println(" Second Map : " + Thread.currentThread().getName());
                    return newMessage;
                })
                .observeOn(Schedulers.single())
                .map(newMessage -> {
                    System.out.println("Third Map : " + Thread.currentThread().getName());
                    return newMessage;
                })
                .doOnNext(r -> System.out.println(r));
        //stream.subscribe();
        stream.blockingLast();// which stops the main thread until all data processing is over.

        //Thread.sleep(5000); //blocked main thread for 5scs
    }
}
