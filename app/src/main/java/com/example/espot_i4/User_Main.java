package com.example.espot_i4;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.net.Uri; // 지도 API 연결

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class User_Main extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);

        // 충전소 찾기
        Button findButton = (Button) findViewById(R.id.ChargeButton);
        findButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                //화면 전환
                Intent intent = new Intent(getApplicationContext(), find_cs.class);
                startActivity(intent);
            }
        });

        // 홈 버튼
        Button homeButton = (Button) findViewById(R.id.homebutton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                //화면 전환
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        // 설정 버튼
        Button settingButton = (Button) findViewById(R.id.settingbutton);
        settingButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                //화면 전환
                Intent intent = new Intent(getApplicationContext(), setting.class);
                startActivity(intent);
            }
        });

        // 남은 시간 확인
        Button TimerButton = (Button) findViewById(R.id.TimerButton);
        TimerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                //화면 전환
                Intent intent = new Intent(getApplicationContext(), TimerActivity.class);
                startActivity(intent);
            }
        });

        // 지도 URL 연결
        Button ChargeBtn = (Button) findViewById(R.id.ChargeButton);
        ChargeBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/p/search/%EC%A0%84%EA%B8%B0%EC%B0%A8%EC%B6%A9%EC%A0%84%EC%86%8C?c=12.68,0,0,0,dh"));
                startActivity(myIntent);
            }
        });

    }
}