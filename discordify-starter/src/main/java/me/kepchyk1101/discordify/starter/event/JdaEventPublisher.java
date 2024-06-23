package me.kepchyk1101.discordify.starter.event;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class JdaEventPublisher extends ListenerAdapter {

    @NotNull ApplicationEventPublisher publisher;

    @Override
    public void onGenericEvent(@NotNull GenericEvent event) {
        publisher.publishEvent(event);
    }

}
