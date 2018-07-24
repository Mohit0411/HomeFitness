package com.flamezz.homefitness;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class TrainingPlansFragment extends Fragment {

    private ArrayList<Exercises> arrayList;
    public TrainingPlansFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_training_plans, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        arrayList = new ArrayList<>();
        ExerciseAdapter adapter = new ExerciseAdapter(arrayList);
        recyclerView.setAdapter(adapter);
        fillArrayList();

        return view;
    }

    private void fillArrayList()
    {
        Exercises exercises =  new Exercises();
        exercises.setName("FULL BODY");
        arrayList.add(exercises);

        Exercises exercises1 = new Exercises();
        exercises1.setName("LOWER BODY");
        arrayList.add(exercises1);

        Exercises exercises2 = new Exercises();
        exercises2.setName("CHEST BEGINNER");
        exercises2.setDifficultylevel(R.drawable.difficultylevel);
        arrayList.add(exercises2);

        Exercises exercises3 = new Exercises();
        exercises3.setName("CHEST INTERMEDIATE");
        exercises3.setDifficultylevel(R.drawable.difficultylevel);
        exercises3.setDifficultylevel2(R.drawable.difficultylevel);
        arrayList.add(exercises3);

        Exercises exercises4 = new Exercises();
        exercises4.setName("CHEST ADVANCED");
        exercises4.setDifficultylevel(R.drawable.difficultylevel);
        exercises4.setDifficultylevel2(R.drawable.difficultylevel);
        exercises4.setDifficultylevel3(R.drawable.difficultylevel);
        arrayList.add(exercises4);

        Exercises exercises5 = new Exercises();
        exercises5.setName("ABS BEGINNER");
        exercises5.setDifficultylevel(R.drawable.difficultylevel);
        arrayList.add(exercises5);

        Exercises exercises6 = new Exercises();
        exercises6.setName("ABS INTERMEDIATE");
        exercises6.setDifficultylevel(R.drawable.difficultylevel);
        exercises6.setDifficultylevel2(R.drawable.difficultylevel);
        arrayList.add(exercises6);

        Exercises exercises7 = new Exercises();
        exercises7.setName("ABS ADVANCED");
        exercises7.setDifficultylevel(R.drawable.difficultylevel);
        exercises7.setDifficultylevel2(R.drawable.difficultylevel);
        exercises7.setDifficultylevel3(R.drawable.difficultylevel);
        arrayList.add(exercises7);

        Exercises exercises8 = new Exercises();
        exercises8.setName("LEGS BEGINNER");
        exercises8.setDifficultylevel(R.drawable.difficultylevel);
        arrayList.add(exercises8);

        Exercises exercises9 = new Exercises();
        exercises9.setName("LEGS INTERMEDIATE");
        exercises9.setDifficultylevel(R.drawable.difficultylevel);
        exercises9.setDifficultylevel2(R.drawable.difficultylevel);
        arrayList.add(exercises9);

        Exercises exercises10 = new Exercises();
        exercises10.setName("LEGS ADVANCED");
        exercises10.setDifficultylevel(R.drawable.difficultylevel);
        exercises10.setDifficultylevel2(R.drawable.difficultylevel);
        exercises10.setDifficultylevel3(R.drawable.difficultylevel);
        arrayList.add(exercises10);
    }

}
