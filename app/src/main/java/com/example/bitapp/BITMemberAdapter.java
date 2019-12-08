package com.example.bitapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BITMemberAdapter extends RecyclerView.Adapter<BITMemberAdapter.BITMemberViewHolder>{

    private ArrayList<BITMember> bitMember;
    private Context context;

    public BITMemberAdapter(ArrayList<BITMember> bitMember){
        this.bitMember = bitMember;
    }

    @NonNull
    @Override
    public BITMemberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.member_recyclerview, parent, false);
        return new BITMemberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BITMemberViewHolder holder, int position) {
        holder.tvName.setText(bitMember.get(position).getName());
        holder.tvDateOfBirth.setText(bitMember.get(position).getDateOfBirth());

        String gender = bitMember.get(position).getGender();
        if (gender.equals("M")){
            holder.ivGender.setImageResource(R.drawable.image_man);
        } else {
            holder.ivGender.setImageResource(R.drawable.image_woman);
        }


    }

    @Override
    public int getItemCount() {
        return (bitMember != null) ? bitMember.size() : 0;
    }

    public class BITMemberViewHolder extends RecyclerView.ViewHolder{

        private TextView tvName, tvDateOfBirth;
        private ImageView ivGender;

        public BITMemberViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvDateOfBirth = itemView.findViewById(R.id.tv_dateOfBirth);
            ivGender = itemView.findViewById(R.id.iv_Gender);
        }
    }
}
