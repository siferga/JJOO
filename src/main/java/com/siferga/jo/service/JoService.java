package com.siferga.jo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.siferga.jo.repository.JoRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    //procédure stockée aui récupére une liste de maps représentant les rémunérations classées pour une année donnée

    public List<Map<String, Object>> paysRankedForYear(int year) {
        //La méthode renvoie une liste de maps.
        return joRepository.callSpJoPaysRankedForYear(year);
    }
    //méthode qui convertit une liste de maps en une chaîne JSON utilisant ObjectMapper de Jackson.
    // Chaque map dans la liste représente une ligne de données, où les clés sont les noms de colonnes et les valeurs sont les valeurs de colonnes.
    // Si la conversion échoue, elle imprime la trace de la pile et renvoie null.
    public String convertListMapToJson(List<Map<String, Object>> list) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(list);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}



