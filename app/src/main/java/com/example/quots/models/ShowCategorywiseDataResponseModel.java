package com.example.quots.models;

public class ShowCategorywiseDataResponseModel {

    String quots, author;

    public ShowCategorywiseDataResponseModel(String quots, String author) {
        this.quots = quots;
        this.author = author;
    }

    public String getQuots() {
        return quots;
    }

    public void setQuots(String quots) {
        this.quots = quots;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
