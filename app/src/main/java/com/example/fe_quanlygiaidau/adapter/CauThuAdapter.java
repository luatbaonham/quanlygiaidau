package com.example.fe_quanlygiaidau.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fe_quanlygiaidau.R;
import com.example.fe_quanlygiaidau.joindatabase.Item_hienthi_cauthu;

import java.util.List;

public class CauThuAdapter extends RecyclerView.Adapter<CauThuAdapter.ViewHolder> {

    private List<Item_hienthi_cauthu> dscauthu;
    private Context context;

    public CauThuAdapter(Context context, List<Item_hienthi_cauthu> dscauthu) {
        this.dscauthu = dscauthu;
        this.context = context;
    }

        public void setMatches(List<Item_hienthi_cauthu> dscauthu) {
        this.dscauthu = dscauthu;
    }

    @NonNull
    @Override
    public CauThuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cauthu, parent, false);
        return new CauThuAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CauThuAdapter.ViewHolder holder, int position) {
        // Bind data to views here
        Item_hienthi_cauthu dscauthu = this.dscauthu.get(position);

        String baseUrl = "https://res.cloudinary.com/dyilzwziv/image/upload/";
        String anhcauthu = dscauthu.getHinhAnh();
        String fullImageUrl1 = baseUrl + anhcauthu;
//        Glide.with(context)
//                .load(fullImageUrl1)
//                .placeholder(R.drawable.chan_dung_rice)
//                .error(R.drawable.real)
//                .into(holder.Image_cauthu);
        holder.Image_cauthu.setImageResource(R.drawable.chan_dung_rice);
        holder.tenCauthu.setText(dscauthu.getTenCauThu());
        String soAo = " Số áo: " + dscauthu.getSoAo();
        holder.soAo.setText(String.valueOf(soAo));
        String viTri = " Vị trí: " + dscauthu.getViTri();
        holder.viTri.setText(viTri);
    }

    @Override
    public int getItemCount() {
        return dscauthu.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tenCauthu, soAo, viTri;
        ImageView Image_cauthu;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tenCauthu = itemView.findViewById(R.id.tvTenCauThu);
            soAo = itemView.findViewById(R.id.tvSoAo);
            viTri = itemView.findViewById(R.id.tvViTri);
            Image_cauthu = itemView.findViewById(R.id.imgcauthu);
        }
    }
}
