package ibm.vertx.datainterchangeformat;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.example.util.Runner;

public class JSONVerticle extends AbstractVerticle {
  public static void main(String[] args) {
    Runner.runExample(JSONVerticle.class);
  }

  public Future<JsonObject> getEmployee() {
    Promise<JsonObject> promise = Promise.promise();

    JsonObject address=new
      JsonObject()
      .put("street","10th street")
      .put("city","Coimbatore")
      .put("state","Tamil Nadu");

    JsonObject employeeJSON = new JsonObject();
    employeeJSON.put("id", 1);
    employeeJSON.put("name", "Subramanian");
    employeeJSON.put("status", true);
    employeeJSON.put("address",address);
    promise.complete(employeeJSON);

    return promise.future();
  }
  public Future<JsonArray> findAllEmployees() {
    Promise<JsonArray> promise = Promise.promise();

    JsonObject address=new
      JsonObject()
      .put("street","10th street")
      .put("city","Coimbatore")
      .put("state","Tamil Nadu");
    JsonObject employeeJSON = new JsonObject();
    employeeJSON.put("id", 1);
    employeeJSON.put("name", "Subramanian");
    employeeJSON.put("status", true);
    employeeJSON.put("address",address);

    JsonArray list = new JsonArray();
    list.add(employeeJSON);
    list.add(employeeJSON);
    list.add(employeeJSON);


    promise.complete(list);

    return promise.future();
  }

  @Override
  public void start() throws Exception {
    super.start();
    getEmployee().onSuccess(e->{
      System.out.println(e.encodePrettily());
    });
    findAllEmployees().onSuccess(list->{
      System.out.println(list.encodePrettily());
    });

  }
}
