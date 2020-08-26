package com.ibm.reactive;


import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

public class BackPressures {
    public static void sampleOpertor() {
        Observable<Integer> observable = Observable
                .range(1, 50000)
                .sample(1, TimeUnit.NANOSECONDS)
                .map(i -> i); //down stream dont get values from 1 rather
        observable.subscribe(s -> {
            System.out.println("value after every 1 nano secs " + s);
        });
    }

    public static void buffer() {
        Flowable.range(1, 2000)
                .buffer(5)
                .map(i -> i) //down stream dont get values from 1 rather than get buffer of 5
                .subscribe((i) -> System.out.println("Item Got :" + i), System.out::println);
    }

    public static void lastN() {
        Flowable.range(1, 2000)
                .takeLast(50)
                .map(i -> i) //down stream dont get values from 1 rather than get buffer of 5
                .subscribe((i) -> System.out.println("Item Got :" + i), System.out::println);
    }

    public static void simpleFlowable() throws InterruptedException {
        Flowable flowable = Flowable.range(1, 100);

        flowable.subscribe(new Subscriber() {
            Subscription subscription=null;
            @Override
            public void onSubscribe(Subscription s) {
                this.subscription = s;
                s.request(5);
            }

            @Override
            public void onNext(Object o) {
                subscription.request(5);
                System.out.println(o);
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t);
            }

            @Override
            public void onComplete() {
                System.out.println("complete");
            }
        });

    }

    public static void main(String[] args) throws InterruptedException {
       // simpleFlowable();
          sampleOpertor();
        //buffer();
        //lastN();
    }
}
