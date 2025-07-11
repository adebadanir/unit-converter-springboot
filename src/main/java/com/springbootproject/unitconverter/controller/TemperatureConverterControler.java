package com.springbootproject.unitconverter.controller;

import com.springbootproject.unitconverter.dto.ApiRequestDto;
import com.springbootproject.unitconverter.dto.ApiResponseDto;
import com.springbootproject.unitconverter.dto.ExceptionResponseDto;
import com.springbootproject.unitconverter.model.Converter;
import com.springbootproject.unitconverter.service.TemperatureConverterService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/temperature")
public class TemperatureConverterControler {
    private final TemperatureConverterService temperatureConverterService = new TemperatureConverterService();

    @GetMapping("/convert")
    public ResponseEntity<?> convert(@RequestBody ApiRequestDto requestDto) {
        try{
            String outputValue = temperatureConverterService.convertFormatted(requestDto.getFromUnit(), requestDto.getToUnit(), requestDto.getInputValue());
            Converter converter = new Converter(requestDto.getFromUnit(), requestDto.getToUnit(), requestDto.getInputValue(), outputValue);
            return ResponseEntity.ok(new ApiResponseDto(400, "Success", converter));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ExceptionResponseDto( 500,(e.getMessage())));
        }
    }
}
