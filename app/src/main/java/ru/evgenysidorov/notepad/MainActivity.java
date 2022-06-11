package ru.evgenysidorov.notepad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NoteFragment noteFragment = new NoteFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, noteFragment).commit();
        }


    }





