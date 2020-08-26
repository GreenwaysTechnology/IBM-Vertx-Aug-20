Vert.X:
........
What is Vertx?

Eclipse Vert.x is a tool-kit for building reactive applications on the JVM.

Vertx is functional,event driven,object oriented,reactive,non blocking tookit for building "distributed application - Micro service" on java virtual machine.

 Vert.x is Polyglot tool kit for building micro services application.

 Polyglot means multi technology /language.

 Vertx supports Polyglot on jvm.

Does JVM support multi language(Polyglot)?

   Yes!.

2002,JCP published  specfication called "multi language" on jvm.
 
Groovy, was the first reference implementation of that spec 
Kotlin
Jython - python + java

Vetx PolyGlot

You can use Vert.x with multiple languages including Java, Kotlin, JavaScript, Groovy, Ruby and Scala.

Vert.x doesn't preach about what language is best — you choose the languages you want based on the task at hand and the skill-set of your team.

We provide idiomatic APIs for every language that Vert.x supports.

...............................>

 How these languages works on jvm/
   jvm contract is only "byte code"

             groovy,kotlin,javascript,scala,ruby.......
	                |
                   compilers
                        |
                      .class
                        |
                       jvm
                                                   
..................................................................................

Core idea of Vert.x:

NonBlocking,aka Async Programming: Java and Nonblocking ,Async Programming:
...........................................................................

NonBlocking : node js && javascript..

What is nonblocking and async programming?

NonBlocking ,Async Architecture :

=> Reactor Design pattern

How runtime works /How programs are executed ?

if you want to understand blocking and non blocking , you need to understand basic runtime arch and execution styles.

Runtime:
  it is a program. eg jvm- jvm is a c program.

Types of programs:
 - active program
 - passive program


1.program, active program: The program in Main Memory/RAM.

What is process? 
  programs are in main memory /  active program
    ->Process : Program in execution
 any program, in main memory must have , structure : process structure.

2.passive program ; 
 program which is not in main memory/ which is not accessed by cpu.

Process layout:

Heap:
  The ds for allocating dynamic memory .

Stack:
  The ds for  allocating dynamic memory.

Program data;

 it is ds for passive programs of running application.



What is Object?

The term object refers "memory representation of variables and methods in side heap of  a process" : collective memory.

since memory representation , will have a structure.

passive code     ----->Active code

class Employee {
  state:variables
  methods
  public void calculate(){
  	//biz logic
  }
 
} ---->new Employee()---->Active

What is the structure of object?

state
vtable

why vtable? - Virtual Table
 vtable will have only reference of methods passively.
 because of memory management.

 Executing methods:
  Memory allocation of that method.
  then only cpu can run method.

  As soon as method is called , method picked up from method area, and will be pushed into stack.

  Stack:
     The Last in first out ds.
  Roles of Stack:
    -Memory allocation for any methods.
    -keep track of memories 
    -Keep track of method exection context.

Stack Frame:
  Active execution of methods  by CPU.


Code flow:

Can i run parel frames ?

Flow sequential - sync programming

c.add()---->heap--methodarea--stack--frame---running|- frame is removed
 control move to next frame.
c.calc()---heap --methodare--stack--frame ---running

Can i run more than one frame?

Yes! -----Multi threading.

What is thread of execution? thread?

 A stack frame is called as "thread"

 We can more than one thread at the same time, but any one can be active.

Who manages moving threads(frames) passive and active ?
  Thread scheduler is taking care of managing life of threads.

&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Types of Threading architectures:

- Process level threads
- Worker-Thread / Reactor based model / Event driven model / Async Model

- Process(JVM) level threads:

In java , generally , if want  concurrent execution, jvm creates threads,mananges life cycle of those threads.

CREATE,RUN,CORRNIDATE,TERMINATION.

Problems with Process Level threads:
...................................

1.Blocking
 I have created thread to read database records.
 I have created thread to handle http req, in turn which talks to another thread called db thread.

 what if a thread takes longer time, that thread blocks the jvm, caller is keep on
 waiting...... : Blocking program.

When blocking happens?
 - long running process-long computation.
 - heavy data base reads
 - talks to external systems.
 - Intensive io operations like read and write gb of data.
 - Networking sockets

How to build better non blocking systems?

With help of another concurrency pattern - Worker thread Model

Component of Reactor Pattern:

1.Event Loop thread

2.Event Queue

3.Worker threads

4.main thread

5.stack

6.Heap

&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Event loop concurrency is better for heavy /long running tasks.
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Reactor Design pattern In Java : Vert.x:
........................................

Java and Non blocking Programming:

 Does java support non blocking(worker-thread) model?
 Does jvm supports non blocking,evented concurrency?

