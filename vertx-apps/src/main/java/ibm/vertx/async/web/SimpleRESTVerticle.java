package ibm.vertx.async.web;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.example.util.Runner;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

public class SimpleRESTVerticle extends AbstractVerticle {
  public static void main(String[] args) {
    Runner.runExample(SimpleRESTVerticle.class);
  }

  //handler methods
  public void homePage(RoutingContext routingContext) {
    //Response
    HttpServerResponse response = routingContext.response();
    response.putHeader("content-type", "text/plain");
    response.end("Welcome to Rest End points");
  }

  public void greetPage(RoutingContext routingContext) {
    //Response
    HttpServerResponse response = routingContext.response();
    response.putHeader("content-type", "text/plain");
    response.end("Greet");
  }

  public void helloPage(RoutingContext routingContext) {
    //Response
    HttpServerResponse response = routingContext.response();
    response.putHeader("content-type", "text/plain");
    response.end("Hello");
  }

  @Override
  public void start() throws Exception {
    super.start();
    HttpServerOptions options = new HttpServerOptions();
    options.setPort(3001);

    HttpServer httpServer = vertx.createHttpServer(options);

    //Routers
    Router router = Router.router(vertx);
    //define route configuration
    //get
    //routingContext : will have request,response
    router.get("/").handler(this::homePage);
    router.get("/api/greet").handler(this::greetPage);
    router.get("/api/hello").handler(this::helloPage);
    //Request Handling
    httpServer.requestHandler(router);

    //httpServer
    httpServer.listen(serverHandler -> {
      if (serverHandler.succeeded()) {
        System.out.println("Http Server is up and running");
      } else {
        System.out.println(serverHandler.cause().getMessage());
      }
    });

  }
}
