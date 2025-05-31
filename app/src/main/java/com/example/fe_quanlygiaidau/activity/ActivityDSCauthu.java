package com.example.fe_quanlygiaidau.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fe_quanlygiaidau.R;
import com.example.fe_quanlygiaidau.adapter.CauThuAdapter;
import com.example.fe_quanlygiaidau.api.ApiService;
import com.example.fe_quanlygiaidau.dto.Item_hienthi_cauthu;
import com.example.fe_quanlygiaidau.dto.Join_hienthi_cauthu;
import com.example.fe_quanlygiaidau.model.CauThu;
import com.example.fe_quanlygiaidau.model.CauThuGiaiDau;
import com.example.fe_quanlygiaidau.model.DoiBong;
import com.example.fe_quanlygiaidau.model.ViTriCauThu;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityDSCauthu extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CauThuAdapter adapter;
    private List<Item_hienthi_cauthu> dscauthu;
    private String idDoiBong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cauthu);

        recyclerView = findViewById(R.id.rv_dscauthu);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Khởi tạo adapter với danh sách trống ban đầu
        dscauthu = new ArrayList<>();
        adapter = new CauThuAdapter(this, new ArrayList<>());
        recyclerView.setAdapter(adapter);

        // Nhận mã đội bóng từ Intent
        idDoiBong = getIntent().getStringExtra("idDoiBong"); // Nếu mã đội bóng là String

        if (idDoiBong != null) {
            fetchDataAndDisplay();
        } else {
            Toast.makeText(this, "Không có ID đội bóng", Toast.LENGTH_SHORT).show();
        }
    }
    private int totalApiCalls = 3;
    private int loadedCount = 0;
    List<CauThu> cauThus;
    List<DoiBong> doiBongs;
    List<ViTriCauThu> vitris;
    List<CauThuGiaiDau> cauThuGiaiDaus;
    private void   fetchDataAndDisplay(){
        loadedCount = 0;

        ApiService.apiService.getListCauThu().enqueue(new Callback<List<CauThu>>() {
            @Override
            public void onResponse(Call<List<CauThu>> call, Response<List<CauThu>> response) {
                if (response.isSuccessful()) {
                    cauThus = response.body();
                }
                onApiLoaded();
            }
            @Override
            public void onFailure(Call<List<CauThu>> call, Throwable t) {
                onApiLoaded();
            }
        });
        ApiService.apiService.getListDoiBong().enqueue(new Callback<List<DoiBong>>() {
            @Override
            public void onResponse(Call<List<DoiBong>> call, Response<List<DoiBong>> response) {
                if (response.isSuccessful()) {
                    doiBongs = response.body();
                }
                onApiLoaded();
            }

            @Override
            public void onFailure(Call<List<DoiBong>> call, Throwable t) {
                onApiLoaded();
            }
        });
        ApiService.apiService.getListViTriCauThu().enqueue(new Callback<List<ViTriCauThu>>() {

            @Override
            public void onResponse(Call<List<ViTriCauThu>> call, Response<List<ViTriCauThu>> response) {
                if (response.isSuccessful()) {
                    vitris = response.body();
                }
                onApiLoaded();
            }
            @Override
            public void onFailure(Call<List<ViTriCauThu>> call, Throwable t) {
                onApiLoaded();
            }
        });
    }

    private synchronized void onApiLoaded() {
        loadedCount++;
        if (loadedCount == totalApiCalls) {
            if (cauThus != null && doiBongs != null && vitris != null) {
                Join_hienthi_cauthu joiner = new Join_hienthi_cauthu();
                List<Item_hienthi_cauthu> dscauthu = joiner.mapCauThuNhanh(
                        cauThus, doiBongs, vitris
                );
                adapter.setMatches(dscauthu);
                adapter.notifyDataSetChanged();
            } else {
                Toast.makeText(this, "Lỗi tải dữ liệu!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
