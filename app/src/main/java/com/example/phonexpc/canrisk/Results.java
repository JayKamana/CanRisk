package com.example.phonexpc.canrisk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Results extends AppCompatActivity {

    int loadedPoints;
    TextView totalPoints, riskStatus, riskDesc;
    Button btnRestart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        totalPoints = findViewById(R.id.totalPointsScore);
        riskStatus = findViewById(R.id.riskStatus);
        riskDesc = findViewById(R.id.riskDesc);
        btnRestart = findViewById(R.id.btnRestart);

        Bundle bundle = getIntent().getExtras();
        loadedPoints = bundle.getInt("Points");


        totalPoints.setText(loadedPoints + " Points");

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Results.this, MainActivity.class);
                startActivity(intent);
            }
        });

        if(loadedPoints < 21) {
            riskStatus.setText("low risk");
            riskDesc.setText("Your risk of having pre-diabetes or type 2 " +
                    "diabetes is fairly low, though it always pays " +
                    "to maintain a healthy lifestyle");
        } else if (loadedPoints > 21 && loadedPoints < 35){
            riskStatus.setText("moderate risk");
            riskDesc.setText("Based on your identified risk factors, your risk " +
                    "of having pre-diabetes or type 2 diabetes " +
                    "is moderate. You may wish to consult with " +
                    "a health care practitioner about your risk of " +
                    "developing diabetes.");
        } else {
            riskStatus.setText("high risk");
            riskDesc.setText("Based on your identified risk factors, your risk " +
                    "of having pre-diabetes or type 2 diabetes is " +
                    "high. You may wish to consult with a health " +
                    "care practitioner to discuss getting your blood " +
                    "sugar tested");
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("Points", loadedPoints);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        loadedPoints = savedInstanceState.getInt("Points");
    }
}
