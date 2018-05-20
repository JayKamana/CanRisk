package com.example.phonexpc.canrisk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class Page6 extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    Button btn6Next;
    TextView currentPoints;
    CheckBox cbMother, cbFather, cbSibling, cbChildren, cbOther, cbNo;
    int loadedPoints, cbPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page6);

        btn6Next = findViewById(R.id.btn6Next);
        currentPoints = findViewById(R.id.page6Points);

        cbMother = findViewById(R.id.cbMother);
        cbFather = findViewById(R.id.cbFather);
        cbSibling = findViewById(R.id.cbSibling);
        cbChildren = findViewById(R.id.cbChildren);
        cbOther = findViewById(R.id.cbOther);
        cbNo = findViewById(R.id.cbNo);

        cbMother.setOnCheckedChangeListener(this);
        cbFather.setOnCheckedChangeListener(this);
        cbSibling.setOnCheckedChangeListener(this);
        cbChildren.setOnCheckedChangeListener(this);
        cbOther.setOnCheckedChangeListener(this);
        cbNo.setOnCheckedChangeListener(this);

        Bundle bundle = getIntent().getExtras();
        loadedPoints = bundle.getInt("Points");

        currentPoints.setText(loadedPoints+"");

        btn6Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Page6.this, Page7.class);
                intent.putExtra("Points", cbPoints + loadedPoints);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("Points", cbPoints + loadedPoints);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        loadedPoints = savedInstanceState.getInt("Points");
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if(isChecked){
            switch (compoundButton.getId()){
                case R.id.cbMother:
                case R.id.cbFather:
                case R.id.cbSibling:
                case R.id.cbChildren:
                    cbPoints += 2;
                    break;
                case R.id.cbOther:
                case R.id.cbNo:
                    cbPoints += 0;
                    break;
            }
        } else {
            switch (compoundButton.getId()){
                case R.id.cbMother:
                case R.id.cbFather:
                case R.id.cbSibling:
                case R.id.cbChildren:
                    cbPoints -= 2;
                    break;
                case R.id.cbOther:
                case R.id.cbNo:
                    cbPoints -= 0;
                    break;
            }
        }

        currentPoints.setText(cbPoints + loadedPoints+"");
    }
}
