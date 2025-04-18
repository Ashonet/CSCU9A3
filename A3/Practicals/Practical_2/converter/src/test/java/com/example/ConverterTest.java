package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ConverterTest {

    private static final double ACCURACY = 0.05;
    private static Converter converter;

    @BeforeAll
    public static void setup() {
        converter = new Converter();
    }

    @Test
    public void test_mph2kph() {
        assertEquals(38.6243, converter.mph2kph(24), ACCURACY);
        assertEquals(96.5606, converter.mph2kph(60), ACCURACY);
    }

    @Test
    public void test_mph2kph_printing() {
        assertEquals("60.0 mph = 96.6 kph", converter.mph2kph_printing(60));
    }

    @Test
    public void test_mph2kph_compare() {
        assertTrue(converter.mph2kph_compare(60, 40));
        assertFalse(converter.mph2kph_compare(30, 50));
    }

    @Test
    public void test_convert_array_mph2kph() {
        double[] mphArray = {20, 40, 60};
        double[] expectedKphArray = {32.18, 64.37, 96.56};  
        assertArrayEquals(expectedKphArray, converter.convert_array("mph2kph", mphArray), ACCURACY);
    }

    @Test
    public void test_convert_array_celsius2fahrenheit() {
        double[] celsiusArray = {0, 100};
        double[] expectedFahrenheitArray = {32.0, 212.0};
        assertArrayEquals(expectedFahrenheitArray, converter.convert_array("celsius2fahrenheit", celsiusArray), ACCURACY);
    }

    @Test
    public void test_convert_array_pounds2dollars() {
        double[] poundsArray = {10, 20};
        double[] expectedDollarsArray = {12.5, 25.0};
        assertArrayEquals(expectedDollarsArray, converter.convert_array("pounds2dollars", poundsArray), ACCURACY);
    }

    @Test
    public void test_convert_array_seconds2hours() {
        double[] secondsArray = {3600, 7200};
        double[] expectedHoursArray = {1.0, 2.0};
        assertArrayEquals(expectedHoursArray, converter.convert_array("seconds2hours", secondsArray), ACCURACY);
    }
}
