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
//    heartBeat(cb -> {
//      System.out.println(cb.result());
//    });

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
