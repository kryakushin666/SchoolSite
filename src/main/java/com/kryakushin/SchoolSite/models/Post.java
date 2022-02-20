package com.kryakushin.SchoolSite.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title, anons, full_text, type, url, date;
    private int views;

    public Post(String title, String anons, String full_text, String url, String date) {
        this.title = title;
        this.anons = anons;
        this.full_text = full_text;
        this.url = url;
        this.date = date;
    }

    public Post() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnons() {
        return anons;
    }

    public void setAnons(String anons) {
        this.anons = anons;
    }

    public String getFull_text() {return full_text; }

    public void setFull_text(String full_text) {
        this.full_text = full_text;
    }

    public void setDate(String date) { this.date = date;}

    public String getDate() { return date; }

    public void setUrl(String url) { this.url = url;}

    public String getUrl() { return url; }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

}
