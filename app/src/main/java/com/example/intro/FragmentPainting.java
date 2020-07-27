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

public class FragmentPainting extends Fragment {

    View view;
    private RecyclerView recyclerView;
    private List<Arts> paintingList;

    public FragmentPainting() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.painting_fragment, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_panting);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), paintingList);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setAdapter(recyclerViewAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        paintingList = new ArrayList<>();
        paintingList.add(new Arts("Colors on a bottle", "Painting", "Color appears like a dream", R.drawable.painting1));
        paintingList.add(new Arts("Threads and colors on a bottle", "Painting", "Every day of life is an adventure towards unknown future", R.drawable.painting2));
        paintingList.add(new Arts("Cracked bottle", "Painting", "Let patience, practise and concentration be your tools", R.drawable.painting3));

    }
}
