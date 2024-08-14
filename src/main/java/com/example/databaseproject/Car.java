package com.example.databaseproject;


public class Car
{

    private String ImagSrc;
    private String Year;
    private String Make;
    private String Color;
    private String Price;

    private String Model;
    private String Bodystyle;
    private String Condition;
    private String Distance;
    private String Transmission;
    private String Engine;
    private String FuelType;
    private String IdCar;

    public String getIdCar() {
        return IdCar;
    }

    public void setIdCar(String idCar) {
        IdCar = idCar;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getBodyStyle() {
        return Bodystyle;
    }

    public void setBodyStyle(String bodyStyle) {
        Bodystyle = bodyStyle;
    }

    public String getCondition() {
        return Condition;
    }

    public void setCondition(String condition) {
        Condition = condition;
    }

    public String getDistance() {
        return Distance;
    }

    public void setDistance(String distance) {
        Distance = distance;
    }

    public String getTransmission() {
        return Transmission;
    }

    public void setTransmission(String transmission) {
        Transmission = transmission;
    }

    public String getEngine() {
        return Engine;
    }

    public void setEngine(String engine) {
        Engine = engine;
    }

    public String getFuelType() {
        return FuelType;
    }

    public void setFuelType(String fuelType) {
        FuelType = fuelType;
    }


    public String getPrice() {
        return Price;
    }

    public void setPrice(String P) {
        Price = P;
    }


    public void setImagSrc(String imagSrc) {
        ImagSrc = imagSrc;
    }
    public String getImagSrc()
    {
        return ImagSrc;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getMake() {
        return Make;
    }

    public void setMake(String make) {
        Make = make;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }



}
