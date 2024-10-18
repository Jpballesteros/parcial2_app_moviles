package com.example.parcial2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class CharacterDetailActivity extends AppCompatActivity {

    private TextView txtName, txtStatus, txtSpecies;
    private ImageView imgCharacter;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_detail);

        txtName = findViewById(R.id.txtName);
        txtStatus = findViewById(R.id.txtStatus);
        txtSpecies = findViewById(R.id.txtSpecies);
        imgCharacter = findViewById(R.id.imgCharacter);
        btnLogout = findViewById(R.id.btnLogout);

        // Obtener los datos del Intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String status = intent.getStringExtra("status");
        String species = intent.getStringExtra("species");
        String imageUrl = intent.getStringExtra("imageUrl");


        // Configurar los campos de texto y la imagen
        txtName.setText(name);
        txtStatus.setText(status);
        txtSpecies.setText(species);
        Picasso.get().load(imageUrl).into(imgCharacter);

        // Configurar el botón de cerrar sesión
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Eliminar SharedPreferences
                SharedPreferences sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();

                // Enviar al usuario a la pantalla de login
                Intent loginIntent = new Intent(CharacterDetailActivity.this, LoginActivity.class);
                startActivity(loginIntent);
                finish(); // Finalizar la actividad actual
            }
        });
    }
}
