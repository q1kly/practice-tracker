package com.example.practice;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.*;

public class DocumentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documents);

        RoleUtils.requireRole(this, "INTERN");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Документы");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        ListView list = findViewById(R.id.listDocs);

        List<Map<String, String>> data = new ArrayList<>();
        data.add(item("Отчёт по практике", "Статус: на проверке"));
        data.add(item("Направление на практику", "Статус: готово"));
        data.add(item("Подпись/печать", "Статус: ожидается"));

        SimpleAdapter adapter = new SimpleAdapter(
                this, data, android.R.layout.simple_list_item_2,
                new String[]{"t", "d"}, new int[]{android.R.id.text1, android.R.id.text2}
        );
        list.setAdapter(adapter);

        list.setOnItemClickListener((p, v, pos, id) ->
                Toast.makeText(this, "Действие: открыть/загрузить (заглушка)", Toast.LENGTH_SHORT).show()
        );
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
