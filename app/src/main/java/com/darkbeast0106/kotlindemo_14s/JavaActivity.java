package com.darkbeast0106.kotlindemo_14s;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class JavaActivity extends AppCompatActivity {

    Button btnKorcsoport, btnVissza;
    EditText etKor;
    TextView textKorcsoport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);
        init();

        btnKorcsoport.setOnClickListener(v -> {
            String korString = etKor.getText().toString().trim();
            if (korString.isEmpty()){
                etKor.setError("Nincs Megadva kor");
                return;
            }
            int kor = Integer.parseInt(korString);
            /*
            0-2: csecsemő
            3-12: gyermek
            13-16: serdülő
            17-20: ifjú
            21-60: felnőtt
            61-75: idős
            76-: agg
             */
            String korcsoport = "";
            if (kor < 0){
                korcsoport = "érvénytelen";
            } else if (kor < 3) {
                korcsoport = "csecsemő";
            }else if (kor < 13) {
                korcsoport = "gyermek";
            }else if (kor < 17) {
                korcsoport = "serdülő";
            }else if (kor < 21) {
                korcsoport = "ifjú";
            }else if (kor < 61) {
                korcsoport = "felnőtt";
            }else if (kor < 76) {
                korcsoport = "idős";
            }else{
                korcsoport = "agg";
            }
            String text = kor
                    +"\n" + korcsoport;
            textKorcsoport.setText(text);

        });
        btnVissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void init() {
        btnKorcsoport = findViewById(R.id.btnKorcsoport);
        btnVissza = findViewById(R.id.btnVissza);
        etKor = findViewById(R.id.etKor);
        textKorcsoport = findViewById(R.id.textKorcsoport);
    }
}