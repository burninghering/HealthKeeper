package com.example.healthkeeperplz;
import android.app.Application;

public class global extends Application {
    private int gValue;



// 타 class에서 MyApplication class를 통해 해당 variable 값을 참조

    public int getGlobalValue(){
        return gValue;
    }



// 타 class에서 변경한 valuable을 MyApplication 에 저장

    public void setGlobalValue(int mValue){
        this.gValue = mValue;
    }
}

