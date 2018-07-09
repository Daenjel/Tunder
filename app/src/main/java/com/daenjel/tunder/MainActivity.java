package com.daenjel.tunder;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ViewPager viewPager;
    TextView MyName,MyAge,MyOccupation;
    ArrayList<Integer> ImageArray = new ArrayList<>();
    String name[],occupation[];
    int age[];

    Button userprofile,like;
    AlertDialog.Builder dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageList();

        userprofile = findViewById(R.id.UserProfile);
        like = findViewById(R.id.btnLike);
        MyName = findViewById(R.id.Name);
        MyAge = findViewById(R.id.Age);
        MyOccupation = findViewById(R.id.Occupy);
        Resources res = getResources();
        name = res.getStringArray(R.array.Names);
        age = res.getIntArray(R.array.Age);
        occupation = res.getStringArray(R.array.Occupation);
        viewPager = findViewById(R.id.mainView);
        viewPager.setAdapter(new ImageAdapter(MainActivity.this,ImageArray,name,age,occupation));

        dialog = new AlertDialog.Builder(this);
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setTitle("Awesome you found your match");
        dialog.setMessage("Do you wish to send them a match request?");
        dialog.setNegativeButton("Reject",null);
        dialog.setPositiveButton("Send", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"Request Sent",Toast.LENGTH_LONG).show();
            }
        });

        userprofile.setOnClickListener(this);
        like.setOnClickListener(this);
    }
    public void ImageList(){

        ImageArray.add(R.drawable.adolo);ImageArray.add(R.drawable.ann);
        ImageArray.add(R.drawable.bc);ImageArray.add(R.drawable.dan);
        ImageArray.add(R.drawable.erico);ImageArray.add(R.drawable.gabu);
        ImageArray.add(R.drawable.kamash);ImageArray.add(R.drawable.lydia);
        ImageArray.add(R.drawable.marvins);ImageArray.add(R.drawable.mithams);
        ImageArray.add(R.drawable.morande);ImageArray.add(R.drawable.mrs);
        ImageArray.add(R.drawable.mukina);ImageArray.add(R.drawable.nandabi);
        ImageArray.add(R.drawable.wanderi);ImageArray.add(R.drawable.wright);
        ImageArray.add(R.drawable.nito);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.UserProfile:
                startActivity(new Intent(this,UserProfile.class));
                break;
            case R.id.btnLike:
                dialog.show();
                break;
        }
    }
}
