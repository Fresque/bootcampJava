package com.company.Model;

/**
 * Created by marti on 4/28/2017.
 */
public class Dia {

    //De item
    private String title;
    private String pubDate;

    //De condition
    private int temp;
    private String text;

    //De atmosphere
    private int humudity;
    private float pressure;
    private int rising;
    private float visibility;

    //De wind
    private int chill;
    private int direction;
    private int speed;

    //De astronomy
    private float sunrise;
    private float sunset;

    public Dia(){

    }

    public Dia(String titulo, String fecha, int temperatura, String descripcion, int humedad, int viento){
        this.title = titulo;
        this.pubDate = fecha;
        this.temp =  temperatura;
        this.text = descripcion;
        this.humudity = humedad;
        this.speed = viento;
    }

    private Forecast[] Forecast;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getHumudity() {
        return humudity;
    }

    public void setHumudity(int humudity) {
        this.humudity = humudity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public int getRising() {
        return rising;
    }

    public void setRising(int rising) {
        this.rising = rising;
    }

    public float getVisibility() {
        return visibility;
    }

    public void setVisibility(float visibility) {
        this.visibility = visibility;
    }

    public int getChill() {
        return chill;
    }

    public void setChill(int chill) {
        this.chill = chill;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public float getSunrise() {
        return sunrise;
    }

    public void setSunrise(float sunrise) {
        this.sunrise = sunrise;
    }

    public float getSunset() {
        return sunset;
    }

    public void setSunset(float sunset) {
        this.sunset = sunset;
    }

    public com.company.Model.Forecast[] getForecast() {
        return Forecast;
    }

    public void setForecast(com.company.Model.Forecast[] forecast) {
        Forecast = forecast;
    }

}
