package com.example.shonket.ui.gallery;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shonket.R;

public class SenteceViewHolder extends RecyclerView.ViewHolder {
    TextView sentecne;
    public SenteceViewHolder(@NonNull View itemView) {
        super(itemView);
        sentecne=itemView.findViewById(R.id.content);
    }
}
