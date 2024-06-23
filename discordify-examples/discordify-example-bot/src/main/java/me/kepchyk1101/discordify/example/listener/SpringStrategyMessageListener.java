package me.kepchyk1101.discordify.example.listener;

import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SpringStrategyMessageListener {

    @EventListener
    public void onMessageReceived(MessageReceivedEvent event) {
      log.info("Message received: {}", event.getMessage().getContentDisplay());
    }

}
