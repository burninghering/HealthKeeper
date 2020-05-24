package com.example.healthkeeperplz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;


import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    //각 입력한 데이터를 보여줄 객체 참조 변수 선언
    private TextView name;
    private TextView age;
    private TextView weight;
    private TextView height;
    TextView resulttext;
    String calculation, BMIresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        this.name = (TextView) findViewById(R.id.name);
        this.age = (TextView) findViewById(R.id.age);
        this.weight = (TextView) findViewById(R.id.weight);
        this.height = (TextView) findViewById(R.id.height);
        resulttext = findViewById(R.id.result);

        //이전에 실행된 액티비티 클래스에서 사용한 인텐트 객체에 접근
        Intent intent = this.getIntent();

        //이전 액티비티 클래스로부터 이름 가져오기
        String name = intent.getStringExtra("name");
        // String 형식의 데이터를 받아오므로 getStringExtra
        if(name == null) {
            this.name.setText("이름 가져오기 실패");
        }
        else{
            Log.d("mylogtag", "가져온 이름은" + name);
            this.name.setText(name);
        }

        //이전 액티비티 클래스로부터 나이 가져오기
        int age = intent.getIntExtra("age", -1);
        // int형 데이터를 받기위해서 getIntExtra를 사용
        if(age != -1) {
            Log.d("mylogtag", "가져온 나이는 = " + age);
            this.age.setText(age+"");
        }
        else{
            Log.d("mylogtag","나이 가져오기 실패");
            this.age.setText("나이 가져오기 실패");
        }

        //이전 액티비티 클래스로부터 몸무게 가져오기
        int weight = intent.getIntExtra("weight", -1);
        // int형 데이터를 받기위해서 getIntExtra를 사용
        if(weight != -1) {
            Log.d("mylogtag", "가져온 몸무게는 = " + weight);
            this.weight.setText(weight+"");
        }
        else{
            Log.d("mylogtag","몸무게 가져오기 실패");
            this.weight.setText("몸무게 가져오기 실패");
        }

        //이전 액티비티 클래스로부터 키 가져오기
        int height = intent.getIntExtra("height", -1);
        // int형 데이터를 받기위해서 getIntExtra를 사용
        if(height != -1) {
            Log.d("mylogtag", "가져온 키는 = " + height);
            this.height.setText(height+"");
        }
        else{
            Log.d("mylogtag","키 가져오기 실패");
            this.height.setText("키 가져오기 실패");
        }
    }

    public void ClickedBack(View v) {
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);

        finish();
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
                Intent intent4 = new Intent(this, SettingActivity.class);
                startActivity(intent4);
                break;

        }
        return true;
    }
    public void calculateBMI(View view) { //BMI - 혜린
        String S1 = weight.getText().toString();
        String S2 = height.getText().toString();



        float weightValue = Float.parseFloat(S1);
        float heightValue = Float.parseFloat(S2) / 100;



        float bmi = weightValue / (heightValue * heightValue);



        if(bmi < 16){
            BMIresult = "심각한 저체중";
        }else if(bmi < 18.5){
            BMIresult = "저체중";
        }else if(bmi >= 18.5 && bmi <= 24.9){
            BMIresult = "보통 체중";
        }else if (bmi >= 25 && bmi <= 29.9){
            BMIresult = "과체중";
        }else{
            BMIresult = "데이터를 다시 입력해주세요.";
        }



        calculation = bmi + ", " + BMIresult;
        resulttext.setText(calculation);
    }
}

