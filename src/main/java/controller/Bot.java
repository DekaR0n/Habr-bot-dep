package controller;

import com.vdurmont.emoji.EmojiParser;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;

import java.util.Locale;

public class Bot {
    private final TelegramBot bot = new TelegramBot("5512234968:AAEyOkzdywNhUa2A6fMz0LVKhn7JTU0spGw");

    public void serve() {
        bot.setUpdatesListener(updates -> {
            updates.forEach(this::process);
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }

    private void process(Update update) {
        Message message = update.message();
        CallbackQuery callback = new CallbackQuery();
        BaseRequest request = null;

        if (message != null) {
            long chatId = message.chat().id();
            String greeting = "hello";
            request = (message.text().toLowerCase(Locale.ROOT).equals(greeting)) ?
                    new SendMessage(chatId, "Hello")
                    : new SendMessage(chatId, EmojiParser.parseToUnicode(":pencil:"));
        }

        if (request != null) {
            bot.execute(request);
        }
        
    }
}
