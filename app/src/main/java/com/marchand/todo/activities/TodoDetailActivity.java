package com.marchand.todo.activities;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.marchand.todo.App;
import com.marchand.todo.ITodo;
import com.marchand.todo.OnAddTodoItemListener;
import com.marchand.todo.R;
import com.marchand.todo.fragments.TodoDetailFragment;
import com.marchand.todo.models.Todo;
import com.marchand.todo.models.TodoItem;

import java.util.Date;

public class TodoDetailActivity extends AppCompatActivity implements ITodo, OnAddTodoItemListener {

    private Todo todo;

    private Todo getTodo(Long id) {
        if (id == 0) {
            todo = new Todo();
            todo.setCreatedAt(new Date());
            todo.setUpdatedAt(new Date());
            todo.save();
        } else {
            todo = Todo.findById(Todo.class, id);
        }

        return todo;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_detail);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        todo = getTodo(getIntent().getLongExtra(App.EXTRA_ID, 0));
        //Todo = Todo.findById(Todo.class, getIntent().getLongExtra(App.EXTRA_ID, 0));

        if (savedInstanceState == null) {
            TodoDetailFragment fragment = TodoDetailFragment.newInstance("", "");
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().add(R.id.container, fragment).commit();
        }
    }

    public Todo getTodo() {
        return this.todo;
    }

    @Override
    public void addTodoItem(Todo todo) {
        TodoItem item = new TodoItem();
        todo.getItems().add(item);
        todo.save();
    }
}
