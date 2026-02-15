package com.example.practice;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TasksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        RoleUtils.requireRole(this, "INTERN");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Задания");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        ListView list = findViewById(R.id.listTasks);

        List<Map<String, String>> data = new ArrayList<>();
        data.add(makeItem("task_02 — Основы Git",
                "Инициализация репозитория, commit, push. Оформить README."));
        data.add(makeItem("task_03 — Ветки и merge",
                "Создать ветку, сделать merge и показать историю коммитов."));
        data.add(makeItem("task_04 — Pull Request",
                "Создать PR, описать изменения и добавить ссылку на проверку."));

        SimpleAdapter adapter = new SimpleAdapter(
                this,
                data,
                android.R.layout.simple_list_item_2,
                new String[]{"title", "desc"},
                new int[]{android.R.id.text1, android.R.id.text2}
        );
        list.setAdapter(adapter);

        list.setOnItemClickListener((parent, view, position, id) -> {
            Map<String, String> item = data.get(position);

            Intent intent = new Intent(TasksActivity.this, TaskDetailActivity.class);
            intent.putExtra("taskName", item.get("title"));
            intent.putExtra("taskDesc", item.get("desc"));
            startActivity(intent);
        });
    }

    private Map<String, String> makeItem(String title, String desc) {
        Map<String, String> map = new HashMap<>();
        map.put("title", title);
        map.put("desc", desc);
        return map;
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
