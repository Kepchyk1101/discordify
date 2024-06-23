package me.kepchyk1101.discordify.example.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "me.kepchyk1101.discordify.example",
        "me.kepchyk1101.discordify"
})
public class DiscordifyExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscordifyExampleApplication.class, args);
    }

}
