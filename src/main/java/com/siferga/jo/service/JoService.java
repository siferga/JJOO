package com.siferga.jo.service;

import com.siferga.jo.repository.JoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class JoService {
    private final JoRepository joRepository;
    @Autowired
    public JoService(JoRepository joRepository) {
        this.joRepository = joRepository;
    }

    public List<Map<String, Object>> callSpJoPaysRankedForYear(int year) {
        return joRepository.callSpJoPaysRankedForYear(year);
    }
    public List<Map<String, Object>> getDataFromDatabase() {
        return joRepository.findAll(); // Exemple simple de récupération de toutes les données
    }


}



