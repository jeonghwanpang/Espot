package com.example.espot_i4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth; // 파이어 베이스 연동
    private DatabaseReference mDatabaseRef; // 실시간 데이터 베이스
    private EditText mEtID, mEtPwd, mEtName, mEtPhone, mEtCar1, mEtCar2, mEtAdminNum;
    private Button mBtnRegister, mBtnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference();

        mEtID = findViewById(R.id.editTextText3);
        mEtPwd = findViewById(R.id.editTextText4);
        mBtnRegister = findViewById(R.id.JoinButton);
        mBtnLogin = findViewById(R.id.LoginButton);

        /*
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strID = mEtID.getText().toString();
                String strPwd = mEtPwd.getText().toString();
                String strName = mEtName.getText().toString();
                String strPhone = mEtPhone.getText().toString();
                String strCar1 = mEtCar1.getText().toString();
                String strCar2 = mEtCar2.getText().toString();
                //String strAdminNum = mEtAdminNum.getText().toString();

                mFirebaseAuth.signInWithEmailAndPassword(strID, strPwd).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // 로그인 성공
                            Intent intent = new Intent(MainActivity.this, User_Main.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(MainActivity.this, "로그인 실패", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
        */




        Button findButton = (Button) findViewById(R.id.LoginButton);
        findButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                //화면 전환
                Intent intent = new Intent(getApplicationContext(), User_Main.class);
                startActivity(intent);
            }
        });



        //<사용자 로그인> 회원 가입 버튼 누를 시 사용자 모드 회원 가입 화면으로 전환
        Button joinButton = (Button) findViewById(R.id.JoinButton);
        joinButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //화면 전환
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

        /*
        // 임시
        //<사용자 로그인> 로그인 버튼 누를 시 관리자 모드 회원 가입 화면으로 전환
        Button loginButton = (Button) findViewById(R.id.LoginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                //화면 전환
                Intent intent = new Intent(getApplicationContext(), RegisterActivity_Admin.class);
                startActivity(intent);
            }
        });
*/

    }
}