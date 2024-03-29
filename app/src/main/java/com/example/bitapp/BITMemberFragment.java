package com.example.bitapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BITMemberFragment extends Fragment {

    private RecyclerView recyclerView;
    private BITMemberAdapter adapter, manAdapter, womanAdapter;
    private ArrayList<BITMember> bitMember, bitMan, bitWoman;

    BITMember bitMembers;

    private String name, dateOfBirth, gender;
    private String flag;


    public BITMemberFragment(String p_flag) {
        flag = p_flag;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.member_fragment, container, false);

        addData();
        addManData();
        addWomanData();

        recyclerView = view.findViewById(R.id.member_recyclerview);
        if (flag.equals("All")){
            adapter = new BITMemberAdapter(bitMember);
        } else if (flag.equals("Man")){
            adapter = new BITMemberAdapter(bitMan);
        } else if (flag.equals("Woman")){
            adapter = new BITMemberAdapter(bitWoman);
        }

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return view;

    }

    public void setAdapter(){
        bitMember.add(new BITMember(name, dateOfBirth, gender));
        recyclerView.setAdapter(adapter);
    }

    public void addData(){
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

    public void addManData(){
        bitMan = new ArrayList<>();
        for (int i = 0; i<bitMember.size(); i++){
            String gender = bitMember.get(i).getGender();
            if (gender.equals("M")){
                bitMan.add(bitMember.get(i));
            }
        }
    }

    public void addWomanData(){
        bitWoman = new ArrayList<>();
        for (int i = 0; i<bitMember.size(); i++){
            String gender = bitMember.get(i).getGender();
            if (gender.equals("W")){
                bitWoman.add(bitMember.get(i));
            }
        }
    }


    public void sendMemberValue(String name, String dateOfBirth, String gender){
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

}
