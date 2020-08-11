package com.example.lab_1.recyclerViewActivities;

import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.lab_1.R;

import java.util.List;

public class ActivitiesAdapter extends RecyclerView.Adapter<ActivitiesViewHolder> {
    private List<String> pkgAppsList;
    private List<Drawable> images;

    public ActivitiesAdapter(List<String> pkgAppsList, List<Drawable> images) {
        this.pkgAppsList = pkgAppsList;
        this.images = images;
    }

    @NonNull
    @Override
    public ActivitiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activities_row, parent,false);
        return new ActivitiesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ActivitiesViewHolder holder, int position) {
        holder.txtActivityName.setText(pkgAppsList.get(position));
        holder.imgActivity.setImageDrawable(images.get(position));
    }

    @Override
    public int getItemCount() {
        return pkgAppsList.size();
    }
}
