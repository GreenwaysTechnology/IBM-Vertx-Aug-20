package ibm.vertx.core;

import io.vertx.core.Vertx;

public class CreateVertxInstance {
  public static void main(String[] args) {
    //Create Vertx instance
    Vertx vertx = Vertx.vertx();
    System.out.println(vertx.getClass().getName());

  }
}
