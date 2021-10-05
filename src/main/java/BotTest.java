import org.junit.Assert;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BotTest {

    @org.junit.jupiter.api.Test
    void sendMsg() {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId("12121");
        sendMessage.setReplyToMessageId(12121);
        sendMessage.setText("text");

    }

    @org.junit.jupiter.api.Test
    void onUpdateReceived() {
        Model model = new Model();
        String[] messages = new String[5];
        messages[0] = "/start";
        messages[1] = "погода";
        messages[2] = "Moscow";
        messages[3] = "/about";
        messages[4] = "dskj";
        String expected = "Hi! I'm weather bot, just type in the name of the city in English and I'll show you the weather :)";
        String expected2 = "Bot made by Mykyta Morar. Bot takes weather from OpenWeather.";
        String expected3 = "No city founded!";
        String expected4 = "Weather now in Moscow\n" +
                "Temperature:  8.0°C\n" +
                "Description: overcast clouds\n" +
                "Wind speed: 3.89 km/h\n" +
                "Humidity: 71.0%\n" +
                "http://openweathermap.org/img/w/04d.png";


        for (int i=0;i<5;i++) {
            String message = messages[i];

            switch (message) {
                case "/start":
                    Assert.assertEquals(expected, "Hi! I'm weather bot, just type in the name of the city in English and I'll show you the weather :)");
                    break;
                case "hi":
                    Assert.assertEquals(expected, "Hi! I'm weather bot, just type in the name of the city in English and I'll show you the weather :)");
                    break;
                case "hello":
                    Assert.assertEquals(expected, "Hi! I'm weather bot, just type in the name of the city in English and I'll show you the weather :)");
                    break;
                case "привет":
                    Assert.assertEquals(expected, "Hi! I'm weather bot, just type in the name of the city in English and I'll show you the weather :)");
                    break;
                case "погода":
                    Assert.assertEquals(expected, "Hi! I'm weather bot, just type in the name of the city in English and I'll show you the weather :)");
                    break;
                case "weather":
                    Assert.assertEquals(expected, "Hi! I'm weather bot, just type in the name of the city in English and I'll show you the weather :)");
                    break;
                case "Hi":
                    Assert.assertEquals(expected, "Hi! I'm weather bot, just type in the name of the city in English and I'll show you the weather :)");
                    break;
                case "Hello":
                    Assert.assertEquals(expected, "Hi! I'm weather bot, just type in the name of the city in English and I'll show you the weather :)");
                    break;
                case "Привет":
                    Assert.assertEquals(expected, "Hi! I'm weather bot, just type in the name of the city in English and I'll show you the weather :)");
                    break;
                case "Погода":
                    Assert.assertEquals(expected, "Hi! I'm weather bot, just type in the name of the city in English and I'll show you the weather :)");
                    break;
                case "Weather":
                    Assert.assertEquals(expected, "Hi! I'm weather bot, just type in the name of the city in English and I'll show you the weather :)");
                    break;
                case "/help":
                    Assert.assertEquals(expected, "You should type in the name of the city in English and that's it.");
                    break;
                case "/about":
                    Assert.assertEquals(expected2, "Bot made by Mykyta Morar. Bot takes weather from OpenWeather.");
                    break;
                default:
                    try {
                        Assert.assertEquals(expected4, Weather.getWeather(message, model));
                    } catch (IOException e) {
                        Assert.assertEquals(expected3, "No city founded!");
                    }
            }
        }
        }


    @org.junit.jupiter.api.Test
    void setButtons() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup(); // new keyboard
        SendMessage sendMessage=new SendMessage();
        sendMessage.setText("London");
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add(new KeyboardButton("/help"));
        keyboardFirstRow.add(new KeyboardButton("/about"));

    }

    @org.junit.jupiter.api.Test
    void getBotUsername() {
        String expected = "HelpCoding_bot";
        Bot bot = new Bot();
        Assert.assertEquals(expected, bot.getBotUsername());
    }
}