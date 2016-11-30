package com.marchand.todo.models;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by alex on 11/11/16.
 */

public class TodoItem extends SugarRecord {

    private Todo todo;
    //private String author;
    private String text;
    private boolean checked;
    //private Date createdAt;
    //private Date updatedAt;

    public TodoItem() {
    }

    /*
    public String getAuthor() {
        return author;
    }
    */

    public String getText() {
        return text;
    }

    /*
    public Date getCreatedAt() {
        return createdAt;
    }
    */

//    public Date getUpdatedAt() {
//        return updatedAt;
//    }

    public boolean isChecked() {
        return checked;
    }

    public Todo getTodo() {
        return todo;
    }

    public void setTodo(Todo todo) {
        this.todo = todo;
    }

//    public void setAuthor(String author) {
//        this.author = author;
//    }

//    public void setCreatedAt(Date createdAt) {
//        this.createdAt = createdAt;
//    }

//    public void setUpdatedAt(Date updatedAt) {
//        this.updatedAt = updatedAt;
//    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public void setText(String text) {
        this.text = text;
    }
}
