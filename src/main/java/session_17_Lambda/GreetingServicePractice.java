package session_17_Lambda;

public class GreetingServicePractice {
    public static void main(String[] args) {
        GreetingService lambdaGreeting = msg -> System.out.println(msg + " from lambda");

        GreetingService anonymGreeting = new GreetingService() {
            @Override
            public void greet(String message) {
                System.out.println(message + " from anonym class");
            }
        };

        lambdaGreeting.greet("Hello");
        anonymGreeting.greet("Hello");
    }
}
