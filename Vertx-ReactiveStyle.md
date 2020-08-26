                           Reactive Programming

 Vertx = Functional style + Reactive + Async /Non Blocking

What is Reactive Programming ?

Programming Paradigm(way).

Java 8 , is functional style, object oriented pl.

There is no such separate pl which adopts reactive programming alone, rather which is eXtended by other languages : 
ReactiveX ->through frameworks and libs  -reactiveX for java -Rxjava,for javascript - Rxjs.

What is Reactive?

  Oxford dictionary defines reactive  as "showing a response to a stimulus"

Response :  The result
Stimuls : trigger/actions ---Events

 Get Response because of some events --- event driven programming model.

Event driven programming is extension of  oo.

Event driven programming is extension of  oo design pattern : Observable Design pattern.

Reactive programming is collection of many design patterns and principles.

 -Observable Design pattern
 -Iterator Design pattern
 -Functional style pattern



 -Observable Design pattern
				
				Publisher/Owner/Producer
					|
	      -----------------------------------------------------------------			
	     |                   |          |           |
          Listeners            Subscriber  Subscriber Subscriber
			


How objects communicate

      
  By passing messages via method calls with intermediate object (Event).


Publisher sends/publishes data with events via broker called notfication interface to subcribers

            Publisher/Owner/Producer
					|
			data + event(Event)
					|
		  Event Notification Interface
					|
	      -----------------------------------------------------------------			
	     |                   |          |           |
          Listeners            Subscriber  Subscriber Subscriber

Subscribers are objects who are listening for events, once event is given, who process event and consume take.

&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Legacy Observable Design pattern has some drawback:

Legacy observer design pattern has only 1 thing

  1.they will be able to send only data

Have not addresssed the following
  1.what if error is produced
  2.what if the producer has stopped producing values. 

Reactive programming address the above issues.



Producer can send data,error, complete - events/signals

				Publisher/Owner/Producer <---------Data Source(Device)
					|
				 data / error  & complete
					|
			       Event Notification Interface
					|
			------------------------------------- channels
			|               |                  |
         data              error              complete

			|		|		 |
			------------------------------------
					  |
				      Subscriber

In legacy design pattern, Producer can use only one Channel to send data.

Iterator Design Pattern:

Iterator design pattern talks about how to fetch value/ pull value from the Producer.

In General iterator design pattern  and implementation  is "pull based".

-In Pull Systems,The Consumer determines when it receives data from the producer.
 The Producer itself is unaware of what the data will be delivered to the consumer.

 Use case:
 - list of employees having id,name,salary

 - I want all employee names in upper case,where employee salary is less than 50000.
   code
        List-Data Source
		          |
				  must be loaded into memory
				  |
          for(condition){
			  if(condition){
				  get all filtered data
			  }
			  transform filtered data : uppercase
		  }


Major Drawbacks of Pull based model:
...................................

1. the whole data must have been loaded into memory
2. More imperative rather than declarative

Program types:
- Imperative Program
    focus what it is , and how it is.
           List-Data Source
		          |
				  must be loaded into memory
				  |
          for(condition){
			  if(condition){
				  get all filtered data
			  }
			  transform filtered data : uppercase
		  }
-different algorithms
-scalability when req is increased
-code maintenance

- Declarative Program

-Focus only what it is not how it is
-More readable
-More maintainable
-Stable code across the application/developers.

DSL -Domain specific lanaguages are the most popular examples of declarative programming.

Java supports imperative and declarative.

Our focus is more on declarative rather than imperative.

Any code can be written declarative.

Java declarative Programming:
............................

Java supports declarative programming through "functional Abstraction".

java supports collection processing declaratively via "Streams"

Streams:
  Functional abstraction , more declarative , data Processing.

  Eg:
  List.stream().map().filter(condition).collect()

Reactive Programs are much more "declarative".
..................................................................................

Push Based Programming:
.........................

