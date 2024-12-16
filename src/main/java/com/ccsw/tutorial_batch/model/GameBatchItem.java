package com.ccsw.tutorial_batch.model;

public class GameBatchItem {

    private String title;
    private boolean inStock;

    public GameBatchItem() {
    }

    public GameBatchItem(String title, boolean inStock) {
        this.title = title;
        this.inStock = inStock;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        String availability = (inStock) ? "Available" : "Unavailable";
        return "Title='" + title + '\'' + ", stock=" + availability;
    }
}
