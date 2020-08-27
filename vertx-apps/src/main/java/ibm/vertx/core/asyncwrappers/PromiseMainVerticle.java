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
