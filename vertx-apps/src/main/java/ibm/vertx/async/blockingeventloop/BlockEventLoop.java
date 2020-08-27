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
