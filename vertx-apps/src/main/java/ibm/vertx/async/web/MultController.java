package ibm.vertx.async.web;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.example.util.Runner;
import io.vertx.ext.web.Router;

class GreeterController extends AbstractVerticle {

  public Router getGreeterRouterConfig() {
    Router router = Router.router(vertx);
    //rest end point happing
    router.get("/greet").handler(routingContext -> {
      routingContext.response().end("Greet");
    });

    return router;
  }

  @Override
  public void start() throws Exception {
    super.start();
  }
}

class WelcomeController extends AbstractVerticle {

  public Router getWelcomeRouterConfig() {
    Router router = Router.router(vertx);
    //rest end point happing
    router.get("/sayhello").handler(routingContext -> {
      routingContext.response().end("Hello");
    });
    return router;
  }

  @Override
  public void start() throws Exception {
    super.start();
  }
}

class AppController extends AbstractVerticle {
  @Override
  public void start() throws Exception {
    super.start();

    HttpServer server = vertx.createHttpServer();

    Router router = Router.router(vertx);
    router.get("/").handler(routingContext -> {
      routingContext.response().end("Application Controll");
    });
    router.mountSubRouter("/api/greeter", new GreeterController().getGreeterRouterConfig());
    router.mountSubRouter("/api/welcome", new WelcomeController().getWelcomeRouterConfig());

    server.requestHandler(router);

    server.listen(3000, ar -> {
      if (ar.succeeded()) {
        System.out.println("Server is up");
      }
    });

  }
}


public class MultController extends AbstractVerticle {
  public static void main(String[] args) {
    Runner.runExample(MultController.class);
  }

  @Override
  public void start() throws Exception {
    super.start();

    vertx.deployVerticle(new WelcomeController());
    vertx.deployVerticle(new GreeterController());
    vertx.deployVerticle(new AppController());
  }
}
