package com.example.kaholas_quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    public static int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager=getSupportFragmentManager();
        if (savedInstanceState!=null){
            return;
        }
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        Q1 q1 = new Q1();
        fragmentTransaction.add(R.id.fragment_container,q1,null);
        fragmentTransaction.commit();
    }

   /* public int setCount() {
        count ++;
        return count;
    }
    */
}