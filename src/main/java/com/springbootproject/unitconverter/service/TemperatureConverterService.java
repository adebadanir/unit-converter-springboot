package com.springbootproject.unitconverter.service;

import java.text.DecimalFormat;


public class TemperatureConverterService {
    private final DecimalFormat df = new DecimalFormat("#.#########");

    public TemperatureConverterService() {
    }

    public Double convert(String fromUnit, String toUnit, Double inputValue) {
        Double valueInCelcius = switch (fromUnit) {
            case "celsius" -> inputValue;
            case "fahrenheit" -> (inputValue - 32) * 5 / 9;
            case "kelvin" -> inputValue - 273.15;
            default -> throw new IllegalArgumentException("Invalid unit: " + fromUnit);
        };
        return switch (toUnit) {
            case "celsius" -> valueInCelcius;
            case "fahrenheit" -> valueInCelcius * 9 / 5 + 32;
            case "kelvin" -> valueInCelcius + 273.15;
            default -> throw new IllegalArgumentException("Invalid unit: " + toUnit);
        };
    }

    public String convertFormatted(String fromUnit, String toUnit, Double inputValue) {
        Double result = convert(fromUnit, toUnit, inputValue);
        return df.format(result);
    }
}


