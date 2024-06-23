package me.kepchyk1101.discordify.starter.configuration;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@ToString
@Configuration
@ConfigurationProperties(prefix = "discordify")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JdaAutoConfiguration {

    @NotNull
    @NestedConfigurationProperty
    JdaConfiguration jda;

    @Bean
    public JDA jda() {

        JDABuilder builder = JDABuilder.createDefault(
                        jda.getToken(),
                        jda.getGatewayIntents()
                )
                .setStatus(jda.getOnlineStatus())
                .enableCache(jda.getCacheFlags());

        // Future plan: do mapper for this
        ActivityConfiguration activity = jda.getActivity();
        if (activity != null) {
            builder.setActivity(
                    Activity.of(
                            activity.getType(),
                            activity.getValue(),
                            activity.getUrl()
                    )
            );
        }

        return builder.build();
    }

}
