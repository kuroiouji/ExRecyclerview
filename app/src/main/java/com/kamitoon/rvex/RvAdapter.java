package com.kamitoon.rvex;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<UsersViewHolder> {
    private List<Users> users;

    public RvAdapter(List<Users> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.from(parent.getContext())
                .inflate(R.layout.card, parent, false);
        UsersViewHolder pv = new UsersViewHolder(view);
        return pv;
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position) {
        holder.name.setText(users.get(position).getName());
        holder.username.setText(users.get(position).getUsername());
        holder.email.setText(users.get(position).getEmail());
        holder.address.setText(users.get(position).getAddress().getStreet() + " , " + users.get(position).getAddress().getCity());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
