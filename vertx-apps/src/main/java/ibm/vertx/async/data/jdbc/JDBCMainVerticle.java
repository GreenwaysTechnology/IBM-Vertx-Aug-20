package ibm.vertx.async.data.jdbc;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.example.util.Runner;
import io.vertx.ext.jdbc.JDBCClient;
import io.vertx.ext.sql.SQLConnection;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

public class JDBCMainVerticle extends AbstractVerticle {
  private static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS products(id INT IDENTITY, name VARCHAR(255), price FLOAT, weight INT)";
  private static String INITAL_TABLE_DATA = "INSERT INTO products (name, price, weight) VALUES ('Egg Whisk', 3.99, 150), ('Tea Cosy', 5.99, 100), ('Spatula', 1.00, 80)";
  private static String GET_ALL_PRODUCTS="SELECT id, name, price, weight FROM products";

  private JDBCClient client;

  public static void main(String[] args) {
    Runner.runExample(JDBCMainVerticle.class);
  }

  private void sendError(int statusCode, HttpServerResponse response) {
    response.setStatusCode(statusCode).end();
  }

  private void handleListProducts(RoutingContext routingContext) {
    HttpServerResponse response = routingContext.response();
    SQLConnection conn = routingContext.get("conn");
    conn.query(GET_ALL_PRODUCTS, query -> {
      if (query.failed()) {
        sendError(500, response);
      } else {
        JsonArray arr = new JsonArray();
        query.result().getRows().forEach(arr::add);
        routingContext.response().putHeader("content-type", "application/json").end(arr.encode());
      }
    });
  }

  private void handleAddProduct(RoutingContext routingContext) {
    HttpServerResponse response = routingContext.response();

    SQLConnection conn = routingContext.get("conn");
    JsonObject product = routingContext.getBodyAsJson();

    conn.updateWithParams("INSERT INTO products (name, price, weight) VALUES (?, ?, ?)",
      new JsonArray().add(product.getString("name")).add(product.getFloat("price")).add(product.getInteger("weight")), query -> {
        if (query.failed()) {
          sendError(500, response);
        } else {
          response.end();
        }
      });
  }

  public void startApplication() {
    JsonObject jdbcConfig = new JsonObject()
      .put("url", "jdbc:hsqldb:mem:test?shutdown=true")
      .put("driver_class", "org.hsqldb.jdbcDriver");
    client = JDBCClient.createShared(vertx, jdbcConfig);
    System.out.println(client);

    //setup inital data.
    setUpInitialData(ready -> {
      Router router = Router.router(vertx);

      router.route().handler(BodyHandler.create());

      // in order to minimize the nesting of call backs we can put the JDBC connection on the context for all routes
      // that match /products
      // this should really be encapsulated in a reusable JDBC handler that uses can just add to their app
      router.route("/products*").handler(routingContext -> client.getConnection(res -> {
        if (res.failed()) {
          routingContext.fail(res.cause());
        } else {
          SQLConnection conn = res.result();

          // save the connection on the context
          routingContext.put("conn", conn);

          // we need to return the connection back to the jdbc pool. In order to do that we need to close it, to keep
          // the remaining code readable one can add a headers end handler to close the connection.
          routingContext.addHeadersEndHandler(done -> conn.close(v -> {
          }));

          routingContext.next();
        }
      })).failureHandler(routingContext -> {
        SQLConnection conn = routingContext.get("conn");
        if (conn != null) {
          conn.close(v -> {
          });
        }
      });

      // router.get("/products/:productID").handler(that::handleGetProduct);
      //router.post("/products").handler(that::handleAddProduct);
      router.get("/products").handler(this::handleListProducts);

      vertx.createHttpServer().requestHandler(router).listen(8080);
    });
  }


  private void setUpInitialData(Handler<Void> done) {
    client.getConnection(res -> {
      if (res.failed()) {
        throw new RuntimeException(res.cause());
      }

      final SQLConnection conn = res.result();

      conn.execute(CREATE_TABLE, ddl -> {
        if (ddl.failed()) {
          throw new RuntimeException(ddl.cause());
        }

        conn.execute(INITAL_TABLE_DATA, fixtures -> {
          if (fixtures.failed()) {
            throw new RuntimeException(fixtures.cause());
          }
          done.handle(null);
        });
      });
    });
  }

  @Override
  public void start() throws Exception {
    super.start();
    startApplication();
  }
}
