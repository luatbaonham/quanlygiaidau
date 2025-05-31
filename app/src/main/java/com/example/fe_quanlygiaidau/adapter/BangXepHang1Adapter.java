package com.example.fe_quanlygiaidau.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fe_quanlygiaidau.R;
import com.example.fe_quanlygiaidau.modeladapter.BangXepHangModelAdapter;

import java.util.List;

public class BangXepHang1Adapter extends RecyclerView.Adapter<BangXepHang1Adapter.BangXepHangViewAdapter>{
    private List<BangXepHangModelAdapter> listBangXapHang;

    public BangXepHang1Adapter(List<BangXepHangModelAdapter> listBangXapHang) {
        this.listBangXapHang = listBangXapHang;
    }



    @NonNull
    @Override
    public BangXepHangViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_table_xep_hang, parent, false);
        return new BangXepHangViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BangXepHangViewAdapter holder, int position) {
        BangXepHangModelAdapter bangXepHangModelAdapter=listBangXapHang.get(position);
        holder.tvBangDau.setText(bangXepHangModelAdapter.getTenBang());
        holder.rvlistDoiBong.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
        holder.rvlistDoiBong.setAdapter(new DoiBongBXH1Adapter(bangXepHangModelAdapter.getList()));

        DividerItemDecoration itemDecoration = new DividerItemDecoration(holder.itemView.getContext(),DividerItemDecoration.VERTICAL);
        holder.rvlistDoiBong.addItemDecoration(itemDecoration);
    }

    @Override
    public int getItemCount() {
        if (listBangXapHang != null) {
            return listBangXapHang.size();
        }
        return 0;
    }

    public class BangXepHangViewAdapter extends RecyclerView.ViewHolder {
        TextView tvBangDau;
        RecyclerView rvlistDoiBong;
        public BangXepHangViewAdapter(@NonNull View itemView) {
            super(itemView);
            tvBangDau = itemView.findViewById(R.id.tvBangDau);
            rvlistDoiBong = itemView.findViewById(R.id.rvlistDoiBong);
        }
    }
}
