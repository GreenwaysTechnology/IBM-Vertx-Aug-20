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
