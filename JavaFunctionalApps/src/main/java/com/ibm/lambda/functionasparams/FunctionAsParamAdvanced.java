package com.ibm.lambda.functionasparams;

@FunctionalInterface
interface Resolve {
    void resolve(Object response);
}

interface Reject {
    void reject(Object error);
}

class Login {
    public void validate(Resolve resolver, Reject rejection) {
        String userName = "admin";
        String password = "admin";
        if (userName.equals("admin") && password.equals("admin")) {
            resolver.resolve("Login Success");
        } else {
            rejection.reject("Login failed");
        }

    }

}


public class FunctionAsParamAdvanced {
    public static void main(String[] args) {
        //passing two functions as parameter
        Login login = null;

        login = new Login();

        Resolve resolve = response -> System.out.println(response);
        Reject reject = error -> System.out.println(error);
        login.validate(resolve, reject);
        //
        login.validate(response -> System.out.println(response), error -> System.out.println(error));


    }
}
