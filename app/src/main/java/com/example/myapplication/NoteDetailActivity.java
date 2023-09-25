package com.example.myapplication;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class NoteDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_detail);

        // Get the selected note's title from the intent
        String selectedNoteTitle = getIntent().getStringExtra("note_title");

        // Display the selected note's title in a TextView
        TextView titleTextView = findViewById(R.id.noteTitleTextView); // Replace with the actual ID
        titleTextView.setText(selectedNoteTitle);
    }
}
