package main;

import pattern.UserProfile;

public class Main {
    public static void main(String[] args) {
        UserProfile profile = UserProfile.builder("maria")
            .displayName("Maria Perez")
            .locale("es-CL")
            .enableTwoFactor()
            .disableNewsletter()
            .build();

        System.out.println(profile.describe());
    }
}
