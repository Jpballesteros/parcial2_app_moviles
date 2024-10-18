package com.example.parcial2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parcial2.adaptador.CharacterAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Character> characterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Inicializar RecyclerView
        recyclerView = findViewById(R.id.recyclerView);

        // Crear la lista de personajes
        characterList = new ArrayList<>();
        characterList.add(new Character("Rick Sanchez", "Alive", "Human", "https://www.mundodeportivo.com/alfabeta/hero/2021/01/ac5152b9f7f50781b2b01e35463fc4e6.jpg?width=768&aspect_ratio=16:9&format=nowebp"));
        characterList.add(new Character("Morty Smith", "Alive", "Human", "https://rickandmortyapi.com/api/character/avatar/2.jpeg"));
        characterList.add(new Character("Summer Smith", "Alive", "Human", "https://rickandmortyapi.com/api/character/avatar/3.jpeg"));
        characterList.add(new Character("Beth Smith", "Alive", "Human", "https://rickandmortyapi.com/api/character/avatar/4.jpeg"));
        characterList.add(new Character("Jerry Smith", "Alive", "Human", "https://rickandmortyapi.com/api/character/avatar/5.jpeg"));

        // Configurar el RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CharacterAdapter adapter = new CharacterAdapter(characterList);
        recyclerView.setAdapter(adapter);
    }
}
