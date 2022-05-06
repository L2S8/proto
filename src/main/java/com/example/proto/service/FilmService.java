package com.example.proto.service;

import com.example.proto.domain.Film;
import com.example.proto.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Service
public class FilmService {
    FilmRepository repo;

    public FilmService(FilmRepository repo){
        this.repo = repo;
    }

    public Film getFilmById(int id) {
        return repo.findById(id).get();
    }
    public List<Film> getFilmsByTitle(String title){
        return repo.findAllByTitle(title);
    }
    public List<Film> getFilmsByDate(Date date){
        return repo.findAllByDate(date);
    }
    public List<Film> getFilmsBySeen(boolean seen){
        return repo.findAllBySeen(seen);
    }

    public List<Film> getAllFilms(){
        return (List<Film>)repo.findAll();
    }

    public Film saveOrUpdate(Film film) {
        return repo.save(film);
    }

    public void edit(int id, Film film) {
        Film oldFilm = getFilmById(id);
        oldFilm.setTitle(film.getTitle());
        oldFilm.setDate(film.getDate());
        oldFilm.setSeen(film.getSeen());

        repo.save(oldFilm);
    }

    public void deleteFilmById(int id) {
        repo.deleteById(id);
    }

    public HashSet<Film> searchFilm(Film film){
        HashSet<Film> films = new HashSet<>();
        HashSet<Film> tmp = new HashSet<>();
        if(film.getId() != null){
            films.add(getFilmById(film.getId()));
            return films;
        }
        films.addAll(getAllFilms());

        if(film.getTitle()!=null && !film.getTitle().isEmpty()){
            tmp.addAll(getFilmsByTitle(film.getTitle()));
            films.retainAll(tmp);
            tmp.clear();
        }
        if(film.getDate() != null){
            tmp.addAll(getFilmsByDate(film.getDate()));
            films.retainAll(tmp);
            tmp.clear();
        }

            tmp.addAll(getFilmsBySeen(film.getSeen()));
            films.retainAll(tmp);
            tmp.clear();


        return films;
    }
}
