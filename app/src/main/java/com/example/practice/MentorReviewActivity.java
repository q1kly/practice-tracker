package com.example.practice;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MentorReviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor_review);

        RoleUtils.requireRole(this, "MENTOR");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Проверка");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        TextView tvWhoTask = findViewById(R.id.tvWhoTask);
        EditText etComment = findViewById(R.id.etMentorComment);
        Button btnAccept = findViewById(R.id.btnAccept);
        Button btnFix = findViewById(R.id.btnFix);

        String whoTask = getIntent().getStringExtra("whoTask");
        tvWhoTask.setText(whoTask != null ? whoTask : "Проверка задания");

        btnAccept.setOnClickListener(v -> {
            Toast.makeText(this, "Статус: принято (заглушка)", Toast.LENGTH_SHORT).show();
            finish();
        });

        btnFix.setOnClickListener(v -> {
            String c = etComment.getText().toString().trim();
            if (c.isEmpty()) c = "Нужны правки";
            Toast.makeText(this, "Статус: на доработку. Комментарий: " + c, Toast.LENGTH_SHORT).show();
            finish();
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
