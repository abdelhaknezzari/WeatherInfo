package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.io.*;


import com.fasterxml.jackson.databind.*;
import com.example.models.WeatherInfo;


@Controller
public class ControllerWeather
{

    @RequestMapping("/hello/")
    public @ResponseBody String requestMethodName() {
        return "Hello";
    }

    @RequestMapping("/weather")
    public @ResponseBody ResponseEntity<String>  requestWeatherInfo() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity("http://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=784d8dc34b1679e4536b1dffe7426a0e" , String.class);
    } 
     

   @RequestMapping("/weatherFlat")
   public  @ResponseBody String requestWeatherInfoFlat() {
   
      try{
        ObjectMapper mapper = new ObjectMapper();  
        WeatherInfo weatherInfo = mapper.readValue(requestWeatherInfo().getBody(), WeatherInfo.class);
        return weatherInfo.toString();

        }catch (IOException e) { 
            e.printStackTrace(); 
        }
        return null;
        

   }
   


   @RequestMapping("/weatherFlat2")
   public  @ResponseBody WeatherInfo requestWeatherInfoFlat2() {
   
      try{
        ObjectMapper mapper = new ObjectMapper();  
        return mapper.readValue(requestWeatherInfo().getBody(), WeatherInfo.class);

        }catch (IOException e) { 
            e.printStackTrace(); 
        }
        return null;
        

   }






}
