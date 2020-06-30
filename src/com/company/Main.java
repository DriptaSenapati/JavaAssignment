package com.company;

import java.util.Scanner;

interface Converter{
    Object convert(Object a);
}

abstract class TemperatureConverter implements Converter{
    protected abstract boolean isHot(double a);
}
abstract class SpeedConverter implements Converter{
    protected abstract boolean isFast(double a);
}
class Thermometer extends TemperatureConverter{

    @Override
    public Object convert(Object a) {
        double temp=(double)a;
//        double F=(9/5)*temp +32;
        return (9/5)*temp +32;
    }

    @Override
    protected boolean isHot(double a) {
        boolean hot;
        if (a >=40){
            hot=true;
        }
        else {
            hot =false;
        }
        return hot;
    }
}

class Thermocouple extends TemperatureConverter{

    @Override
    public Object convert(Object a) {
        double temp=(double)a;
        double K=273+temp;
        return K;
    }

    @Override
    protected boolean isHot(double a) {
        boolean hot;
        if (a >=40){
            hot=true;
        }
        else {
            hot =false;
        }
        return hot;
    }
}
class PitotTube extends SpeedConverter{

    @Override
    public Object convert(Object a) {
        double kps=(double)a;
        return kps*2.94;
    }

    @Override
    protected boolean isFast(double a) {
        boolean speed;
        if (a >= 130){
            speed = true;
        }
        else{
            speed=false;
        }
        return speed;
    }
}
class ShaftLog extends SpeedConverter{

    @Override
    public Object convert(Object a) {
        double kmh=(double)a;
        return kmh*0.621;
    }

    @Override
    protected boolean isFast(double a) {
        boolean speed;
        if (a >= 130){
            speed = true;
        }
        else{
            speed=false;
        }
        return speed;
    }
}



public class Main {

    public static void main(String[] args) {
	// write your code here
    Converter converter;
    Scanner sc= new Scanner(System.in);
    System.out.println("Enter a number between 1-4: ");
    int a= sc.nextInt();
    if (a == 1){
        Thermometer thermobj=new Thermometer();
        converter=thermobj;
        Thermometer obj=(Thermometer)converter;
        System.out.println("Temperature converted to  Fahrenheit is:"+converter.convert(56.24));  //Since converter is of type Converter and this has own
                                                                                                        //property and description named convert.
        System.out.println("Hot or not:"+obj.isHot(45.24));
    }
    else if (a==2){
        Thermocouple thermcpl=new Thermocouple();
        converter=thermcpl;
        Thermocouple obj=(Thermocouple )converter;
        System.out.println("Temperature converted to Kelvin is:"+converter.convert(59.24));
        System.out.println("kps to mach:"+obj.isHot(81.14));

    }
    else if (a==3){
        PitotTube pttube=new PitotTube();
        converter= pttube;
        PitotTube obj=(PitotTube)converter;
        System.out.println("kps to mach:"+converter.convert(81.14));
        System.out.println("is fast or not:"+obj.isFast(81.14));
    }
    else if (a==4){
        ShaftLog shftobj=new ShaftLog();
        converter= shftobj;
        ShaftLog obj=(ShaftLog)converter;
        System.out.println("kmh to mph:"+converter.convert(89.01));
        System.out.println("fast or not:"+obj.isFast(89.01));
    }
    else {
        System.out.println("Please choose between 1 and 4");
    }
    }
}

