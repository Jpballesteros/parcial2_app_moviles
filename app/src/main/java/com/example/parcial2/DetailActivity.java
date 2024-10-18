package com.example.parcial2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private ImageView imageViewCharacter;
    private TextView textViewName, textViewStatus, textViewSpecies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageViewCharacter = findViewById(R.id.imageViewCharacterDetail);
        textViewName = findViewById(R.id.textViewNameDetail);
        textViewStatus = findViewById(R.id.textViewStatusDetail);
        textViewSpecies = findViewById(R.id.textViewSpeciesDetail);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String status = intent.getStringExtra("status");
        String species = intent.getStringExtra("species");
        String imageUrl = intent.getStringExtra("imageUrl");

        textViewName.setText(name);
        textViewStatus.setText(status);
        textViewSpecies.setText(species);
        Picasso.get().load(imageUrl).into(imageViewCharacter);
    }
}
