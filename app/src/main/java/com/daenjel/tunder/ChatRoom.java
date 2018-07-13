package com.daenjel.tunder;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ChatRoom extends AppCompatActivity implements View.OnClickListener{

    Button newsfd,chat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room);
        overridePendingTransition(R.anim.slide_from_right,R.anim.slide_to_left);

        newsfd = findViewById(R.id.news);
        chat = findViewById(R.id.chat);

        newsfd.setOnClickListener(this);
        chat.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.news:
                startActivity(new Intent(this,NewsFeed.class));
                overridePendingTransition(R.anim.slide_from_left,R.anim.slide_to_right);
                finish();
                break;
            case R.id.chat:
                Snackbar.make(view, " User Inbox ", Snackbar.LENGTH_LONG).show();
                break;
        }
    }
}
