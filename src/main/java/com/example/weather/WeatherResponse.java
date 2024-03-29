package com.example.weather;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
    private Weather[] weather;
    private Main main;
    private Wind wind;
    private Sys sys;

    private Coord coord;




    public Weather[] getWeather() {
        return weather;
    }

    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Weather {
        private String description;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }



//---------------------------------------------------------------------



    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Main {
        private int temp;

        private int feels_like;

        public int getTemp() {
            return temp;
        }

        public void setTemp(int temp) {
            this.temp = temp;
        }

        public int getFeels_like() {
            return feels_like;
        }

        public void setFeels_like(int feels_like) {
            this.feels_like = feels_like;
        }
    }

//---------------------------------------------------------------------

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Wind{
        private int speed;

        public int getSpeed() {
            return speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }
    }

    //---------------------------------------------------------------------

    @JsonIgnoreProperties(ignoreUnknown = true)
    private int timezone;

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

//---------------------------------------------------------------------
    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Sys{
        private String country;

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    }



    //---------------------------------------------------------------------


    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Coord{
        public double lon;
        public double lat;

        public double getLon() {
            return lon;
        }

        public void setLon(double lon) {
            this.lon = lon;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }
    }

}