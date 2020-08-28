package ibm.vertx.async.http;


import io.vertx.core.AbstractVerticle;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.*;
import io.vertx.core.json.JsonObject;
import io.vertx.example.util.Runner;
import io.vertx.ext.web.client.HttpResponse;
import io.vertx.ext.web.client.WebClient;

//provider; who provides service
class ProviderVerticle extends AbstractVerticle {

  private void startApp() {
    //HttpServer options
    HttpServerOptions options = new HttpServerOptions();
    options.setPort(3001);
    //create WebServer , Handle request  and Send Response

    HttpServer server = vertx.createHttpServer(options);

    //Handle Request
    server.requestHandler(context -> {
      //context is container object , having HttpResponse and HttpRequest.
      HttpServerResponse response = context.response();
      response.putHeader("content-type", "application/json");
      JsonObject address = new JsonObject();
      address.put("city", "coimbatore").put("street", "10th street").put("state", "Tamil Nadu");
      JsonObject visitor = new JsonObject();
      visitor.put("name", "subramanian").put("address", address);
      //response.end("<h1>Hello Vertx Application</h1>");
      response.end(visitor.encodePrettily());
    });
    server.listen(serverHandler -> {
      if (serverHandler.succeeded()) {
        System.out.println("Http Server is up and running");
      } else {
        System.out.println(serverHandler.cause().getMessage());
      }
    });

  }

  @Override
  public void start() throws Exception {
    super.start();
    startApp();
  }
}

class ConsumerVerticle extends AbstractVerticle {

  public void fetchVistitor() {
    HttpClientOptions clientOptions = new HttpClientOptions();
    //create Socket
    HttpClient httpClient = vertx.createHttpClient(clientOptions);
    //sending request
    vertx.setTimer(1000, timer -> {
      System.out.println("Getting Resonse");
      httpClient.request(HttpMethod.GET, 3001, "localhost", "/", httpClientResponse -> {
        System.out.println("Status :" + httpClientResponse.statusCode() + httpClientResponse.statusMessage());
        //processing response
        httpClientResponse.bodyHandler(payload -> {
          System.out.println(payload);
        });
      }).end();

    });

  }

  //fetch visitor via WebClient
  public void fetchVisitorViaWebClient() {
    //Create WebClient instance
    WebClient webClient = WebClient.create(vertx);
    //start request
    webClient
      .get(3001, "localhost", "/")
      .send(ar -> {
        if (ar.succeeded()) {
          //Obtain Response
          HttpResponse<Buffer> response = ar.result();
          System.out.println(response.bodyAsJsonObject().encodePrettily());
        } else {
          System.out.println(ar.cause());
        }
      });
  }

  @Override
  public void start() throws Exception {
    super.start();
  //  fetchVistitor();
    System.out.println("Geeting via webClient");
    vertx.setTimer(1500, ar -> {
      fetchVisitorViaWebClient();
    });
  }
}


public class ConsumerProviderCommunication extends AbstractVerticle {
  public static void main(String[] args) {
    Runner.runExample(ConsumerProviderCommunication.class);
  }

  @Override
  public void start() throws Exception {
    super.start();
    vertx.deployVerticle(new ProviderVerticle());
    vertx.deployVerticle(new ConsumerVerticle());
  }
}
