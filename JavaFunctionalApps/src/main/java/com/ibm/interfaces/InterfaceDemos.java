package com.ibm.interfaces;

interface Greeter {
    void sayHello();
}

class GreeterImpl implements Greeter {
    @Override
    public void sayHello() {
        System.out.println("Say Hello");
    }
}

public class InterfaceDemos {
    public static void main(String[] args) {
        Greeter greeter = null;
        greeter = new GreeterImpl();
        greeter.sayHello();

        // Anonmous inner class
        greeter = new Greeter() {
            @Override
            public void sayHello() {
                System.out.println("Inner annonmous class");
            }
        };
        greeter.sayHello();

        //lambda implementation
        greeter = () -> {
            System.out.println("Lambda");
        };
        greeter.sayHello();


    }
}
