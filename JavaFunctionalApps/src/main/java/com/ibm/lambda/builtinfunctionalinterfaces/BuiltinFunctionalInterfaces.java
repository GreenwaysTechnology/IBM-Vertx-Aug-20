package com.ibm.lambda.builtinfunctionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BuiltinFunctionalInterfaces {
    public static void main(String[] args) {
        Supplier<String> supplier = null;
        supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "Hello";
            }
        };
        System.out.println(supplier.get());
        supplier = () -> "Hello";
        System.out.println(supplier.get());

        Consumer<String> consumer = null;
        consumer = response -> System.out.println(response);
        consumer.accept("Hello Consumer");

        Predicate<Integer> isBig = null;
        isBig = number -> number > 100;
        boolean result = isBig.test(106);
        System.out.println(result);

        Function<String, String> myfunc = null;
        myfunc = (input) -> {
            return input.toUpperCase();
        };
        System.out.println(myfunc.apply("Test"));

        //List
        List<Integer> list = Arrays.asList(1, 2, 3, 45, 56, 89);
        list.forEach(integer -> System.out.println(integer));
        list.forEach(System.out::println);


    }
}
