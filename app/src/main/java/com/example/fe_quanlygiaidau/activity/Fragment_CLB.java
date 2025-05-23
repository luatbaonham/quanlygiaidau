package com.example.fe_quanlygiaidau.activity;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fe_quanlygiaidau.R;
import com.example.fe_quanlygiaidau.adapter.CauLacBoAdapter;
import com.example.fe_quanlygiaidau.adapter.KetQuaTranDauAdapter;
import com.example.fe_quanlygiaidau.api.ApiService;
import com.example.fe_quanlygiaidau.model.DoiBong;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_CLB extends Fragment {
    private CauLacBoAdapter adapter;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cau_lac_bo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rv_club);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new CauLacBoAdapter(getContext(), new ArrayList<>());
        recyclerView.setAdapter(adapter);

        fetchClbFromApi();  // gọi API lấy dữ liệu
    }

    private void fetchClbFromApi() {
        ApiService.apiService.getListDoiBong().enqueue(new Callback<List<DoiBong>>() {
            @Override
            public void onResponse(Call<List<DoiBong>> call, Response<List<DoiBong>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<DoiBong> doiBongList = response.body();

                    for (DoiBong db : doiBongList) {
                        Log.d("Luat", "Tên: " + db.getTenDoiBong() + ", logo: " + db.getLogo() + ", quốc gia: " + db.getQuocGia());
                    }

                    adapter.setdoiBong(doiBongList);
                    adapter.notifyDataSetChanged();

                    Toast.makeText(getContext(), "get oke nhá", Toast.LENGTH_SHORT).show();
                } else {
                    Log.e("API_ERROR", "getListDoiBong trả về null hoặc lỗi.");
                }
            }

            @Override
            public void onFailure(Call<List<DoiBong>> call, Throwable t) {
                Log.e("API_ERROR", "getListDoiBong thất bại: " + t.getMessage(), t);
            }
        });
    }
}


