package com.daenjel.tunder;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jaredrummler.materialspinner.MaterialSpinner;

public class UserProfile extends AppCompatActivity implements View.OnClickListener{

    Button button,profile,news;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        overridePendingTransition(R.anim.slide_from_left,R.anim.slide_to_right);

        button = findViewById(R.id.btnApply);
        profile = findViewById(R.id.profile);
        news = findViewById(R.id.news);

        button.setOnClickListener(this);
        profile.setOnClickListener(this);
        news.setOnClickListener(this);

        Resources res = getResources();
        String [] Items = res.getStringArray(R.array.spinner_items);
        MaterialSpinner spinner =  findViewById(R.id.userOccupation);
        spinner.setItems(Items);
        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnApply:
              Snackbar.make(view, " Applying Changes ", Snackbar.LENGTH_LONG).show();
              break;
            case R.id.profile:
                Snackbar.make(view, " Account Profile ", Snackbar.LENGTH_LONG).show();
                break;
            case R.id.news:
                startActivity(new Intent(this,NewsFeed.class));
                overridePendingTransition(R.anim.slide_from_right,R.anim.slide_to_left);
                finish();
                break;
        }
    }
}
