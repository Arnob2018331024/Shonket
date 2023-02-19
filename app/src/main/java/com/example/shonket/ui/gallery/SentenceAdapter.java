package com.example.shonket.ui.gallery;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shonket.R;

import java.util.ArrayList;

public class SentenceAdapter extends RecyclerView.Adapter<SenteceViewHolder> {
    ArrayList<String> setntences;
    Context c;

    public SentenceAdapter(ArrayList<String> setntences, Context c) {
        this.setntences = setntences;
        this.c = c;
    }
    public void setSenteces(ArrayList<String> setntences){this.setntences=setntences;}

    @NonNull
    @Override
    public SenteceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(c).inflate(R.layout.fragment_sentences,parent,false);
        SenteceViewHolder vh=new SenteceViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull SenteceViewHolder holder, int position) {
        String sentence=setntences.get(position);
        holder.sentecne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GalleryFragment.play(sentence);
            }
        });
        holder.sentecne.setText(setntences.get(position));
    }

    @Override
    public int getItemCount() {
        return setntences.size();
    }
}
