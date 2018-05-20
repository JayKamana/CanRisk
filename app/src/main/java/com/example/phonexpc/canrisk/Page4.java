package com.example.phonexpc.canrisk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Page4 extends AppCompatActivity {

    Button btn4Next;
    int physicalPoints;
    int nutritionPoints;
    int loadedPoints;
    TextView currentPoints;
    RadioGroup radioGroupPhysical, radioGroupNutrition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page4);

        btn4Next = findViewById(R.id.btn4Next);
        currentPoints = findViewById(R.id.page4Points);
        radioGroupPhysical = findViewById(R.id.radioGroupPhysical);
        radioGroupNutrition = findViewById(R.id.radioGroupNutrition);

        Bundle bundle = getIntent().getExtras();
        loadedPoints = bundle.getInt("Points");

        currentPoints.setText(loadedPoints+"");

        radioGroupPhysical.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {

                RadioButton checkedRadioButton = radioGroup.findViewById(id);
                switch(checkedRadioButton.getText().toString()){
                    case "Yes":
                        physicalPoints = 0;
                        break;
                    case "No":
                        physicalPoints = 1;
                        break;
                }

                currentPoints.setText(physicalPoints + nutritionPoints + loadedPoints+"");

            }
        });

        radioGroupNutrition.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {

                RadioButton checkedRadioButton = radioGroup.findViewById(id);
                switch(checkedRadioButton.getText().toString()){
                    case "Every day":
                        nutritionPoints = 0;
                        break;
                    case "Not every day":
                        nutritionPoints = 2;
                        break;
                }

                currentPoints.setText(physicalPoints + nutritionPoints + loadedPoints+"");

            }
        });

        btn4Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Page4.this, Page5.class);
                intent.putExtra("Points", physicalPoints + nutritionPoints + loadedPoints);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("Points", physicalPoints + nutritionPoints + loadedPoints);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        loadedPoints = savedInstanceState.getInt("Points");
    }
}
