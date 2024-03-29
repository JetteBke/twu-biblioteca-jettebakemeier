package com.twu.biblioteca.Movies;

import java.time.Year;

public class Movie {

    private String title;
    private String director;
    private Year year;
    private String rating = "unrated";
    private Boolean checkedOut = false;

    public Movie(String title, String director, Year year) {
        this.title = title;
        this.director = director;
        this.year = year;
    }

    public Movie(String title, String director, String year) {
        this(title, director, Year.parse(year));
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public Year getYear() {
        return year;
    }

    public String getRating() {
        return rating;
    }

    public Boolean getCheckedOut() {
        return checkedOut;
    }

    public void checkOutMovie() {
        checkedOut = true;
    }

    public void returnMovie() { checkedOut = false; }

    @Override
    public String toString() {
        return "Movie info - title: " + this.title + ", director: " + this.director + ", year: " + this.year + " rating; " + this.rating + ", checked out: " + this.checkedOut;
    }
}
