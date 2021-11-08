package com.example.resttemplate.webclient.weather;

import com.example.resttemplate.model.WeatherDto;
import com.example.resttemplate.webclient.weather.dto.OpenWeatherWeatherDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherClient {


    private static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/";
    private static final String ApiKey = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
    private RestTemplate restTemplate = new RestTemplate();

    public WeatherDto getWeatherForCity(String city){

        OpenWeatherWeatherDto openWeatherWeatherDto= callGetMethod("weather?q={city}&appid={apiKey}&units=metric&lang=pl",
                OpenWeatherWeatherDto.class,
                city, ApiKey);

        return WeatherDto.builder()
                .temperature(openWeatherWeatherDto.getMain().getTemp())
                .pressure(openWeatherWeatherDto.getMain().getPressure())
                .humidity(openWeatherWeatherDto.getMain().getHumidity())
                .windSpeed(openWeatherWeatherDto.getWind().getSpeed())
                .build();

    }


    public String getForecast(double lat,double lon){
        return callGetMethod("onecall?lat={lat}&lon={lon}&exclude=minutely,hourly&appid={apiKey}&unit=metric&lang=pl",
                String.class,
                lat, lon, ApiKey);
    }

    private <T> T callGetMethod(String url,Class<T> responseType,Object...objects) {
        return restTemplate.getForObject(WEATHER_URL + url,
                responseType, objects);
    }

}


//        double lat = 51.1;
//        double lon = 17.0333;
