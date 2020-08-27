package ibm.vertx.async.fs;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.file.FileSystem;
import io.vertx.example.util.Runner;

public class FileSystemVerticle extends AbstractVerticle {
  public static void main(String[] args) {
    Runner.runExample(FileSystemVerticle.class);
  }

  //blocking version of filessytem
  private Future<String> readFileBlockingApi() {
    Promise<String> promise = Promise.promise();
    FileSystem fs = vertx.fileSystem();
    //sync version
    Buffer buffer = fs.readFileBlocking("assets/info.txt");
    promise.complete(buffer.toString());
    return promise.future();
  }

  //nonblocking
  private Future<String> readFile() {
    Promise<String> promise = Promise.promise();
    //read file async
    FileSystem fs = vertx.fileSystem();
    //read
    fs.readFile("assets/info.txt", fileHandler -> {
      if (fileHandler.succeeded())
        promise.complete(fileHandler.result().toString());
      else {
        promise.fail(fileHandler.cause().toString());
      }
    });

    return promise.future();
  }

  @Override
  public void start() throws Exception {
    super.start();
    System.out.println("Start");
    readFileBlockingApi().onSuccess(res -> {
      System.out.println("Blocking version");
      System.out.println(res);
    })
      .onFailure(System.out::println);

    readFile()
      .onSuccess(System.out::println)
      .onFailure(System.out::println);
    System.out.println("end");

  }
}
