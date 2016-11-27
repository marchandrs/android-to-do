package com.marchand.hellou.models;

import org.joda.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 11/11/16.
 */

public class Todo {

    private int id;
    private int order;
    private String author;
    private String title;
    private List<TodoItem> items;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Todo() {
        items = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public List<TodoItem> getItems() {
        return items;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public int getOrder() {
        return order;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setItems(List<TodoItem> items) {
        this.items = items;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
