package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    @Size(min = 1, max = 50)
    private String director;

    @NotEmpty
    @Size(min = 1, max = 50)
    private String title;

    @NotEmpty
    @Size(min = 1, max = 140)
    private String plot;

    @NotNull
    @Size(min = 4)
    private int releaseYear;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", director='" + director + '\'' +
                ", title='" + title + '\'' +
                ", plot='" + plot + '\'' +
                ", releaseYear=" + releaseYear +
                '}';
    }
}
