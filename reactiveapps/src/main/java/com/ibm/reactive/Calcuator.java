package com.ibm.reactive;

class MyCalculator {
    int add(int a, int b) {
        return a + b;
    }

    int subtract(int a, int b) {
        return a - b;
    }
}

public class Calcuator {
    public static void main(String[] args) {
        MyCalculator calculator = new MyCalculator();
        System.out.println(calculator.add(10, 10));
        System.out.println(calculator.subtract(10, 10));

    }
}
