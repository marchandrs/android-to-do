package com.marchand.hellou.adapters;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;

import com.marchand.hellou.R;
import com.marchand.hellou.models.Todo;
import com.marchand.hellou.models.TodoItem;

/**
 * Created by alex on 20/11/16.
 */

public class TodoItemAdapter extends Adapter {

    private Todo todo;
    private LayoutInflater inflater;

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageButton btnDelete;
        CheckBox chkTodo;
        EditText edtText;


        ViewHolder(View view) {
            super(view);
            chkTodo = (CheckBox) view.findViewById(R.id.chkTodo);
            chkTodo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    TodoItem item = todo.getItems().get(getAdapterPosition());
                    item.setChecked(b);
                }
            });
            btnDelete = (ImageButton) view.findViewById(R.id.btnDelete);
            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    todo.getItems().remove(getAdapterPosition());
                    notifyDataSetChanged();
                }
            });
            edtText = (EditText) view.findViewById(R.id.edtText);
            edtText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //do nothing
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //do nothing
                }

                @Override
                public void afterTextChanged(Editable editable) {
                    TodoItem item = todo.getItems().get(getAdapterPosition());
                    item.setText(editable.toString());
                }
            });
        }
    }


    public TodoItemAdapter(Todo todo, LayoutInflater inflater) {
        this.todo = todo;
        this.inflater = inflater;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_detail_todo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh = (ViewHolder) holder;
        TodoItem item = todo.getItems().get(position);
        vh.edtText.setText(item.getText());
        vh.chkTodo.setChecked(item.isChecked());
    }

    @Override
    public int getItemCount() {
        return todo.getItems().size();
    }
}
