package stefa168.group_spider.telegram;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import stefa168.group_spider.data.model.TelegramUser;
import stefa168.group_spider.data.repositories.UserRepository;

import java.util.Objects;
import java.util.Optional;

@Component
public class NeeggaButlerBot extends TelegramLongPollingBot {

    private final Logger logger;
    private final String token;
    private final UserRepository userRepository;


    public NeeggaButlerBot(@Value("${botToken}") String token,
                           @Autowired DefaultBotOptions options,
                           @Autowired Logger logger,
                           @Autowired UserRepository userRepository) {
        super(options);

        this.token = token;
        this.logger = logger;
        this.userRepository = userRepository;
    }

    @Override
    public void onUpdateReceived(Update update) {
        logger.info(update.toString());
        Optional<User> optionalSender = Optional.ofNullable(update.getMessage().getFrom());

        if (optionalSender.isEmpty()) {
            return;
        }

        User from = optionalSender.orElseThrow();

        System.out.println(from.getUserName());

        Long messageTimestamp = Long.valueOf(update.getMessage().getDate());
        // https://dzone.com/articles/java-string-formatting
        String name = String.format("%s %s",
                                    from.getFirstName(),
                                    Objects.requireNonNullElse(from.getLastName(), ""));

        TelegramUser telegramUser = userRepository.save(new TelegramUser(from.getId(),
                                                                         messageTimestamp,
                                                                         name,
                                                                         from.getUserName()));
    }

    @Override
    public String getBotUsername() {
        return "NeeggaButlerBot";
    }

    @Override
    public String getBotToken() {
        return token;
    }

}
