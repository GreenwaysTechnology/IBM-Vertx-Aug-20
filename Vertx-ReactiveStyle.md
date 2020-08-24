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