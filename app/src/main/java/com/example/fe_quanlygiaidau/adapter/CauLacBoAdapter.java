package com.example.fe_quanlygiaidau.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.fe_quanlygiaidau.activity.ActivityDSCauthu;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fe_quanlygiaidau.R;
import com.example.fe_quanlygiaidau.model.DoiBong;

import java.util.ArrayList;
import java.util.List;

public class CauLacBoAdapter extends RecyclerView.Adapter<CauLacBoAdapter.ViewHolder> {

    private List<DoiBong> dsDoiBong;
    private Context context;

    public CauLacBoAdapter(Context context, List<DoiBong> dsDoiBong) {
        this.context = context;
        this.dsDoiBong = dsDoiBong;
    }

    public void setdoiBong(List<DoiBong> doiBongList) {
        this.dsDoiBong = doiBongList;
    }

    @NonNull
    @Override
    public CauLacBoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_clb, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CauLacBoAdapter.ViewHolder holder, int position) {
        DoiBong doiBong = dsDoiBong.get(position);
        holder.tvTenDoiBong.setText(doiBong.getTenDoiBong());
        holder.tvQuocGia.setText("Quốc gia: "+doiBong.getQuocGia());
        holder.tvGioiTinh.setText("Câu lạc bộ: "+doiBong.getGioiTinh());
        String baseUrl = "https://res.cloudinary.com/dyilzwziv/image/upload/";
        String logodoi = doiBong.getLogo(); // "7e238089a2201e9c336d698b96425f53.jpg"
        String fullImageUrl1 = baseUrl + logodoi;
//        Glide.with(context)
//                .load(fullImageUrl1)
//                .placeholder(R.drawable.arsenal)
//                .error(R.drawable.real)
//                .into(holder.ivLogo);
        holder.ivLogo.setImageResource(R.drawable.arsenal);
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ActivityDSCauthu.class);
            intent.putExtra("idDoiBong", doiBong.getMaDoiBong());
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return dsDoiBong.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTenDoiBong, tvQuocGia, tvGioiTinh;
        ImageView ivLogo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTenDoiBong = itemView.findViewById(R.id.tvTenCLB);
            tvQuocGia = itemView.findViewById(R.id.tvQuocGia);
            tvGioiTinh = itemView.findViewById(R.id.tvGioiTinh);
            ivLogo = itemView.findViewById(R.id.imgLogoDoi);
        }
    }
}
