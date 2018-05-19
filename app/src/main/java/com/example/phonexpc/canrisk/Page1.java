package com.example.phonexpc.canrisk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Page1 extends AppCompatActivity {

    Button btn1Next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        btn1Next = findViewById(R.id.btn1Next);

        btn1Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Page1.this, Page2.class);
                startActivity(intent);
            }
        });
    }
}
