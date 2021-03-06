package com.codecool.web.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "employer_ratings")
public class EmployerRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rater_id")
    @JsonBackReference(value = "user-employer-rating")
    @NotNull
    private User rater;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rated_id")
    @JsonBackReference(value = "user-rated-employer")
    @NotNull
    private User rated;

    @NotNull
    private int rating;

    public EmployerRating() {
    }

    public EmployerRating(@NotNull User rater, @NotNull User rated, @NotNull int rating) {
        this.rater = rater;
        this.rated = rated;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public User getRater() {
        return rater;
    }

    public void setRater(User rater) {
        this.rater = rater;
    }

    public User getRated() {
        return rated;
    }

    public void setRated(User rated) {
        this.rated = rated;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
