package com.example.espot_i4;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class find_cs extends AppCompatActivity {

    private Button findCSButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // EdgeToEdge.enable(this); // 이 부분은 주석 처리하거나 관련 라이브러리를 추가하세요.
        setContentView(R.layout.activity_find_cs);

        // findViewById의 ID 수정
        View backButton = findViewById(R.id.findCSButton);

        // WindowInsets 처리
        View mainView = findViewById(R.id.main); // 'main' ID를 가진 View가 존재하는지 확인하세요.
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return WindowInsetsCompat.CONSUMED;
            });
        }

        // WebView 설정
        WebView webView = findViewById(R.id.webView); // 레이아웃에 정의된 WebView의 ID
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); // JavaScript 활성화
        webView.loadUrl("file:///android_asset/map3.html"); // assets 폴더 내 map.html 로드

        // 화면 비율
        // webSettings.setUseWideViewPort(true); // wide viewport를 사용하도록 설정
        webSettings.setLoadWithOverviewMode(true); // 컨텐츠가 웹뷰보다 클 경우 스크린 크기에 맞게 조정

        // 웹뷰 멀티 터치 가능하게 (줌기능)
        webSettings.setBuiltInZoomControls(true); // 줌 아이콘 사용
        webSettings.setSupportZoom(true);

        // 버튼에 클릭 리스너 추가
        backButton.setOnClickListener(v -> {
            // WebView가 이전 페이지로 갈 수 있다면, 뒤로 가기
            if (webView.canGoBack()) {
                webView.goBack();
            } else {
                // WebView가 뒤로 갈 수 없다면, Activity를 종료합니다.
                finish();
            }
        });
    }
}
