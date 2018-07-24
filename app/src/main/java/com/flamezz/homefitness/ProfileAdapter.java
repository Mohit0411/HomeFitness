package com.flamezz.homefitness;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;


import java.util.ArrayList;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder> {

    ArrayList<User> arrayList;
    FirebaseAuth firebaseAuth;
    ProfileAdapter(ArrayList<User> arrayList)
    {
        this.arrayList=arrayList;
    }
    @NonNull
    @Override
    public ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_recycler_view,parent,false);
        ProfileViewHolder viewHolder = new ProfileViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileViewHolder holder, int position) {
            User user = arrayList.get(position);
            holder.profileName.setText("Name:\t" +user.getName() );
            holder.profileEmail.setText("Email:\t" + user.getEmail());
            holder.profilePhone.setText("Phone:\t" + user.getPhone());


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ProfileViewHolder extends RecyclerView.ViewHolder
    {
        TextView profileName,profileEmail,profilePhone;
        ProfileViewHolder(View view)
        {
            super(view);
            profileName = view.findViewById(R.id.profileName);
            profileEmail = view.findViewById(R.id.profileEmail);
            profilePhone = view.findViewById(R.id.profilePhone);
        }
    }
}
