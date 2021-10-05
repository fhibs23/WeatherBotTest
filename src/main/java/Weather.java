import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Weather {
    /**
     * метод getWeather  ищет информацию по введенному городу через Api
     * @param message город - подстрока для поиска
     * @param model
     * @return нужная информация
     * @throws IOException
     */
    public static String getWeather(String message, Model model) throws IOException {
        URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + message + "&units=metric&appid=937f2e3d9fdc3a61ceb74a79273ee512");

        Scanner in = new Scanner((InputStream) url.getContent());
        String result = "";
        while (in.hasNext()) {
            result += in.nextLine();
        }

        JSONObject object = new JSONObject(result);
        model.setName(object.getString("name"));


        JSONObject main = object.getJSONObject("main");
        model.setTemp(main.getDouble("temp"));
        model.setHumidity(main.getDouble("humidity"));

        JSONObject wind = object.getJSONObject("wind");
        model.setSpeed(wind.getDouble("speed"));


        JSONArray getArray = object.getJSONArray("weather");
        for (int i = 0; i < getArray.length(); i++) {
            JSONObject obj = getArray.getJSONObject(i);
            model.setIcon((String) obj.get("icon"));
            model.setDescription((String) obj.get("description"));
        }

        return  "Weather now in " + model.getName() + "\n" +
                "Temperature:  " + model.getTemp() + "°C" + "\n" +
                "Description: " + model.getDescription() +"\n" +
                "Wind speed: " + model.getSpeed() + " km/h" + "\n" +
                "Humidity: " + model.getHumidity() + "%" + "\n" +
                "http://openweathermap.org/img/w/" + model.getIcon() + ".png";
        ///"https://raw.githubusercontent.com/mykytam/weatherTelegramBot/master/img/" + model.getIcon() + ".png";
    }
}