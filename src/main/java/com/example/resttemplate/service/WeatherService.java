package com.example.resttemplate.service;

import com.example.resttemplate.model.WeatherDto;
import com.example.resttemplate.webclient.weather.WeatherClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherClient weatherClient;

    public WeatherDto getWeather(){
       return weatherClient.getWeatherForCity("wrocław");
    }



    public String getForecast(){
               String response = weatherClient.getForecast(51.1,17.0333);
        log.info(response);
        return response;
    }





}
