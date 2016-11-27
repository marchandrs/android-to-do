package com.marchand.hellou;

import android.app.Application;

import com.marchand.hellou.models.Todo;

import org.joda.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 11/11/16.
 */

public final class App extends Application {

    public static String EXTRA_ID = "ID";
    private List<Todo> todoList = null;

    @Override
    public void onCreate(){
        super.onCreate();
    }

    public List<Todo> getTodoList() {
        if (todoList == null) {
            todoList = getTodoListForTest();
        }

        return todoList;
    }

    private List<Todo> getTodoListForTest() {
        List list = new ArrayList();

        for(int i = 0; i < 100; i++) {
            Todo todo = new Todo();
            todo.setId(i);
            todo.setAuthor("Alex Marchand");
            todo.setTitle("To-do list example");
            todo.setCreatedAt(new LocalDateTime(2016, 11, 11, 0, 0));
            list.add(todo);
        }

        return list;
    }

}