-Opposit to Pull
-Where consumer never pull the data.
-Producer starts sending data over channel with help of events.
-Consumer only listens for data.



	          Publisher/Owner/Producer <---------Data Source(Device)
					|
				  push data into memory over time.
					|
				  -----------------------------
                                      1---2---3--4--error--5--|-->
				  ------------------------------
                        		|    
				     emit event data,data -complete           	
			
				 data / error  & complete
					|
			       Event Notification Interface
					|
			------------------------------------- channels
			|               |                  |
                     data              error              complete

			|		|		   |
			------------------------------------
					  |
				      Subscriber

&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Pull + Push ==>Reactive Pull
**********************************************************************************

Functional style pattern:

-High Order function
 -Functions can be passed as parameters 
 -Functions can be returned as a result
 -Separation of responsibilities (separation of Concerns)
 -Patterns: Execute-Around, Deferred Execution, Decorator, Strategy, Template      Method

 newFunction =  func1 + func2

-Pure function

  function which takes parameter, returns the same as it is
  function which wants to return new data , dont modify the data , rather 
  creates new of copy of the data , return that
 
 -Immutablity
    Dont override the same memory location,rather creates copy of that memory and
	return that.

Reactive Programming takes the best practices of observable ,iterator,functional style  in one place.
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Standards of Reactive Programming:
.................................

->The Reactive Manifesto:https://www.reactivemanifesto.org/
   It is standard, published to build and ensure that system is fully reactive.

Principles of Best Reactive System:

1.Responsive:
   Reactive Systems should be responsive : Quick/Timely result.

2.Resilient:
   Any System is subject to fail, You must have failure work around.
   failures and how to fallback, provides high availability

3.Elastic : scalability
   In case of load, how to scale application by increasing and decreasing resources(Softwares)

4.Message Driven
   The Programs sends and receives data via events- event driven.

&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Reactive Streams:

Reactive Streams is an initiative to provide a standard for asynchronous stream processing with non-blocking back pressure.

&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Reactive landscap:

-Reactive Programming
   Writing data processing application inside any language based on 
   -observable , iterator, functional style.

-Reactive System
   The overall application which is written based on reactive standards
   those system is called Reactive System.

-Reactive Streams
    - it is also spec based on data processing
-Reactive Microservice
   -Micro Service architecture is developed based on Reactive systems, programming principles those are called reactive microservice.

History of Reactive Programming:

It is microsoft Language-Integrated Query (LINQ) is the name for a set of technologies based on the integration of query capabilities directly into the C# language.

        // Specify the data source.
int[] scores = new int[] { 97, 92, 81, 60 };

        // Define the query expression.
        IEnumerable<int> scoreQuery =
            from score in scores
            where score > 80
            select score;

Netflix inspired the LINQ, who wanted put the same syntax into java language.
For that who created  and crafted specfication that is called "Reactive"

Netflix Spec:
-declarative ,functional style,observable,iterator based programming to process
data inside java language.
The birth of Reactive Programming.

Netflix started building a lib called "Reactive java", then open sourced, after
that it became very popular, other languages also started implementing reactive

features,

"ReactiveX-(Extension) - ReactiveX-Language ===>ReactiveXjava===>Rxjava.

Rxjs,Rxscala,Rxpyhton............

Reactive programs are using sql like operators(or,and,==,>) , We call Reactive operators- Methods in java.

*&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Java and Reactive Programming:

1.Rxjava 1.x
2.Rxjava 2 and 3
3.Project Reactor -- alternate to Rxjava

&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Stream:
  Logical Representation of movement of data

Rxjava Objects: Objects mostly exposed with Interfaces and classes

-io.reactivex.Observable<T>
-io.reactivex
 Interface ObservableSource<T>
-io.reactivex
Interface Observer<T>
-Subject
-Single
-Maybe
-Schedulers
etc.....

-io.reactivex.Observable<T>

public abstract class Observable<T> implements ObservableSource<T>{

}

Lets Code:

Stepts:

1.You need data source
  What could be data source ?
    Data source can be any type of data representaiton in java
 -Primitive variables
 -Objects
 -Arrays
 -Collections
 -Another processed Data source

2.Create Observable(Pipeline/stream) and starts pushing data via Event Notification interface
  data - data,error,complete

3.Processing data

4.Consume processed data.

Note:

Observable Object can be created only through factory apis

factory api may differ based on datasource.

Operator: it is method in reactive programming.

