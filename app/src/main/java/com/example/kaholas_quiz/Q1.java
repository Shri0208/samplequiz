package com.example.kaholas_quiz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;


public class Q1 extends Fragment {

    EditText answer;
    ImageButton ttsBtn;
    Button submitBtn;
    TextToSpeech textToSpeech;
    TextView txt;
    int num;
    int num1;
    int num2;
    int c;

    public Q1() {
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
        View view = inflater.inflate(R.layout.fragment_q1,container,false);


        answer = view.findViewById(R.id.answer1);
        ttsBtn = view.findViewById(R.id.ttsButton1);
        submitBtn = view.findViewById(R.id.submitBtn1);
        txt = view.findViewById(R.id.q1);
        textToSpeech = new TextToSpeech(getContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i!=TextToSpeech.ERROR){
                    // To Choose language of speech
                    textToSpeech.setLanguage(Locale.UK);
                }
            }
        });
        Random r = new Random();
        num1 = r.nextInt(10);
        num2 = r.nextInt(10);
        c = num1*num2;
        String query = "" + num1 + " * " + num2 + " equals?";
        txt.setText(query);
        String newSpeech = "" + num1 + "multiplied by" + num2 + "equals?";

        ttsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textToSpeech.speak(newSpeech,TextToSpeech.QUEUE_FLUSH,null);
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ans = answer.getText().toString();

                if (ans.isEmpty()) {
                    Toast.makeText(getContext(), "Please Enter a Value.", Toast.LENGTH_SHORT).show();;
                }
                else{
                    num = Integer.parseInt(answer.getText().toString());
                    if (num == c){
                        Toast.makeText(getContext(), "Your answer : " + c + " is Correct!", Toast.LENGTH_SHORT).show();
                        MainActivity.count++;
                    }
                    else
                    {
                        Toast.makeText(getContext(), "Your answer : " + num + " is Incorrect!", Toast.LENGTH_SHORT).show();
                    }
                }
                FragmentTransaction t = MainActivity.fragmentManager.beginTransaction();
                Fragment mFrag = new Q2();
                t.replace(R.id.fragment_container, mFrag);
                t.commit();
            }
        });

        return view;
    }
}