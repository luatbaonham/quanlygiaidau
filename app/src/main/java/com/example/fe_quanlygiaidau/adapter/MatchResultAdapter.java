package com.example.fe_quanlygiaidau.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fe_quanlygiaidau.R;
import com.example.fe_quanlygiaidau.model.Match;

import java.util.List;

public class MatchResultAdapter extends RecyclerView.Adapter<MatchResultAdapter.ViewHolder> {

    private List<Match> matches;

    public MatchResultAdapter(List<Match> matches) {
        this.matches = matches;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_kq_tran_dau, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Bind data to views here
        Match match = matches.get(position);
        holder.team1Text.setText(match.getTeam1());
        holder.team2Text.setText(match.getTeam2());
        holder.scoreText.setText(match.getScore());
        holder.timeText.setText(match.getTime());
    }

    @Override
    public int getItemCount() {
        return matches.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView team1Text, team2Text, scoreText, timeText;
        ImageView team1Image, team2Image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            team1Text = itemView.findViewById(R.id.tv_team1);
            team2Text = itemView.findViewById(R.id.tv_team2);
            scoreText = itemView.findViewById(R.id.tv_score);
            timeText = itemView.findViewById(R.id.tv_time);
            team1Image = itemView.findViewById(R.id.iv_team1);
            team2Image = itemView.findViewById(R.id.iv_team2);
        }
    }
}
