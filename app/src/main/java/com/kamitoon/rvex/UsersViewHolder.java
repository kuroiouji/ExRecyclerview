package com.kamitoon.rvex;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

class UsersViewHolder extends RecyclerView.ViewHolder {
    TextView name, username, email, address;

    public UsersViewHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        username = itemView.findViewById(R.id.username);
        email = itemView.findViewById(R.id.email);
        address = itemView.findViewById(R.id.address);
    }
}
