package com.ibm.reactive;

import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;
import java.util.List;

public class DataSource {
    public static void justOperator() {
        Observable<Integer> stream = Observable.just(1, 2, 3, 4, 5, 6, 6, 7, 8);
        stream.subscribe(System.out::println, System.out::println, () -> {
            System.out.println("Stream was completed");
        });
    }

    public static void arrayOperator() {
        int[] list = {1, 2, 3, 4, 5, 6, 7};
        Observable<int[]> stream = Observable.fromArray(list);
        stream.subscribe(e -> {
            for (int i = 0; i < e.length; i++) {
                System.out.println(e[i]);
            }
        }, System.out::println, () -> {
            System.out.println("Stream was completed");
        });
    }

    //collection
    public static void collectionOperator() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 6, 7, 8);
        Observable<Integer> stream = Observable.fromIterable(list);
        stream.subscribe(System.out::println, System.out::println, () -> {
            System.out.println("Stream was completed");
        });
    }

    public static void main(String[] args) {
        //justOperator();
        // arrayOperator();
        collectionOperator();
    }

}
