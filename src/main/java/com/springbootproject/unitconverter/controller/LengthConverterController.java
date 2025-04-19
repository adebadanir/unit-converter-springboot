package com.springbootproject.unitconverter.controller;

import com.springbootproject.unitconverter.dto.ApiResponseDto;
import com.springbootproject.unitconverter.dto.ExceptionResponseDto;
import com.springbootproject.unitconverter.dto.ApiRequestDto;
import com.springbootproject.unitconverter.model.LengthConverter;
import com.springbootproject.unitconverter.service.LengthConverterService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/length")
public class LengthConverterController {
    private final LengthConverterService lengthConverterService = new LengthConverterService();

    @GetMapping("/convert")
    public ResponseEntity<?> convert(@RequestBody ApiRequestDto requestDto) {
        try{
            String outputValue = lengthConverterService.convertFormatted(requestDto.getFromUnit(), requestDto.getToUnit(), requestDto.getInputValue());
            LengthConverter lengthConverter = new LengthConverter(requestDto.getFromUnit(), requestDto.getToUnit(), requestDto.getInputValue(), outputValue);
            return ResponseEntity.ok(new ApiResponseDto(400, "Success", lengthConverter));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ExceptionResponseDto( 500,(e.getMessage())));
        }
    }
}
