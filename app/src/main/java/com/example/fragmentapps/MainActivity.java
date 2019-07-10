package com.example.fragmentapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.fragmentapps.fragment.FragmentPertama;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bersiap untuk interaksi antar fragment dengan main activity
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //memulai transaction fragment manager

        FragmentPertama fragmentPertama = new FragmentPertama();
        //membuat object fragment wellcome
        transaction.add(R.id.frame_content, fragmentPertama);
        //menambahkan fragment
        transaction.addToBackStack("Wellcome Fragment");
        //dapat menyimpan fragment ke dalam state, ketika tombol back di klik
        transaction.commit();
        //mengeksekusi fragment transaction
    }
}
