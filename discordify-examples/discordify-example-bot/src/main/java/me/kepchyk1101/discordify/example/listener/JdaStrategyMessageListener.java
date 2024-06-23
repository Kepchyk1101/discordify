package me.kepchyk1101.discordify.example.listener;

import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.events.message.MessageDeleteEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JdaStrategyMessageListener extends ListenerAdapter {

    @Override
    public void onMessageDelete(@NotNull MessageDeleteEvent event) {
        log.info("Message deleted: {}", event.getMessageId());
    }

}
