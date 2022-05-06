package com.example.proto.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Film {

    @Id
    private Integer id;

    @NotEmpty
    private String title;

    @NotNull
    @DateTimeFormat(pattern="dd.MM.yyyy")
    private Date date;

    private Boolean seen;


    @SuppressWarnings("unused")
    public Film(){}

    public Film(int id, String title, Date date, boolean seen){
        this.id = id;
        this.title = title;
        this.date = date;
        this.seen = seen;
    }

    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public Date getDate(){
        return date;
    }
    public void setDate(Date date){
        this.date = date;
    }

    public Boolean getSeen(){
        return seen;
    }
    public void setSeen(Boolean seen){
        this.seen = seen;
    }

    public String toString(){
        return String.format("Title: %s  Date: %s   Seen: %s", title, date, seen);
//        return "Title: " + title + "  Date: " + date + "   Seen: " + seen ;
    }

}
