package stefa168.group_spider.telegram;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class NeeggaButlerBot extends TelegramLongPollingBot {

    final Logger logger;

    private final String token;

    public NeeggaButlerBot(@Value("${botToken}") String token,
                           @Autowired Logger logger) {
        this.token = token;
        this.logger = logger;
    }

    @Override
    public void onUpdateReceived(Update update) {
        logger.info(update.toString());
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
