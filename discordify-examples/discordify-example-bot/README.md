The documentation is under construction and will change many times...

*There will be a guide on how to install the dependency, but it’s not available anywhere yet :)*

The library currently only supports running JDA in a Spring container and the JDA event listener system.
In the near future we plan to add custom commands on annotations and much more :)

To start using the library you need:
```java
@SpringBootApplication(scanBasePackages = {
        "com.example.yourapp",
        "me.kepchyk1101.discordify"
})
public class DiscordifyExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscordifyExampleApplication.class, args);
    }

}
```

Specify in the configuration:
```yaml
discordify:
  jda:
    token: YOUR_TOKEN_HERE
```

Now, full config can be like this *(Optional settings)*:
```yaml
discordify:
  jda:
    token: YOUR_TOKEN_HERE
    gateway-intents:
      - guild_presences
    online-status: do_not_disturb
    cache-flags:
      - forum_tags
      - activity
    activity:
      type: streaming
      value: 'Grand Theft Auto VI'
      url: 'https://www.youtube.com/watch?v=dQw4w9WgXcQ'
```
Dont forget to add dependencies:
- [Spring Boot Starter](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter)
- [JDA](https://mvnrepository.com/artifact/net.dv8tion/JDA)

---

## Listener system
Currently there are 2 options to listen to events:
- Via Spring's built-in listener
- Via a wrapped built-in JDA listener

Spring's built-in method:
```java
@Slf4j
@Component
public class SpringStrategyMessageListener {

    @EventListener
    public void onMessageReceived(MessageReceivedEvent event) {
      log.info("Message received: {}", event.getMessage().getContentDisplay());
    }

}
```
---
Wrapped built-in JDA method:
```java
@Slf4j
@Component
public class JdaStrategyMessageListener extends ListenerAdapter {

    @Override
    public void onMessageDelete(@NotNull MessageDeleteEvent event) {
        log.info("Message deleted: {}", event.getMessageId());
    }

}
```