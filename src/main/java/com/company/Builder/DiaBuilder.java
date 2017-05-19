package com.company.Builder;

import com.company.Model.Dia;

/**
 * Created by marti on 5/19/2017.
 */
public class DiaBuilder {

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

    DiaBuilder withTitle(String s){
        title=s;
        return this;
    }

    DiaBuilder withPubDate(String s){
        text=s;
        return this;
    }

    DiaBuilder withHumidity(int i){
        humudity=i;
        return this;
    }

    DiaBuilder withPressure(float f){
        pressure=f;
        return this;
    }

    DiaBuilder withRising(int i){
        rising=i;
        return this;
    }

    DiaBuilder withVisibility(float f){
        visibility=f;
        return this;
    }

    DiaBuilder withChill(int i){
        chill=i;
        return this;
    }

    DiaBuilder withDirection(int i){
        direction=i;
        return this;
    }

    DiaBuilder withSpeed(int i){
        speed=i;
        return this;
    }

    DiaBuilder withSunrise(float f){
        sunrise=f;
        return this;
    }

    DiaBuilder withSunset(float f){
        sunset=f;
        return this;
    }

    public Dia build() {
        Dia d = new Dia();

        d.setTitle(this.title);
        d.setPubDate(this.pubDate);

        d.setTemp(this.temp);
        d.setText(this.text);

        d.setHumudity(this.humudity);
        d.setPressure(this.pressure);
        d.setRising(this.rising);
        d.setVisibility(this.visibility);

        d.setChill(this.chill);
        d.setDirection(this.direction);
        d.setSpeed(this.speed);

        d.setSunrise(this.sunrise);
        d.setSunset(this.sunset);

        return d;
    }

}
