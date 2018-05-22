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

public class Page3 extends AppCompatActivity {

    Button btn3Next;
    int loadedPoints;
    int waistPoints;
    RadioGroup radioGroupWaist;
    TextView currentPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

        btn3Next = findViewById(R.id.btn3Next);
        radioGroupWaist = findViewById(R.id.radioGroupWaist);
        currentPoints = findViewById(R.id.page3Points);

        Bundle bundle = getIntent().getExtras();
        loadedPoints = bundle.getInt("Points");

        currentPoints.setText(loadedPoints+"");

        radioGroupWaist.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                RadioButton checkedRadioButton = radioGroup.findViewById(id);
                switch(checkedRadioButton.getId()){

                    case R.id.lessMale:
                    case R.id.lessFemale:
                        waistPoints = 0;
                        break;

                    case R.id.betweenMale:
                    case R.id.betweenFemale:
                        waistPoints = 4;
                        break;

                    case R.id.overMale:
                    case R.id.overFemale:
                        waistPoints = 6;
                        break;

                }

                currentPoints.setText(waistPoints + loadedPoints+"");
            }
        });

        btn3Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioGroupWaist.getCheckedRadioButtonId() != -1){
                    Intent intent = new Intent(Page3.this, Page4.class);
                    intent.putExtra("Points", waistPoints + loadedPoints);
                    startActivity(intent);
                } else {
                    Toast.makeText(Page3.this, "Please select an option for each category", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("Points", waistPoints + loadedPoints);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        loadedPoints = savedInstanceState.getInt("Points");
    }
}
