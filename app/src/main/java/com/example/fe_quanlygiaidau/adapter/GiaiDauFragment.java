package com.example.fe_quanlygiaidau.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fe_quanlygiaidau.R;
import com.example.fe_quanlygiaidau.adapter.DoiBong1Adapter;
import com.example.fe_quanlygiaidau.adapter.GiaiDau1Adapter;
import com.example.fe_quanlygiaidau.api.ApiService;
import com.example.fe_quanlygiaidau.layout.ChiTietGiaidauActivity;
import com.example.fe_quanlygiaidau.model.DoiBong;
import com.example.fe_quanlygiaidau.model.DoiBongGiaiDau;
import com.example.fe_quanlygiaidau.model.Giaidau;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GiaiDauFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GiaiDauFragment extends Fragment {


    private RecyclerView rvGiaiDau,rvDoiBong;
    private Button btnChiTiet;
    private List<Giaidau> listGiaidau;
    private List<DoiBongGiaiDau> listDoiBongGiaiDau;
    private List<DoiBongGiaiDau> listDoiBongGiaiDauShow = new ArrayList<>();
    private List<DoiBong> listDoiBong;
    private GiaiDau1Adapter giaiDau1Adapter;
    private Giaidau giaidaumain;
    private DoiBong1Adapter doiBong1Adapter;

    private TextView tvTenGiaiDau,tvMotaGiaiDau,tvTenToChucGiaiDau,tvThoiGianBatDau,tvThoiGianKetThuc,tvGioiTinhGiaiDau;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GiaiDauFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GiaiDauFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GiaiDauFragment newInstance(String param1, String param2) {
        GiaiDauFragment fragment = new GiaiDauFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_giai_dau,container,false);

        rvGiaiDau = view.findViewById(R.id.rvGiaidau);
        rvDoiBong = view.findViewById(R.id.rvDoiBong);
        btnChiTiet = view.findViewById(R.id.btnChiTietGiaiDau);
        tvTenGiaiDau = view.findViewById(R.id.tvTenGiaiDau);
        tvMotaGiaiDau = view.findViewById(R.id.tvMotaGiaiDau);
        tvTenToChucGiaiDau = view.findViewById(R.id.tvTenToChucGiaiDau);
        tvThoiGianBatDau = view.findViewById(R.id.tvThoiGianBatDau);
        tvThoiGianKetThuc = view.findViewById(R.id.tvThoiGianKetThuc);
        tvGioiTinhGiaiDau = view.findViewById(R.id.tvGioiTinhGiaiDau);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        rvGiaiDau.setLayoutManager(linearLayoutManager);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        rvGiaiDau.addItemDecoration(itemDecoration);

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext());
        rvDoiBong.setLayoutManager(linearLayoutManager1);

        DividerItemDecoration itemDecoration1 = new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        rvDoiBong.addItemDecoration(itemDecoration1);

        listGiaidau = new ArrayList<>();
        listDoiBongGiaiDau = new ArrayList<>();
        listDoiBong = new ArrayList<>();
        callApiGiaidau();

        btnChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), giaidaumain.getMaGiaidau(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), ChiTietGiaidauActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("giaidau",giaidaumain);
                intent.putExtra("chitietgiaidau", bundle);
                startActivity(intent);
            }
        });
        return view;
    }


    private void callApiGiaidau(){
        ApiService.apiService.getListDoiBongGiaiDau().enqueue(new Callback<List<DoiBongGiaiDau>>() {
            @Override
            public void onResponse(Call<List<DoiBongGiaiDau>> call, Response<List<DoiBongGiaiDau>> response) {
                listDoiBongGiaiDau=response.body();
                checkAndSetupAdapter();
            }

            @Override
            public void onFailure(Call<List<DoiBongGiaiDau>> call, Throwable t) {
                Toast.makeText(getContext(), "Fail api", Toast.LENGTH_SHORT).show();
            }
        });
        ApiService.apiService.getListGiaiDau().enqueue(new Callback<List<Giaidau>>() {
            @Override
            public void onResponse(Call<List<Giaidau>> call, Response<List<Giaidau>> response) {
                listGiaidau=response.body();
                checkAndSetupAdapter();
            }

            @Override
            public void onFailure(Call<List<Giaidau>> call, Throwable t) {
                Toast.makeText(getContext(), "Fail api", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void checkAndSetupAdapter() {
        if (listDoiBongGiaiDau != null && listGiaidau != null) {
            setupAdapter();
        }
    }

    private void setupAdapter() {
        giaiDau1Adapter = new GiaiDau1Adapter(listGiaidau);
        giaiDau1Adapter.setOnItemClickListener(new GiaiDau1Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(Giaidau giaidau) {
                giaidaumain = giaidau;
                displayTournamentDetails(giaidau);
                showDoiBong(giaidau);
            }
        });

        rvGiaiDau.setAdapter(giaiDau1Adapter);

        if (!listGiaidau.isEmpty()) {
            displayTournamentDetails(listGiaidau.get(0));
            showDoiBong(listGiaidau.get(0));
            giaidaumain=listGiaidau.get(0);
        }
    }

    private void displayTournamentDetails(Giaidau giaidau) {
        if (giaidau == null) return;

        tvTenGiaiDau.setText(giaidau.getTenGiaiDau() != null ?
                giaidau.getTenGiaiDau() : "Chưa có tên giải đấu");

        tvMotaGiaiDau.setText("Mô tả :" +(giaidau.getMoTa() != null && !giaidau.getMoTa().isEmpty() ?
                giaidau.getMoTa() : "Chưa có mô tả"));

        tvTenToChucGiaiDau.setText("Tổ chức: " +
                (giaidau.getTenToChuc() != null ? giaidau.getTenToChuc() : "Chưa xác định"));

        tvGioiTinhGiaiDau.setText("Giải dành cho : " +
                (giaidau.getGioiTinh() != null ? giaidau.getGioiTinh() : "Chưa xác định"));

        String formattedStartDate = formatDate(String.valueOf(giaidau.getNgayBatdau()));
        tvThoiGianBatDau.setText("Ngày bắt đầu: " + formattedStartDate);

        String formattedEndDate = formatDate(String.valueOf(giaidau.getNgayKetThuc()));
        tvThoiGianKetThuc.setText("Ngày kết thúc: " + formattedEndDate);

    }

    private void showDoiBong(Giaidau giaidau){
        if (giaidau == null) return;
        if(listDoiBongGiaiDau==null) return;
        listDoiBongGiaiDauShow.clear();

        for (DoiBongGiaiDau doibonggiaidau : listDoiBongGiaiDau){
            if (giaidau.getMaGiaidau().equals(doibonggiaidau.getMaGiaiDau())){
                listDoiBongGiaiDauShow.add(doibonggiaidau);
            }
        }
        doiBong1Adapter = new DoiBong1Adapter(listDoiBongGiaiDauShow);
        rvDoiBong.setAdapter(doiBong1Adapter);

    }

    private String formatDate(String dateString) {
        if (dateString == null || dateString.isEmpty()) {
            return "Chưa xác định";
        }
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
            Date date = inputFormat.parse(dateString);

            SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            return outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return dateString;
        }
    }
}