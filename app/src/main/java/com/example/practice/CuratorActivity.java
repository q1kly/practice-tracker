package com.example.practice;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CuratorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curator);

        RoleUtils.requireRole(this, "CURATOR");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Куратор");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Button btnLate = findViewById(R.id.btnLateTasks);
        Button btnNoDocs = findViewById(R.id.btnNoDocs);
        Button btnNotify = findViewById(R.id.btnNotify);

        btnLate.setOnClickListener(v ->
                Toast.makeText(this, "Показать просроченные (заглушка)", Toast.LENGTH_SHORT).show());

        btnNoDocs.setOnClickListener(v ->
                Toast.makeText(this, "Показать без документов (заглушка)", Toast.LENGTH_SHORT).show());

        btnNotify.setOnClickListener(v ->
                Toast.makeText(this, "Напоминание отправлено (заглушка)", Toast.LENGTH_SHORT).show());
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
