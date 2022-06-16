package ru.evgenysidorov.notepad;


import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NoteDescriptionFragment extends Fragment {

    static final String ARG_INDEX = "index";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState!=null){
            requireActivity().getSupportFragmentManager().popBackStack();
        }


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      setHasOptionsMenu(true);
       return inflater.inflate(R.layout.fragment_note_description,container,false);



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button deleteButton = requireActivity().findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(v -> {
            Toast.makeText(getContext(),"Заметка удалена",Toast.LENGTH_SHORT).show();
        });
        if(savedInstanceState!=null){
            requireActivity().getSupportFragmentManager().popBackStack();
        }
        Note [] notes=new Note [3];
        notes [0]=new Note("Встреча в субботу","На набережной в 18.00, встреча однокурсников");
        notes [1]=new Note("Купить вечером","Хлеб и молоко");
        notes [2]=new Note("Важно!!!","До субботы сходить в парикмахерскую");
        Bundle arguments = getArguments();
        if (arguments!=null){
            int index = arguments.getInt(ARG_INDEX);
            TextView tv = view.findViewById(R.id.text_description);
            tv.setText(notes[index].getnDescription().toString());
            tv.setTextSize(30);



        }
    }

    public static NoteDescriptionFragment newInstance (int index){
        NoteDescriptionFragment fragment = new NoteDescriptionFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_INDEX,index);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        MenuItem item = menu.findItem(R.id.about);
        if (item != null) {
            item.setVisible(false);
        }
    }
}

