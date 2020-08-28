package ibm.vertx.microservice.config;

import io.vertx.config.ConfigRetriever;
import io.vertx.config.ConfigRetrieverOptions;
import io.vertx.config.ConfigStoreOptions;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonObject;
import io.vertx.example.util.Runner;

public class ConfigVerticle extends AbstractVerticle {

  public static void main(String[] args) {
    Runner.runExample(ConfigVerticle.class);
  }

  //config method
  public void getConfig() {
    System.out.println(config().getString("message","default Message"));
  }

  @Override
  public void start() throws Exception {
    super.start();
    System.out.println("Config Examples");

    getConfig();
  }
}
