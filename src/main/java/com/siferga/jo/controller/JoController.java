package com.siferga.jo.controller;

import com.siferga.jo.service.JoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JoController {
    private  final JoService joService;


    public JoController(JoService joService) {
        this.joService = joService;
    }
    @GetMapping("/callProcedure")
    public List<Map<String, Object>> callSp(@RequestParam int year) {
        return joService.callSpJoPaysRankedForYear(year);
    }
    @GetMapping("/chart")
    public List<Map<String, Object>> getChartData(@RequestParam int year) {
        return joService.callSpJoPaysRankedForYear(year);
    }

}
