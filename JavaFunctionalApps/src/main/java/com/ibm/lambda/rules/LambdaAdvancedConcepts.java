package com.ibm.lambda.rules;

@FunctionalInterface
interface Greeter {
    void sayHello();
}

//args and parameters
//Single Input
@FunctionalInterface
interface Single {
    void accept(String input);
}

//More than One parameter
@FunctionalInterface
interface Function2 {
    void accept(String input1, String input2);
}

//Return
@FunctionalInterface
interface ValueGetter {
    String getValue();
}

//Args + Return
@FunctionalInterface
interface Adder {
    int add(int a, int b);
}

public class LambdaAdvancedConcepts {
    public static void main(String[] args) {
        /**
         * How to write lambda in simple form
         */
        Greeter greeter = null;
        //()- args,{function body}
        greeter = () -> {
            System.out.println("Welcome");
        };
        greeter.sayHello();
        //function body has only one line of code, remove {}
        greeter = () -> System.out.println("Welcome");
        greeter.sayHello();

        Single single = null;
        single = (String myinput) -> System.out.println(myinput);
        single.accept("Hello How are you?");
        //Type inference : type of variable in the method need not specified.
        single = (myinput) -> System.out.println(myinput);
        single.accept("Hello How are you?");
        //if lambda args has single arg value,remove ()
        //Type inference : type of variable in the method need not specified.
        single = myinput -> System.out.println(myinput);
        single.accept("Hello How are you?");

        //Two args
        Function2 myfunc2 = null;
        myfunc2 = (String input1, String input2) -> System.out.println(input1 + " " + input2);
        myfunc2.accept("One", "Two");
        myfunc2 = (input1, input2) -> System.out.println(input1 + " " + input2);
        myfunc2.accept("One", "Two");

        //Return values
        ValueGetter valueGetter = null;
        valueGetter = () -> {
            return "Value Return";
        };
        System.out.println(valueGetter.getValue());
        //Only return statement, no more function body, remove return statement,{}
        valueGetter = () -> "Value Return";
        System.out.println(valueGetter.getValue());

        //Input and output
        Adder adder = null;
        adder = (a, b) -> a + b;
        System.out.println(adder.add(1,2));

    }
}
