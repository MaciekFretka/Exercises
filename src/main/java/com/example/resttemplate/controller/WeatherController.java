package com.example.resttemplate.controller;

import com.example.resttemplate.model.WeatherDto;
import com.example.resttemplate.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping("/weather")
    public WeatherDto getWeather(){
        return weatherService.getWeather();
    }

    @GetMapping("/forecast")
    public String getForecast(){
        return weatherService.getForecast();
    }

}
