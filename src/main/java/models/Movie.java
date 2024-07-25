/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 *
 * @author MSII
 */
@Entity
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int id;
    @Column(unique = true, nullable = false)
    private String code;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    @ElementCollection
    private List<String> genre;
    @ElementCollection
    @Column(nullable = false)
    private List<String> director;
    @Column(nullable = false)
    @ElementCollection
    private List<String> cast;
    @OneToMany(mappedBy = "movie")
    private Set<Showtimes> showTimes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public List<String> getDirector() {
        return director;
    }

    public void setDirector(List<String> director) {
        this.director = director;
    }

    public List<String> getCast() {
        return cast;
    }

    public void setCast(List<String> cast) {
        this.cast = cast;
    }

    public Movie(String code, String name, List<String> genre, List<String> director, List<String> cast) {
        this.code = code;
        this.name = name;
        this.genre = genre;
        this.director = director;
        this.cast = cast;
    }

    public Movie() {
    }

    public Set<Showtimes> getShowTimes() {
        return showTimes;
    }

    public void setShowTimes(Set<Showtimes> showTimes) {
        this.showTimes = showTimes;
    }
}
