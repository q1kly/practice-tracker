package com.example.practice;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.*;

public class MentorQueueActivity extends AppCompatActivity {

    private List<Map<String, String>> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor_queue);

        RoleUtils.requireRole(this, "MENTOR");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Очередь проверок");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        ListView list = findViewById(R.id.listSubmissions);

        data = new ArrayList<>();
        data.add(item("Иван Петров • task_03", "Статус: на проверке • ссылка GitHub"));
        data.add(item("Мария Соколова • task_04", "Статус: на проверке • ссылка GitHub"));

        SimpleAdapter adapter = new SimpleAdapter(
                this, data, android.R.layout.simple_list_item_2,
                new String[]{"t", "d"}, new int[]{android.R.id.text1, android.R.id.text2}
        );
        list.setAdapter(adapter);

        list.setOnItemClickListener((p, v, pos, id) -> {
            Intent intent = new Intent(this, MentorReviewActivity.class);
            intent.putExtra("whoTask", data.get(pos).get("t"));
            startActivity(intent);
        });
    }

    private Map<String, String> item(String t, String d) {
        Map<String, String> m = new HashMap<>();
        m.put("t", t);
        m.put("d", d);
        return m;
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
