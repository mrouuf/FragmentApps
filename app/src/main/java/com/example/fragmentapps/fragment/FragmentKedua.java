package com.example.fragmentapps.fragment;


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


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentKedua extends Fragment {
    Button btnNext;


    public FragmentKedua() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_fragment_kedua, container, false);
        View view = inflater.inflate(R.layout.fragment_fragment_kedua, container, false);

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Rouuf");
        ((MainActivity) getActivity()).getSupportActionBar().setSubtitle("langkah 2");
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
                FragmentKetiga fragmentKetiga = new FragmentKetiga();

                getFragmentManager().beginTransaction()
                        .replace(R.id.frame_content, fragmentKetiga)

                        .addToBackStack(null)

                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)

                        .commit();
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
