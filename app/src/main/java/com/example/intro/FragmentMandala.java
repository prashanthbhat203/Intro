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

public class FragmentMandala extends Fragment {

    View view;
    private RecyclerView recyclerView;
    private List<Arts> artsList;


    public FragmentMandala() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.mandala_fragment, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_mandala);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), artsList);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setAdapter(recyclerViewAdapter);
        return view;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        artsList = new ArrayList<>();
        artsList.add(new Arts("Dot Mandala", "Mandala", "Color appears like a dream", R.drawable.mandala1));
        artsList.add(new Arts("Nature Mandala", "Mandala", "Every day of life is an adventure towards unknown future", R.drawable.mandala2));
        artsList.add(new Arts("Tea Coasters", "Mandala", "Let patience, practise and concentration be your tools", R.drawable.mandala3));
        artsList.add(new Arts("Peacock Mandala", "Mandala", "Believe in your heart that your'e meant to live a life full of passion, purpose, magic and miracles", R.drawable.mandala4));
        artsList.add(new Arts("Dot Mandala", "Mandala", "Nothing goes in vain when work with fullest", R.drawable.mandala5));
        artsList.add(new Arts("Bird Mandala", "Mandala", "When we start observing rather than just seeing things around us, we perceive more ", R.drawable.mandala6));
        artsList.add(new Arts("Flower Mandala", "Mandala", "Sunflower end up facing the sun, but they go through a lot dirt to find their way there", R.drawable.mandala7));
        artsList.add(new Arts("Black and White Mandala", "Mandala", "Focus on your portal, trust the process", R.drawable.mandala8));
        artsList.add(new Arts("Cartoon Mandala", "Mandala", "Yesterday is history. Tomorrow is a mystery. But today is a gift", R.drawable.mandala9));
        artsList.add(new Arts("Half Mandala", "Mandala", "Try and fail,but never fail to try", R.drawable.mandala10));
        artsList.add(new Arts("Golden Mandala", "Mandala", "All that glitters are not gold", R.drawable.mandala11));
        artsList.add(new Arts("Decorative Mandala", "Mandala", "What you have many can have, but who you are, no one can be", R.drawable.mandala12));
        artsList.add(new Arts("Galaxy Mandala", "Mandala", "What blooms in it's time, will bloom the best", R.drawable.mandala13));






    }
}
