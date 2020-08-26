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
