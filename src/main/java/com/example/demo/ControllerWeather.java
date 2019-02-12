package com.example.demo;

//import org.springframework.boot.json.JsonParser;
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.RequestScope;

import java.io.*;
//import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
//import com.fasterxml.jackson.core.JsonFactory;
//import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonToken;
//import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
//import com.fasterxml.jackson.databind.util.JSONPObject;
import com.example.models.WeatherInfo;

@RestController
@RequestMapping(path = ControllerWeather.PATH)
@RequestScope
public class ControllerWeather {

    public static final String PATH = "weather/v1";

    @RequestMapping("/hello/")
    public @ResponseBody String requestMethodName() {
        return "Hello";
    }

    @RequestMapping("/weather")
    public @ResponseBody ResponseEntity<String> requestWeatherInfo() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(
                "http://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=784d8dc34b1679e4536b1dffe7426a0e",
                String.class);
    }

    @RequestMapping("/weather/{cityId}")
    public @ResponseBody ResponseEntity<String> requestWeatherInfoByCityId(@PathVariable("cityId") Long cityId) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity("http://api.openweathermap.org/data/2.5/weather?id=" + cityId
                + "&APPID=784d8dc34b1679e4536b1dffe7426a0e", String.class);
    }

    @RequestMapping("/weatherFlat")
    public @ResponseBody String requestWeatherInfoFlat() {

        try {
            ObjectMapper mapper = new ObjectMapper();
            WeatherInfo weatherInfo = mapper.readValue(requestWeatherInfo().getBody(), WeatherInfo.class);
            return weatherInfo.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String readFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }

    @RequestMapping("/cities")
    public @ResponseBody String requestCities() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("cities.json");
        return readFromInputStream(inputStream);
    }

    @RequestMapping("/path")
    public @ResponseBody String requestPath() throws IOException {

        File directory = new File("./");
        return directory.getAbsolutePath();

    }

    @RequestMapping("/weatherFlat2/{cityId}")
    public @ResponseBody <T> Object requestWeatherInfoFlat2(@PathVariable("cityId") Long cityId)
            throws IOException, JsonParseException, JsonMappingException {


        Map<?,?> jsonMapping  = new HashMap<>();


        RestTemplate restTemplate = new RestTemplate();
        Map<?, ?> result = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?id="
                + cityId + "&APPID=784d8dc34b1679e4536b1dffe7426a0e", Map.class);
       
                String result2 = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?id="
                + cityId + "&APPID=784d8dc34b1679e4536b1dffe7426a0e", String.class);

         
	   Json jsonFlattener = new Json();
       Map<String, String> map = new HashMap<String, String>();
 
    jsonFlattener.addKeys("", new ObjectMapper().readTree(result2), map);
    return map;
      

        //WeatherInfo weatherinfo = new WeatherInfo();

       // Map<String,?> jsonMapping2 = result.entrySet().stream().collect(Collectors.toMap(gp -> gp., valueMappe));

       // return ((Map<?, ?>) result.get("main")).get("temp");
//        //  jsonMapping.put("temp", value);
        
// //jsonMapping.put("temp",((Map<?, ?>) result.get("main")).get("temp"));


//         weatherinfo.setTempMain((Double) ((Map<?, ?>) result.get("main")).get("temp"));
//         weatherinfo.setHumidityMain((int) ((Map<?, ?>) result.get("main")).get("humidity"));

//         weatherinfo.setPressureMain((Integer) ((Map<?, ?>) result.get("main")).get("pressure"));
        
//         weatherinfo.setTemp_minMain((double) ((Map<?, ?>) result.get("main")).get("temp_min"));
//         weatherinfo.setTemp_maxMain((double) ((Map<?, ?>) result.get("main")).get("temp_max"));
//         weatherinfo.setDegWind((Double) ((Map<?, ?>) result.get("wind")).get("deg"));
//         weatherinfo.setSpeedWind((double) ((Map<?, ?>) result.get("wind")).get("speed"));
//         weatherinfo.setLatCoord((Double) ((Map<?, ?>) result.get("coord")).get("lat"));  
//         weatherinfo.setLonCoord((Double)((Map<?, ?>) result.get("coord")).get("lon"));
//         weatherinfo.setAllClouds((Integer) ((Map<?, ?>) result.get("clouds")).get("all"));
//         weatherinfo.setBase((String)result.get("base"));
//         weatherinfo.setCod((Integer) result.get("cod"));
//         weatherinfo.setSunriseSys((int)((Map<?, ?>) result.get("sys")).get("sunrise"));