Operators are methods can be used to create,process stream.

Marable diagram :
 It is flow diagram used to understand about reactive work flows.

 ---------10----20-----30---Error-----10---------------------|-->

Horizontal line says time(over period of time) line and also stream
10,20 represents items
Error represents error
| represents -Complete


Note:

When Stream Processing, When stream is closed? 
   -Once stream is closed, no more data is emitted.

->At end of data emission, when ever complete single is emitted.
->if any error is emitted, then stream will be closed.


Rxjava 3:
........

Use Case:
I want to create a new Observable,from scratch, with custom logic


package com.ibm.reactive;

import io.reactivex.rxjava3.core.Observable;

public class StreamScratch {
    public static void main(String[] args) {
        Observable<Integer> stream = Observable.create(observer -> {
            boolean shouldFail = true;
            //send data via Observer: EventNotification Interface; emit data and send data
            observer.onNext(10); // emit data
            observer.onNext(20);
            if (shouldFail)
                throw new RuntimeException("Something Went Wrong!!");
            observer.onNext(30);
            observer.onComplete();
        });

        //Suscriber - will listen for data,error,complete
//        stream.subscribe(data -> System.out.println(data), err -> System.out.println(err), () -> {
//            System.out.println("Stream was completed");
//        });
        stream.subscribe(System.out::println, System.out::println, () -> {
            System.out.println("Stream was completed");
        });
    }
}


Login:
package com.ibm.reactive;

import io.reactivex.rxjava3.core.Observable;

public class StreamWIthLogin {
    public static void main(String[] args) {
        Observable<String> stream = Observable.create(observer -> {
            String userName = "admin";
            String password = "admin";
            if (userName.equals("admin") && password.equals("admin")) {
                observer.onNext("LoginSuccess");
            } else {
                observer.onError(new RuntimeException("Login Failed"));
            }
            observer.onComplete();
        });
        stream.subscribe(System.out::println, System.out::println, () -> {
            System.out.println("Stream was completed");
        });
    }
}
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
Data Sources and other operators:

Data Source can be primitve,list,arrays,Future,Callable....


package com.ibm.reactive;
package com.ibm.reactive;

import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;
import java.util.List;

public class DataSource {
    public static void justOperator() {
        Observable<Integer> stream = Observable.just(1, 2, 3, 4, 5, 6, 6, 7, 8);
        stream.subscribe(System.out::println, System.out::println, () -> {
            System.out.println("Stream was completed");
        });
    }

    public static void arrayOperator() {
        int[] list = {1, 2, 3, 4, 5, 6, 7};
        Observable<int[]> stream = Observable.fromArray(list);
        stream.subscribe(e -> {
            for (int i = 0; i < e.length; i++) {
                System.out.println(e[i]);
            }
        }, System.out::println, () -> {
            System.out.println("Stream was completed");
        });
    }

    //collection
    public static void collectionOperator() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 6, 7, 8);
        Observable<Integer> stream = Observable.fromIterable(list);
        stream.subscribe(System.out::println, System.out::println, () -> {
            System.out.println("Stream was completed");
        });
    }

    public static void main(String[] args) {
        //justOperator();
        // arrayOperator();
        collectionOperator();
    }

}
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Data Processing : Stream Processing:
....................................

Types of Streams:
-Source Stream

->Up Stream
->Down Stream

if you want to understand this concept, Assembly Line Analogy:

Reactive Programs are thought as conveyor belt and work stations. The raw material pours form a source and ends up as fininished product ready to be pushed to the consumer.

work stations are implemented by Reactive Operators(methods), are connected via Stream Objects(Observable)

operator1().operator2().operator3().operatorN().subscribe()

Operators are pure functions
  -never ever modifies original data
operators provides immutable data structure.

&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
Operators:

map:
package com.ibm.reactive;

import io.reactivex.rxjava3.core.Observable;

public class StreamProcessing {
    public static void mapOperator() {
        Observable<Integer> stream = Observable
                .range(1, 25) //source stream ---UpStream
                .map(item -> { //down stream -- up stream : WorkStation
                    System.out.println("Emitted : " + item);
                    return item * 2;
                })
                .map(item -> { //down stream --- up stream // WorkStation
                    System.out.println("Emitted : " + item);
                    return item * 2;
                });
        stream.subscribe(System.out::println);

    }

