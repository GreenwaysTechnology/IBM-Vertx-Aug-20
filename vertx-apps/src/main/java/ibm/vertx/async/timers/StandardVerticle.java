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
