package com.example.fe_quanlygiaidau.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fe_quanlygiaidau.R;
import com.example.fe_quanlygiaidau.adapter.CauThuAdapter;
import com.example.fe_quanlygiaidau.api.ApiService;
import com.example.fe_quanlygiaidau.joindatabase.Item_hienthi_cauthu;
import com.example.fe_quanlygiaidau.joindatabase.Join_hienthi_cauthu;
import com.example.fe_quanlygiaidau.model.CauThu;
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
    private void fetchDataAndDisplay() {
        // Gọi 3 API đồng thời
        Call<List<CauThu>> call1 = ApiService.apiService.getListCauThu();
        Call<List<DoiBong>> call2 = ApiService.apiService.getListDoiBong();
        Call<List<ViTriCauThu>> call3 = ApiService.apiService.getListViTriCauThu();

        call1.enqueue(new Callback<List<CauThu>>() {
            @Override
            public void onResponse(Call<List<CauThu>> call, Response<List<CauThu>> response1) {
                if (response1.isSuccessful() && response1.body() != null) {
                    List<CauThu> listCauThu = response1.body();

                    call2.enqueue(new Callback<List<DoiBong>>() {
                        @Override
                        public void onResponse(Call<List<DoiBong>> call, Response<List<DoiBong>> response2) {
                            if (response2.isSuccessful() && response2.body() != null) {
                                List<DoiBong> listDoiBong = response2.body();

                                call3.enqueue(new Callback<List<ViTriCauThu>>() {
                                    @Override
                                    public void onResponse(Call<List<ViTriCauThu>> call, Response<List<ViTriCauThu>> response3) {
                                        if (response3.isSuccessful() && response3.body() != null) {
                                            List<ViTriCauThu> listViTri = response3.body();

                                            // Join dữ liệu
                                            Join_hienthi_cauthu joiner = new Join_hienthi_cauthu();
                                            List<Item_hienthi_cauthu> fullList = joiner.mapCauThuNhanh(listCauThu, listDoiBong, listViTri);

                                            // ✅ Lọc theo mã đội bóng
                                            List<Item_hienthi_cauthu> filteredList = new ArrayList<>();
                                            for (Item_hienthi_cauthu item : fullList) {
                                                if (item.getMaDoiBong().equals(idDoiBong)) {
                                                    dscauthu.add(item);
                                                }
                                            }

                                            // Cập nhật adapter
                                            adapter.setMatches(dscauthu);
                                            adapter.notifyDataSetChanged();
                                        } else {
                                            Toast.makeText(ActivityDSCauthu.this, "Lỗi lấy danh sách vị trí", Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<List<ViTriCauThu>> call, Throwable t) {
                                        Toast.makeText(ActivityDSCauthu.this, "Lỗi API vị trí: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                });
                            } else {
                                Toast.makeText(ActivityDSCauthu.this, "Lỗi lấy danh sách đội bóng", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<List<DoiBong>> call, Throwable t) {
                            Toast.makeText(ActivityDSCauthu.this, "Lỗi API đội bóng: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    Toast.makeText(ActivityDSCauthu.this, "Lỗi lấy danh sách cầu thủ", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<CauThu>> call, Throwable t) {
                Toast.makeText(ActivityDSCauthu.this, "Lỗi API cầu thủ: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