    public static void main(String[] args) {
        mapOperator();

    }
}
///////////////////////////////////////////////////////////////////////////////

Lab:

Create list of Employee Objects- id,name,salary.

create stream,has to transform all employee name with upper case and print it.

List<Employee>


filter;
 public static void filterOperator() {
        //works based on predicate, If condition is true only , it will push items to downstream
        Observable<Integer> stream = Observable
                .range(1, 25) //source stream ---UpStream
                .filter(item -> item % 2 == 0) // downstream --- upStream
                .map(item -> { //down stream --- up stream // WorkStation
                    System.out.println("Emitted : " + item);
                    return item;
                });
        stream.subscribe(System.out::println);
    }
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
flatMap vs Map:
map returns a item, where as flatMap returns another Observable.

flat - Making nested things into one.

[
	[
		[
			[

			]
		]
	]
]
 for(){
	 for(){
		 for(){

		 }
	 }
 }


package com.ibm.reactive;

import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;
import java.util.List;

public class StreamProcessing {
    public static void mapOperator() {
        Observable<Integer> stream = Observable
                .range(1, 25) //source stream ---UpStream
                .map(item -> { //down stream -- up stream : WorkStation
                    System.out.println("Emitted : " + item);
                    return item * 2;
                })
                .map(item -> { //down stream --- up stream // WorkStation
                    System.out.println("Emitted : " + item);
                    return item * 2;
                });
        stream.subscribe(System.out::println);

    }

    public static void filterOperator() {
        //works based on predicate, If condition is true only , it will push items to downstream
        Observable<Integer> stream = Observable
                .range(1, 25) //source stream ---UpStream
                .filter(item -> item % 2 == 0) // downstream --- upStream
                .map(item -> { //down stream --- up stream // WorkStation
                    System.out.println("Emitted : " + item);
                    return item;
                });
        stream.subscribe(System.out::println);
    }


    public static void zipOperator() {
        Observable<Integer> intStream = Observable.just(1, 2, 3, 4);
        Observable<String> stringStream = Observable.just("a", "b", "c", "d", "e");

        Observable.zip(intStream, stringStream, (i, j) -> {
            String result = i + j;
            return result;
        }).subscribe(System.out::println);

    }

    public static void main(String[] args) {
        //mapOperator();
        //filterOperator();
        // flatMap();
        //
        // zipOperator();
        coimbineMany();

    }

    public static void coimbineMany() {
        List<String> words = Arrays.asList("the", "quick", "quick", "brown", "fox", "apple", "fox", "jumped", "over", "the", "lazy", "dog");
        Observable<String> manyLetters = Observable
                .fromIterable(words)
                .flatMap(word -> {
                    return Observable.just(word);
                })
                .distinct()
                .sorted();
        manyLetters.subscribe(System.out::println);

    }

    public static void flatMap() {
        List<String> items = Arrays.asList("a", "b", "c", "d", "e", "f");

        Observable.fromIterable(items)
                .flatMap(s -> {
                    System.out.println(s);
                    return Observable.just(s + " new Item");
                }).subscribe(System.out::println);

    }
}

&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
Observable Events api:
......................
-We have seen how to handle data,errors,complete inside subscribe.

doXXX
package com.ibm.reactive;


import io.reactivex.rxjava3.core.Observable;

public class StreamEventapi {
    public static void main(String[] args) {
        Observable<Integer> stream = Observable
                .range(1, 10)
                .doOnSubscribe(subscription -> {
                    System.out.println("Do On Subscription");
                })
                .doOnNext(i -> {
                    System.out.println("Do on Next " + i);
                })
                .doOnError(err -> {
                    System.out.println("Do on Error" + err);
                })
                .doOnComplete(() -> {
                    System.out.println("Do on Complete");
                })
                .doFinally(() -> {
                    System.out.println("Do on finally");
                });
        stream.subscribe();
    }
}

Multi threading ; concurrency; and Reactive Programming:
........................................................

