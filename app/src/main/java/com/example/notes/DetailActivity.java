package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_NOTE_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setNoteDetailFragment();
    }

    private void setNoteDetailFragment() {
        NoteDetailFragment noteDetailFragment = new NoteDetailFragment();
        int noteId = (int)getIntent().getExtras().get(EXTRA_NOTE_ID);
        noteDetailFragment.setNote(noteId);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.detailFragment,new NoteDetailFragment())
                .commit();
    }
}