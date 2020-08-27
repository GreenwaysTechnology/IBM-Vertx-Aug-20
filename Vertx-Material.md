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
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
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

  //return response: error only
  public Future<String> getErrorFuture() {
    Future<String> future = Future.future();
    //wrap success string response
    future.fail("Something went Wrong");
    return future;
  }

  //how to use success/failure
  public Future<String> login() {
    Future<String> future = Future.future();

    //biz logic
    String userName = "admin";
    String password = "adminxx";

    if (userName.equals("admin") && password.equals("admin")) {
      future.complete("Login Success");
    } else {
      future.fail("Login Failed");
    }

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
    ////////////////////////////////////////////////////////////
    getErrorFuture().onComplete(errhandler -> {
      if (errhandler.failed()) {
        System.out.println(errhandler.cause().toString());
      }
    });
    getErrorFuture().onFailure(System.out::println);
    ///////////////////////////////////////////////////////////////
    login().onComplete(asyncResult -> {
      if (asyncResult.succeeded()) {
        System.out.println(asyncResult.result());
      } else {
        System.out.println(asyncResult.cause());
      }
    });
    login()
      .onSuccess(System.out::println)
      .onFailure(System.out::println);


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
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
Async Wrapper Object : Promise:
...............................

Promise is async abstraction largly promoted by javascript community.
Dont Compare  javascript Promises with Vertx Promises , because both are different.

Promise is "semantically meaningfull abstraction" for handling asyn results.

Many times developers confuse with java Future and Vertx Future.

Promises can't be processed directly with onComplete/setHandler/OnSuccecc/onFailure apis

if you want process, you have to convert "Promise to Future" again.
  -promise.future();

promise conversion can be done when you process or promise conversion can be before process.
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
package ibm.vertx.core.asyncwrappers;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.example.util.Runner;

class PromiseVerticle extends AbstractVerticle {

  //Empty Promise
  public Promise<Void> getEmptyPromise() {
    Promise promise = Promise.promise();
    promise.complete();
    return promise;
  }

  public Future<String> getDataPromise() {
    Promise promise = Promise.promise();
    promise.complete("Hello World");
    //convert promise into future and return
    return promise.future();
  }

  //return response: error only
  public Future<String> getErrorFuture() {
    Promise promise = Promise.promise();
    //wrap success string response
    promise.fail("Something went Wrong");
    return promise.future();
  }

  //how to use success/failure
  public Future<String> login() {
    Promise promise = Promise.promise();
    //biz logic
    String userName = "admin";
    String password = "admin";

    if (userName.equals("admin") && password.equals("admin")) {
      promise.complete("Login Success");
    } else {
      promise.fail("Login Failed");
    }

    return promise.future();
  }


  @Override
  public void start() throws Exception {
    super.start();
    if (getEmptyPromise().future().succeeded()) {
      System.out.println("Promise Success");
    }
    //getDataPromise().future().onSuccess(System.out::println);
    getDataPromise().onSuccess(System.out::println);

    getErrorFuture().onComplete(errhandler -> {
      if (errhandler.failed()) {
        System.out.println(errhandler.cause().toString());
      }
    });
    getErrorFuture().onFailure(System.out::println);

    login().onComplete(asyncResult -> {
      if (asyncResult.succeeded()) {
        System.out.println(asyncResult.result());
      } else {
        System.out.println(asyncResult.cause());
      }
    });
    login()
      .onSuccess(System.out::println)
      .onFailure(System.out::println);

  }
}


public class PromiseMainVerticle extends AbstractVerticle {
  public static void main(String[] args) {
    Runner.runExample(PromiseMainVerticle.class);
  }

  @Override
  public void start() throws Exception {
    super.start();
    vertx.deployVerticle(new PromiseVerticle());
  }
}
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Legacy Application flow : object oriented and sync flow
  
dependent operations  , should happen one by one

Object oriented seq work flow

 1.connect db - connect()
 2.Query results -queryResult()
 3.Formate results -formateResult()
 4.add results into http response stream - write()
 5.send/flush the results to clients - send()

 Connection con=connect();
 QueryResult queryres=con.queryResult()
 ..................................................................

 Functional sequential workflow:

 Nested Callback : Callback chaining: functional style

  Handler function is called as callback function

"The out put of one callback is input to the another callback : nested callbacks

   cb1
     --cb2
         -cb3
            --cbN
              --process the result.


Use case :

 getUser ----|if data is available
			|	|
			|
			      	 call login method with input of getUser
                        |
		     if not
			 -error
package ibm.vertx.core.asyncwrappers;
//Callback nesting

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.example.util.Runner;

class CallbackNestingVerticle extends AbstractVerticle {
  //callback nesting ; outuput of one callback will be input to another callback

  public Future<String> getUser() {
    Promise promise = Promise.promise();
    //biz logic
    String fakeUser = "Subramanian";
    if (fakeUser != null) {
      promise.complete(fakeUser);
    } else {
      promise.fail("User Not found!");
    }
    return promise.future();
  }

  public Future<String> login(String fakeUser) {
    Promise promise = Promise.promise();
    //biz logic based on result of previous(getUser) function
    if (fakeUser.equals("Subramanian")) {
      promise.complete("Login Success");
    } else {
      promise.fail("Login failed!");
    }

    return promise.future();
  }

  @Override
  public void start() throws Exception {
    super.start();
    //call get User
    getUser().onComplete(asyncResult -> {
      if (asyncResult.succeeded()) {
        System.out.println("Get User is called");
        //call nesting ;
        login(asyncResult.result()).onComplete(loginarresult -> {
          if (loginarresult.succeeded()) {
            System.out.println(loginarresult.result());
          } else {
            System.out.println(loginarresult.cause());
          }
        });

      } else {
        System.out.println(asyncResult.cause());
      }
    });
  }
}


public class MainCallbackNestingVerticle extends AbstractVerticle {
  public static void main(String[] args) {
    Runner.runExample(MainCallbackNestingVerticle.class);
  }

  @Override
  public void start() throws Exception {
    super.start();
    vertx.deployVerticle(new CallbackNestingVerticle());
  }
}

&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
Grabbing Result:
-> by registering onComplete/setHandler/OnSuccess/OnFailure
-> Passing function as a parameter syntax - Callback function

For onComplete
public Future<?> getUser(){

}
public void getUser(Handler<AsyncResult<String>> ahandler){
 //logic

}


Caller syntax
getUser().onComplete() -Registration syntax
getUser((user)->{

}) - passing function as parameter

class UserVerticle extends AbstractVerticle {

  public void getUser(Handler<AsyncResult<String>> aHandler) {
    String fakeUser = "Subramanian";
    if (fakeUser != null) {
      //wrap result into future
      aHandler.handle(Future.succeededFuture(fakeUser));
    } else {
      aHandler.handle(Future.failedFuture("UserNot Found"));
    }
  }

  public void login(String fakeUser, Handler<AsyncResult<String>> aHandler) {
    if (fakeUser.equals("Subramanian")) {
      //wrap result into future
      aHandler.handle(Future.succeededFuture("Login Success"));
    } else {
      aHandler.handle(Future.failedFuture("Login failed"));
    }
  }

  public void showPage(String loginStatus, Handler<AsyncResult<String>> aHandler) {
    if (loginStatus.equals("Login Success")) {
      //wrap result into future
      aHandler.handle(Future.succeededFuture("You are Premium User"));
    } else {
      aHandler.handle(Future.failedFuture("YOu are guest"));
    }
  }


  @Override
  public void start() throws Exception {
    super.start();
    getUser(fakeUserRes -> {
      if (fakeUserRes.succeeded()) {
        System.out.println("Get User is called");
        //login
        login(fakeUserRes.result(), loginRes -> {
          if (loginRes.succeeded()) {
            System.out.println("Login  is called");
            showPage(loginRes.result(), pageRes -> {
              System.out.println("Show Page  is called");
              if (pageRes.succeeded()) {
                System.out.println(pageRes.result());
              } else {
                System.out.println(pageRes.cause());
              }
            });
            System.out.println(loginRes.cause());
          }
        });
      } else {
        System.out.println(fakeUserRes.cause());
      }
    });
  }
}
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
callback Hell:
 The way we write nested callbacks.
 doom of pyrmid


getUser(fakeUserRes -> {
      if (fakeUserRes.succeeded()) {
        System.out.println("Get User is called");
        //login
        login(fakeUserRes.result(), loginRes -> {
          if (loginRes.succeeded()) {
            System.out.println("Login  is called");
            showPage(loginRes.result(), pageRes -> {
              System.out.println("Show Page  is called");
              if (pageRes.succeeded()) {
                System.out.println(pageRes.result());
              } else {
                System.out.println(pageRes.cause());
              }
            });
            System.out.println(loginRes.cause());
          }
        });
      } else {
        System.out.println(fakeUserRes.cause());
      }
    });



Look at the above code , ask your self

1.is it easy to understand?
2.is it easy to scale
3.is it easy to maintain



can we escape from callback hell problem, how to write better callback based programming?

Yes! 

Solution to callback Hell:
..........................
compose method.


package ibm.vertx.core.asyncwrappers;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.example.util.Runner;

class CallbackHellVerticle extends AbstractVerticle {
  //prepareDatabase
  public Future<String> prepareDatabase() {
   // System.out.println("PrepareDatabase is called");
    Promise promise = Promise.promise();
    promise.complete("Redis server");
    return promise.future();
  }

  public Future<String> startHttpServer() {
   // System.out.println("startHttpServer is called");
    Promise promise = Promise.promise();
   // promise.fail("Http Server Error");
    promise.complete("Http Server");
    return promise.future();
  }

  public Future<String> startWebContainer() {
 //   System.out.println("startWebContainer is called");
    Promise promise = Promise.promise();
    promise.complete("Netty Container");
    return promise.future();
  }

  @Override
  public void start() throws Exception {
    super.start();
    //callback based
    prepareDatabase().onComplete(dbar -> {
      //if database success,start http server
      if (dbar.succeeded()) {
        startHttpServer().onComplete(httpar -> {
          //if http success, start web container
          if (httpar.succeeded()) {
            startWebContainer().onComplete(webctar -> {
              if (webctar.succeeded()) {
                System.out.println("System is Up!!");
              } else {
                System.out.println("System is down!!!");
              }
            });
          }
        });
      } else {
        System.out.println(dbar.cause().getMessage());
      }
    });
    //Compose mehtod
    prepareDatabase().compose(httpRes -> {
      //extra logic
      System.out.println(httpRes);
      return startHttpServer();
    }).compose(webcontainer -> {
      System.out.println(webcontainer);
      return startWebContainer();
    }).onComplete(status -> {
      if (status.succeeded()) {
        System.out.println("All Server: is Up");
      } else {
        System.out.println("All Server is Down");
      }
    });
    //simple
    prepareDatabase()
      .compose(httpRes -> startHttpServer())
      .compose(webct -> startWebContainer())
      .onSuccess(res -> System.out.println(res + " Server up"))
      .onFailure(err -> System.out.println(err + " Server Down"));


  }
}


public class CallbackHellSolutionVerticle extends AbstractVerticle {
  public static void main(String[] args) {
    Runner.runExample(CallbackHellSolutionVerticle.class);
  }

  @Override
  public void start() throws Exception {
    super.start();
    vertx.deployVerticle(new CallbackHellVerticle());
  }
}
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
Async and Non blocking:

Vertx is most pouplar for async programming:

->Vertx uses dedicated threads who handles all non blocking operations

vertx Engine components

1.Non blocking operations Thread pool : Event loop pool threads

2.Blocking operations thread pool : Worker Pool threads

3.Event Queue

4.Event loop thread
 -Listens for events from Async operation threads,
 -Assign event with handler(With Future/Promise) abstractions.
How many event loop?
 in node js, only one event loop.

 Vertx has many event loops, based on no of cpu cores
  lets say i have 12 core, 12 event loop will 

Which operations are  blocking and which operations are non blocking
based on verticles

Gloden Rules:
 Dont block event loop.


Types of Verticles:
...................

1.Standard Verticle
  This is most common and usefull type.
  Standard verticles are processed by event loop
  By default all verticles are event loop verticles

2.Worker Verticle
  It is verticle which is not processed by event loop any more, 
  Worker verticles are handled by "Worker pool"



somenonblockingapi()------>Assigns a thread (From Event loop thread loop)---running --done--emit event (nameof event + data) --- event loop listens for 
events---grab event--->starts assigning event to handler function (Which is registered inside event Queue)--handler function will deliver results

somenon-------------------->Assigns a thread -----running---

&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

What are the process are executed by "worker threads" , processed by event loop?

Vertx provides high level apis?
 only those apis can be scheduled inside worker threads

Api category
vert-core modules

Async api classification:

1.Timer api
2.File System
3.HTTP api
4.TCP/ip api
5.Database drivers api - jdbc,mongo...

Demo On Event loop thread: Standard Verticle

public class TimerAsyncMainVerticle extends AbstractVerticle {
  public static void main(String[] args) {
    Runner.runExample(TimerAsyncMainVerticle.class);
  }

  @Override
  public void start() throws Exception {
    super.start();
    System.out.println(Thread.currentThread().getName());
  }
}

How to write worker verticles?

worker verticles are processed by "normal thread pools"
Worker verticles not for async operatoins
worker verticles geneerally for blocking operations

In Vertx , Every object has configurations
-Vertx object has configuration
-Verticle has configurations
    
package ibm.vertx.async.timers;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.example.util.Runner;

class WorkerVerticle extends AbstractVerticle {
  @Override
  public void start() throws Exception {
    super.start();
    System.out.println("Worker Verticle Class :  " + Thread.currentThread().getName());
  }
}


public class StandardVerticle extends AbstractVerticle {
  public static void main(String[] args) {
    Runner.runExample(StandardVerticle.class);
  }

  @Override
  public void start() throws Exception {
    super.start();
    System.out.println(Thread.currentThread().getName());

    //Verticle Configuration object
    DeploymentOptions options = new DeploymentOptions();
    options.setWorker(true);
    vertx.deployVerticle(new WorkerVerticle(), options);
  }
}


timers

package ibm.vertx.async.timers;

import io.vertx.core.*;
import io.vertx.example.util.Runner;

import java.time.Instant;

class Timer extends AbstractVerticle {

  //funciton returns some message asynly
  public Future<String> delay() {
    Promise<String> promise = Promise.promise();
    //we are calling async scheduling
    vertx.setTimer(5000, handler -> {
      System.out.println("Timeout");
      promise.complete("Hello I am Delayed Message from " + Thread.currentThread().getName());
    });
    return promise.future();
  }

  //setperiod -
  public void heartBeat(Handler<AsyncResult<String>> asyncResultHandler) {
    long timerId = vertx.setPeriodic(1000, (ar) -> {
      asyncResultHandler.handle(Future.succeededFuture(Instant.now().toString()));
    });
    vertx.setTimer(10000, timer -> {
      System.out.println("Stopping Timer");
      vertx.cancelTimer(timerId);
    });
  }

  @Override
  public void start() throws Exception {
    super.start();
    //sync call
    System.out.println("start");
    delay().onSuccess(System.out::println);
    System.out.println("end");
    heartBeat(cb -> {
      System.out.println(cb.result());
    });

  }
}


public class TimerMainVerticle extends AbstractVerticle {
  public static void main(String[] args) {
    Runner.runExample(TimerMainVerticle.class);
  }

  @Override
  public void start() throws Exception {
    super.start();
    vertx.deployVerticle(new Timer());
  }
}
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Non blocking io:

Vertx is good for non blocking application.
Vertx is good for non blocking io application.

IO :
 IO is every Where.
Every pl , traditionally blocking io.
Vertx offers nonblocking io  / async io : io operations never block current process,to be scheduled separatelly.

Types of io:
1.file system io  - read,write from disk files
2.Networking io -  http,tcp/ip,dns,datagram....
3.Database io

File System api:
How to read a file async?

package ibm.vertx.async.fs;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.file.FileSystem;
import io.vertx.example.util.Runner;

public class FileSystemVerticle extends AbstractVerticle {
  public static void main(String[] args) {
    Runner.runExample(FileSystemVerticle.class);
  }

  private Future<String> readFile() {
    Promise<String> promise = Promise.promise();
    //read file async
    FileSystem fs = vertx.fileSystem();
    //read
    fs.readFile("assets/info.txt", fileHandler -> {
      if (fileHandler.succeeded())
        promise.complete(fileHandler.result().toString());
      else {
        promise.fail(fileHandler.cause().toString());
      }
    });

    return promise.future();
  }

  @Override
  public void start() throws Exception {
    super.start();
    readFile()
      .onSuccess(System.out::println)
      .onFailure(System.out::println);
  }
}
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
does vertx supports blocking code? is blocking is neccessary?How do we write blocking code? 

Yes! vertx supports blocking code.

Yes!, you cant write 100% non blocking code
.
Use case : 

You are building vertx application, vertx application need to talk to hibernate/jpa layer.
Vertx is non blocking but hibernate blocking.

if you write blocking inside non blocking vertx will throw error, but how to bride blocking with non-blocking.

Solution:

vertx itself provides blocking apis for some use cases
Fileystem.
  //blocking version of filessytem
  private Future<String> readFileBlockingApi() {
    Promise<String> promise = Promise.promise();
    FileSystem fs = vertx.fileSystem();
    //sync version
    Buffer buffer = fs.readFileBlocking("assets/info.txt");
    promise.complete(buffer.toString());
    return promise.future();
  }

&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Golden Rule : Dont block event loop:
.....................................

There is no gurantee that vertx can offer 100% non blocking, what if i want to write blocking opertions inside vertx.

-Non blocking operations are handled by "Event Loop" Thread.
-Blocking operations should be off loaded outside event loop thread, grab result carefully without  blocking event loop.



Blocking code :

1.Through verticle itself
   The verticle itself can be isloated from the event loop.
2.Through vertx has api executeBlocking.

Verticle Types:

  There are two types of verticles

1.Standard Verticle
2.Worker Verticle


1.Standard Verticle :
   These types of verticles are the most common and usefull type - They are always executed using 
an event loop thread.

2.Worker Verticle
    These run using a thread from the "Worker Pool".
    An instance is never executed concurrently by more than one thread.

Before deploying verticle, you can tell that this verticle is "Worker" / "standard".


Blocking could be 

Thread.sleep() - will block the current thread

class MyVerticle extends AbstractVerticle {
  @Override
  public void start() throws Exception {
    super.start();
    //non blocking code
    vertx.setTimer(1000, ar -> {
      //call blocking code
      try {
        System.out.println("zzzzzz");
        Thread.sleep(5000);
        System.out.println("After sleep");
      } catch (InterruptedException es) {
        System.out.println(es);
      }
    });
  }
}
output:
zzzzzz
Aug 27, 2020 3:48:04 PM io.vertx.core.impl.BlockedThreadChecker
WARNING: Thread Thread[vert.x-eventloop-thread-1,5,main]=Thread[vert.x-eventloop-thread-1,5,main] has been blocked for 2920 ms, time limit is 2000 ms
Aug 27, 2020 3:48:05 PM io.vertx.core.impl.BlockedThreadChecker
WARNING: Thread Thread[vert.x-eventloop-thread-1,5,main]=Thread[vert.x-eventloop-thread-1,5,main] has been blocked for 3920 ms, time limit is 2000 ms
Aug 27, 2020 3:48:06 PM io.vertx.core.impl.BlockedThreadChecker
WARNING: Thread Thread[vert.x-eventloop-thread-1,5,main]=Thread[vert.x-eventloop-thread-1,5,main] has been blocked for 4921 ms, time limit is 2000 ms

The above code throws warning that , event loop thread has been blocked.

Cant i write "Blocking code inside non blocking code"

No, we can , how to run this code safely.

->The whole verticle can be sheduled outside.
  isloate non blocking and blocking code  .


package ibm.vertx.async.blockingeventloop;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.example.util.Runner;

class MyVerticle extends AbstractVerticle {
  @Override
  public void start() throws Exception {
    super.start();
    //non blocking code
    vertx.setTimer(1000, ar -> {
      //call blocking code
      try {
        System.out.println("zzzzzz" + Thread.currentThread().getName());
        Thread.sleep(5000);
        System.out.println("After sleep");
      } catch (InterruptedException es) {
        System.out.println(es);
      }
    });
  }
}

public class BlockEventLoop extends AbstractVerticle {
  public static void main(String[] args) {
    Runner.runExample(BlockEventLoop.class);
  }

  @Override
  public void start() throws Exception {
    super.start();
    vertx.deployVerticle(new MyVerticle(), new DeploymentOptions().setWorker(true));
  }
}
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
How to isloate the whole Verticle Processing by Worker Pool thread?

 -Maker Worker Verticle

What if i dont want to isloate the entire Verticle  as worker Verticle , i want to  schedule a few apis ?

i want to get blocking result , inside non blocking code : coordination between event loop and work pool threads
 - The out put of worker pool thread, need inside event loop thread.

<T> void executeBlocking(Handler<Promise<T>> blockingCodeHandler,
                         boolean ordered,
                         Handler<AsyncResult<T>> resultHandler)


package ibm.vertx.async.blockingeventloop;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Promise;
import io.vertx.example.util.Runner;

class OffLoadVerticle extends AbstractVerticle{
  public void deploy(){
    vertx.setTimer(5000,handler->{
      //run blocking ,blocking code result i need inside nonblocking
      vertx.executeBlocking(this::sayHello,this::resultHandler);
    });
  }

  //read result from blocking service
  private void resultHandler(AsyncResult<String> ar) {
    System.out.println("Result Handler" + Thread.currentThread().getName());
    if (ar.succeeded()) {
      System.out.println("Blocking api Result goes Ready Here");
      System.out.println(ar.result());
    } else {
      System.out.println(ar.cause().getMessage());
    }
  }
  private void sayHello(Promise<String> promise) {
    System.out.println("Say Hello : " + Thread.currentThread().getName());
    try {
      Thread.sleep(4000);
      System.out.println("Wake Up read to send data to Non blocking Service");
      promise.complete("Hey this is blocking Result");
    } catch (InterruptedException es) {
      promise.fail("Something went wrong in blocking service");
    }
  }
  @Override
  public void start() throws Exception {
    super.start();
    deploy();
  }
}


class MyVerticle extends AbstractVerticle {
  @Override
  public void start() throws Exception {
    super.start();
    //non blocking code
    vertx.setTimer(1000, ar -> {
      //call blocking code
      try {
        System.out.println("zzzzzz" + Thread.currentThread().getName());
        Thread.sleep(5000);
        System.out.println("After sleep");
      } catch (InterruptedException es) {
        System.out.println(es);
      }
    });
  }
}

public class BlockEventLoop extends AbstractVerticle {
  public static void main(String[] args) {
    Runner.runExample(BlockEventLoop.class);
  }

  @Override
  public void start() throws Exception {
    super.start();
    //vertx.deployVerticle(new MyVerticle(), new DeploymentOptions().setWorker(true));
    vertx.deployVerticle(new OffLoadVerticle());
  }
}
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Vertx and Micro Services:

Vertx has been designed from scratch microservice architecture in mind.

Micro Service Patterns
 
 Micro services, the applicaiton is broken into multiple components called services.

1.Communication Pattern
 two applications how they communicate: Object Communcation : why ? they need to exechange data.
 if apps are in two different process?
    RPI

Types of communication
1.sync 
   styles:
 blocking 
  http 
  rpc
2.async
 non blocking
 http
 MOM - Message oriented middlewares- Rabbitmq,kafka...
 
In Vertx, How objects(Verticles) communicate each other?

 Via MOM like architecture, event bus

Event Bus:


-Event Bus is nerve of vertx systems.

-Vertx By default is distributed

-Vertx carries distributed architecture by default

-In Vertx Verticles can communicate via Centraized Broker which is built in called event Bus.

-Event Bus uses tcp transport layer by default
-EventBus can send and recive data in the form of json and buffer

How verticle has been designed to adopt this architecture?

Verticle follows a design pattern  "Actor-like Model" ---->Actor Model design pattern
 

Verticle follows a design pattern  "Actor-like Model" ---->Actor Model design pattern

https://doc.akka.io/docs/akka/current/typed/guide/actors-intro.html


&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

EventBus is also the reference of implementation of microservice design pattern "Pattern: Event sourcing"

Event Bus:

1.Event Bus can allow verticles sends data from one place to another place
2.Event Bus forms a distributed peer-to-peer messaging system spannining multiple server nodes   and multiple browers.
3.Event bus allows sending messages in three ways
  1.pub/sub : one to many
  2.point-to-point : one to one
  3.request-reply(reponse) - one to one with acknowlegement.

4.Event bus identifies clients via "addressing"
   Messages are sent on the event bus to an "address"
   Address schemes can be any naming convention, recommendation is dns model "in.news.covid"
   
5.Handlers
   Since vertx is non blocking, messages are processed by handlers.
   You have to register a handler at an address

6.Type of Data
   Data type of message could be any primitive-int,char,boolean,String, Buffer,JSON

   Per Vertx Engine only One Event Bus-single

&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Event Bus : PUB -SUB

one Verticle can send /publish message------async messages are delivered to many verticles in one short.


package ibm.vertx.async.eventbus;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.MessageConsumer;
import io.vertx.example.util.Runner;

//Consumer Verticles
class NewsSevenVerticle extends AbstractVerticle {
  public void consume() {
    EventBus eventBus = vertx.eventBus();
    //pub-sub
    MessageConsumer<String> messageConsumer = eventBus.consumer("news.in.covid");
    //handle /process the message/news
    messageConsumer.handler(news -> {
      System.out.println("News Seven  - Today News : " + news.body());
    });

  }

  @Override
  public void start() throws Exception {
    super.start();
    consume();
  }
}

class BBCVerticle extends AbstractVerticle {
  public void consume() {
    EventBus eventBus = vertx.eventBus();
    //pub-sub
    MessageConsumer<String> messageConsumer = eventBus.consumer("news.in.covid");
    //handle /process the message/news
    messageConsumer.handler(news -> {
      System.out.println("BBC  - Today News : " + news.body());
    });

  }

  @Override
  public void start() throws Exception {
    super.start();
    consume();
  }
}

class NDTVVerticle extends AbstractVerticle {

  public void consume() {
    EventBus eventBus = vertx.eventBus();
    //pub-sub
    MessageConsumer<String> messageConsumer = eventBus.consumer("news.in.covid");
    //handle /process the message/news
    messageConsumer.handler(news -> {
      System.out.println("NDTV  - Today News : " + news.body());
    });

  }

  @Override
  public void start() throws Exception {
    super.start();
    consume();
  }
}

//publisher Verticle
class NewsPublisherVerticle extends AbstractVerticle {

  public void publishNews() {
    //
    System.out.println("News started....");
    vertx.setTimer(5000, ar -> {
      //publish
      String message = "Last 24 Hrs,new 50000 covid patients in India";
      vertx.eventBus().publish("news.in.covid", message);
    });
  }

  @Override
  public void start() throws Exception {
    super.start();
    publishNews();

  }
}

public class EventBusMainVerticle extends AbstractVerticle {
  public static void main(String[] args) {
    Runner.runExample(EventBusMainVerticle.class);
  }

  @Override
  public void start() throws Exception {
    super.start();
    vertx.deployVerticle(new NewsPublisherVerticle());
    vertx.deployVerticle(new NewsSevenVerticle());
    vertx.deployVerticle(new BBCVerticle());
    vertx.deployVerticle(new NDTVVerticle());
  }
}

&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
Point --Point : one to One
package ibm.vertx.async.eventbus;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.MessageConsumer;
import io.vertx.example.util.Runner;

//////////////////////////////////////////////////////////////////////////////////////////////////////
//point to point
class CenertalFinanceVerticle extends AbstractVerticle {

  public void consume() {
    EventBus eventBus = vertx.eventBus();
    //pub-sub
    MessageConsumer<String> messageConsumer = eventBus.consumer("fund.in.covid.request");
    //handle /process the message/news
    messageConsumer.handler(news -> {
      System.out.println("Request -  : " + news.body());
    });
  }
  @Override
  public void start() throws Exception {
    super.start();
    consume();
  }
}


//////////////////////////////////////////////////////////////////////////////////////////////////
//Consumer Verticles
class NewsSevenVerticle extends AbstractVerticle {
  public void consume() {
    EventBus eventBus = vertx.eventBus();
    //pub-sub
    MessageConsumer<String> messageConsumer = eventBus.consumer("news.in.covid");
    //handle /process the message/news
    messageConsumer.handler(news -> {
      System.out.println("News Seven  - Today News : " + news.body());
    });

  }

  @Override
  public void start() throws Exception {
    super.start();
    consume();
  }
}

class BBCVerticle extends AbstractVerticle {
  public void consume() {
    EventBus eventBus = vertx.eventBus();
    //pub-sub
    MessageConsumer<String> messageConsumer = eventBus.consumer("news.in.covid");
    //handle /process the message/news
    messageConsumer.handler(news -> {
      System.out.println("BBC  - Today News : " + news.body());
    });

  }

  @Override
  public void start() throws Exception {
    super.start();
    consume();
  }
}

class NDTVVerticle extends AbstractVerticle {

  public void consume() {
    EventBus eventBus = vertx.eventBus();
    //pub-sub
    MessageConsumer<String> messageConsumer = eventBus.consumer("news.in.covid");
    //handle /process the message/news
    messageConsumer.handler(news -> {
      System.out.println("NDTV  - Today News : " + news.body());
    });

  }

  @Override
  public void start() throws Exception {
    super.start();
    consume();
  }
}

//publisher Verticle
class NewsPublisherVerticle extends AbstractVerticle {

  public void publishNews() {
    //
    System.out.println("News started....");
    vertx.setTimer(5000, ar -> {
      //publish
      String message = "Last 24 Hrs,new 50000 covid patients in India";
      vertx.eventBus().publish("news.in.covid", message);
    });
  }

  @Override
  public void start() throws Exception {
    super.start();
    publishNews();

  }
}

//point to point publisher
class FinanceRequestVerticle extends AbstractVerticle {

  public void requestFinance() {
    //
    System.out.println("Finance Request started....");
    vertx.setTimer(5000, ar -> {
      //point to point : send method
      String message = "Dear Team, We request that we want 1 Billion Money for Covid";
      vertx.eventBus().send("fund.in.covid.request", message);
    });
  }

  @Override
  public void start() throws Exception {
    super.start();
    requestFinance();
  }
}

public class EventBusMainVerticle extends AbstractVerticle {
  public static void main(String[] args) {
    Runner.runExample(EventBusMainVerticle.class);
  }

  private void pubsub() {
    vertx.deployVerticle(new NewsPublisherVerticle());
    vertx.deployVerticle(new NewsSevenVerticle());
    vertx.deployVerticle(new BBCVerticle());
    vertx.deployVerticle(new NDTVVerticle());
  }

  private void pointtopoint() {
    vertx.deployVerticle(new FinanceRequestVerticle());
    vertx.deployVerticle(new CenertalFinanceVerticle());
  }

  @Override
  public void start() throws Exception {
    super.start();
    //pub-sub
    //pubsub();
    //point to point
    pointtopoint();

  }
}
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
request-reply - with ack:
..........................

package ibm.vertx.async.eventbus;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.MessageConsumer;
import io.vertx.example.util.Runner;

//////////////////////////////////////////////////////////////////////////////////

class LabVerticle extends AbstractVerticle {
  public void consume() {
    EventBus eventBus = vertx.eventBus();
    //pub-sub
    MessageConsumer<String> messageConsumer = eventBus.consumer("report.in.covid");
    //handle /process the message/news
    messageConsumer.handler(news -> {
      System.out.println("Request -  : " + news.body());
      //sending reply /ack
      news.reply("Patient is Crictal, Need More attention");
    });
  }

  @Override
  public void start() throws Exception {
    super.start();
    consume();
  }
}

class ReportVerticle extends AbstractVerticle {

  public void sendReport() {
    vertx.setTimer(5000, ar -> {
      String message = "Report of Mr.x";
      vertx.eventBus().request("report.in.covid", message, asyncResult -> {
        if (asyncResult.succeeded()) {
          System.out.println(asyncResult.result().body());
        } else {
          System.out.println(asyncResult.cause());
        }
      });
    });
  }

  @Override
  public void start() throws Exception {
    super.start();
    sendReport();
  }
}


//////////////////////////////////////////////////////////////////////////////////////////////////////
//point to point
class CenertalFinanceVerticle extends AbstractVerticle {

  public void consume() {
    EventBus eventBus = vertx.eventBus();
    //pub-sub
    MessageConsumer<String> messageConsumer = eventBus.consumer("fund.in.covid.request");
    //handle /process the message/news
    messageConsumer.handler(news -> {
      System.out.println("Request -  : " + news.body());
    });
  }

  @Override
  public void start() throws Exception {
    super.start();
    consume();
  }
}


//////////////////////////////////////////////////////////////////////////////////////////////////
//Consumer Verticles
class NewsSevenVerticle extends AbstractVerticle {
  public void consume() {
    EventBus eventBus = vertx.eventBus();
    //pub-sub
    MessageConsumer<String> messageConsumer = eventBus.consumer("news.in.covid");
    //handle /process the message/news
    messageConsumer.handler(news -> {
      System.out.println("News Seven  - Today News : " + news.body());
    });

  }

  @Override
  public void start() throws Exception {
    super.start();
    consume();
  }
}

class BBCVerticle extends AbstractVerticle {
  public void consume() {
    EventBus eventBus = vertx.eventBus();
    //pub-sub
    MessageConsumer<String> messageConsumer = eventBus.consumer("news.in.covid");
    //handle /process the message/news
    messageConsumer.handler(news -> {
      System.out.println("BBC  - Today News : " + news.body());
    });

  }

  @Override
  public void start() throws Exception {
    super.start();
    consume();
  }
}

class NDTVVerticle extends AbstractVerticle {

  public void consume() {
    EventBus eventBus = vertx.eventBus();
    //pub-sub
    MessageConsumer<String> messageConsumer = eventBus.consumer("news.in.covid");
    //handle /process the message/news
    messageConsumer.handler(news -> {
      System.out.println("NDTV  - Today News : " + news.body());
    });

  }

  @Override
  public void start() throws Exception {
    super.start();
    consume();
  }
}

//publisher Verticle
class NewsPublisherVerticle extends AbstractVerticle {

  public void publishNews() {
    //
    System.out.println("News started....");
    vertx.setTimer(5000, ar -> {
      //publish
      String message = "Last 24 Hrs,new 50000 covid patients in India";
      vertx.eventBus().publish("news.in.covid", message);
    });
  }

  @Override
  public void start() throws Exception {
    super.start();
    publishNews();

  }
}

//point to point publisher
class FinanceRequestVerticle extends AbstractVerticle {

  public void requestFinance() {
    //
    System.out.println("Finance Request started....");
    vertx.setTimer(5000, ar -> {
      //point to point : send method
      String message = "Dear Team, We request that we want 1 Billion Money for Covid";
      vertx.eventBus().send("fund.in.covid.request", message);
    });
  }

  @Override
  public void start() throws Exception {
    super.start();
    requestFinance();
  }
}

public class EventBusMainVerticle extends AbstractVerticle {
  public static void main(String[] args) {
    Runner.runExample(EventBusMainVerticle.class);
  }

  private void pubsub() {
    vertx.deployVerticle(new NewsPublisherVerticle());
    vertx.deployVerticle(new NewsSevenVerticle());
    vertx.deployVerticle(new BBCVerticle());
    vertx.deployVerticle(new NDTVVerticle());
  }

  private void pointtopoint() {
    vertx.deployVerticle(new FinanceRequestVerticle());
    vertx.deployVerticle(new CenertalFinanceVerticle());
  }

  private void requetAndReply() {
    vertx.deployVerticle(new LabVerticle());
    vertx.deployVerticle(new ReportVerticle());
  }

  @Override
  public void start() throws Exception {
    super.start();
    //pub-sub
    //pubsub();
    //point to point
    //  pointtopoint();
    //request-reply
    requetAndReply();

  }
}









































