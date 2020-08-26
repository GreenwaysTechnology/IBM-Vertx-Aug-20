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
