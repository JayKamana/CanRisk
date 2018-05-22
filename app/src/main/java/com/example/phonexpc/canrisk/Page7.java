package com.example.phonexpc.canrisk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Page7 extends AppCompatActivity {

    Button btn7Next;
    int loadedPoints, motherPoints, fatherPoints;
    TextView currentPoints;
    RadioGroup radioGroupMother, radioGroupFather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page7);

        btn7Next = findViewById(R.id.btn7Next);
        currentPoints = findViewById(R.id.page7Points);

        radioGroupMother = findViewById(R.id.radioGroupMotherEthnic);
        radioGroupFather = findViewById(R.id.radioGroupFatherEthnic);

        Bundle bundle = getIntent().getExtras();
        loadedPoints = bundle.getInt("Points");

        currentPoints.setText(loadedPoints+"");

        radioGroupMother.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                RadioButton checkedRadioButton = radioGroup.findViewById(id);
                switch(checkedRadioButton.getId()){
                    case R.id.motherWhite:
                        motherPoints = 0;
                        break;
                    case R.id.motherAboriginal:
                        motherPoints = 3;
                        break;
                    case R.id.motherBlack:
                        motherPoints = 5;
                        break;
                    case R.id.motherEastAsian:
                        motherPoints = 10;
                        break;
                    case R.id.motherSouthAsian:
                        motherPoints = 11;
                        break;
                    case R.id.motherNonWhite:
                        motherPoints = 3;
                        break;
                }

                currentPoints.setText(loadedPoints +(motherPoints > fatherPoints ? motherPoints : fatherPoints)+"");
            }
        });

        radioGroupFather.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                RadioButton checkedRadioButton = radioGroup.findViewById(id);
                switch(checkedRadioButton.getId()){
                    case R.id.fatherWhite:
                        fatherPoints = 0;
                        break;
                    case R.id.fatherAboriginal:
                        fatherPoints = 3;
                        break;
                    case R.id.fatherBlack:
                        fatherPoints = 5;
                        break;
                    case R.id.fatherEastAsian:
                        fatherPoints = 10;
                        break;
                    case R.id.fatherSouthAsian:
                        fatherPoints = 11;
                        break;
                    case R.id.fatherNonWhite:
                        fatherPoints = 3;
                        break;
                }

                currentPoints.setText(loadedPoints +(motherPoints > fatherPoints ? motherPoints : fatherPoints)+"");
            }
        });

        btn7Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioGroupFather.getCheckedRadioButtonId() != -1 && radioGroupMother.getCheckedRadioButtonId() != -1){
                    Intent intent = new Intent(Page7.this, Page8.class);
                    intent.putExtra("Points", loadedPoints +(motherPoints > fatherPoints ? motherPoints : fatherPoints));
                    startActivity(intent);
                } else {
                    Toast.makeText(Page7.this, "Please select an option for each category", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("Points", loadedPoints +(motherPoints > fatherPoints ? motherPoints : fatherPoints));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        loadedPoints = savedInstanceState.getInt("Points");
    }
}
