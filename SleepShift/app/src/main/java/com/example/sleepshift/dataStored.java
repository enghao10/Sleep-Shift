package com.example.sleepshift;

public class dataStored {
    private String date;
    private String time;
    private int age;
    private String dateLeaving;
    private int daysInSpace;

    public dataStored() {
    }

    public dataStored(String date, String time, String dateLeaving, int age, int daysInSpace) {
        this.date = date;
        this.time = time;
        this.age = age;
        this.dateLeaving=dateLeaving;
        this.daysInSpace=daysInSpace;
    }

    @Override
    public String toString() {
        return "dataStored{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", age=" + age +
                ", dateLeaving='" + dateLeaving + '\'' +
                ", daysInSpace=" + daysInSpace +
                '}';
    }

    public int getDaysInSpace() {
        return daysInSpace;
    }

    public void setDaysInSpace(int daysInSpace) {
        this.daysInSpace = daysInSpace;
    }

    public String getDateLeaving() {
        return dateLeaving;
    }

    public void setDateLeaving(String dateLeaving) {
        this.dateLeaving = dateLeaving;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
