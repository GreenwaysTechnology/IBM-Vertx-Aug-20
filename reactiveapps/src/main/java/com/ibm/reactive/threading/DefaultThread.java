package com.ibm.reactive.threading;

import io.reactivex.rxjava3.core.Observable;

public class DefaultThread {
    public static void main(String[] args) {
        Observable.just(10, 20).map(item -> {
            System.out.println(Thread.currentThread().getName());
            return item;
        }).subscribe();

    }
}
