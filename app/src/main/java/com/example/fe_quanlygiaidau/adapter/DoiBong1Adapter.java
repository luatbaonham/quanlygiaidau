package com.example.fe_quanlygiaidau.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fe_quanlygiaidau.R;
import com.example.fe_quanlygiaidau.model.DoiBongGiaiDau;

import java.util.List;

public class DoiBong1Adapter extends RecyclerView.Adapter<DoiBong1Adapter.DoiBong1ViewAdapter>{

    private List<DoiBongGiaiDau> listDoiBong;

    public DoiBong1Adapter(List<DoiBongGiaiDau> listDoiBong) {
        this.listDoiBong = listDoiBong;
    }

    @NonNull
    @Override
    public DoiBong1ViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_doi_bong1, parent, false);
        return new DoiBong1ViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoiBong1ViewAdapter holder, int position) {
        DoiBongGiaiDau doibong = listDoiBong.get(position);
        if(doibong==null){
            return;
        }
        holder.sttDoiBong.setText(String.valueOf(position + 1));
        holder.tenDoiBong.setText(doibong.getTenDoiBong());
        String baseUrl = "https://res.cloudinary.com/dyilzwziv/image/upload/";
        String fullImageUrl1 = baseUrl + doibong.getLogo();
        Glide.with(holder.logoDoiBong.getContext())
                .load(fullImageUrl1)
                .placeholder(R.drawable.mancity)
                .error(R.drawable.mancity)
                .into(holder.logoDoiBong);
    }

    @Override
    public int getItemCount() {
        if (listDoiBong != null) {
            return listDoiBong.size();
        }
        return 0;
    }

    public class DoiBong1ViewAdapter extends RecyclerView.ViewHolder{
        private TextView sttDoiBong,tenDoiBong;
        private ImageView logoDoiBong;


        public DoiBong1ViewAdapter(@NonNull View itemView) {
            super(itemView);
            sttDoiBong = itemView.findViewById(R.id.sttDoiBong);
            tenDoiBong = itemView.findViewById(R.id.tenDoiBong);
            logoDoiBong = itemView.findViewById(R.id.logoDoiBong);
        }
    }
}
