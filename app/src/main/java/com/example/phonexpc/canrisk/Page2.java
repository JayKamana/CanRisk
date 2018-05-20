package com.example.phonexpc.canrisk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Page2 extends AppCompatActivity {

    Button btn2Next;
    int loadedPoints;
    int pointsBMI = 0;
    RadioGroup radioGroupBMI;
    TextView currentPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        btn2Next = findViewById(R.id.btn2Next);
        radioGroupBMI = findViewById(R.id.radioGroupBMI);
        currentPoints = findViewById(R.id.page2Points);

        Bundle bundle = getIntent().getExtras();
            loadedPoints = bundle.getInt("Points");


            currentPoints.setText(loadedPoints+"");

            radioGroupBMI.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                RadioButton checkedRadioButton = radioGroup.findViewById(id);
                switch(checkedRadioButton.getId()){
                    case R.id.bmi25:
                        pointsBMI = 0;
                        break;
                    case R.id.bmi29:
                        pointsBMI = 4;
                        break;
                    case R.id.bmi34:
                        pointsBMI = 9;
                        break;
                    case R.id.bmiOver:
                        pointsBMI = 14;
                        break;
                }

                currentPoints.setText(pointsBMI + loadedPoints+"");
            }


        });

        btn2Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Page2.this, Page3.class);
                intent.putExtra("Points", pointsBMI + loadedPoints);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("Points", pointsBMI + loadedPoints);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        loadedPoints = savedInstanceState.getInt("Points");
    }


}
