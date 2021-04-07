package com.example.notes;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements NoteListFragment.NoteListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setNoteDetailFragment();
        setNoteListFragment();

    }

    private void setNoteDetailFragment() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragContainer, new NoteDetailFragment())
                .commit();
    }

    private void setNoteListFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragNoteListContainer, new NoteListFragment())
                .commit();
    }

    @Override
    public void itemClicked(long id) {
        View fragmentContainer = findViewById(R.id.fragContainer);
        if(fragmentContainer != null) {
            NoteDetailFragment details = new NoteDetailFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            details.setNote(id);
            ft.replace(R.id.fragContainer, details);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        } else {
            Intent intent = new Intent(this,DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_NOTE_ID,(int)id);
            startActivity(intent);
        }
    }
}