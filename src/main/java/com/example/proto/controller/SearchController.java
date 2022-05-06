package com.example.proto.controller;

import com.example.proto.domain.Film;
import com.example.proto.service.FilmService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashSet;
import java.util.List;

@Controller
public class SearchController {
    private FilmService service;

    public SearchController(FilmService service){
        this.service = service;
    }

    @GetMapping(path = "/search/view")
    public String post(Model model){

        model.addAttribute("film", new Film() );

        return "search";
    }

    @PostMapping( path = "/search/post")
    public String search(@ModelAttribute Film film, Model model){
        HashSet<Film> filmHashSet = service.searchFilm(film);
        model.addAttribute("filmHashSet", filmHashSet);

        return "searchResult";
    }
}
