package com.marchand.hellou.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.marchand.hellou.OnDetailTodoClickListener;
import com.marchand.hellou.R;
import com.marchand.hellou.models.Todo;

import java.util.List;

/**
 * Created by alex on 11/11/16.
 */
public class TodoListAdapter extends RecyclerView.Adapter {

    private List<Todo> todoList;
    private LayoutInflater inflater;
    private OnDetailTodoClickListener onDetailTodoClickListener;

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitle;
        TextView txtCreatedAt;
        TextView txtUpdatedAt;

        ViewHolder(View v) {
            super(v);
            txtTitle = (TextView) v.findViewById(R.id.txtTodoTitle);
            //txtCreatedAt = (TextView) v.findViewById(R.id.txtTodoCreatedAt);
            txtUpdatedAt = (TextView) v.findViewById(R.id.txtTodoUpdatedAt);
        }

        void bind(final Todo todo, final OnDetailTodoClickListener listener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onEditItemClickListener(todo);
                }
            });
        }
    }

    public TodoListAdapter(List<Todo> todoList, LayoutInflater inflater, OnDetailTodoClickListener onDetailTodoClickListener) {
        this.todoList = todoList;
        this.inflater = inflater;
        this.onDetailTodoClickListener = onDetailTodoClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_main_todo, parent, false);
        View view = inflater.inflate(R.layout.row_main_todo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh = (ViewHolder) holder;
        Todo todo = todoList.get(position);
        vh.txtTitle.setText(todo.getTitle());

        StringBuilder sb = new StringBuilder();
        sb.append("Editada em: ");
        sb.append(todo.getCreatedAt().toString("d/M/y"));
        vh.txtUpdatedAt.setText(sb.toString());

        sb = new StringBuilder();
        sb.append("Criada em: ");
        sb.append(todo.getCreatedAt().toString("d/M/y"));
        //vh.txtCreatedAt.setText(sb.toString());

        vh.bind(todoList.get(position), onDetailTodoClickListener);
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }
}
