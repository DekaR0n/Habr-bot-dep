package game.handler;

import com.vdurmont.emoji.EmojiParser;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;

public class TripleGame {
    public static String  getEmoji(String text){
        return EmojiParser.parseToUnicode(text);
    }

}
