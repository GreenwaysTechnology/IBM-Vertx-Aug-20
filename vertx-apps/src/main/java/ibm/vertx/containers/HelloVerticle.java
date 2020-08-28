package ibm.vertx.containers;

import io.vertx.core.AbstractVerticle;

public class HelloVerticle extends AbstractVerticle {

  @Override
  public void start() throws Exception {
    vertx.createHttpServer().requestHandler(request -> {
      request.response().end("Hello Java world");
    }).listen(8080);
  }
}