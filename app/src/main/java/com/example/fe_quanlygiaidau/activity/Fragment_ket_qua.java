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
import com.example.fe_quanlygiaidau.dto.Item_hienthi_KQ;
import com.example.fe_quanlygiaidau.dto.Join_hienthi_KQ;
import com.example.fe_quanlygiaidau.model.DoiBong;
import com.example.fe_quanlygiaidau.model.DoiBongGiaiDau;
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

    private int totalApiCalls = 5;
    private int loadedCount = 0;

    private List<KetQuaTranDau> ketQuaList;
    private List<TranDau> tranDauList;
    private List<DoiBong> doiBongList;
    private List<Giaidau> giaiDauList;
    private List<DoiBongGiaiDau> doiBongGiaiDauList;

    private void fetchKQTDFromApi() {
        loadedCount = 0;

        ApiService.apiService.getListKetQuaTranDau().enqueue(new Callback<List<KetQuaTranDau>>() {
            @Override
            public void onResponse(Call<List<KetQuaTranDau>> call, Response<List<KetQuaTranDau>> response) {
                if (response.isSuccessful()) {
                    ketQuaList = response.body();
                }
                onApiLoaded();
            }

            @Override
            public void onFailure(Call<List<KetQuaTranDau>> call, Throwable t) {
                Log.e("API", "getListKetQuaTranDau fail", t);
                onApiLoaded();
            }
        });

        ApiService.apiService.getListTranDau().enqueue(new Callback<List<TranDau>>() {
            @Override
            public void onResponse(Call<List<TranDau>> call, Response<List<TranDau>> response) {
                if (response.isSuccessful()) {
                    tranDauList = response.body();
                }
                onApiLoaded();
            }

            @Override
            public void onFailure(Call<List<TranDau>> call, Throwable t) {
                Log.e("API", "getListTranDau fail", t);
                onApiLoaded();
            }
        });

        ApiService.apiService.getListDoiBong().enqueue(new Callback<List<DoiBong>>() {
            @Override
            public void onResponse(Call<List<DoiBong>> call, Response<List<DoiBong>> response) {
                if (response.isSuccessful()) {
                    doiBongList = response.body();
                }
                onApiLoaded();
            }

            @Override
            public void onFailure(Call<List<DoiBong>> call, Throwable t) {
                Log.e("API", "getListDoiBong fail", t);
                onApiLoaded();
            }
        });

        ApiService.apiService.getListGiaiDau().enqueue(new Callback<List<Giaidau>>() {
            @Override
            public void onResponse(Call<List<Giaidau>> call, Response<List<Giaidau>> response) {
                if (response.isSuccessful()) {
                    giaiDauList = response.body();
                }
                onApiLoaded();
            }

            @Override
            public void onFailure(Call<List<Giaidau>> call, Throwable t) {
                Log.e("API", "getListGiaiDau fail", t);
                onApiLoaded();
            }
        });

        ApiService.apiService.getListDoiBongGiaiDau().enqueue(new Callback<List<DoiBongGiaiDau>>() {
            @Override
            public void onResponse(Call<List<DoiBongGiaiDau>> call, Response<List<DoiBongGiaiDau>> response) {
                if (response.isSuccessful()) {
                    doiBongGiaiDauList = response.body();
                }
                onApiLoaded();
            }

            @Override
            public void onFailure(Call<List<DoiBongGiaiDau>> call, Throwable t) {
                Log.e("API", "getListDoiBongGiaiDau fail", t);
                onApiLoaded();
            }
        });
    }

    private synchronized void onApiLoaded() {
        loadedCount++;
        if (loadedCount == totalApiCalls) {
            if (ketQuaList != null && tranDauList != null && doiBongList != null && giaiDauList != null) {
                Join_hienthi_KQ joiner = new Join_hienthi_KQ();
                List<Item_hienthi_KQ> kq = joiner.mapKetQuaNhanh(
                        ketQuaList, tranDauList, doiBongList, giaiDauList, doiBongGiaiDauList
                );
                adapter.setMatches(kq);
                adapter.notifyDataSetChanged();
                Toast.makeText(getContext(), "Có " + kq.size() + " kết quả", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Lỗi tải dữ liệu!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}