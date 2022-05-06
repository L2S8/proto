package com.example.proto.controller;

import com.example.proto.domain.Film;
import com.example.proto.service.FilmService;
import com.example.proto.service.TeamsAPIService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class FormularController {

    private static final Logger log = LoggerFactory.getLogger(FormularController.class);

    private TeamsAPIService apiService;
    private FilmService service;

    public FormularController(FilmService service, TeamsAPIService APIservice){
        this.service = service;
        this.apiService = APIservice;
        this.service.saveOrUpdate(new Film(0, "test0", new Date(),true));
        this.service.saveOrUpdate(new Film(1, "test1", new Date(),false));
        this.service.saveOrUpdate(new Film(2, "test2", new Date(),true));
        this.service.saveOrUpdate(new Film(3, "same", new Date(),false));
        this.service.saveOrUpdate(new Film(4, "same", new Date(),true));

    }

    @GetMapping(path="/edit/view/{id}")
    public String edit(@PathVariable("id") int id, Model model){
        model.addAttribute("film", service.getFilmById(id));
        model.addAttribute("title", "Edit Message");
        model.addAttribute("redirect", "/edit/put");
        model.addAttribute("type","edit");
        return "baseFormular";
    }

    @PostMapping( path = "/edit/put")
    public String edit(@ModelAttribute @Valid Film film, BindingResult bindingResult, Model model){
        if( bindingResult.hasErrors() ) {
            model.addAttribute("title", "Edit Message");
            model.addAttribute("type","edit");
            return "baseFormular";
        } else {
            service.edit(film.getId(), film);
            return "sent";
        }
    }

    @GetMapping(path="/delete/{id}")
    public String delete(@PathVariable("id") int id, Model model){
        service.deleteFilmById(id);
        //apiService.sendWebhook();
        Film film = apiService.sendWebhook();
        return "redirect:/viewAll";
    }

    @GetMapping(path = "/formular/view")
    public String post(Model model){
        model.addAttribute("film", new Film());
        model.addAttribute("title", "Send Message");
        model.addAttribute("redirect","/formular/post");
        model.addAttribute("type", "post");
        return "baseFormular";
    }

    @PostMapping( path = "/formular/post")
    public String post(@ModelAttribute @Valid Film film, BindingResult bindingResult, Model model){
        if( bindingResult.hasErrors() ) {
            model.addAttribute("title", "Send Message");
            model.addAttribute("type", "post");
            return "baseFormular";
        } else {
            service.saveOrUpdate(film);
            //log.error("Uebergebener Film:{}", film);
            return "sent";
        }
    }

    @RequestMapping("/viewAll")
    public String viewAll(Model model){
        model.addAttribute("filmList",service.getAllFilms());
        return "viewAll";
    }
}
