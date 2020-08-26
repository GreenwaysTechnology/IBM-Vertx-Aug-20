package com.ibm.reactive;

import io.reactivex.rxjava3.core.Observable;

public class StreamScratch {
    public static void main(String[] args) {
        Observable<Integer> stream = Observable.create(observer -> {
            boolean shouldFail = true;
            //send data via Observer: EventNotification Interface; emit data and send data
            observer.onNext(10); // emit data
            observer.onNext(20);
            if (shouldFail)
                throw new RuntimeException("Something Went Wrong!!");
            observer.onNext(30);
            observer.onComplete();
        });

        //Suscriber - will listen for data,error,complete
//        stream.subscribe(data -> System.out.println(data), err -> System.out.println(err), () -> {
//            System.out.println("Stream was completed");
//        });
        stream.subscribe(System.out::println, System.out::println, () -> {
            System.out.println("Stream was completed");
        });
    }
}
