package com.ibm.reactive;

import io.reactivex.rxjava3.core.Observable;

public class ErrorHandling {
    private static String doSomething(int i) {
        // System.out.println(i);
        if (i == 5) {
            throw new RuntimeException("something went wrong!!!");
        }
        return Integer.toString(i);
    }

    public static void main(String[] args) {
        //legacy code
        try {
            for (int i = 1; i < 10; i++) {
                String v1 = doSomething(i);
                System.out.println(v1);
            }

        } catch (Throwable a) {
            System.out.println("CAUGHT" + a);
        }
        //Reactive way
        Observable<String> f = Observable.range(1, 10)
                .map(v -> doSomething(v));
        f.subscribe(v -> System.out.println(v), err -> System.out.println("CAUGHT" + err.getMessage()));
        //STATIC FALLBACK VALUE
        /**
         *
         try {
         for (int i = 1; i < 10; i++) {
         String v1 = doSomething(i);
         System.out.println(v1);
         }

         } catch (Throwable a) {
         return "RECOVERED";
         }
         */
        Observable.range(1, 10)
                .map(v -> doSomething(v))
                .onErrorReturn(throwable -> "Recovered")
                .subscribe(v -> System.out.println(v), err -> System.out.println(err));
/**
 * Fallback method
 *   try {
 *          for (int i = 1; i < 10; i++) {
 *          String v1 = doSomething(i);
 *          System.out.println(v1);
 *          }
 *
 *          } catch (Throwable a) {
 *             result = getFromCache("key1");
 *          }
 */
        Observable.range(1, 10)
                .map(v -> doSomething(v))
                .onErrorReturn(e -> getFromCache())
                .subscribe(v -> System.out.println(v), err -> System.out.println(err));

        Observable.range(1, 10)
                .map(v -> doSomethingboom(v))
                .onErrorReturn(e -> e.getMessage().equals("boom10") ? "recovered10" : "")
                .subscribe(v -> System.out.println(v), err -> System.out.println(err));
    }

    private static String getFromCache() {
        return "Recovered from Fallback method :Result from cache";
    }

    private static String doSomethingboom(int i) {
        // System.out.println(i);
        if (i == 5) {
            throw new RuntimeException("boom10");
        }
        return Integer.toString(i);
    }

}
