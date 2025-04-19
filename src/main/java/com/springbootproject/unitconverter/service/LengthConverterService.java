package com.springbootproject.unitconverter.service;

import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.HashMap;

@Service
public class LengthConverterService {
    private final DecimalFormat df = new DecimalFormat("#.#########");

    private final HashMap<String, Double> unitMap = new HashMap<>();
     public LengthConverterService() {
        unitMap.put("milimeter", 0.001);
        unitMap.put("centimeter", 0.01);
        unitMap.put("meter", 1.0);
        unitMap.put("kilometer", 1000.0);
        unitMap.put("inch", 0.0254);
        unitMap.put("foot", 0.3048);
        unitMap.put("yard", 0.9144);
        unitMap.put("mile", 1609.34);
    }

    public Double convert(String fromUnit, String toUnit, Double inputValue) {
        if (!unitMap.containsKey(fromUnit) || !unitMap.containsKey(toUnit)) {
            throw new IllegalArgumentException("Invalid unit: " + fromUnit + " or " + toUnit);
        }
        return  inputValue * unitMap.get(fromUnit) / unitMap.get(toUnit);
    }

    public String convertFormatted(String fromUnit, String toUnit, Double inputValue) {
        Double result = convert(fromUnit, toUnit, inputValue);
        return df.format(result);
    }

}
