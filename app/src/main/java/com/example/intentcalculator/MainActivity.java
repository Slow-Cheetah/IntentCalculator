package com.example.intentcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button mainNavigationBTN;

    TextView calcResultTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mainNavigationBTN = findViewById(R.id.mainNavigationBTN);
        calcResultTV = findViewById(R.id.calcResultTV);

        mainNavigationBTN.setOnClickListener(v -> {
            Intent intent = new Intent(this, CalculateActivity.class);
            startActivity(intent);
        });

        String stroke = getIntent().getStringExtra("key");
        calcResultTV.setText(stroke);

    }
}