package com.flamezz.homefitness;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder> {

   private ArrayList<Exercises> arrayList;
   private Context context;
    ExerciseAdapter(ArrayList<Exercises> arrayList)
    {
        this.arrayList=arrayList;
    }
    @NonNull
    @Override
    public ExerciseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_exercise,parent,false);
        ExerciseViewHolder viewHolder = new ExerciseViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseViewHolder holder, int position) {
        Exercises exercises = arrayList.get(position);
        holder.exerciseName.setText(exercises.getName());
        holder.difficultylevel1.setImageResource(exercises.getDifficultylevel());
        holder.difficultylevel2.setImageResource(exercises.getDifficultylevel2());
        holder.difficultylevel3.setImageResource(exercises.getDifficultylevel3());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"Coming Soon",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ExerciseViewHolder extends RecyclerView.ViewHolder
    {
        TextView exerciseName;
        ImageView difficultylevel1,difficultylevel2,difficultylevel3;
        ExerciseViewHolder(View view)
        {
            super(view);
            exerciseName = view.findViewById(R.id.exerciseName);
            difficultylevel1 = view.findViewById(R.id.difficultyLevel1);
            difficultylevel2 = view.findViewById(R.id.difficultyLevel2);
            difficultylevel3 = view.findViewById(R.id.difficultyLevel3);
        }
    }
}
