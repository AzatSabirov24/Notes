package com.example.notes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NoteDetailFragment extends Fragment {
    private long noteId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if(view != null){
            TextView tittle = (TextView)view.findViewById(R.id.textTitle);
            Note note = Note.notes[(int) noteId];
            tittle.setText(note.getName());
            TextView description = (TextView) view.findViewById(R.id.textDescription);
            description.setText(note.getDescription());
        }
    }

    public void setNote(long id){
        this.noteId = id;
    }
}