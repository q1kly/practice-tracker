package com.example.practice;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TaskDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);

        RoleUtils.requireRole(this, "INTERN");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Карточка задания");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        TextView tvTitle = findViewById(R.id.tvTaskTitle);
        TextView tvDesc = findViewById(R.id.tvTaskDesc);
        EditText etLink = findViewById(R.id.etLink);
        Button btnSubmit = findViewById(R.id.btnSubmit);

        String name = getIntent().getStringExtra("taskName");
        String desc = getIntent().getStringExtra("taskDesc");

        tvTitle.setText(name != null ? name : "Задание");
        tvDesc.setText(desc != null ? desc : "Описание отсутствует.");

        btnSubmit.setOnClickListener(v -> {
            String link = etLink.getText().toString().trim();
            if (link.isEmpty()) {
                Toast.makeText(this, "Введите ссылку на GitHub", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Отправлено на проверку!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
