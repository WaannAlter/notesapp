package com.example.myapplication;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextTitle, editTextContent;
    private Button saveButton, viewSavedNotesButton; // Added a button for viewing saved notes
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextContent = findViewById(R.id.editTextContent);
        saveButton = findViewById(R.id.saveButton);
        viewSavedNotesButton = findViewById(R.id.savedNotesButton); // Initialize the viewSavedNotesButton
        sharedPreferences = getSharedPreferences("MyNotes", MODE_PRIVATE);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = editTextTitle.getText().toString();
                String content = editTextContent.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("note_title", title);
                editor.putString("note_content", content);
                editor.apply();
            }
        });

        // Add a click listener to the "Lihat Catatan Tersimpan" button
        viewSavedNotesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to the NoteListActivity to view saved notes
                Intent intent = new Intent(MainActivity.this, NoteListActivity.class);
                startActivity(intent);
            }
        });

        // Display saved notes if they exist
        String savedTitle = sharedPreferences.getString("note_title", "");
        String savedContent = sharedPreferences.getString("note_content", "");

        if (!savedTitle.isEmpty() || !savedContent.isEmpty()) {
            editTextTitle.setText(savedTitle);
            editTextContent.setText(savedContent);
        }
    }
}
