package com.company.Model;

/**
 * Created by marti on 4/28/2017.
 */
public class Forecast {
    private String date;
    private String day;
    private int high;
    private int low;
    private int text;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public int getText() {
        return text;
    }

    public void setText(int text) {
        this.text = text;
    }

}
