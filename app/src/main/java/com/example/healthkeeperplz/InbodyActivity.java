package com.example.healthkeeperplz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;


import android.view.MenuItem;

public class InbodyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) { //액티비티의 화면이 보여지는 함수
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbody);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //메뉴 함수
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) { //메뉴 전환 함수
        switch (item.getItemId()) {
            case R.id.menu1:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.menu2:
                Intent intent2 = new Intent(this, TrainerActivity.class);
                startActivity(intent2);
                break;
            case R.id.menu3:
                Intent intent3 = new Intent(this, InbodyActivity.class);
                startActivity(intent3);
                break;
            case R.id.menu4:
                Intent intent4 = new Intent(this, SettingActivity.class);
                startActivity(intent4);
                break;

        }
        return true;
    }
}

