package com.example.intro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FragmentPencilsketch extends Fragment {

    View view;
    private RecyclerView recyclerView;
    private List<Arts> pencilsketchList;

    public FragmentPencilsketch() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.pencilsketch_fragment, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_pencilsketch);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), pencilsketchList);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setAdapter(recyclerViewAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pencilsketchList = new ArrayList<>();
        pencilsketchList.add(new Arts("Shiva", "Pencil Sketch", "Stop controlling things which are not in your control", R.drawable.pencilsketch1));
        pencilsketchList.add(new Arts("Jack Sparrow", "Pencil Sketch", "Let your smile change the world, don't let the world to change your smile", R.drawable.pencilsketch2));
        pencilsketchList.add(new Arts("Eagles Eye", "Pencil Sketch", "Try and try until you get success", R.drawable.pencilsketch3));
    }
}
