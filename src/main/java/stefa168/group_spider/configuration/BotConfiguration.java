package stefa168.group_spider.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.telegram.telegrambots.bots.DefaultBotOptions;

import java.util.List;

@Configuration
public class BotConfiguration {
    @Bean
    @Scope("prototype")
    public DefaultBotOptions botOptions() {
        DefaultBotOptions options = new DefaultBotOptions();
        // https://core.telegram.org/bots/api#getupdates
        options.setAllowedUpdates(List.of("message",
                                          "edited_message",
                                          "inline_query",
                                          "chosen_inline_result",
                                          "callback_query",
                                          "poll",
                                          "poll_answer",
                                          "my_chat_member",
                                          "chat_member",
                                          "chat_join_request"));
        return options;
    }
}
