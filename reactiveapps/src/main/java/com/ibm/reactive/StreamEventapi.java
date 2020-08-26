package com.ibm.reactive;


import io.reactivex.rxjava3.core.Observable;

public class StreamEventapi {
    public static void main(String[] args) {
        Observable<Integer> stream = Observable
                .range(1, 10)
                .doOnSubscribe(subscription -> {
                    System.out.println("Do On Subscription");
                })
                .doOnNext(i -> {
                    System.out.println("Do on Next " + i);
                })
                .doOnError(err -> {
                    System.out.println("Do on Error" + err);
                })
                .doOnComplete(() -> {
                    System.out.println("Do on Complete");
                })
                .doFinally(() -> {
                    System.out.println("Do on finally");
                });
        stream.subscribe();
    }
}
