package com.timepet.uppclass;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class metr2 extends AppCompatActivity {
    private static final String PREFS_NAME = "MyPrefs";
    private static final String KEY_BOOLEAN_ONE = "myBooleanOneMetr";
    private static final String KEY_BOOLEAN_TWO = "myBooleanTwoMetr";

    private static final String KEY_BOOLEAN_THREE = "myBooleanThreeMetr";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_metr2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageView otvet1 = findViewById(R.id.imageView15);
        ImageView otvet2 = findViewById(R.id.imageView16);
        ImageView otvet3 = findViewById(R.id.imageView17);
        ImageView otvet4 = findViewById(R.id.imageView18);







        TextView textView = findViewById(R.id.textView);

        CountDownTimer timer = new CountDownTimer(60000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                // Обновляем TextView с оставшимся временем
                textView.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                saveBooleanInSharedPreferences(KEY_BOOLEAN_ONE, false);
                startActivity(new Intent(metr2.this, metr3.class));
                finish();
            }
        };

        timer.start();

        otvet1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                saveBooleanInSharedPreferences(KEY_BOOLEAN_ONE, true);

                startActivity(new Intent(metr2.this, metr3.class));
                finish();
            }
        });
        otvet2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                saveBooleanInSharedPreferences(KEY_BOOLEAN_ONE, false);
                startActivity(new Intent(metr2.this, metr3.class));
                finish();
            }
        });
        otvet3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                saveBooleanInSharedPreferences(KEY_BOOLEAN_ONE, false);
                startActivity(new Intent(metr2.this, metr3.class));
                finish();
            }
        });
        otvet4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                saveBooleanInSharedPreferences(KEY_BOOLEAN_ONE, false);
                startActivity(new Intent(metr2.this, metr3.class));
                finish();
            }
        });

    }
    private void saveBooleanInSharedPreferences(String key, boolean value) {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    // Метод для получения значения boolean из SharedPreferences
    private boolean getBooleanFromSharedPreferences(String key) {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, false); // Второй параметр - значение по умолчанию
    }
}