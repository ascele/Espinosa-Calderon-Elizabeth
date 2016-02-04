package com.dragonregnan.sistemasdinamicos.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dragonregnan.sistemasdinamicos.R;

/**
 * Created by laura on 03/02/2016.
 */
public class FragmentHistorial extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_historial, container, false);
        return rootView;
    }

}