No!

Yes from Java 7 called "Dolphin".

Dolphin introduced experimental model for building fast disk io, called "NIO"
NONBlocking IO. But not based on  worker thread model.

That was beginning

  due to low support from the java, only disk io was implemented: nio

later it was improved to support read and write using nio for TCP/IP . but it is still not  "Worker thread Model".


...............................................................................................
                                   Reactor Design Pattern
.............................................................................................

                All non blocking architectures(worker-thread( are designed with  
                         "Reactor Design pattern" Pattern.


Reactor design pattern implementations:

1.nodejs
2.Vertx
3.Project Reactor (used in springWebFlux)
4.nginx

Reactor design pattern in java:
..............................


NETTY

 "Netty is a NIO client server framework which enables quick and easy development of network applications such as protocol servers and clients. "

It greatly simplifies and streamlines network programming such as TCP and UDP socket server.

Unified API for various transport types - blocking and non-blocking socket

Based on a flexible and extensible event model which allows clear separation of concerns- The first Reactor Model on jvm.

                   Netty
		            |
          	      nettycore
			        |
			        nio
			        |
		           jvm

Netty project provides:
1.nio only for disk io but netty provided more io like
   tcp/ip,sockets,udp,http
  non blocking  
    netty uses "Reactor Model" internaly

Apache MINA 

  Apache MINA is a network application framework which helps users develop high performance and high scalability network applications easily.
 It provides an abstract event-driven asynchronous API over various transports such as TCP/IP and 

UDP/IP via Java NIO.
NIO framework library,
client server framework library, or
a networking socket library



 		    Apache MINA 
		         |
          	      Minaapi
			 |
			nio
			 |
		        jvm



Vertx:

Birth of Vertx Project

Vertx was born to simulate Node.js Capability on JVM.
 initally it was named "Node.X"

A core project, called vertx-core, provides the APIs for asynchronous programming, non-blocking I/O, streaming, and convenient access to networked protocols such as TCP, UDP, DNS, HTTP or Web Sockets,

Vertx is industry ready , polyglot toolkit for building Non blocking,async,evented io applications.

Vertx has been built on the top of Netty Core.




Vertx:


Birth of Vertx Project

Vertx was born to simulate Node.js Capability on JVM. initally it was named "Node.X"

A core project, called vertx-core, provides the APIs for asynchronous programming, non-blocking I/O, streaming, and convenient access to networked protocols such as TCP, UDP, DNS, HTTP or Web Sockets,

Vertx is industry ready , polyglot toolkit for building Non blocking,async,evented io applications.

Vertx has been built on the top of Netty Core.


			VertxApplication
			      |
			Vertx Core Runtime
			      |
			   Netty Core
			      |
			     NIO
			      |
			     JVM

Objective of VertX:
   
    100% non blocking applications on jvm.



NonBlocking IO Apis


                     NonBlocking IO Application -VertApplication
   --------------------------------------------------------------------		
    Vertx-FS  Vertx-TCP/IP  Vertx-UDP Vertx-HTTP Vertx-HTTPS Vertx-SMTP .....
  ---------------------------------------------------------------------
			      |
			Vertx Core Runtime
			      |
			   Netty Core
			      |
			     NIO
			      |
			     JVM


vert-x is poly glot:

 Vertx is java technology platform, Vertx runs on JVM.
 Fundamentally JVM supports multiple language as JVM Spec dt 2003.


             Java PL  Groovy Kotlin  Javascript  scala Ruby
		|       |     |         |         |     |
      -------------------------------------------------------------
                               .class
				 |
   --------------------------------------------------------------------		
       Vertx-FS  Vertx-TCP/IP  Vertx-UDP Vertx-HTTP Vertx-HTTPS Vertx-SMTP .....
  ---------------------------------------------------------------------
			      |
			Vertx Core Runtime
			      |
			   Netty Core
			      |
			     NIO
			      |
			     JVM
                                
                                Vertx Tech Stack
  Build async,non blocking Apps

Spring is collection of projects called modules
  like core,data,mvc,integration,microservice.............

Like Spring Vertx is also collection projects

Vertx-core
vertx-web
Vertx-Data
Vertx-Reactive Extension
Vertx-Microservices
Vertx-Messaging
Vertx-Security
Vertx-Integration
Vertx-Devops Engineering
Vertx-Testing
Vertx-Clusters
Vertx-Services
Vertx-Cloud

Vertx-Core:
Writing TCP clients and servers
Writing HTTP clients and servers including support for WebSockets
The Event bus
Shared data - local maps and clustered distributed maps
Periodic and delayed actions
Deploying and undeploying Verticles
Datagram Sockets
DNS client
File system access
High availability
Native transports
Clustering   

&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Lets code:

-Vertx Project setup

-Maven Project
-Gradle Project

1.plain maven project, add vertx depedencies,You can use template entry method provided by
vertx .

2.Vertx Starter project

3.Vertx maven cli project

Vetx Distribution:

-maven
-zip

download zip and extract and set path 
C:\session\ibm\Aug\vert.x-3.9.2-full\vertx\bin


running:
To launch your tests:

./mvnw clean test
To package your application:

./mvnw clean package
To run your application:

./mvnw clean compile exec:java
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Vertx Project Running:

1.via maven command
mvnw clean compile exec:java

The main entry program must be configured in pom.xml
    <main.verticle>ibm.vertx.MainVerticle</main.verticle>

2.through java command.

You have to pack vertx app as fat jar.

1.mvnw clean package - make it fat jar

2.java -jar target/vertx-apps-1.0.0-SNAPSHOT-fat.jar

3.via vertx command

C:\session\ibm\Aug\Vertx-Training\vertx-apps\src\main\java\ibm\vertx>vertx run  MainVerticle.java

4.via java main method ; recommended for development

&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Vertx Application:

 Vertx application is application is developed and deployed on vertx Run time.

 Vertx Runtime is Core of vertx.

                            Vertx Apps
                                |
                            Vertx Runtime
                                |
                             Netty Core
                                |
                               NIO
                                |
                               JVM




Vertx Core Concepts:

1.Vertx Instance
2.Verticle

io.vertx.core package is core package

Vertx Instance:

 It is Object,Container Object. like Spring Container.

-it is entry and exit point of vertx application.
-on jvm(single) process can have single vertx instance.
-vertx can host other objects.

Objects in vertx Land:
..................... 
1.vertx instance
2.Verticle

1.how to create vertx instance

Vertx Instance can do 

Creating TCP clients and servers
Creating HTTP clients and servers
Creating DNS clients
Creating Datagram sockets
Setting and cancelling periodic and one-shot timers
Getting a reference to the event bus API
Getting a reference to the file system API
Getting a reference to the shared data API
Deploying and undeploying verticles



1.1. Vertx instance is created using factory apis
..................................................

To create an instance of this class you can use the static factory methods:
  vertx(), 
  vertx(io.vertx.core.VertxOptions) 
  clusteredVertx(io.vertx.core.VertxOptions, Handler).

package ibm.vertx.core;

import io.vertx.core.Vertx;

public class CreateVertxInstance {
  public static void main(String[] args) {

    //Create Vertx instance
    Vertx vertx = Vertx.vertx();
    System.out.println(vertx.getClass().getName());

  }
}

&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Verticle:
  -It is java object
  -It can be deployed and undeployed on vertx instance.
  -It is based on design pattern called "Actor-like Model"
  -Verticles are bound to "Event loop" , are processed by event loops.

Verticle is interface which provides life cycle methods 
  -init
  -start - called when verticle during deployment
  -stop  - called when verticles during undeployment

 How to use Verticle?

 AbstractVerticle is base class for creating our own verticles.

Use case First verticle :


steps:

1.declare a class
2.extends Abstract Verticle
3.override start  method
4.deploy the verticle.


Running via Special Runner class provided by vertx itself.

Deployment :

-> via maven deployement
- via vertx command deployement

- via Programmetic deployement

Vertx instance can be created 
using factory method Vertx.vertx()
using AbstractVerticle , inside this class vertx instance already refered via
vertx variable

package ibm.vertx.core;

import io.vertx.core.AbstractVerticle;
import io.vertx.example.util.Runner;

public class HelloWorldVertcle extends AbstractVerticle {
  public static void main(String[] args) {
    Runner.runExample(HelloWorldVertcle.class);
  }
  @Override
  public void start() throws Exception {
    super.start();
    System.out.println("Hello World Verticle is Deployed");
  }
}
if you want to create your own verticles, then you have to inherit AbstractVerticle

if you inherit AbstractVertcle, vertx reference is availble automatically,you need not use factory method.

Abstract verticle provides life cycle methods

start
  - is called once , you deploy the verticle on vertx
stop
 - is called once , you undeploy the verticle from vertx

&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Vertx apps:
 Collection of Verticles which can talk each other, they can exchanges messages

Vertx Application must have one single root / main verticle from where verticle application is started.


package ibm.vertx.core;

import io.vertx.core.AbstractVerticle;
import io.vertx.example.util.Runner;

class GreeterVerticle extends AbstractVerticle {
  @Override
  public void start() throws Exception {
    super.start();
    System.out.println("Greeter Verticle");
    vertx.deployVerticle(new HelloVerticle());
  }
}

class HelloVerticle extends AbstractVerticle {
  @Override
  public void start() throws Exception {
    super.start();
    System.out.println("HelloVerticle deployed");
  }
}


public class MainVertcle extends AbstractVerticle {
  public static void main(String[] args) {
    Runner.runExample(MainVertcle.class);
  }

  @Override
  public void start() throws Exception {
    super.start();
    System.out.println("Main Verticle is Started");
    vertx.deployVerticle(new GreeterVerticle());
  }
}
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
Event Handlers:
..............

Vertx Handlers - Event Handlers:
................................

Vertx Event Handlers can be in written in two ways

1.Future && Promise Pattern : Functional style
2.Reactive Pattern - RxJava2


if you come from java script && node.js background,you know the concept called "Callback function" - callback function is other wise called as "listener function" or "handler function".


1.Handler functions are not called by developers directly like other functions.
2.Handlers functions are called by a thread "Event Loop".
3.Handler functions are available inside Event Queue as passive instruction.
4.Once async operation(task-database connnection) is completed, os triggers event, along with event, data, and its   handler is pushed into event queue, event loop starts processing.

What is handler function/callback function/listener function for?
To handle async success /failure result.
   The result of async opertion could be either success or failure


io.vertx.Future:

-it is interface used to handle async success/failure results.

io.vertx.core

Interface Future<T>

Future Interface 
				AsyncResult       Handler
				-------------------------
					   |
				     Future


Future interface is used to handle the result of async operation.


Future is interface , encapsulate response(Success/failure), we need to create Object 
for "Future" implementation
 Future f = Future.future() // create FutureImpl object

Two major api for response:


1.complete()  and complete(T result) =>Success Response, encasulated inside this api

2.fail(String failureMessage) and fail(Throwable cause) =>Failure response, encapsulate
 inside this api.

Handler apis for handling response;
...................................

1.succeeded() : empty response
2.default Future<T> setHandler(Handler<AsyncResult<T>> handler)
3.default Future<T> onComplete(Handler<AsyncResult<T>> handler)
4.onSuccess
5.onFailure

AsyncResult interface apis

 -result() - get the success result sent by Future
 -cause()   -get the failure result sent by Future
 -succeed() -test whether it was success or failure
 -failed()  -test whether it was failure or success

 ********************************************************************************
coding use case
Future may
 -not return any value ; empty
 -may return success result
 -may return failure result
 -may return either success/failure - biz use case

steps

callee:
1.create future object using Future.future factory method
2.wrap result -  empty / success/failure
3.return the future.

caller
4.handle the future

package ibm.vertx.core.asyncwrappers;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.example.util.Runner;


class FutureVerticle extends AbstractVerticle {

  //empty use case :callee
  public Future<Void> getEmptyFuture() {
    //create Future Object
    Future<Void> future = Future.future();
    //wrap empty result
    future.complete();
    return future;
  }

  //return response: success only
  public Future<String> getSuccessFuture() {
    Future<String> future = Future.future();
    //wrap success string response
    future.complete("Hello World Response");
    return future;
  }

  @Override
  public void start() throws Exception {
    super.start();
    //call and handle the future
    if (getEmptyFuture().succeeded()) {
      System.out.println("Call succeeded");
    } else {
      System.out.println("Call failed");
    }
    //Handle Response
//    getSuccessFuture().setHandler(new Handler<AsyncResult<String>>() {
//      @Override
//      public void handle(AsyncResult<String> asyncResult) {
//        if (asyncResult.succeeded()) {
//          System.out.println(asyncResult.result());
//        } else {
//          System.out.println(asyncResult.cause());
//        }
//      }
//    });
//    getSuccessFuture().setHandler(asyncResult -> {
//      if (asyncResult.succeeded()) {
//        System.out.println(asyncResult.result());
//      } else {
//        System.out.println(asyncResult.cause());
//      }
//    });
    getSuccessFuture().onComplete(asyncResult -> {
      if (asyncResult.succeeded()) {
        System.out.println(asyncResult.result());
      } else {
        System.out.println(asyncResult.cause());
      }
    });
    //more simple pattern
    getSuccessFuture().onSuccess(handler -> {
      System.out.println(handler);
    });
    getSuccessFuture().onSuccess(System.out::println);

  }
}


public class FutureMainVerticle extends AbstractVerticle {
  public static void main(String[] args) {
    Runner.runExample(FutureMainVerticle.class);
  }

  @Override
  public void start() throws Exception {
    super.start();
    vertx.deployVerticle(new FutureVerticle());
  }
}
