package com.example;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Converter {

    // Method to convert mph to kph
    public double mph2kph(double mph) {
        return mph * 1.609;
    }

    // Method to return mph and kph as a formatted string
    public String mph2kph_printing(double mph) {
        return Double.toString(mph) + " mph = " + 
            new DecimalFormat("#.#", DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(mph2kph(mph)) + " kph";
    }

    // Method to compare mph values
    public boolean mph2kph_compare(double mph1, double mph2) {
        return mph2kph(mph1) >= mph2kph(mph2);
    }

    // Convert arrays based on type (mph2kph, celsius2fahrenheit, pounds2dollars, seconds2hours)
    public double[] convert_array(String type, double[] values) {
        double[] out_values = new double[values.length];
        
        switch (type) {
            case "mph2kph":
                for (int i = 0; i < values.length; i++) {
                    out_values[i] = mph2kph(values[i]);
                }
                break;
            case "celsius2fahrenheit":
                for (int i = 0; i < values.length; i++) {
                    out_values[i] = celsius2fahrenheit(values[i]);
                }
                break;
            case "pounds2dollars":
                for (int i = 0; i < values.length; i++) {
                    out_values[i] = pounds2dollars(values[i]);
                }
                break;
            case "seconds2hours":
                for (int i = 0; i < values.length; i++) {
                    out_values[i] = seconds2hours(values[i]);
                }
                break;
        }
        return out_values;
    }

    // Method to convert Celsius to Fahrenheit
    public double celsius2fahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32.0;
    }

    // Method to convert Pounds to Dollars
    public double pounds2dollars(double pounds) {
        return pounds * 1.25; // Assume fixed conversion rate
    }

    // Method to convert Seconds to Hours
    public double seconds2hours(double seconds) {
        return seconds / 3600.0;
    }

    // Main method to manually run some conversions for testing
    public static void main(String[] args) {
        Converter converter = new Converter();
        
        // Test mph to kph conversion
        double mph = 60;
        System.out.println("60 mph in kph: " + converter.mph2kph(mph));

        // Test celsius to fahrenheit conversion
        double celsius = 100;
        System.out.println("100 Celsius in Fahrenheit: " + converter.celsius2fahrenheit(celsius));

        // Test pounds to dollars conversion
        double pounds = 50;
        System.out.println("50 Pounds in Dollars: " + converter.pounds2dollars(pounds));

        // Test seconds to hours conversion
        double seconds = 7200;
        System.out.println("7200 seconds in hours: " + converter.seconds2hours(seconds));
    }
}
