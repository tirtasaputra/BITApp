package com.example.bitapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BITMemberAdapter adapter;
    private ArrayList<BITMember> bitMember;

    private EditText etName, etDateOfBirth, etGender;
    private Button btnAddMember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addData();
        recyclerView = findViewById(R.id.member_recyclerview);
        adapter = new BITMemberAdapter(bitMember);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        etName = findViewById(R.id.et_name);
        etDateOfBirth = findViewById(R.id.et_date_of_birth);
        etGender = findViewById(R.id.et_gender);
        btnAddMember = findViewById(R.id.btn_add);

        btnAddMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String dateOfBirth = etDateOfBirth.getText().toString();
                String gender = etGender.getText().toString();

                bitMember.add(new BITMember(name, dateOfBirth, gender));
                recyclerView.setAdapter(adapter);

            }
        });

    }

    void addData(){
        bitMember = new ArrayList<>();
        bitMember.add(new BITMember("Edwin", "12-01-1997", "M"));
        bitMember.add(new BITMember("Putra", "12-01-1997", "M"));
        bitMember.add(new BITMember("Steven", "12-01-1997", "M"));
        bitMember.add(new BITMember("Christian", "12-01-1997", "M"));
        bitMember.add(new BITMember("Nada", "12-01-1997", "W"));
        bitMember.add(new BITMember("Dennis", "12-01-1997", "M"));
        bitMember.add(new BITMember("Gio", "12-01-1997", "M"));
        bitMember.add(new BITMember("Anthony", "12-01-1997", "M"));
        bitMember.add(new BITMember("Felix", "12-01-1997", "M"));
        bitMember.add(new BITMember("Winston", "12-01-1997", "M"));
        bitMember.add(new BITMember("Kelvin", "12-01-1997", "M"));
        bitMember.add(new BITMember("Rio", "12-01-1997", "M"));
        bitMember.add(new BITMember("Vincent", "12-01-1997", "M"));
        bitMember.add(new BITMember("Evelyn", "12-01-1997", "W"));
        bitMember.add(new BITMember("William", "12-01-1997", "M"));
        bitMember.add(new BITMember("Fakhri", "12-01-1997", "M"));
    }
}
