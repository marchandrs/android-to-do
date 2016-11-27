package com.marchand.hellou.activities;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.marchand.hellou.App;
import com.marchand.hellou.ITodo;
import com.marchand.hellou.OnAddTodoItemListener;
import com.marchand.hellou.R;
import com.marchand.hellou.fragments.TodoDetailFragment;
import com.marchand.hellou.models.Todo;
import com.marchand.hellou.models.TodoItem;

public class TodoDetailActivity extends AppCompatActivity implements ITodo, OnAddTodoItemListener {

    private Todo todo;

    private Todo getTodo(int id) {
        Todo todo = new Todo();

        if (id == 0) {
        // new Todolist?
            todo.setId(7);
            todo.setTitle("teste");
        } else {
        // fetch existing todolist?
            todo.setId(id);
        }

        return todo;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_detail);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        todo = getTodo(getIntent().getIntExtra(App.EXTRA_ID, 0));

        if (savedInstanceState == null) {
            TodoDetailFragment fragment = TodoDetailFragment.newInstance("", "");
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().add(R.id.container, fragment).commit();
        }
    }

    @Override
    public Todo getTodo() {
        return this.todo;
    }

    @Override
    public void addTodoItem(Todo todo) {
        TodoItem item = new TodoItem();
        item.setText("teste");
        item.setChecked(true);
        todo.getItems().add(item);
    }
}
