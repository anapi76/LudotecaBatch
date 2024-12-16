package com.ccsw.tutorial_batch.model;

public class Game {

    private Long id;
    private String title;
    private int age;
    private int stock;

    public Game() {
    }

    public Game(String title, int age, int stock) {
        this.title = title;
        this.age = age;
        this.stock = stock;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Game [ title='" + title + '\'' + ", age=" + age + ", stock=" + stock + ']';
    }
}
