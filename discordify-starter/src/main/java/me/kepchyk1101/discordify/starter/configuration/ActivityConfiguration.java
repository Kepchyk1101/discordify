package me.kepchyk1101.discordify.starter.configuration;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import net.dv8tion.jda.api.entities.Activity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public final class ActivityConfiguration {

    /**
     * Type of bot activity in its profile
     */
    @NotNull
    Activity.ActivityType type;

    /**
     * Name for the bot's "activity". No more than 128 characters
     */
    @NotNull
    String value;

    /**
     * (Optional)
     * Streaming link, only needed for {@link net.dv8tion.jda.api.entities.Activity.ActivityType#STREAMING}
     */
    @Nullable
    String url;

}
