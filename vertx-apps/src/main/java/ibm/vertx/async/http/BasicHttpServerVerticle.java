package ibm.vertx.async.http;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.example.util.Runner;

public class BasicHttpServerVerticle extends AbstractVerticle {
  public static void main(String[] args) {
    Runner.runExample(BasicHttpServerVerticle.class);
  }

  @Override
  public void start() throws Exception {
    super.start();

    //Create HttpServerConfiguration
    HttpServerOptions options = new HttpServerOptions();
    options.setPort(3000);
    //create HTTP Server
    HttpServer httpServer = vertx.createHttpServer(options);

    //Handle Client Request and Response processing

    httpServer.requestHandler(httpServerRequest -> {
      HttpServerResponse response = httpServerRequest.response();
      //write data into outputstream of http protocal and terminate the connection
      response.end("<h1> Hello Vertx Web Server</h1>");
    });


    //start HTTP Server,port is 3000, host: localhost
//    httpServer.listen(3000, httpServerAsyncResult -> {
//      if (httpServerAsyncResult.succeeded()) {
//        System.out.println("Vertx Web Server is Running...");
//      } else {
//        System.out.println("Vertx Web Server is down");
//      }
//    });
    httpServer.listen(httpServerAsyncResult -> {
      if (httpServerAsyncResult.succeeded()) {
        System.out.println("Vertx Web Server is Running...");
      } else {
        System.out.println("Vertx Web Server is down" );
      }
    });


  }
}
