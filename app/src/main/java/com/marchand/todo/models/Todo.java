package com.marchand.todo.models;

import com.orm.SugarRecord;
import com.orm.dsl.Ignore;

import org.joda.time.LocalDateTime;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by alex on 11/11/16.
 */

public class Todo extends SugarRecord{

    //private int sortOrder;
    //private String author;
    private String title;
    @Ignore
    private List<TodoItem> items;
    private Date createdAt;
    private Date updatedAt;

    public Todo() {
        items = null;
    }

    /*
    public Todo findByIdOrCreateNew(Long id){
        Todo todo;
        if (id == 0) {
            todo = new Todo();
        } else {
            todo = Todo.findById(Todo.class, id);
        }
        return todo;
    }
    */

    /*
    public String getAuthor() {
        return author;
    }
    */

    public String getTitle() {
        return title;
    }

    public List<TodoItem> getItems(){
        return getItems(false);
    }

    public List<TodoItem> getItems(boolean refresh) {
        if (items == null || refresh) {
            items = TodoItem.find(TodoItem.class, "todo = ?", String.valueOf(getId()));
        }
        return items;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    /*
    public int getSortOrder() {
        return sortOrder;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    */

    public void setTitle(String title) {
        this.title = title;
    }

    public void setItems(List<TodoItem> items) {
        this.items = items;
    }

    /*
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }
    */

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