//         weatherinfo.setTypeSys((Integer) ((Map<?, ?>) result.get("sys")).get("type"));
//         weatherinfo.setIdSys((Integer) ((Map<?, ?>) result.get("sys")).get("id"));
//         weatherinfo.setMessageSys((Double) ((Map<?, ?>) result.get("sys")).get("message"));
//         weatherinfo.setCountrySys((String) ((Map<?, ?>) result.get("sys")).get("country"));
//         weatherinfo.setSunriseSys((int) ((Map<?, ?>) result.get("sys")).get("sunrise"));
//         weatherinfo.setSunsetSys((int) ((Map<?, ?>) result.get("sys")).get("sunset"));
       
//        weatherinfo.setIdWeather( (int ) (( Map<?, ?>) ((List<?>) result.get("weather")).get(0)).get("id")   );
//        weatherinfo.setMainWeather((String) (( Map<?, ?>) ((List<?>) result.get("weather")).get(0)).get("main")) ;
//        weatherinfo.setDescriptionWeather((String) (( Map<?, ?>) ((List<?>) result.get("weather")).get(0)).get("description")) ;
//        weatherinfo.setIconWeather((String) (( Map<?, ?>) ((List<?>) result.get("weather")).get(0)).get("icon") );
      
//        weatherinfo.setId((Integer) result.get("id"));
//        weatherinfo.setName((String)result.get("name"));
//        weatherinfo.setVisibility((Long) result.get("visibility") );

//         //weatherinfo.setDescriptionWeather((String)  ( Map<String, Object>) ((List<Object>) result.get("weather")).get(0)).get("description") );

//         // {"coord":{"lon":-0.13,"lat":51.51},
//         // "weather":[{"id":741,"main":"Fog","description":"fog","icon":"50d"},
//         // {"id":701,"main":"Mist","description":"mist","icon":"50d"},
//         // {"id":300,"main":"Drizzle","description":"light intensity drizzle","icon":"09d"}],
//         // "base":"stations", "visibility":10000, "id":2643743,"name":"London","cod":200
//         // "main":{"temp":279.33,"pressure":1024,"humidity":87,"temp_min":278.15,"temp_max":280.15},
//         // 
//         // "wind":{"speed":4.1,"deg":180},
//         // "clouds":{"all":90},"dt":1549376520,
//         // "sys":{"type":1,"id":1414,"message":0.005,"country":"GB","sunrise":1549351917,"sunset":1549385870},
//         //"id":2643743,"name":"London","cod":200}



//         return  weatherinfo;

  }

    @RequestMapping("/weatherByCityID/{cityId}")
    public @ResponseBody WeatherInfo requestWeatherInfoByCityID(@PathVariable("cityId") Long cityId)
            throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(requestWeatherInfoByCityId(cityId).getBody(), WeatherInfo.class);

    }


    @RequestMapping("/weatherByCityIDNested/{cityId}")
    public @ResponseBody ResponseEntity<String>  requestWeatherInfoByCityIDNested(@PathVariable("cityId") Long cityId)
           throws IOException {

        return requestWeatherInfoByCityId(cityId);

    }


    @RequestMapping("/citiesStream")
    public @ResponseBody HashMap<Integer, String>  requestCitiesStream() throws IOException {
    

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("cities.json");

        JsonFactory jfactory = new JsonFactory();
        JsonParser jParser = jfactory.createParser(inputStream);

        //List<String>  myListOfCities = new ArrayList<>();

        HashMap<Integer, String>  citiesMapping = new HashMap<Integer,String>();

       // int cnt1 = 0;
        int cnt2 = 0;
        
        Integer cityId = 0;
        
        while (jParser.nextToken() != JsonToken.END_OBJECT) {

              while (jParser.nextToken() != JsonToken.END_ARRAY) {
              
               cnt2 = cnt2 + 1;
               if(cnt2 > 30001)
               {
                   break;
               }
              if ("id".equals(jParser.getCurrentName())) 
               {   
                   jParser.nextToken();  
                   cityId =  Integer.parseInt(jParser.getValueAsString());             
                  // myListOfCities.add(jParser.getValueAsString());
                }
 
               if ("name".equals(jParser.getCurrentName())) 
               {   
                  jParser.nextToken();
                 // myListOfCities.add(jParser.getValueAsString());
                  citiesMapping.put(cityId,jParser.getValueAsString());

               }
        }
       // myListOfCities.add(fieldname);
        
    }
    jParser.close();

        return citiesMapping;
 
   }




}
