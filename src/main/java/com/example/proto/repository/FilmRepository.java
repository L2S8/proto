package com.example.proto.repository;

import com.example.proto.domain.Film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface FilmRepository extends CrudRepository<Film, Integer> {

    public List<Film> findAllByTitle(String title);
    public List<Film> findAllByDate(Date date);
    public List<Film> findAllBySeen(boolean seen);

}
