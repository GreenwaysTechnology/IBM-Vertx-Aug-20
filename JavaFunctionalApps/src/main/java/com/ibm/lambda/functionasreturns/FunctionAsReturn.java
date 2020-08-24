package com.ibm.lambda.functionasreturns;

@FunctionalInterface
interface Closure {
    void getValue(int value);
}

class Counter {
    public Closure fetchValue() {
//        Closure closure = () -> {
//            System.out.println("function as return value");
//        };
//        return closure;
//        return () -> {
//            System.out.println("Function as return value");
//        };
        return value -> System.out.println("Function as return value" + value);

    }
}

public class FunctionAsReturn {
    public static void main(String[] args) {
        Counter counter = null;
        counter = new Counter();
        Closure closure = counter.fetchValue();
        closure.getValue(100);
    }
}
