package com.example.fe_quanlygiaidau.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fe_quanlygiaidau.R;
import com.example.fe_quanlygiaidau.adapter.MatchResultAdapter;
import com.example.fe_quanlygiaidau.model.Match;

import java.util.ArrayList;
import java.util.List;

public class Fragment_ket_qua extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ket_qua, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.rv_match_results);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new MatchResultAdapter(getSampleMatches()));
    }

    private List<Match> getSampleMatches() {
        List<Match> matches = new ArrayList<>();
        matches.add(new Match("Arsenal", "Real Đần", "5 - 1", "20:00 - 12/05/2023"));
        matches.add(new Match("Man City", "Barcelona", "3 - 2", "21:00 - 13/05/2023"));
        matches.add(new Match("Man City", "Barcelona", "3 - 2", "21:00 - 13/05/2023"));
        matches.add(new Match("Man City", "Barcelona", "3 - 2", "21:00 - 13/05/2023"));
        matches.add(new Match("Man City", "Barcelona", "3 - 2", "21:00 - 13/05/2023"));
        matches.add(new Match("Man City", "Barcelona", "3 - 2", "21:00 - 13/05/2023"));
        matches.add(new Match("Man City", "Barcelona", "3 - 2", "21:00 - 13/05/2023"));
        matches.add(new Match("Man City", "Barcelona", "3 - 2", "21:00 - 13/05/2023"));
        matches.add(new Match("Man City", "Barcelona", "3 - 2", "21:00 - 13/05/2023"));
        return matches;
    }
}
