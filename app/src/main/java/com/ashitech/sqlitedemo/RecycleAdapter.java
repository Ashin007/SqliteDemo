package com.ashitech.sqlitedemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ashin on 4/2/2018.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder>{

    private ArrayList<ContactInfo> arrayList;
    public RecycleAdapter(ArrayList<ContactInfo> arrayList) {

        this.arrayList = arrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_rv,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvPersonName.setText(arrayList.get(position).getUserName());
        holder.tvContactNumber.setText(arrayList.get(position).getUserContactNumber());
        holder.tvEmail.setText(arrayList.get(position).getUserEmail());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvPersonName,tvContactNumber,tvEmail;
        public ViewHolder(View itemView) {
            super(itemView);
            tvPersonName = itemView.findViewById(R.id.tvPersonName);
            tvContactNumber = itemView.findViewById(R.id.tvContactNumber);
            tvEmail = itemView.findViewById(R.id.tvEmail);

        }
    }
}
