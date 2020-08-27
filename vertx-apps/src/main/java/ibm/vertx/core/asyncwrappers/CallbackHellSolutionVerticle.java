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
