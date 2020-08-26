package com.ibm.reactive.rety;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Retry {
    public static void main(String[] args) {
        Observable firstMillion = Observable.range(1, 100000).sample(1, TimeUnit.NANOSECONDS);

        firstMillion.subscribe(next -> System.out.println("Subscriber #1: " + next), // onNext
                throwable -> System.out.println("Error: " + throwable), // onError
                () -> System.out.println("Sequence #1 complete") // onComplete
        );


    }
}
