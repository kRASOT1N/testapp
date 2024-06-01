package com.timepet.uppclass;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class preobrazfinish extends AppCompatActivity {
    private static final String PREFS_NAME = "MyPrefs";
    private static final String KEY_BOOLEAN_ONE = "myBooleanOnePreobraz";
    private static final String KEY_BOOLEAN_TWO = "myBooleanTwoPreobraz";

    private static final String KEY_BOOLEAN_THREE = "myBooleanThreePreobraz";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_preobrazfinish);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        boolean myBooleanOne = getBooleanFromSharedPreferences(KEY_BOOLEAN_ONE); // Загрузить значение для первого boolean
        boolean myBooleanTwo = getBooleanFromSharedPreferences(KEY_BOOLEAN_TWO); // Загрузить значение для второго boolean
        boolean myBooleanThree = getBooleanFromSharedPreferences(KEY_BOOLEAN_THREE);
        TextView answer = findViewById(R.id.answer);
        ImageView testbttn = findViewById(R.id.testbttn);
        answer.setText("Первый вопрос:"+myBooleanOne+"         Второй вопрос:"+myBooleanTwo+"      Третий вопрос:"+myBooleanThree);
        testbttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(preobrazfinish.this,AllTest.class));
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