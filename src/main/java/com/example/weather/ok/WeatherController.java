package com.example.weather.ok;

import com.example.weather.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;


@Controller
public class WeatherController {

    @Value("${openweathermap.api.key}")
    private String apiKey;



    private static final String API_URL = "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s";

    @GetMapping("/weather")
    public String showWeather(@RequestParam("city") String cityName, Model model) {
        String url = String.format(API_URL, cityName, apiKey);

        RestTemplate restTemplate = new RestTemplate();
        WeatherResponse response = restTemplate.getForObject(url, WeatherResponse.class);

        String weatherDescription = response.getWeather()[0].getDescription();
        int temperature = response.getMain().getTemp() - 273;
        int feels_like = response.getMain().getFeels_like() - 273;
        int speed = response.getWind().getSpeed();
        int timezoneSeconds = response.getTimezone(); // Получаем смещение временной зоны в секундах
        String country = response.getSys().getCountry();
        double lon = response.getCoord().getLon();
        double lat = response.getCoord().getLat();

        // Преобразуем смещение временной зоны из секунд в часы
        int timezoneHours = timezoneSeconds / 3600;

        // Формируем строку с временным смещением в формате "UTC±X"
        String utcOffset;
        if (timezoneHours >= 0) {
            utcOffset = "UTC+" + timezoneHours; // Добавляем символ "+" для положительного смещения
        } else {
            utcOffset = "UTC" + timezoneHours; // Знак "-" будет добавлен автоматически для отрицательного смещения
        }

        model.addAttribute("cityName", cityName);
        model.addAttribute("weatherDescription", weatherDescription);
        model.addAttribute("temperature", temperature);
        model.addAttribute("feels_like", feels_like);
        model.addAttribute("speed", speed);
        model.addAttribute("utcTime", utcOffset);
        model.addAttribute("country", country);
        model.addAttribute("lon", lon);
        model.addAttribute("lat", lat);

        return "weather";
    }
}
