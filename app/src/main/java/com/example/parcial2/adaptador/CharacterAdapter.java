package com.example.parcial2.adaptador;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.parcial2.DetailActivity;
import com.example.parcial2.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {

    private List<Character> characterList;

    public CharacterAdapter(List<Character> characterList) {
        this.characterList = characterList;
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new CharacterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        Character character = characterList.get(position);
        holder.bind(character);
    }

    @Override
    public int getItemCount() {
        return characterList.size();
    }

    public static class CharacterViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName, textViewStatus, textViewSpecies;
        ImageView imageViewCharacter;
        Button buttonSeeMore;

        public CharacterViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewStatus = itemView.findViewById(R.id.textViewStatus);
            textViewSpecies = itemView.findViewById(R.id.textViewSpecies);
            imageViewCharacter = itemView.findViewById(R.id.imageViewCharacter);
            buttonSeeMore = itemView.findViewById(R.id.buttonSeeMore);
        }

        public void bind(Character character) {
            textViewName.setText(character.getName());
            textViewStatus.setText(character.getStatus());
            textViewSpecies.setText(character.getSpecies());
            Picasso.get().load(character.getImageUrl()).into(imageViewCharacter);

            buttonSeeMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                    intent.putExtra("name", character.getName());
                    intent.putExtra("status", character.getStatus());
                    intent.putExtra("species", character.getSpecies());
                    intent.putExtra("imageUrl", character.getImageUrl());
                    itemView.getContext().startActivity(intent);
                }
            });
        }

    }
}
