package com.siferga.jo.controller;

import com.siferga.jo.service.JoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
public class JoController {
    private  final JoService joService;


    public JoController(JoService joService) {
        this.joService = joService;
    }

    @GetMapping("/chart")
    public List<Map<String, Object>> getChartData(@RequestParam int year) {
        return joService.paysRankedForYear(year);
    }
    @GetMapping("/callProcedure")
    public ModelAndView callSp(@RequestParam int year) {
        String jsonData = joService.convertListMapToJson(joService.paysRankedForYear(year));
        return new ModelAndView("chart", "jsonData", jsonData);
    }

}
