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
import com.example.fe_quanlygiaidau.modeladapter.TranDauModelAdapter;

import java.util.List;

public class TranDau1Adapter extends RecyclerView.Adapter<TranDau1Adapter.Trandau1ViewAdapter> {

    private List<TranDauModelAdapter> listTraudau;

    public TranDau1Adapter(List<TranDauModelAdapter> listTraudau) {
        this.listTraudau = listTraudau;
    }

    @NonNull
    @Override
    public Trandau1ViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trau_dau1, parent, false);
        return new Trandau1ViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Trandau1ViewAdapter holder, int position) {
            TranDauModelAdapter trandau = listTraudau.get(position);
            holder.tvVongDau.setText(trandau.getVongdau());
            holder.tvTySo.setText(trandau.getTyso());
            holder.tvtenDoi1.setText(trandau.getTenDoi1());
            holder.tvtenDoi2.setText(trandau.getTenDoi2());
            holder.tvThoiGian.setText(trandau.getGio());
            holder.tvNgayToChuc.setText(trandau.getNgay());
            holder.tvTenSanVanDong.setText(trandau.getSanvandong());

        String baseUrl = "https://res.cloudinary.com/dyilzwziv/image/upload/";
        String fullImageUrl1 = baseUrl + trandau.getHinhAnhDoi1();
        String fullImageUrl2 = baseUrl + trandau.getHinhAnhDoi2();
        Glide.with(holder.itemView.getContext())
                .load(fullImageUrl1)
                .placeholder(R.drawable.mancity)
                .error(R.drawable.mancity)
                .into(holder.imhinhAnhDoi1);
        Glide.with(holder.itemView.getContext())
                .load(fullImageUrl2)
                .placeholder(R.drawable.chelsea)
                .error(R.drawable.chelsea)
                .into(holder.imhinhAnhDoi2);

    }
    @Override
    public int getItemCount() {
        if (listTraudau != null) {
            return listTraudau.size();
        }
        return 0;
    }

    public class Trandau1ViewAdapter extends RecyclerView.ViewHolder{
        TextView tvVongDau,tvtenDoi1,tvTySo,tvThoiGian,tvNgayToChuc,tvtenDoi2,tvTenSanVanDong;
        ImageView imhinhAnhDoi2,imhinhAnhDoi1;
        public Trandau1ViewAdapter(@NonNull View itemView) {
            super(itemView);
            tvVongDau = itemView.findViewById(R.id.tvVongDau);
            tvtenDoi1 = itemView.findViewById(R.id.tvtenDoi1);
            tvtenDoi2 = itemView.findViewById(R.id.tvtenDoi2);
            tvTySo = itemView.findViewById(R.id.tvTySo);
            tvThoiGian = itemView.findViewById(R.id.tvThoiGian);
            tvNgayToChuc=itemView.findViewById(R.id.tvNgayToChuc);
            tvTenSanVanDong=itemView.findViewById(R.id.tvTenSanVanDong);
            imhinhAnhDoi1=itemView.findViewById(R.id.imhinhAnhDoi1);
            imhinhAnhDoi2=itemView.findViewById(R.id.imhinhAnhDoi2);

        }
    }
}
