package com.example.intentcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculateActivity extends AppCompatActivity implements View.OnClickListener {

    EditText topLineET;

    EditText secondLineET;

    Button plusBTN;

    Button minusBTN;

    Button multBTN;

    Button divBTN;

    TextView secondResultTV;

    Button calcNavigationBTN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculate);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        unitUI();
        onButtonsClick();


        calcNavigationBTN.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("key", secondResultTV.getText().toString());
            startActivity(intent);
        });
    }

    private void onButtonsClick() {
        plusBTN.setOnClickListener(this);
        minusBTN.setOnClickListener(this);
        multBTN.setOnClickListener(this);
        divBTN.setOnClickListener(this);
    }


    private void unitUI() {
        topLineET = findViewById(R.id.topLineET);
        secondLineET = findViewById(R.id.secondLineET);
        plusBTN = findViewById(R.id.plusBTN);
        minusBTN = findViewById(R.id.minusBTN);
        multBTN = findViewById(R.id.multBTN);
        divBTN = findViewById(R.id.divBTN);
        secondResultTV = findViewById(R.id.secondResultTV);
        calcNavigationBTN = findViewById(R.id.calcNavigationBTN);
    }



    public Integer sum(Integer numbOne, Integer numbTwo) {
        Integer sumResult = numbOne + numbTwo;
        return sumResult;
    }

    public Integer minus(Integer numbOne, Integer numbTwo) {
        Integer minusResult = numbOne - numbTwo;
        return minusResult;
    }

    public Integer mult(Integer numbOne, Integer numbTwo) {
        Integer multResult = numbOne * numbTwo;
        return multResult;
    }

    public Integer div(Integer numbOne, Integer numbTwo) {
        if (numbTwo == 0) {
            Toast.makeText(this, "Деление на 0 НЕДОПУСТМО", Toast.LENGTH_SHORT).show();
            return null;
        } else {
            Integer divResult = numbOne / numbTwo;
            return divResult;
        }
    }

    public String resultToString(Integer result) {
        String strokeResult = result.toString();
        return strokeResult;
    }

    @Override
    public void onClick(View v) {
        Integer result = 0;
        Integer numbOne;
        Integer numbTwo;
        //Обработаем первое поле ввода
        if (topLineET.getText().toString().isEmpty()) {
            numbOne = 0;
        } else {
            numbOne = Integer.parseInt(topLineET.getText().toString());
        }
        //Работаем с вторым полем
        if (secondLineET.getText().toString().isEmpty()) {
            numbTwo = 0;
        } else {
            numbTwo = Integer.parseInt(secondLineET.getText().toString());
        }
        switch (v.getId()) {
            case R.id.plusBTN:
                result = sum(numbOne, numbTwo);
                break;
            case R.id.minusBTN:
                result = minus(numbOne, numbTwo);
                break;
            case R.id.multBTN:
                result = mult(numbOne, numbTwo);
                break;
            case R.id.divBTN:
                result = div(numbOne, numbTwo);
                break;
        }
        secondResultTV.setText(result.toString());
    }
}