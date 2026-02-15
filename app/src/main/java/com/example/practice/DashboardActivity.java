package com.example.practice;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        RoleUtils.requireRole(this, "INTERN");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Главная");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Button btnGoTasks = findViewById(R.id.btnGoTasks);
        Button btnGoDocs = findViewById(R.id.btnGoDocs);
        Button btnLogout = findViewById(R.id.btnLogout);

        btnGoTasks.setOnClickListener(v ->
                startActivity(new Intent(DashboardActivity.this, TasksActivity.class)));

        btnGoDocs.setOnClickListener(v ->
                startActivity(new Intent(DashboardActivity.this, DocumentsActivity.class)));

        btnLogout.setOnClickListener(v -> {
            startActivity(new Intent(DashboardActivity.this, MainActivity.class));
            finish();
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
