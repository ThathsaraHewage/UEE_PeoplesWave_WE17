package com.example.peopleswave;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class loanAdapter extends RecyclerView.Adapter<loanAdapter.MyViewHolder>{
    Context context;
    ArrayList<Loan> list;

    public loanAdapter(Context context, ArrayList<Loan> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Loan loans = list.get(position);
        holder.name.setText(loans.getName());
        holder.bank.setText(loans.getBank());
//        holder.amount.setText(loans.getAmount());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name,amount, bank;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txtname2);
            bank = itemView.findViewById(R.id.txtbranch2);
//            amount = itemView.findViewById(R.id.txtamount2);
        }
    }
}
