package com.example.lab_1.recyclerViewActivities;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.lab_1.R;

public class ActivitiesViewHolder extends RecyclerView.ViewHolder {
    TextView txtActivityName;
    ImageView imgActivity;

    public ActivitiesViewHolder(@NonNull View itemView) {
        super(itemView);
        txtActivityName = itemView.findViewById(R.id.txtActivityName);
        imgActivity = itemView.findViewById(R.id.imgActivity);
    }
}
