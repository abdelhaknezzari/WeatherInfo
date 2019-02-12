package com.example.models;

import java.time.Instant;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherInfo {
    private long timeStampMillis;
    private double lonCoord;
    private double latCoord;
    private int idWeather;
    private String mainWeather;
    private String descriptionWeather;
    private String iconWeather;
    private String base;
    private double tempMain;
    private Integer pressureMain;
    private int humidityMain;
    private double temp_minMain;
    private double temp_maxMain;
    // private Double sea_levelMain;
    // private Double grnd_levelMain;


    private Long visibility;

    //private Wind wind;
    private double speedWind;
    private double degWind;

    private Integer allClouds;

    private long dt;

    private Integer typeSys;
    private Integer idSys;
    private double messageSys;
    private String countrySys;
    private int sunriseSys;
    private int sunsetSys;

    private Integer id;
    private String name;
    private long cod;

    public WeatherInfo() {
       timeStampMillis = Instant.now().toEpochMilli();
    }

    @JsonProperty("coord")
    private void unpackNested1(Map<String, Object> coord) {
        this.lonCoord = (double) coord.get("lon");
        this.latCoord = (double) coord.get("lat");
    }

    @JsonProperty("weather")
    private <T> void unpackNested2(List<T> weather) {
        Map<?, ?> obj = (Map<?, ?>) weather.get(0);

        this.idWeather = (Integer) obj.get("id");
        this.mainWeather = (String) obj.get("main");
        this.descriptionWeather = (String) obj.get("description");
        this.iconWeather = (String) obj.get("icon");
    }

    @JsonProperty("main")
    private void unpackNested3(Map<String, Object> main) {
        this.tempMain = (Double) main.get("temp");
        this.pressureMain = (Integer) main.get("pressure");
        this.humidityMain = (Integer) main.get("humidity");
        this.temp_minMain = (Double) main.get("temp_min");
        this.temp_maxMain = (Double) main.get("temp_max");

        // this.sea_levelMain = (Double) main.get("sea_level");
        // this.grnd_levelMain = (Double) main.get("grnd_level");

    }


    @JsonProperty("wind")
    private void unpackNested4(Map<String, Object> wind) {
        this.speedWind = (double) wind.get("speed");
        this.degWind = (int) wind.get("deg");

    }

    @JsonProperty("clouds")
    private void unpackNested5(Map<String, Object> clouds) {
        this.allClouds = (int) clouds.get("all");
    }

    @JsonProperty("sys")
    private void unpackNested6(Map<String, Object> sys) {
        this.typeSys = (Integer) sys.get("type");
        this.idSys = (Integer) sys.get("id");
        this.messageSys = (double) sys.get("message");
        this.countrySys = (String) sys.get("country");
        this.sunriseSys = (int) sys.get("sunrise");
        this.sunsetSys = (int) sys.get("sunset");
    }
    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.writeValueAsString(this);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * @return the timeStampMillis
     */
    public long getTimeStampMillis() {
        return timeStampMillis;
    }

    /**
     * @param timeStampMillis the timeStampMillis to set
     */
    public void setTimeStampMillis(long timeStampMillis) {
        this.timeStampMillis = timeStampMillis;
    }

    /**
     * @return the lonCoord
     */
    public double getLonCoord() {
        return lonCoord;
    }

    /**
     * @param lonCoord the lonCoord to set
     */
    public void setLonCoord(double lonCoord) {
        this.lonCoord = lonCoord;
    }

    /**
     * @return the latCoord
     */
    public double getLatCoord() {
        return latCoord;
    }

    /**
     * @param latCoord the latCoord to set
     */
    public void setLatCoord(double latCoord) {
        this.latCoord = latCoord;
    }

    /**
     * @return the idWeather
     */
    public int getIdWeather() {
        return idWeather;
    }

    /**
     * @param idWeather the idWeather to set
     */
    public void setIdWeather(int idWeather) {
        this.idWeather = idWeather;
    }

    /**
     * @return the mainWeather
     */
    public String getMainWeather() {
        return mainWeather;
    }

    /**
     * @param mainWeather the mainWeather to set
     */
    public void setMainWeather(String mainWeather) {
        this.mainWeather = mainWeather;
    }

    /**
     * @return the descriptionWeather
     */
    public String getDescriptionWeather() {
        return descriptionWeather;
    }

    /**
     * @param descriptionWeather the descriptionWeather to set
     */
    public void setDescriptionWeather(String descriptionWeather) {
        this.descriptionWeather = descriptionWeather;
    }

    /**
     * @return the iconWeather
     */
    public String getIconWeather() {
        return iconWeather;
    }

    /**
     * @param iconWeather the iconWeather to set
     */
    public void setIconWeather(String iconWeather) {
        this.iconWeather = iconWeather;
    }

    /**
     * @return the base
     */
    public String getBase() {
        return base;
    }

    /**
     * @param base the base to set
     */
    public void setBase(String base) {
        this.base = base;
    }

    /**
     * @return the tempMain
     */
    public double getTempMain() {
        return tempMain;
    }

    /**
     * @param tempMain the tempMain to set
     */
    public void setTempMain(double tempMain) {
        this.tempMain = tempMain;
    }

    /**
     * @return the pressureMain
     */
    public Integer getPressureMain() {
        return pressureMain;
    }

    /**
     * @param pressureMain the pressureMain to set
     */
    public void setPressureMain(Integer pressureMain) {
        this.pressureMain = pressureMain;
    }

    /**
     * @return the humidityMain
     */
    public int getHumidityMain() {
        return humidityMain;
    }

    /**
     * @param humidityMain the humidityMain to set
     */
    public void setHumidityMain(int humidityMain) {
        this.humidityMain = humidityMain;
    }

    /**
     * @return the temp_minMain
     */
    public double getTemp_minMain() {
        return temp_minMain;
    }

    /**
     * @param temp_minMain the temp_minMain to set
     */
    public void setTemp_minMain(double temp_minMain) {
        this.temp_minMain = temp_minMain;
    }

    /**
     * @return the temp_maxMain
     */
    public double getTemp_maxMain() {
        return temp_maxMain;
    }

    /**
     * @param temp_maxMain the temp_maxMain to set
     */
    public void setTemp_maxMain(double temp_maxMain) {
        this.temp_maxMain = temp_maxMain;
    }

    /**
     * @return the visibility
     */
    public Long getVisibility() {
        return visibility;
    }

    /**
     * @param visibility the visibility to set
     */
    public void setVisibility(Long visibility) {
        this.visibility = visibility;
    }

    /**
     * @return the speedWind
     */
    public double getSpeedWind() {
        return speedWind;
    }

    /**
     * @param speedWind the speedWind to set
     */
    public void setSpeedWind(double speedWind) {
        this.speedWind = speedWind;
    }

    /**
     * @return the degWind
     */
    public double getDegWind() {
        return degWind;
    }

    /**
     * @param degWind the degWind to set
     */
    public void setDegWind(double  degWind) {
        this.degWind = degWind;
    }

    /**
     * @return the allClouds
     */
    public Integer getAllClouds() {
        return allClouds;
    }

    /**
     * @param allClouds the allClouds to set
     */
    public void setAllClouds(Integer allClouds) {
        this.allClouds = allClouds;
    }

    /**
     * @return the dt
     */
    public long getDt() {
        return dt;
    }

    /**
     * @param dt the dt to set
     */
    public void setDt(long dt) {
        this.dt = dt;
    }

    /**
     * @return the typeSys
     */
    public Integer getTypeSys() {
        return typeSys;
    }

    /**
     * @param typeSys the typeSys to set
     */
    public void setTypeSys(Integer typeSys) {
        this.typeSys = typeSys;
    }

    /**
     * @return the idSys
     */
    public Integer getIdSys() {
        return idSys;
    }

    /**
     * @param idSys the idSys to set
     */
    public void setIdSys(Integer idSys) {
        this.idSys = idSys;
    }

    /**
     * @return the messageSys
     */
    public double getMessageSys() {
        return messageSys;
    }

    /**
     * @param messageSys the messageSys to set
     */
    public void setMessageSys(double messageSys) {
        this.messageSys = messageSys;
    }

    /**
     * @return the countrySys
     */
    public String getCountrySys() {
        return countrySys;
    }

    /**
     * @param countrySys the countrySys to set
     */
    public void setCountrySys(String countrySys) {
        this.countrySys = countrySys;
    }

    /**
     * @return the sunriseSys
     */
    public int getSunriseSys() {
        return sunriseSys;
    }

    /**
     * @param sunriseSys the sunriseSys to set
     */
    public void setSunriseSys(int sunriseSys) {
        this.sunriseSys = sunriseSys;
    }

    /**
     * @return the sunsetSys
     */
    public int getSunsetSys() {
        return sunsetSys;
    }

    /**
     * @param sunsetSys the sunsetSys to set
     */
    public void setSunsetSys(int sunsetSys) {
        this.sunsetSys = sunsetSys;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the cod
     */
    public long getCod() {
        return cod;
    }

    /**
     * @param cod the cod to set
     */
    public void setCod(long cod) {
        this.cod = cod;
    }

    // /**
    //  * @return the sea_levelMain
    //  */
    // public double getSea_levelMain() {
    //     return sea_levelMain;
    // }

    // /**
    //  * @param sea_levelMain the sea_levelMain to set
    //  */
    // public void setSea_levelMain(double sea_levelMain) {
    //     this.sea_levelMain = sea_levelMain;
    // }

    // /**
    //  * @return the grnd_levelMain
    //  */
    // public double getGrnd_levelMain() {
    //     return grnd_levelMain;
    // }

    // /**
    //  * @param grnd_levelMain the grnd_levelMain to set
    //  */
    // public void setGrnd_levelMain(Double grnd_levelMain) {
    //     this.grnd_levelMain = grnd_levelMain;
    // }

    

 
}