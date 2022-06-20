package ru.evgenysidorov.notepad;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MyDialogFragment extends DialogFragment {

    public static final String TAG = "MyDialogFragment";

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Activity activity = requireActivity();
        return new AlertDialog.Builder(activity)
                .setTitle("Предупреждение")
                .setMessage("Вы действиетльно хотите выйти?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        requireActivity().finish();
                        Toast.makeText(requireActivity().getApplicationContext(), "Приложение закрыто",Toast.LENGTH_SHORT).show();

                    }

                })
                .setNegativeButton("No", null).create();

    }
}