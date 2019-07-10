package com.example.fragmentapps.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.fragmentapps.MainActivity;
import com.example.fragmentapps.R;
import com.example.fragmentapps.ui.login.LoginActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentKetiga extends Fragment {
    Button btnNext;


    public FragmentKetiga() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_fragment_ketiga, container, false);
        View view = inflater.inflate(R.layout.fragment_fragment_ketiga, container, false);

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Rouuf");
        ((MainActivity) getActivity()).getSupportActionBar().setSubtitle("langkah 3");
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnNext = (Button) view.findViewById(R.id.btnNext);

        setHasOptionsMenu(true);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            getFragmentManager().popBackStack();
        }
        return super.onOptionsItemSelected(item);
    }
}
