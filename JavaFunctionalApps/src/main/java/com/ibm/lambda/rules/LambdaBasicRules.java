package com.ibm.lambda.rules;

//functional interface

/**
 * 1.interface must have only one obstract method :SAM
 * 2.you can have multiple non abstract, default and static methods
 */
interface Welcome {
    public static void doNothing() {
        System.out.println("Static methods");
    }

    public static void doNothing1() {
        System.out.println("Static methods");
    }

    void sayHello();

    // void sayHai();
    public default void doSomething() {
        System.out.println("Default methods");
    }

    public default void doSomething1() {
        System.out.println("Default methods");
    }
}

@FunctionalInterface
interface Something {
    void doSomething();
    // void doNothing();
    public default void mydefaultMetho() {
        System.out.println("Default methods");
    }
}

public class LambdaBasicRules {
    public static void main(String[] args) {
        Welcome welcome = null;

        welcome = () -> {
            System.out.println("SayHello");
        };
        welcome.sayHello();
        welcome.doSomething();
        welcome.doSomething1();
        Welcome.doNothing();
        Welcome.doNothing1();

        //
        Something something = null;
        something= ()->{
            System.out.println("Functional Interface Annotation");
        };
        something.doSomething();
        something.mydefaultMetho();

    }
}
