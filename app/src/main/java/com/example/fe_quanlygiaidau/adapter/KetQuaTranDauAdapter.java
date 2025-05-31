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
import com.example.fe_quanlygiaidau.dto.Item_hienthi_KQ;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class KetQuaTranDauAdapter extends RecyclerView.Adapter<KetQuaTranDauAdapter.ViewHolder> {

    private List<Item_hienthi_KQ> dsketQuaTranDau;
    private Context context;

    public KetQuaTranDauAdapter(Context context, List<Item_hienthi_KQ> dsketQuaTranDau) {
        this.dsketQuaTranDau = dsketQuaTranDau;
        this.context = context;
    }

    public void setMatches(List<Item_hienthi_KQ> ketQuaTranDau) {
        this.dsketQuaTranDau = ketQuaTranDau;
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
        Item_hienthi_KQ ketQuaTranDau = this.dsketQuaTranDau.get(position);
        holder.team1Text.setText(ketQuaTranDau.getTenDoi1());
        holder.team2Text.setText(ketQuaTranDau.getTenDoi2());
        String time = ketQuaTranDau.getGioDienRa();
        String gioKhongGiay = time.substring(0, 5);
        Date ngayDienRa = ketQuaTranDau.getNgayDienRa(); // kiểu Date
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String formattedDate = sdf.format(ngayDienRa);
        String formattedTimeDate = " " + gioKhongGiay + " \n " + formattedDate;
        holder.timeText.setText(formattedTimeDate);
        String tiSo = ketQuaTranDau.getSoBanDoi1() + " - " + ketQuaTranDau.getSoBanDoi2();
        holder.scoreText.setText(tiSo);


        String baseUrl = "https://res.cloudinary.com/dyilzwziv/image/upload/";
        String logo1 = ketQuaTranDau.getLogoDoi1();
        String fullImageUrl1 = baseUrl + logo1;
        Glide.with(context)
                .load(fullImageUrl1)
                .placeholder(R.drawable.arsenal)
                .error(R.drawable.real)
                .into(holder.team1Image);
        String logo2 = ketQuaTranDau.getLogoDoi2();
        String fullImageUrl2 = baseUrl + logo2;
        Glide.with(context)
                .load(fullImageUrl2)
                .placeholder(R.drawable.real)
                .error(R.drawable.arsenal)
                .into(holder.team2Image);
//        holder.team1Image.setImageResource(R.drawable.real);
//        holder.team2Image.setImageResource(R.drawable.arsenal);
        holder.tenGiaiDau.setText(ketQuaTranDau.getTengiaidau());

    }

    @Override
    public int getItemCount() {
        return dsketQuaTranDau.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView team1Text, team2Text, scoreText, timeText, tenGiaiDau;
        ImageView team1Image, team2Image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            team1Text = itemView.findViewById(R.id.tv_team1);
            team2Text = itemView.findViewById(R.id.tv_team2);
            scoreText = itemView.findViewById(R.id.tv_score);
            timeText = itemView.findViewById(R.id.tv_time);
            team1Image = itemView.findViewById(R.id.iv_team1);
            team2Image = itemView.findViewById(R.id.iv_team2);
            tenGiaiDau = itemView.findViewById(R.id.tv_tengiai);

        }
    }
}
