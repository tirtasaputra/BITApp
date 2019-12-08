package com.example.bitapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
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

    BITMemberFragment bitMemberFragment;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bitMemberFragment = new BITMemberFragment();
        transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.member_fragment, new BITMemberFragment());
        transaction.addToBackStack(null);
        transaction.commit();

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
                BITMemberFragment bitMemberFragment = new BITMemberFragment();
                bitMemberFragment.setAdapter();
            }
        });

    }

}
