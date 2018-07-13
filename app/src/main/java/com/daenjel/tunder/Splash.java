package com.daenjel.tunder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread thread = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch (Exception e){
                    Toast.makeText(Splash.this,e.getMessage(),Toast.LENGTH_LONG).show();
                }finally {
                    startActivity(new Intent(Splash.this,NewsFeed.class));
                    finish();
                }
            }
        };
        thread.start();
    }
}
