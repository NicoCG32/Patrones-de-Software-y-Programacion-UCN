package main;

import static pattern.PatternImplementation.*;
public class Main {
    public static void main(String[] args) {
        HttpClientConfig config = HttpClientConfig.builder("https://api.example.com")
            .timeoutSeconds(10)
            .retries(3)
            .bearerToken("secret")
            .build();

        System.out.println(config.describe());
    }
}
