package com.example.proto.service;

import com.example.proto.domain.Film;
import com.example.proto.exception.ServiceException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
public class TeamsAPIService {

    WebClient webClient;


    public TeamsAPIService(){
       this.webClient=WebClient.builder()
                .baseUrl("http://localhost:8080")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .filter(WebClientFilter.logRequest())
                .filter(WebClientFilter.logResponse())
                .filter(WebClientFilter.handleError())
                .build();
    }

    public Film sendWebhook() {
        Film film = new Film(8, "webhook", new Date(), true);
        try {
            return webClient.post()
                    .uri("/roster/film")
                    .body(Mono.just(film), Film.class)
                    .retrieve()
                    .bodyToMono(Film.class)
                    .block();
        } catch (WebClientResponseException we){
            throw new ServiceException(we.getMessage(), we.getRawStatusCode());
        }
    }

}
