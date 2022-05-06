package com.example.proto.config;

import com.example.proto.domain.Film;
import com.example.proto.service.TeamsAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ApplicationListenerInitialize implements ApplicationListener<ApplicationReadyEvent>  {

    @Autowired
    private TeamsAPIService teamsService;

    public void onApplicationEvent(ApplicationReadyEvent event) {
        Film film = teamsService.sendWebhook();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
            System.err.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(film));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}