package com.springbootproject.unitconverter.dto;

public class ApiRequestDto {
    private String fromUnit;
    private String toUnit;
    private Double inputValue;

    public ApiRequestDto(String fromUnit, String toUnit, Double inputValue) {
        this.fromUnit = fromUnit;
        this.toUnit = toUnit;
        this.inputValue = inputValue;
    }

    public String getFromUnit() {
        return fromUnit;
    }

    public void setFromUnit(String fromUnit) {
        this.fromUnit = fromUnit;
    }

    public String getToUnit() {
        return toUnit;
    }

    public void setToUnit(String toUnit) {
        this.toUnit = toUnit;
    }

    public Double getInputValue() {
        return inputValue;
    }

    public void setInputValue(Double inputValue) {
        this.inputValue = inputValue;
    }
}
