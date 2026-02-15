package com.example.practice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLogin = findViewById(R.id.btnLogin);
        RadioGroup rgRole = findViewById(R.id.rgRole);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedId = rgRole.getCheckedRadioButtonId();

                if (selectedId == R.id.rbMentor) {
                    RoleUtils.setRole(MainActivity.this, "MENTOR");
                    startActivity(new Intent(MainActivity.this, MentorQueueActivity.class));
                } else if (selectedId == R.id.rbCurator) {
                    RoleUtils.setRole(MainActivity.this, "CURATOR");
                    startActivity(new Intent(MainActivity.this, CuratorActivity.class));
                } else {
                    RoleUtils.setRole(MainActivity.this, "INTERN");
                    startActivity(new Intent(MainActivity.this, DashboardActivity.class));
                }
            }
        });
    }
}
