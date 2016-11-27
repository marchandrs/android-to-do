package com.marchand.hellou.models;

import java.util.Date;

/**
 * Created by alex on 11/11/16.
 */

public class TodoItem {

    private int id;
    private String author;
    private String text;
    private boolean checked;
    private Date createdAt;
    private Date updatedAt;

    public TodoItem() {
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public void setText(String text) {
        this.text = text;
    }
}
