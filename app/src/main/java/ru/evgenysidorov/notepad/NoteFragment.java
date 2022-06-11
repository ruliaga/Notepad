package ru.evgenysidorov.notepad;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class NoteFragment extends Fragment {

    private Note [] notes;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_note, container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initList (view);
    }
    private void initList(View view){
        Note [] notes=new Note [3];
        notes [0]=new Note("Встретиться с друзьями в субботу");
        notes [1]=new Note("Купить хлеб и молоко");
        notes [2]=new Note("Постричься до субботы");
        LinearLayout linearLayout = (LinearLayout) view;
        for (Note note: notes){
          TextView tv= new TextView(getContext());
          tv.setText(note.getnTitle().toString());
          tv.setTextSize(30);
          linearLayout.addView(tv);
       }

    }

}





