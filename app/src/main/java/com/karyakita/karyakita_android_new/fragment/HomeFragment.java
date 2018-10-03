package com.karyakita.karyakita_android_new.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.karyakita.karyakita_android_new.R;

public class HomeFragment extends Fragment {
    int kategoris[] = {
            R.drawable.doodle_art,
            R.drawable.kaligrafi,
            R.drawable.karikatur,
            R.drawable.lettering
    };

    GridView homeGrid;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_customer, null);
        return view;



    }

}
