package com.marchand.hellou.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.marchand.hellou.App;
import com.marchand.hellou.ITodo;
import com.marchand.hellou.OnAddTodoItemListener;
import com.marchand.hellou.R;
import com.marchand.hellou.adapters.TodoItemAdapter;
import com.marchand.hellou.adapters.VerticalSpaceItemDecoration;
import com.marchand.hellou.models.Todo;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TodoDetailFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TodoDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TodoDetailFragment extends Fragment {
    private static final int VERTICAL_ITEM_SPACE = 48;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnAddTodoItemListener mListener;
    private ITodo iTodo;

    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    private TextView txtTitle;
    private TextView txtUpdatedAt;
    private TextView txtCreatedAt;

    public TodoDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TodoDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TodoDetailFragment newInstance(String param1, String param2) {
        TodoDetailFragment fragment = new TodoDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final Todo todo = iTodo.getTodo();

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_todo_detail, container, false);

        txtTitle = (TextView) v.findViewById(R.id.fragment_detail_txtTitle);
        txtUpdatedAt = (TextView) v.findViewById(R.id.fragment_detail_txtUpdatedAt);
        txtCreatedAt = (TextView) v.findViewById(R.id.fragment_detail_txtCreatedAt);

        recyclerView = (RecyclerView) v.findViewById(R.id.fragment_detail_recyclerView);
        App app = (App) getActivity().getApplication();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new TodoItemAdapter(todo, inflater));
        recyclerView.addItemDecoration(new VerticalSpaceItemDecoration(VERTICAL_ITEM_SPACE));

        txtTitle.setText(todo.getTitle());

        fab = (FloatingActionButton) v.findViewById(R.id.fragment_detail_fab_add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.addTodoItem(todo);
                recyclerView.getAdapter().notifyDataSetChanged();
            }
        });

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        /*
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
        */
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnAddTodoItemListener) {
            mListener = (OnAddTodoItemListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnAddTodoItemListener");
        }

        if (context instanceof ITodo) {
            iTodo = (ITodo) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement ITodo");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        iTodo = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
