package com.ibm.reactive;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

public class AdvancedTypes {
    //single
    public static void singleTest() {
        Single.create(observer->{
            observer.onSuccess("one");
            observer.onSuccess("two");
            observer.onSuccess("three");
            observer.onSuccess("four");
            observer.onSuccess("five");
        }).subscribe(System.out::println);

        Single<String> single = Single.just("hello");
        single.subscribe(System.out::println);
    }

    public static void maybeTest() {
      //single item only
        Maybe.just("hello")
                .subscribe(System.out::println, System.out::println, () -> System.out.println("onComplete"));
       //single but only error
        Maybe.error(new RuntimeException("something went wrong"))
                .subscribe(System.out::println, System.out::println, () -> System.out.println("onComplete"));

        //single but complete
        Maybe.empty()
                .subscribe(System.out::println, System.out::println, () -> System.out.println("onComplete"));

    }
    public static void completeTest() {
        Completable.complete().subscribe(() -> System.out.println("Completeable"));

    }
    public static void main(String[] args) {
        //singleTest();
        maybeTest();
//        completeTest();

    }
}
