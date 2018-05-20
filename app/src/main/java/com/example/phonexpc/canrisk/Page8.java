package com.example.phonexpc.canrisk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Page8 extends AppCompatActivity {
    int loadedPoints, educationPoints;
    TextView currentPoints;
    RadioGroup radioGroupEducation;
    Button results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page8);

        currentPoints = findViewById(R.id.page8Points);
        radioGroupEducation = findViewById(R.id.radioGroupEducation);
        results = findViewById(R.id.btnResults);

        Bundle bundle = getIntent().getExtras();
        loadedPoints = bundle.getInt("Points");

        currentPoints.setText(loadedPoints+"");

        radioGroupEducation.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                RadioButton checkedRadioButton = radioGroup.findViewById(id);
                switch(checkedRadioButton.getId()){
                    case R.id.rbHighSchool:
                        educationPoints = 5;
                        break;
                    case R.id.rbDiploma:
                        educationPoints = 1;
                        break;
                    case R.id.rbCollege:
                        educationPoints = 0;
                        break;
                    case R.id.rbDegree:
                        educationPoints = 0;
                        break;
                }

                currentPoints.setText(loadedPoints + educationPoints+"");
            }
        });

        results.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Page8.this, Results.class);
                intent.putExtra("Points", loadedPoints + educationPoints);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("Points", loadedPoints +educationPoints);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        loadedPoints = savedInstanceState.getInt("Points");
    }
}
