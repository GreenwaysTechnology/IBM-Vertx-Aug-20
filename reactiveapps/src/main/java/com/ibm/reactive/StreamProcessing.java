package com.ibm.reactive;

import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;
import java.util.List;

public class StreamProcessing {
    public static void mapOperator() {
        Observable<Integer> stream = Observable
                .range(1, 25) //source stream ---UpStream
                .map(item -> { //down stream -- up stream : WorkStation
                    System.out.println("Emitted : " + item);
                    return item * 2;
                })
                .map(item -> { //down stream --- up stream // WorkStation
                    System.out.println("Emitted : " + item);
                    return item * 2;
                });
        stream.subscribe(System.out::println);

    }

    public static void filterOperator() {
        //works based on predicate, If condition is true only , it will push items to downstream
        Observable<Integer> stream = Observable
                .range(1, 25) //source stream ---UpStream
                .filter(item -> item % 2 == 0) // downstream --- upStream
                .map(item -> { //down stream --- up stream // WorkStation
                    System.out.println("Emitted : " + item);
                    return item;
                });
        stream.subscribe(System.out::println);
    }


    public static void zipOperator() {
        Observable<Integer> intStream = Observable.just(1, 2, 3, 4);
        Observable<String> stringStream = Observable.just("a", "b", "c", "d", "e");

        Observable.zip(intStream, stringStream, (i, j) -> {
            String result = i + j;
            return result;
        }).subscribe(System.out::println);

    }

    public static void main(String[] args) {
        //mapOperator();
        //filterOperator();
        // flatMap();
        //
        // zipOperator();
        coimbineMany();

    }

    public static void coimbineMany() {
        List<String> words = Arrays.asList("the", "quick", "quick", "brown", "fox", "apple", "fox", "jumped", "over", "the", "lazy", "dog");
        Observable<String> manyLetters = Observable
                .fromIterable(words)
                .flatMap(word -> {
                    return Observable.just(word);
                })
                .distinct()
                .sorted();
        manyLetters.subscribe(System.out::println);

    }

    public static void flatMap() {
        List<String> items = Arrays.asList("a", "b", "c", "d", "e", "f");

        Observable.fromIterable(items)
                .flatMap(s -> {
                    System.out.println(s);
                    return Observable.just(s + " new Item");
                }).subscribe(System.out::println);

    }
}
