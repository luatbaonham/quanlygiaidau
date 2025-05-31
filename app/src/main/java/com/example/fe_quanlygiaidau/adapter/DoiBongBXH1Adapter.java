package com.example.fe_quanlygiaidau.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fe_quanlygiaidau.R;
import com.example.fe_quanlygiaidau.modeladapter.DoiBongModelAdapter;

import java.util.List;

public class DoiBongBXH1Adapter extends RecyclerView.Adapter<DoiBongBXH1Adapter.DoiBongBXH1ViewAdapter>{
    private List<DoiBongModelAdapter> doiBongBXH1AdapterList;

    public DoiBongBXH1Adapter(List<DoiBongModelAdapter> doiBongBXH1AdapterList) {
        this.doiBongBXH1AdapterList = doiBongBXH1AdapterList;
    }

    @NonNull
    @Override
    public DoiBongBXH1ViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team_xep_hang, parent, false);
        return new DoiBongBXH1ViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoiBongBXH1ViewAdapter holder, int position) {
        DoiBongModelAdapter doibong = doiBongBXH1AdapterList.get(position);
        holder.tvSTTBXH.setText(String.valueOf(doibong.getStt()));
        holder.tvDoiBongBXH.setText(doibong.getDoiBong());
        holder.tvTranDauBXh.setText(String.valueOf(doibong.getTranDau()));
        holder.tvTranThangBXH.setText(String.valueOf(doibong.getTranThang()));
        holder.tvTranHoaBXH.setText(String.valueOf(doibong.getTranHoa()));
        holder.tvTranThuaBXH.setText(String.valueOf(doibong.getTranThua()));
        holder.tvDiemBXH.setText(String.valueOf(doibong.getDiem()));
    }

    @Override
    public int getItemCount() {
        if (doiBongBXH1AdapterList != null) {
            return doiBongBXH1AdapterList.size();
        }
        return 0;
    }

    public class DoiBongBXH1ViewAdapter extends RecyclerView.ViewHolder {
        TextView tvSTTBXH,tvDoiBongBXH,tvTranDauBXh,tvTranThangBXH,tvTranHoaBXH,tvTranThuaBXH,tvDiemBXH;
        public DoiBongBXH1ViewAdapter(@NonNull View itemView) {
            super(itemView);
            tvSTTBXH = itemView.findViewById(R.id.tvSTTBXH);
            tvDoiBongBXH = itemView.findViewById(R.id.tvDoiBongBXH);
            tvTranDauBXh = itemView.findViewById(R.id.tvTranDauBXh);
            tvTranThangBXH = itemView.findViewById(R.id.tvTranThangBXH);
            tvTranHoaBXH = itemView.findViewById(R.id.tvTranHoaBXH);
            tvTranThuaBXH = itemView.findViewById(R.id.tvTranThuaBXH);
            tvDiemBXH = itemView.findViewById(R.id.tvDiemBXH);
        }
    }
}
