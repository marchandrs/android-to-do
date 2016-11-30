package com.marchand.todo;

import com.marchand.todo.models.Todo;
import com.orm.SugarApp;

import org.joda.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 11/11/16.
 */

public final class App extends SugarApp {

    public static String EXTRA_ID = "ID";
    private List<Todo> todoList = null;

    @Override
    public void onCreate(){
        super.onCreate();
        Todo.findById(Todo.class, 1);
        //teste();
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
            Todo Todo = new Todo();
            Todo.setTitle("To-do list example");
            Todo.setCreatedAt(new LocalDateTime(2016, 11, 11, 0, 0).toDate());
            list.add(Todo);
        }

        return list;
    }

    /*
    private void teste(){
        TesteItem item = new TesteItem();
        item.setAbc("abc");

        Teste t = new Teste();
        t.setName("a");
        t.setItems(new ArrayList<TesteItem>());
        t.getItems().add(item);
        t.save();

        Toast.makeText(this, "salvou", Toast.LENGTH_SHORT).show();

        Teste t2 = Teste.findById(Teste.class, 1);

        Toast.makeText(this, "encontrou", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, t2.getItems().get(0).getAbc(), Toast.LENGTH_LONG).show();
    }
    */

}
