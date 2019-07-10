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
public class FragmentPertama extends Fragment {
    Button btnNext;

    public FragmentPertama() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_fragment_pertama, container, false);

        View view = inflater.inflate(R.layout.fragment_fragment_pertama, container, false);

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Rouuf");
        ((MainActivity) getActivity()).getSupportActionBar().setSubtitle("wellcome");
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        btnNext = (Button) view.findViewById(R.id.btnNext);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentKedua fragmentKedua = new FragmentKedua();

                getFragmentManager().beginTransaction()
                        .replace(R.id.frame_content, fragmentKedua)

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
