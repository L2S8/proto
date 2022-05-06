package com.example.proto.controller;

import com.example.proto.domain.Film;
import com.example.proto.service.FilmService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/roster")
public class FilmController {
    private FilmService service;

    public FilmController(FilmService service){
        this.service = service;
    }

    @GetMapping("/films")
    public List<Film> getAllFilms(){
        return service.getAllFilms();
    }

    @GetMapping("/film/{id}")
    public Film getFilm(@PathVariable("id") int id){
        return service.getFilmById(id);
    }

    @DeleteMapping("/delete/film/{id}")
    public void deleteFilm(@PathVariable("id") int id){
        service.deleteFilmById(id);
    }


    @PostMapping("/film")
    public Film addFilm(@RequestBody Film film){
        return service.saveOrUpdate(film);
    }

    @PutMapping("/edit/film/{id}")
    public void editFilm(@PathVariable("id") int id, @RequestBody Film film){
        service.edit(id, film);
    }
}
