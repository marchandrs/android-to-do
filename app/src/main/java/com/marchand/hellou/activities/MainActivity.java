package com.marchand.hellou.activities;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.marchand.hellou.App;
import com.marchand.hellou.R;
import com.marchand.hellou.fragments.MainFragment;

public class MainActivity extends AppCompatActivity implements MainFragment.OnTodoDetail {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);


        if (savedInstanceState == null) {
            MainFragment fragment = MainFragment.newInstance("", "");
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().add(R.id.container, fragment).commit();
        }
    }

    @Override
    public void onTodoDetail(int id) {
        Intent intent = new Intent(this, TodoDetailActivity.class);
        // maybe send id when the intention is to edit an existing ToDoList?
        // send id 0 or null when is a new TodoList?
        //intent.putExtra(EXTRA_MESSAGE, message);
        intent.putExtra(App.EXTRA_ID, id);
        startActivity(intent);
    }
}
