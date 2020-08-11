package com.example.lab_1;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.lab_1.recyclerViewActivities.ActivitiesAdapter;

import java.util.ArrayList;
import java.util.List;

public class ImplicitActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<String> appsList;
    List<Drawable> images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit);
        try {
            init();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        initRecyclerView();
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ActivitiesAdapter(appsList, images));
    }

    private void init() throws PackageManager.NameNotFoundException {
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> pkgAppsList = getPackageManager().queryIntentActivities(mainIntent, 0);

        appsList = new ArrayList<>();
        images = new ArrayList<>();

        for (int i = 0; i < pkgAppsList.size(); i++) {
//            Log.e("Activity package", pkgAppsList.get(i).activityInfo.name);
            ResolveInfo ri = pkgAppsList.get(i);
            appsList.add(i, ri.activityInfo.name);
            images.add(i, getPackageManager().getApplicationIcon(ri.activityInfo.packageName));
        }


    }
}
