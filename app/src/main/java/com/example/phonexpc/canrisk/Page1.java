package com.example.phonexpc.canrisk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Page1 extends AppCompatActivity {

    int agePoints = 0;
    int genderPoints = 0;
    int loadedPoints;
    Button btn1Next;
    TextView currentPoints;
    RadioGroup radioGroupAge, radioGroupGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        btn1Next = findViewById(R.id.btn1Next);

        currentPoints = findViewById(R.id.page1Points);

        radioGroupAge = findViewById(R.id.radioGroupAge);
        radioGroupGender = findViewById(R.id.radioGroupGender);

        currentPoints.setText(loadedPoints+"");

        radioGroupAge.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                RadioButton checkedRadioButton = radioGroup.findViewById(id);

                switch(checkedRadioButton.getText().toString()){
                    case "40 - 44 years":
                        agePoints = 0;
                        break;
                    case "45 - 54 years":
                        agePoints = 7;
                        break;
                    case "55 - 64 years":
                        agePoints = 13;
                        break;
                    case "65 - 74 years":
                        agePoints = 15;
                        break;
                }

                currentPoints.setText(agePoints + genderPoints + loadedPoints+"");
            }
        });

        radioGroupGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                RadioButton checkedRadioButton = radioGroup.findViewById(id);
                switch(checkedRadioButton.getText().toString()){
                    case "Male":
                        genderPoints = 6;
                        break;
                    case "Female":
                        genderPoints = 0;
                        break;
                }
                currentPoints.setText(agePoints + genderPoints + loadedPoints+"");
            }
        });

        btn1Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Page1.this, Page2.class);
                intent.putExtra("Points", agePoints + genderPoints + loadedPoints);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("Points", loadedPoints + agePoints + genderPoints);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        loadedPoints = savedInstanceState.getInt("Points");
    }
}
