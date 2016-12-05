package com.marchand.todo.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.marchand.todo.OnDetailTodoClickListener;
import com.marchand.todo.R;
import com.marchand.todo.models.Todo;

import org.joda.time.LocalDateTime;

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
        ImageButton btnDelete;

        ViewHolder(View v) {
            super(v);
            txtTitle = (TextView) v.findViewById(R.id.txtTodoTitle);
            //txtCreatedAt = (TextView) v.findViewById(R.id.txtTodoCreatedAt);
            txtUpdatedAt = (TextView) v.findViewById(R.id.txtTodoUpdatedAt);
            btnDelete = (ImageButton) v.findViewById(R.id.btn_delete);
            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Todo todo = todoList.get(getAdapterPosition());
                    todo.delete();
                    todoList.remove(getAdapterPosition());
                    notifyDataSetChanged();
                }
            });
        }

        void bind(final Todo Todo, final OnDetailTodoClickListener listener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onEditItemClickListener(Todo);
                }
            });
        }
    }

    public TodoListAdapter(List<Todo> todoList, LayoutInflater inflater, OnDetailTodoClickListener onDetailTodoClickListener) {
        this.todoList = todoList;
        this.inflater = inflater;
        this.onDetailTodoClickListener = onDetailTodoClickListener;
    }

    public void setTodoList(List<Todo> list) {
        this.todoList = list;
        notifyDataSetChanged();
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

        if (todo.getTitle() != null && todo.getTitle().length() > 0) {
            vh.txtTitle.setText(todo.getTitle());
        }

        StringBuilder sb = new StringBuilder();

        if (todo.getUpdatedAt() != null) {
            sb.append("Editada em: ");
            sb.append(new LocalDateTime().fromDateFields(todo.getUpdatedAt()).toString("d/M/y"));
            vh.txtUpdatedAt.setText(sb.toString());
        }

        if (todo.getCreatedAt() != null) {
            sb = new StringBuilder();
            sb.append("Criada em: ");
            sb.append(new LocalDateTime().fromDateFields(todo.getCreatedAt()).toString("d/M/y"));
            //vh.txtCreatedAt.setText(sb.toString());
        }

        vh.bind(todoList.get(position), onDetailTodoClickListener);
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }
}