We create stream,process the stream,subscribe , where (which thread we are doing)

package com.ibm.reactive.threading;

import io.reactivex.rxjava3.core.Observable;

public class DefaultThread {
    public static void main(String[] args) {
        Observable.just(10, 20).map(item -> {
            System.out.println(Thread.currentThread().getName());
            return item;
        }).subscribe();

    }
}
output:
main
main

Using Thread
package com.ibm.reactive.threading;

import io.reactivex.rxjava3.core.Observable;

public class ThreadClassAndReactive {
    public static void main(String[] args) throws InterruptedException {
        Observable<String> mono = Observable.just("Hello World");
        //Create a custom Thread
        Thread thread = new Thread(() -> {
            mono.map(msg -> msg + " thread  ")
                    .subscribe(res -> System.out.println(res + Thread.currentThread().getName()));
        });
        thread.start();
        thread.join();

    }
}

Schedulers:
...........

A scheduler is low level thread abstraction similar to "ExecutorSerivice" in java.
Scheduler has wide range of features
- virutal time for testing
- trampoling for immediate scheduling
so on...


The Schedulers class has static methods that give access to the following execution contexts:

The current thread (Schedulers.immediate()).

A single, reusable thread (Schedulers.single()).
 Note that this method reuses the same thread for all callers, until the Scheduler is disposed. If you want a per-call dedicated thread, use Schedulers.newSingle() for each call.


An elastic thread pool (Schedulers.elastic()). 

It creates new worker pools as needed, and reuse idle ones.
 Worker pools that stay idle for too long (default is 60s) are disposed. This is a good choice for I/O blocking work for instance. Schedulers.elastic() is a handy way to give a blocking process its own thread, so that it does not tie up other resources.

a fixed pool of workers that is tuned for parallel work (Schedulers.parallel()). It creates as many workers as you have CPU cores

How to run operators in a separate thread of execution?

observeOn(s):
 where you have attached this operator in the middle of subscriber chain, it takes signals from the upstream and replays them downstream while executing the task from the associated scheduler.


 source()---map()---filter-|-map---filter---map |
                         observeon(sheduler)

subscribeOn
 applies to the subscription process,
 no mater where you place the subscribeOn in the chain.
 It always affects context of the source emission.

 source()---map()---filter-|-map---filter---map |
                         subscribeOn(sheduler)



package com.ibm.reactive.threading;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ReactiveSchedulers {

    public static void main(String[] args) {
        //Scheduler scheduler = Schedulers.newThread();
        Observable stream = Observable.just("Hello Scheduler")
                .map(message -> {
                    System.out.println("First Map : " + Thread.currentThread().getName());
                    return message;
                }).observeOn(Schedulers.computation()) //will apply to all down stream
                .map(newMessage -> {
                    System.out.println(" Second Map : " + Thread.currentThread().getName());
                    return newMessage;
                })
                .observeOn(Schedulers.single())
                .map(newMessage -> {
                    System.out.println("Third Map : " + Thread.currentThread().getName());
                    return newMessage;
                })
                .doOnNext(r -> System.out.println(r));
        //stream.subscribe();
        stream.blockingLast();// which stops the main thread until all data processing is over.

        //Thread.sleep(5000); //blocked main thread for 5scs
    }
}

**********************************************************************************
BroadCasting:
............
Producer(Stream)-----can be connected with ---one Subscriber : 
one to one  This communication style is called "unicast".

Producer(Stream)----can be connected with ----->many subscribers : 
one to Many  This communication style is called "Multicast".

Based on this communication style stream can be classified into two category.

1.Cold Observable(Cold Stream)
2.Hot Observable(Hot Stream)


1.Cold Observable

1.Observable that doesn’t emit items until a subscriber subscribes.

2.If we have more than one subscriber, then observable will 
emit sequence of items to all subscribers one by one.

3.Each subscriber get fresh copy of the data from the begining.

