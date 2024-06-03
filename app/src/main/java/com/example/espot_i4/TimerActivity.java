package com.example.espot_i4;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar; // Toolbar를 사용하기 위해 추가
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;

import org.w3c.dom.Text;

public class TimerActivity extends AppCompatActivity {

    private TextView countdownText; // 타이머 현황
    private Button startButton; // 시작버튼
    private Button stopButton; // 정지버튼
    private Button cancleButton; //취소버튼

    private TextView hourText; // 시
    private TextView minText; // 분
    private TextView secondText; // 초

    private CountDownTimer countDownTimer;

    private boolean timerRunning; // 타이머 상태
    private boolean firstState; // 처음인지 아닌지?

    private long time =0;
    private long tempTime = 0;

    FrameLayout setting; // 셋팅화면
    FrameLayout timer; // 타이머 화면

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // 뒤로가기 버튼 활성화
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        countdownText = findViewById(R.id.countdown_text);
        startButton = findViewById(R.id.countdown_button); // 시작
        stopButton = findViewById(R.id.stop_btn); // 정지
        cancleButton = findViewById(R.id.cancel_btn); // 취소

        hourText = findViewById(R.id.hour); // 시
        minText = findViewById(R.id.min); //분
        secondText = findViewById(R.id.second); // 초

        setting = findViewById(R.id.setting);
        timer = findViewById(R.id.timer);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                firstState = true;

                setting.setVisibility(View.GONE);
                timer.setVisibility(View.VISIBLE);
                startStop();
            }
        });
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startStop();
            }
        });
        cancleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting.setVisibility(View.VISIBLE); // 설정 생김
                timer.setVisibility(View.GONE); // 타이머 사라짐
                firstState = true;
                stopTimer();
            }
        });
        updateTimer();
    }

    private void startStop() {
        if (timerRunning) {
            stopTimer();
        } else {
            startTimer();
        }
    }

    private void startTimer(){
        if(firstState) {
            String sHour = hourText.getText().toString();
            String sMin = minText.getText().toString();
            String sSecond = secondText.getText().toString();
            time = (Long.parseLong(sHour) * 3600000) + (Long.parseLong(sMin) * 60000) + (Long.parseLong(sSecond) * 1000) + 1000;
        }else {
            time = tempTime;
        }
        countDownTimer= new CountDownTimer(time,1000) {
            @Override
            public void onTick(long millisUnitFinished) {
                tempTime = millisUnitFinished;
                updateTimer();
            }

            @Override
            public void onFinish() {
                AlertDialog.Builder builder = new AlertDialog.Builder(TimerActivity.this);
                builder.setTitle("시간 종료"); // 팝업창 제목 설정
                builder.setMessage("충전이 완료되었습니다."); // 팝업창 메시지 설정
                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // '확인' 버튼 클릭 시 수행할 동작
                        // 예를 들어, 타이머 설정 화면으로 돌아가는 등의 동작을 구현
                        setting.setVisibility(View.VISIBLE); // 설정 화면 보이기
                        timer.setVisibility(View.GONE); // 타이머 화면 숨기기
                        firstState = true; // 타이머 초기 상태로 설정
                        stopTimer(); // 타이머 정지
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        }.start();

        stopButton.setText("일시정지");
        timerRunning = true;
        firstState = false;
    }
    private void stopTimer(){
        countDownTimer.cancel();
        timerRunning=false;
        stopButton.setText("계속");
    }
    private void updateTimer(){
        int hour = (int)tempTime / 3600000;
        int minutes = (int)tempTime % 3600000 / 60000;
        int seconds = (int)tempTime % 3600000 % 60000 / 1000;

        String timeLeftText ="";

        timeLeftText = "" + hour + ":";

        if(minutes <10) timeLeftText +="0";
        timeLeftText += minutes+":";

        if(seconds<10) timeLeftText +="0";
        timeLeftText += seconds;

        countdownText.setText(timeLeftText);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            // 뒤로가기 버튼 클릭 시 동작
            finish(); // 현재 액티비티 종료
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
