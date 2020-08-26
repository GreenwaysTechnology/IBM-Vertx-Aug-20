package com.ibm.reactive;

import io.reactivex.rxjava3.core.Observable;

public class StreamWIthLogin {
    public static void main(String[] args) {
        Observable<String> stream = Observable.create(observer -> {
            String userName = "admin";
            String password = "admin";
            if (userName.equals("admin") && password.equals("admin")) {
                observer.onNext("LoginSuccess");
            } else {
                observer.onError(new RuntimeException("Login Failed"));
            }
            observer.onComplete();
        });
        stream.subscribe(System.out::println, System.out::println, () -> {
            System.out.println("Stream was completed");
        });
    }
}
