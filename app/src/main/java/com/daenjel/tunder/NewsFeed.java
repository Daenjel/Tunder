package com.daenjel.tunder;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NewsFeed extends AppCompatActivity implements View.OnClickListener{

    ViewPager viewPager;
    TextView MyName,MyAge,MyOccupation;
    ArrayList<Integer> ImageArray = new ArrayList<>();
    String name[],occupation[];
    int age[];
    View view;
    Button userprofile,like,feed,chat;
    AlertDialog.Builder dialog;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed);

        like = findViewById(R.id.btnLike);
        viewPager = findViewById(R.id.mainView);
        userprofile = findViewById(R.id.UserProfile);
        feed = findViewById(R.id.news);
        chat = findViewById(R.id.chat);

        userprofile.setOnClickListener(this);
        like.setOnClickListener(this);
        feed.setOnClickListener(this);
        chat.setOnClickListener(this);

        ImageList();



        Resources res = getResources();
        name = res.getStringArray(R.array.Names);
        age = res.getIntArray(R.array.Age);
        occupation = res.getStringArray(R.array.Occupation);

        viewPager.setAdapter(new ImageAdapter(this,ImageArray,name,age,occupation));

        dialog = new AlertDialog.Builder(this);
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setTitle("Awesome you found your match");
        dialog.setMessage("Do you wish to send them a match request?");
        dialog.setNegativeButton("Reject",null);
        dialog.setPositiveButton("Send", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(NewsFeed.this,"Request Sent",Toast.LENGTH_LONG).show();
            }
        });




                }
    public void ImageList(){

        ImageArray.add(R.drawable.ann);ImageArray.add(R.drawable.dan);
        ImageArray.add(R.drawable.erico);ImageArray.add(R.drawable.kamash);
        ImageArray.add(R.drawable.lydia);ImageArray.add(R.drawable.marvins);
        ImageArray.add(R.drawable.morande);ImageArray.add(R.drawable.mrs);
        ImageArray.add(R.drawable.mukina);ImageArray.add(R.drawable.nandabi);
        ImageArray.add(R.drawable.wanderi);ImageArray.add(R.drawable.wright);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.UserProfile:
                startActivity(new Intent(this,UserProfile.class));
                finish();
                break;
            case R.id.btnLike:
                dialog.show();
                break;
            case R.id.chat:
                startActivity(new Intent(this,ChatRoom.class));
                finish();
                break;
            case R.id.news:
                Snackbar.make(view, " View Posts ", Snackbar.LENGTH_LONG).show();
                break;
        }
    }
}