4.Most of Observerables are Cold.

  public static void coldObservableTest() throws InterruptedException {
        //interval operator emits sequenece of numbers based on timer
        Observable<Long> myObservable = Observable.interval(1, TimeUnit.SECONDS);
        myObservable.subscribe(item -> System.out.println("Observer 1: " + item));
        //after 3scs new subscriber joins
        Thread.sleep(3000);
        Disposable subscriber2 = myObservable
                .doOnSubscribe((r)-> System.out.println("Joining"))
                .doFinally(()-> System.out.println("Observer 2 left"))
                .subscribe(item -> System.out.println("Observer 2: " + item));
        //unscribe after 5000 ms
        Thread.sleep(5000);
        subscriber2.dispose();
        //block main thread for subscrber2
        Thread.sleep(8000);
    }
    Every subscribe method returns "Disposable" Interface, which has dispose method
    This method used to unsubscribe from the producer.

&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Hot Observable:

1.Observables that don’t wait for any subscription. They start emitting items   when created.
2.They don’t emit the sequence of items again for a new subscriber.

3.When an item is emitted by hot observable, all the subscribers that are   subscribed will get the emitted item at once.

There are many ways to implement hot observables:

1.ConnectableObservable
2.Subjects

1.ConnectableObservable:
  A ConnectableObservable is a single observable source for different observers.

A ConnectableObservable is a single observable source for different observers. The main difference aside from being a single observable source is that calling subscribe on a ConnectableObserver will not trigger emission, but connect will.

    public static void multicastTest() throws InterruptedException {
        //cold
        Observable<Long> myObservable = Observable.interval(1, TimeUnit.SECONDS);
        //convert cold into hot
        ConnectableObservable<Long> connectableObservable = myObservable.publish();

        connectableObservable.connect();

        connectableObservable
                .doOnSubscribe((r) -> System.out.println("Observer 1 Joining"))
                .subscribe(item -> System.out.println("Observer 1: " + item));
        Thread.sleep(3000);

        connectableObservable
                .doOnSubscribe((r) -> System.out.println("Observer 2 Joining"))
                .subscribe(item -> System.out.println("Observer 2: " + item));

        Thread.sleep(3500);
        connectableObservable
                .doOnSubscribe((r) -> System.out.println("Observer 3 Joining"))
                .subscribe(item -> System.out.println("Observer 3: " + item));

        Thread.sleep(8000);

    }
..................................................................................
Streo types :
 Bean
   -Component,Service,Repository,Controller

Rx java Streo Types:
...................
Observable - o---n 
Single - only item
Maybe - single or empty
Completeable - only complet


Single:
......
RxJava (and its derivatives like RxGroovy & RxScala) has developed an Observable variant called “Single.”

A Single is something like an Observable, but instead of emitting a series of values — anywhere from none at all to an infinite number — it always either emits one value or an error notification.

1.Single is an observable that emits only a single item.


Maybe:

Maybe is similar to Single . but special Singles

only item: Maybe.just
only completed single: Maybe.empty
only error : Maybe.error


Completable:

Objective:

only error
only complete
not data

package com.ibm.reactive;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

public class AdvancedTypes {
    //single
    public static void singleTest() {
        Single.create(observer->{
            observer.onSuccess("one");
            observer.onSuccess("two");
            observer.onSuccess("three");
            observer.onSuccess("four");
            observer.onSuccess("five");
        }).subscribe(System.out::println);

        Single<String> single = Single.just("hello");
        single.subscribe(System.out::println);
    }

    public static void maybeTest() {
      //single item only
        Maybe.just("hello")
                .subscribe(System.out::println, System.out::println, () -> System.out.println("onComplete"));
       //single but only error
        Maybe.error(new RuntimeException("something went wrong"))
                .subscribe(System.out::println, System.out::println, () -> System.out.println("onComplete"));

        //single but complete
        Maybe.empty()
                .subscribe(System.out::println, System.out::println, () -> System.out.println("onComplete"));

    }
    public static void completeTest() {
        Completable.complete().subscribe(() -> System.out.println("Completeable"));

    }
    public static void main(String[] args) {
        //singleTest();
        maybeTest();
//        completeTest();

    }
}
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
Back Pressure:

Upstream is faster enough to stream data to downstream , where downstream is unable to process data.
   -Back Pressure.

When back pressure happens , 
  -data loss
  -data inconsisistency

How to manage backpressure?
we have various patterns

