package ibm.vertx.core.asyncwrappers;
//Callback nesting

import io.vertx.core.*;
import io.vertx.example.util.Runner;

//function as parameter syntax
class UserVerticle extends AbstractVerticle {

  public void getUser(Handler<AsyncResult<String>> aHandler) {
    String fakeUser = "Subramanian";
    if (fakeUser != null) {
      //wrap result into future
      aHandler.handle(Future.succeededFuture(fakeUser));
    } else {
      aHandler.handle(Future.failedFuture("UserNot Found"));
    }
  }

  public void login(String fakeUser, Handler<AsyncResult<String>> aHandler) {
    if (fakeUser.equals("Subramanian")) {
      //wrap result into future
      aHandler.handle(Future.succeededFuture("Login Success"));
    } else {
      aHandler.handle(Future.failedFuture("Login failed"));
    }
  }

  public void showPage(String loginStatus, Handler<AsyncResult<String>> aHandler) {
    if (loginStatus.equals("Login Success")) {
      //wrap result into future
      aHandler.handle(Future.succeededFuture("You are Premium User"));
    } else {
      aHandler.handle(Future.failedFuture("YOu are guest"));
    }
  }


  @Override
  public void start() throws Exception {
    super.start();
    getUser(fakeUserRes -> {
      if (fakeUserRes.succeeded()) {
        System.out.println("Get User is called");
        //login
        login(fakeUserRes.result(), loginRes -> {
          if (loginRes.succeeded()) {
            System.out.println("Login  is called");
            showPage(loginRes.result(), pageRes -> {
              System.out.println("Show Page  is called");
              if (pageRes.succeeded()) {
                System.out.println(pageRes.result());
              } else {
                System.out.println(pageRes.cause());
              }
            });
            System.out.println(loginRes.cause());
          }
        });
      } else {
        System.out.println(fakeUserRes.cause());
      }
    });
  }
}


class CallbackNestingVerticle extends AbstractVerticle {
  //callback nesting ; outuput of one callback will be input to another callback

  public Future<String> getUser() {
    Promise promise = Promise.promise();
    //biz logic
    String fakeUser = "Subramanian";
    if (fakeUser != null) {
      promise.complete(fakeUser);
    } else {
      promise.fail("User Not found!");
    }
    return promise.future();
  }

  public Future<String> login(String fakeUser) {
    Promise promise = Promise.promise();
    //biz logic based on result of previous(getUser) function
    if (fakeUser.equals("Subramanian")) {
      promise.complete("Login Success");
    } else {
      promise.fail("Login failed!");
    }

    return promise.future();
  }

  @Override
  public void start() throws Exception {
    super.start();
    //call get User
    getUser().onComplete(asyncResult -> {
      if (asyncResult.succeeded()) {
        System.out.println("Get User is called");
        //call nesting ;
        login(asyncResult.result()).onComplete(loginarresult -> {
          if (loginarresult.succeeded()) {
            System.out.println(loginarresult.result());
          } else {
            System.out.println(loginarresult.cause());
          }
        });

      } else {
        System.out.println(asyncResult.cause());
      }
    });
  }
}


public class MainCallbackNestingVerticle extends AbstractVerticle {
  public static void main(String[] args) {
    Runner.runExample(MainCallbackNestingVerticle.class);
  }

  @Override
  public void start() throws Exception {
    super.start();
    //vertx.deployVerticle(new CallbackNestingVerticle());
    vertx.deployVerticle(new UserVerticle());
  }
}
