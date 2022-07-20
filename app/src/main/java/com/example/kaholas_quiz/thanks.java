package com.example.kaholas_quiz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class thanks extends Fragment {

    TextView scoreBoard;
    int s;

    public thanks() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_thanks,container,false);

        s = MainActivity.count;
        scoreBoard = view.findViewById(R.id.score);
        String score = "Your Score is : " + s + "";
        scoreBoard.setText(score);

        return view;
    }
}