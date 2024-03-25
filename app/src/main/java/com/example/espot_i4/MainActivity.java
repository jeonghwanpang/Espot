package com.example.espot_i4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //<사용자 로그인> 카카오 버튼 누를 시 차량 번호 입력 화면으로 전환
        Button imageButton = (Button) findViewById(R.id.kakaobutton);
        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //화면 전환
                Intent CarNumintent = new Intent(getApplicationContext(), CarNum.class);
                //Intent intent = new Intent(getApplicationContext(), User_Main.class);
                startActivity(CarNumintent);
            }
        });

        //<사용자 로그인> 네이버 버튼 누를 시 차량 번호 입력 화면으로 전환
        Button naverButton = (Button) findViewById(R.id.naverbutton);
        naverButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                //화면 전환
                Intent CarNumintent = new Intent(getApplicationContext(), CarNum.class);
                //Intent intent = new Intent(getApplicationContext(), User_Main.class);
                startActivity(CarNumintent);
            }
        });


    }
}