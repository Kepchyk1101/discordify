package me.kepchyk1101.discordify.starter.configuration;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public final class JdaConfiguration {

    /**
     * Bot authentication token. Can be obtained when creating a bot
     */
    @NotNull
    String token;

    @NotNull
    Collection<GatewayIntent> gatewayIntents = new ArrayList<>();

    /**
     * Bot online status
     */
    @NotNull
    OnlineStatus onlineStatus = OnlineStatus.ONLINE;

    /**
     * User caching flags, emojis, etc.
     */
    @NotNull
    Collection<CacheFlag> cacheFlags = new ArrayList<>();

    /**
     * Bot activity settings in its profile
     */
    @Nullable
    @NestedConfigurationProperty
    ActivityConfiguration activity;

}
