package com.ibm.lambda.functionasparams;

@FunctionalInterface
interface Handler {
    void handle();
}

//args and parameters for function
@FunctionalInterface
interface HttpHandler {
    void write(Object data);
}

//args and return
@FunctionalInterface
interface HttpConnection {
    boolean connect(String connectionString);
}

class SocketHandler {
    public void handleRequest(Handler handler) {
        //handle request
        handler.handle();
    }
}

class HttpServer {
    public void handleRequest(HttpHandler httpHandler) {
        //handle request
        httpHandler.write("Welcome to Http Server");
    }

    public void connect(HttpConnection connection) {
        boolean status = connection.connect("http://www.ibm.com");
        if (status) {
            System.out.println("IBM Domain is Active");
        } else {
            System.out.println("IBM Domain is InActive");
        }
    }
}

//
class SocketHandlerImpl implements Handler {
    @Override
    public void handle() {
        System.out.println("Handling Socket!!!!");
    }
}

public class FunctionAsParameter {
    public static void main(String[] args) {

        SocketHandler socketHandler = null;
        socketHandler = new SocketHandler();
        socketHandler.handleRequest(new SocketHandlerImpl());

        //annomous
        Handler handler = null;
        handler = new Handler() {
            @Override
            public void handle() {
                System.out.println("Handler as Anonmous");
            }
        };
        socketHandler.handleRequest(handler);

        socketHandler.handleRequest(new Handler() {
            @Override
            public void handle() {
                System.out.println("Handler as Anonmous -Inline");
            }
        });
        //function as parameter

        handler = () -> System.out.println("Lambda Handler");
        socketHandler.handleRequest(handler);
        socketHandler.handleRequest(() -> System.out.println("Lambda Handler-inline"));
        //////////////////////////////////////////////////////////////////////////////////////////////

        HttpServer httpServer = null;
        HttpHandler httpHandler = null;

        httpHandler = data -> {
            System.out.println(data + " has been written into http Channel");
        };
        httpServer = new HttpServer();
        httpServer.handleRequest(httpHandler);

        //only parameters
        httpServer.handleRequest(data -> {
            System.out.println(data + " has been written into http Channel");
        });
        httpServer.handleRequest(httpHandler);

        //receive parameters and return vales
        httpServer.connect(connectionString -> {
            System.out.println(connectionString);
            return true;
        });


    }
}
