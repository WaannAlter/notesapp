
package com.example.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class NoteListActivity extends AppCompatActivity {

    private ArrayList<String> noteTitles; // Store note titles dynamically

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_list);

        ListView noteListView = findViewById(R.id.noteListView);

        // Load saved note titles from your data source here (e.g., SharedPreferences or a database)
        // Example:
        // noteTitles = loadNoteTitlesFromSharedPreferences();

        // Create an ArrayAdapter to display the list of note titles
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, noteTitles);

        // Set the adapter for the ListView
        noteListView.setAdapter(adapter);

        // Add a click listener to handle when a note is selected
        noteListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // Get the selected note's title
                String selectedNoteTitle = noteTitles.get(position);

                // Start a new activity to display the note's details
                Intent intent = new Intent(NoteListActivity.this, NoteDetailActivity.class);
                intent.putExtra("note_title", selectedNoteTitle);
                startActivity(intent);
            }
        });
    }
}
