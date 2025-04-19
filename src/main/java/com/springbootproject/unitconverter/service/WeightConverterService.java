package com.springbootproject.unitconverter.service;

import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.HashMap;

@Service
public class WeightConverterService {
    private final DecimalFormat df = new DecimalFormat("#.#########");

    private final HashMap<String, Double> unitMap = new HashMap<>();
    public WeightConverterService() {
        unitMap.put("miligram", 0.001);
        unitMap.put("gram", 1.0);
        unitMap.put("kilogram", 1000.0);
        unitMap.put("ounce", 28.3495);
        unitMap.put("pound", 453.592);
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