Rxjava 1.x 
 -Through backpressure operators
Buffer
Sample
Debounce
Window
backpressure operators
strategies for coping with Observables that produce items more rapidly than their observers consume them


1.Via Operators:

Most of the Flitering Operaors are back pressure managed operators

 debounce,distinct,ElementAt,filter,first,ignoreElements,Last,sample,skip,skipLast,take,takeLast.

During backpressure, items may be droped
 drop operators: fliter
 collecting operators: window,buffer

Reactive Pull
..............
Above two strategies manage backpressure by dropping items, if your application need to process all the items emitted by source observable then you can’t use those strategies.

In this scenario, using reactive pull strategy is the right choice. In reactive pull, subscriber requests required number of items from observable by calling request().


Reactive Pull:

 Reactive programs supports push paradigm
 Reactive programs supports even pull also


PUSH + PULL = Reactive PULL

Down Stream can control up stream with help of mediator object that is called
"Subscription object"

DownStream --------Subscription ---------UpStream

DownStream --------Subscription ---------UpStream
                        |
                 request(no-elements)
Reactive Streams:
.................
   Reactive Stream is spec published to enable backpressure and create Back Pressure streams.-https://www.reactive-streams.org/

How provide backPressure handling feature at api level or Publisher level?

Soultion : Publisher level, in order to provide publisher , Many companies joined together

who published another spec "Reactive Stream"

Reactive Streams is an initiative to provide a standard for asynchronous stream processing with non-blocking back pressure. This encompasses efforts aimed at runtime environments (JVM and JavaScript) as well as network protocols.


The Team provided common spec:

1.Publisher
2.Subscriber
3.Subscription
4.Processor

After this spec published, Rxjava team relased new version - Rxjava 2 which implements reactive stream specification..

Rxjava 1 - has no implementation of "Reactive Stream Spec"

Rxjava 2 - Reactive Stream Spec implemented.

Rxjava 2 Provided one Simple Observable.

Flowable ====== Observable

io.reactivex.rxjava3.core.Flowable:
 0..N flows, supporting Reactive-Streams and backpressure


 package com.ibm.reactive;


import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

public class BackPressures {
    public static void sampleOpertor() {
        Observable<Integer> observable = Observable
                .range(1, 50000)
                .sample(1, TimeUnit.NANOSECONDS)
                .map(i -> i); //down stream dont get values from 1 rather
        observable.subscribe(s -> {
            System.out.println("value after every 1 nano secs " + s);
        });
    }

    public static void buffer() {
        Flowable.range(1, 2000)
                .buffer(5)
                .map(i -> i) //down stream dont get values from 1 rather than get buffer of 5
                .subscribe((i) -> System.out.println("Item Got :" + i), System.out::println);
    }

    public static void lastN() {
        Flowable.range(1, 2000)
                .takeLast(50)
                .map(i -> i) //down stream dont get values from 1 rather than get buffer of 5
                .subscribe((i) -> System.out.println("Item Got :" + i), System.out::println);
    }

    public static void simpleFlowable() throws InterruptedException {
        Flowable flowable = Flowable.range(1, 100);

        flowable.subscribe(new Subscriber() {
            Subscription subscription=null;
            @Override
            public void onSubscribe(Subscription s) {
                this.subscription = s;
                s.request(5);
            }

            @Override
            public void onNext(Object o) {
                subscription.request(5);
                System.out.println(o);
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t);
            }

            @Override
            public void onComplete() {
                System.out.println("complete");
            }
        });

    }

    public static void main(String[] args) throws InterruptedException {
        simpleFlowable();
        //  sampleOpertor();
        //buffer();
        //lastN();
    }
}


********************************************************************************

Project Reactor :

  It is reactive framework built on top of
     -Rxjava
     -Reactive Streams
     -NonBlocking
Two Major Types
 ->Flux - o..N items ---powered with nonblocking and backpressure
     -similar to Observable,Flowable
 ->Mono --0..1 item - powered with nonblocking and backpressure
    -similar to Single,MayBe,Completeable....

Project Reactor has been added as part of Spring 5.

Spring 5 web framework -- Spring Webflux---Powered with Reactive Programming on Reactor.
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&