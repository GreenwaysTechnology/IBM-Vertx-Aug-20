package com.ibm.methodreferences;

import java.util.ArrayList;

@FunctionalInterface
interface MessageFunction {
    Message supply();
}

class Message {
    public Message() {
        System.out.print("Message Constructor");
    }
//
//    public Message supply() {
//        //this()
          //return this
//    }

    public void sayHello() {
        System.out.println(" : say Hello");
    }

    @Override
    public String toString() {
        return this.getClass().getName();
    }
}

class MicroTask {
    public static void startMicroTaskStatic() {

    }

    public void startMicoTask() {
        System.out.println("Micro Task : " + Thread.currentThread().getName());
    }
}


class Task {
    //instance method which will be acting as Lambda
    private void startMicoTask() {
        System.out.println(Thread.currentThread().getName());
    }

    public void start() {
        Thread thread = null;
        thread = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        thread.start();
        //isloate the thread task into a method method
        thread = new Thread(() -> this.startMicoTask());
        thread.start();
        //method references : with out lambda syntax;
        thread = new Thread(this::startMicoTask);
        thread.start();

        //what if the thread runnable logic isloated into another class
        MicroTask microTask = new MicroTask();
        thread = new Thread(() -> microTask.startMicoTask());
        thread.start();
        thread = new Thread(() -> new MicroTask().startMicoTask());
        thread.start();
        //method reference
        thread = new Thread(microTask::startMicoTask);
        thread.start();
        thread = new Thread(new MicroTask()::startMicoTask);
        thread.start();
        //method Reference of static
        thread = new Thread(MicroTask::startMicroTaskStatic);
        thread.start();

    }
}
class Animal{
    void eat(){
        System.out.println("animal eat");
    }
}
class Dog extends Animal{
    void bark(){
        System.out.println("Bark");
    }
}

public class MethodReference {
    public static void main(String[] args) {
        Task task = null;
        task = new Task();
        task.start();

        // MessageFunction messageFunciton =new Message();
        MessageFunction messageFunction = Message::new;// no arg constructor
        Message msg= messageFunction.supply(); //trigger constructor call
        msg.sayHello();
    }
}
