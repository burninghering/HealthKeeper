package com.example.healthkeeperplz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;  // 이름입력
    EditText editText2; // 나이입력
    EditText editText3; // 몸무게 입력
    EditText editText4; // 키 입력

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
    }

    public void Button1Clicked(View v) {
        // 사용자가 입력한 나이와 이름을 가져와서 임시 변수에 저장
        String inputName = this.editText.getText().toString().trim();
        String inputAge = this.editText2.getText().toString().trim();
        String inputWeight = this.editText3.getText().toString().trim();
        String inputHeight = this.editText4.getText().toString().trim();

        // 데이터 입력여부 확인
        if(inputName.length() > 0 && inputAge.length() > 0) {

            //Intent 객체를 생성
            Intent intent = new Intent(this, ResultActivity.class);

            // 사용자가 입력한 이름과 나이를 인텐트 객체에 저장
            intent.putExtra("name", inputName);
            intent.putExtra("age", Integer.parseInt(inputAge));
            intent.putExtra("weight", Integer.parseInt(inputWeight));
            intent.putExtra("height", Integer.parseInt(inputHeight));
            startActivity(intent);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
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
                Intent intent4 = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent4);
                break;

        }
        return true;
    }

}
