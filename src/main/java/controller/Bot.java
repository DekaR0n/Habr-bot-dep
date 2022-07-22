package controller;


import com.pengrad.telegrambot.model.InlineQuery;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.model.request.InlineQueryResultArticle;
import com.pengrad.telegrambot.request.AnswerInlineQuery;
import com.vdurmont.emoji.EmojiParser;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;

import java.util.ArrayList;
import java.util.List;
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
        InlineQuery query = update.inlineQuery();


        if (query != null) {
            //   InlineQueryResultArticle QueryStone = getListQuery("stone", "Stone", "0");
            //   InlineQueryResultArticle QueryScissors = getListQuery("scissors", "Scissors", "1");
            //   InlineQueryResultArticle QueryPaper = getListQuery("paper", "Paper", "2");

            //   request = new AnswerInlineQuery(query.id(), QueryStone, QueryScissors, QueryPaper);

        }
        if (message != null) {
            long chatId = message.chat().id();
            //  sendInlineKeyBoardMessage(chatId);
            //    InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

            //     InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton("Tyk").callbackData("has passed");
            //    List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
            //    keyboardButtonsRow1.add(new InlineKeyboardButton("Fi4a")
            //            .callbackData("CallFi4a"));
            //    List<List<InlineKeyboardButton>> rowList= new ArrayList<>();
            //    rowList.add(keyboardButtonsRow1);


            //   request = new SendMessage(chatId, "inlineKeyboardMarkup");
            request = sendInlineKeyBoardMessage(chatId);
            //   String greeting = "hello";
            //   request = (message.text().toLowerCase(Locale.ROOT).equals(greeting)) ?
            //           new SendMessage(chatId, "Hello")
            //           : new SendMessage(chatId, (EmojiParser.parseToUnicode(":fist: :hand: :victory hand:") + " write the number"));
        }

        if (request != null) {
            bot.execute(request);
        }

    }

    private InlineQueryResultArticle getListQuery(String id, String title, String callbackData) {
        return new InlineQueryResultArticle(id, title, callbackData)
                .replyMarkup(
                        new InlineKeyboardMarkup(
                                new InlineKeyboardButton("Processing").callbackData("0")
                        )
                );
    }

    public static SendMessage sendInlineKeyBoardMessage(long chatId) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton("1")
                .callbackData("Button \"Тык\" has been pressed");
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton("2")
                .callbackData("Button \"Тык2\" has been pressed");

        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();

        keyboardButtonsRow1.add(inlineKeyboardButton1);
        keyboardButtonsRow1.add(new InlineKeyboardButton("Fi4a").callbackData("CallFi4a"));
        keyboardButtonsRow2.add(inlineKeyboardButton2);
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);
        rowList.add(keyboardButtonsRow2);
        for (int i = 0 ; i<keyboardButtonsRow1.size(); i++){
            inlineKeyboardMarkup.addRow(keyboardButtonsRow1.get(i));
        }
        return new SendMessage(chatId, "Пример").replyMarkup(inlineKeyboardMarkup);
    }

}
