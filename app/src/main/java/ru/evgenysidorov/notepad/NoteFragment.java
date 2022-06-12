package ru.evgenysidorov.notepad;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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
    private static final String CURRENT_NOTE="CurrentCity";
    private int currentPosition = 0;



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
        if (savedInstanceState!=null){
            currentPosition=savedInstanceState.getInt(CURRENT_NOTE,0);
                    }


        initList (view);

        if (isLandscape()){
            showLandNoteDescription(currentPosition);
        }

    }
    public void initList(View view){
        Note [] notes=new Note [3];
        notes [0]=new Note("1. Встреча в субботу","На набережной в 18.00, встреча однокурсников");
        notes [1]=new Note("2. Купить вечером","Хлеб и молоко");
        notes [2]=new Note("3. Важно!!!","До субботы сходить в парикмахерскую");
        LinearLayout linearLayout = (LinearLayout) view;
        for (int i=0; i<notes.length;i++){
          Note note = notes[i];
          TextView tv= new TextView(getContext());
          tv.setText(note.getnTitle().toString());
          tv.setTextSize(30);
          linearLayout.addView(tv);
          final int position = i;
          tv.setOnClickListener(v->{
              currentPosition=position;
              showNoteDescription(position);
          });
       }

    }

    private void showNoteDescription (int index){
        if (isLandscape()){
    showLandNoteDescription(index);
        } else {
    showPortNoteDescription(index);
        }
    }


    private void showPortNoteDescription (int index){
        NoteDescriptionFragment noteDescriptionFragment=NoteDescriptionFragment.newInstance(index);
        FragmentManager fragmentManager=requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentContainer,noteDescriptionFragment);
        fragmentTransaction.addToBackStack("");
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();
    }
private void showLandNoteDescription (int index){
        NoteDescriptionFragment noteDescriptionFragment = NoteDescriptionFragment.newInstance(index);
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.descriptionContainer,noteDescriptionFragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();
}

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(CURRENT_NOTE,currentPosition);
        super.onSaveInstanceState(outState);
    }
    private  boolean isLandscape(){
        return getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE;
    }
}





