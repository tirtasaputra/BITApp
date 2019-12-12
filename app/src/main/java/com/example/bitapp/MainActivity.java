package com.example.bitapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
//    private BITMemberAdapter adapter;
    private ArrayList<BITMember> bitMember;

    private EditText etName, etDateOfBirth, etGender;
    private Button btnAddMember;

    BITMemberFragment bitMemberFragment, manBitMemberFragment, womanBitMemberFragment;
//    FragmentTransaction transaction;

    ViewPager viewPager;
    TabLayout tabLayout;
    ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bitMemberFragment = new BITMemberFragment("All");
        manBitMemberFragment = new BITMemberFragment("Man");
        womanBitMemberFragment = new BITMemberFragment("Woman");

//        transaction = getSupportFragmentManager().beginTransaction();
//
//        transaction.replace(R.id.member_fragment, bitMemberFragment);
//        transaction.addToBackStack(null);
//        transaction.commit();

        viewPager = findViewById(R.id.member_fragment);
        tabLayout = findViewById(R.id.tab_layout);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.AddFragment(bitMemberFragment,"All");
        adapter.AddFragment(manBitMemberFragment,"Man");
        adapter.AddFragment(womanBitMemberFragment, "Woman");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(Color.WHITE, Color.WHITE);

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

                bitMemberFragment.sendMemberValue(name,dateOfBirth,gender);
                bitMemberFragment.setAdapter();
            }
        });

    }

}
