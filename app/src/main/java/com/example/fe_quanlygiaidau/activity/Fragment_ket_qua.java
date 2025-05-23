package com.example.fe_quanlygiaidau.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fe_quanlygiaidau.R;
import com.example.fe_quanlygiaidau.adapter.KetQuaTranDauAdapter;
import com.example.fe_quanlygiaidau.api.ApiService;
import com.example.fe_quanlygiaidau.joindatabase.Item_hienthi_KQ;
import com.example.fe_quanlygiaidau.joindatabase.Join_hienthi_KQ;
import com.example.fe_quanlygiaidau.model.DoiBong;
import com.example.fe_quanlygiaidau.model.Giaidau;
import com.example.fe_quanlygiaidau.model.KetQuaTranDau;
import com.example.fe_quanlygiaidau.model.TranDau;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_ket_qua extends Fragment {

    private KetQuaTranDauAdapter adapter;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ket_qua, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rv_match_results);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new KetQuaTranDauAdapter(getContext(), new ArrayList<>());
        recyclerView.setAdapter(adapter);

        fetchKQTDFromApi();  // gọi API lấy dữ liệu
    }

    private void fetchKQTDFromApi() {
        ApiService.apiService.getListKetQuaTranDau().enqueue(new Callback<List<KetQuaTranDau>>() {
            @Override
            public void onResponse(Call<List<KetQuaTranDau>> call, Response<List<KetQuaTranDau>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<KetQuaTranDau> ketQuaTranDauList = response.body();

                    for (KetQuaTranDau kq : ketQuaTranDauList) {
                        Log.d("KetQuaTranDau", "Số bàn đội 1: " + kq.getSoBanDoi1() + ", đội 2: " + kq.getSoBanDoi2());
                    }

                    ApiService.apiService.getListTranDau().enqueue(new Callback<List<TranDau>>() {
                        @Override
                        public void onResponse(Call<List<TranDau>> call, Response<List<TranDau>> response2) {
                            if (response2.isSuccessful() && response2.body() != null) {
                                List<TranDau> tranDauList = response2.body();

                                for (TranDau td : tranDauList) {
                                    Log.d("TranDau", "Mã đội 1: " + td.getMaDoi1() + ", mã đội 2: " + td.getMaDoi2());
                                }

                                ApiService.apiService.getListDoiBong().enqueue(new Callback<List<DoiBong>>() {
                                    @Override
                                    public void onResponse(Call<List<DoiBong>> call, Response<List<DoiBong>> response3) {
                                        if (response3.isSuccessful() && response3.body() != null) {
                                            List<DoiBong> doiBongList = response3.body();

                                            for (DoiBong db : doiBongList) {
                                                Log.d("DoiBong", "Tên: " + db.getTenDoiBong() + ", logo: " + db.getLogo() + ", quốc gia: " + db.getQuocGia());
                                            }

                                            ApiService.apiService.getListGiaiDau().enqueue(new Callback<List<Giaidau>>() {
                                                @Override
                                                public void onResponse(Call<List<Giaidau>> call, Response<List<Giaidau>> response4) {
                                                    if (response4.isSuccessful() && response4.body() != null) {
                                                        List<Giaidau> giaiDauList = response4.body();

                                                        for (Giaidau gd : giaiDauList) {
                                                            Log.d("GiaiDau", "Tên giải: " + gd.getTenGiaiDau() + ", ngày kết thúc: " + gd.getNgayKetThuc());
                                                        }

                                                        Join_hienthi_KQ joiner = new Join_hienthi_KQ();
                                                        List<Item_hienthi_KQ> kq = joiner.mapKetQuaNhanh(
                                                                ketQuaTranDauList, tranDauList, doiBongList, giaiDauList
                                                        );

                                                        adapter.setMatches(kq);
                                                        adapter.notifyDataSetChanged();

                                                        Toast.makeText(getContext(), "Có " + kq.size() + " kết quả", Toast.LENGTH_SHORT).show();
                                                    } else {
                                                        Log.e("API_ERROR", "getListGiaiDau trả về null hoặc lỗi.");
                                                    }
                                                }

                                                @Override
                                                public void onFailure(Call<List<Giaidau>> call, Throwable t) {
                                                    Log.e("API_ERROR", "getListGiaiDau thất bại: " + t.getMessage(), t);
                                                }
                                            });

                                        } else {
                                            Log.e("API_ERROR", "getListDoiBong trả về null hoặc lỗi.");
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<List<DoiBong>> call, Throwable t) {
                                        Log.e("API_ERROR", "getListDoiBong thất bại: " + t.getMessage(), t);
                                    }
                                });

                            } else {
                                Log.e("API_ERROR", "getListTranDau trả về null hoặc lỗi.");
                            }
                        }

                        @Override
                        public void onFailure(Call<List<TranDau>> call, Throwable t) {
                            Log.e("API_ERROR", "getListTranDau thất bại: " + t.getMessage(), t);
                        }
                    });

                } else {
                    Log.e("API_ERROR", "getListKetQuaTranDau trả về null hoặc lỗi.");
                }
            }

            @Override
            public void onFailure(Call<List<KetQuaTranDau>> call, Throwable t) {
                Log.e("API_ERROR", "getListKetQuaTranDau thất bại: " + t.getMessage(), t);
            }
        });
    }
}