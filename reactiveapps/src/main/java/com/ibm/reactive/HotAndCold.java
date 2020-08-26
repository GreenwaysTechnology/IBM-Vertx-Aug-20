package com.ibm.reactive;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

public class HotAndCold {
    public static void coldObservableTest() throws InterruptedException {
        //interval operator emits sequenece of numbers based on timer
        Observable<Long> myObservable = Observable.interval(1, TimeUnit.SECONDS);
        myObservable.subscribe(item -> System.out.println("Observer 1: " + item));
        //after 3scs new subscriber joins
        Thread.sleep(3000);
        Disposable subscriber2 = myObservable
                .doOnSubscribe((r) -> System.out.println("Joining"))
                .doFinally(() -> System.out.println("Observer 2 left"))
                .subscribe(item -> System.out.println("Observer 2: " + item));
        //unscribe after 5000 ms
        Thread.sleep(5000);
        subscriber2.dispose();
        //block main thread for subscrber2
        Thread.sleep(8000);
    }


    //hot observble
    public static void multicastTest() throws InterruptedException {
        //cold
        Observable<Long> myObservable = Observable.interval(1, TimeUnit.SECONDS);
        //convert cold into hot
        ConnectableObservable<Long> connectableObservable = myObservable.publish();

        connectableObservable.connect();

        connectableObservable
                .doOnSubscribe((r) -> System.out.println("Observer 1 Joining"))
                .subscribe(item -> System.out.println("Observer 1: " + item));
        Thread.sleep(3000);

        connectableObservable
                .doOnSubscribe((r) -> System.out.println("Observer 2 Joining"))
                .subscribe(item -> System.out.println("Observer 2: " + item));

        Thread.sleep(3500);
        connectableObservable
                .doOnSubscribe((r) -> System.out.println("Observer 3 Joining"))
                .subscribe(item -> System.out.println("Observer 3: " + item));

        Thread.sleep(8000);

    }

    public static void main(String[] args) throws InterruptedException {
        //coldObservableTest();
        multicastTest();
    }
}
