package com.example.notes;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements NoteListFragment.NoteListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setNoteListFragment();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void setNoteListFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragNoteListContainer, new NoteListFragment())
                .commit();
    }

    @Override
    public void itemClicked(long id) {
        View fragmentContainer = findViewById(R.id.fragContainer);
        if (fragmentContainer != null) {
            NoteDetailFragment details = new NoteDetailFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            details.setNote(id);
            ft.replace(R.id.fragContainer, details);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        } else {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_NOTE_ID, (int) id);
            startActivity(intent);
        }
    }

}
