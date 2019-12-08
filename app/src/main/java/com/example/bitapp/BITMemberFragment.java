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
    private BITMemberAdapter adapter;
    private ArrayList<BITMember> bitMember;

    BITMember bitMembers;

    public BITMemberFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.member_fragment, container, false);

        addData();

        recyclerView = view.findViewById(R.id.member_recyclerview);
        adapter = new BITMemberAdapter(bitMember);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return view;

    }

    public void setAdapter(){

        recyclerView.setAdapter(adapter);
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
