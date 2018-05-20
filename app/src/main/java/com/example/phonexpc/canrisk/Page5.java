package com.example.phonexpc.canrisk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Page5 extends AppCompatActivity {

    Button btn5Next;
    int loadedPoints, bloodPressurePoints, bloodSugarPoints, babyWeightPoints;
    TextView currentPoints;
    RadioGroup radioGroupBP, radioGroupBS, radioGroupBW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page5);

        currentPoints = findViewById(R.id.page5Points);

        btn5Next = findViewById(R.id.btn5Next);
        radioGroupBP = findViewById(R.id.radioGroupBP);
        radioGroupBS = findViewById(R.id.radioGroupBS);
        radioGroupBW = findViewById(R.id.radioGroupBW);

        Bundle bundle = getIntent().getExtras();
        loadedPoints = bundle.getInt("Points");

        currentPoints.setText(loadedPoints+"");

        radioGroupBP.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                RadioButton checkedRadioButton = radioGroup.findViewById(id);
                switch(checkedRadioButton.getId()){
                    case R.id.bpYes:
                        bloodPressurePoints = 4;
                        break;
                    case R.id.bpNo:
                        bloodPressurePoints = 0;
                        break;
                }

                currentPoints.setText(bloodPressurePoints + bloodSugarPoints + babyWeightPoints + loadedPoints+"");
            }
        });

        radioGroupBS.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                RadioButton checkedRadioButton = radioGroup.findViewById(id);
                switch(checkedRadioButton.getId()){
                    case R.id.bsYes:
                        bloodSugarPoints = 14;
                        break;
                    case R.id.bsNo:
                        bloodSugarPoints = 0;
                        break;
                }

                currentPoints.setText(bloodPressurePoints + bloodSugarPoints + babyWeightPoints + loadedPoints+"");
            }
        });

        radioGroupBW.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                RadioButton checkedRadioButton = radioGroup.findViewById(id);
                switch(checkedRadioButton.getId()){
                    case R.id.bwYes:
                        babyWeightPoints = 1;
                        break;
                    case R.id.bwNo:
                        babyWeightPoints = 0;
                        break;
                }

                currentPoints.setText(bloodPressurePoints + bloodSugarPoints + babyWeightPoints + loadedPoints+"");
            }
        });

        btn5Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Page5.this, Page6.class);
                intent.putExtra("Points", bloodPressurePoints + bloodSugarPoints + babyWeightPoints + loadedPoints);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("Points", bloodPressurePoints + bloodSugarPoints + babyWeightPoints + loadedPoints);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        loadedPoints = savedInstanceState.getInt("Points");
    }
}
