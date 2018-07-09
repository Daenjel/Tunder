package com.daenjel.tunder;

import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    TextView MyName,MyAge,MyOccupation;
    ArrayList<Integer> ImageArray = new ArrayList<>();
    String name[],occupation[];
    int age[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageList();

        MyName = findViewById(R.id.Name);
        MyAge = findViewById(R.id.Age);
        MyOccupation = findViewById(R.id.Occupy);
        Resources res = getResources();
        name = res.getStringArray(R.array.Names);
        age = res.getIntArray(R.array.Age);
        occupation = res.getStringArray(R.array.Occupation);
        viewPager = findViewById(R.id.mainView);
        viewPager.setAdapter(new ImageAdapter(MainActivity.this,ImageArray,name,age,occupation));
    }
    public void ImageList(){

        ImageArray.add(R.drawable.adolo);
        ImageArray.add(R.drawable.ann);
        ImageArray.add(R.drawable.bc);
        ImageArray.add(R.drawable.dan);
        ImageArray.add(R.drawable.erico);
        ImageArray.add(R.drawable.gabu);
        ImageArray.add(R.drawable.kamash);
        ImageArray.add(R.drawable.lydia);
        ImageArray.add(R.drawable.marvins);
        ImageArray.add(R.drawable.mithams);
        ImageArray.add(R.drawable.morande);
        ImageArray.add(R.drawable.mrs);
        ImageArray.add(R.drawable.mukina);
        ImageArray.add(R.drawable.nandabi);
        ImageArray.add(R.drawable.wanderi);
        ImageArray.add(R.drawable.wright);
        ImageArray.add(R.drawable.nito);
    }
}
