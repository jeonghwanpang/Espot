package com.example.espot_i4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Manager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        Button naverButton = (Button) findViewById(R.id.homebutton);
        naverButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                //화면 전환
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                //Intent intent = new Intent(getApplicationContext(), User_Main.class);
                startActivity(intent);
            }
        });
    }
}