package com.example.fe_quanlygiaidau.activity;

import android.os.Bundle;

import android.os.Handler;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.List;

import com.example.fe_quanlygiaidau.adapter.BannerAdapter;
import com.example.fe_quanlygiaidau.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Fragment_lich_thi_dau extends Fragment {

    private ViewPager2 viewPagerBanner;
    private List<Integer> bannerImages;
    private Handler sliderHandler;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lich_thi_dau, container, false);
        //Khởi tạo Banner (ViewPager2)
        setupBanner(view);
        return view;
    }

    private void setupBanner(View view) {
        viewPagerBanner = view.findViewById(R.id.viewPagerBanner);

        // Danh sách ảnh banner
        bannerImages = new ArrayList<>();
        bannerImages.add(R.drawable.messi);
        bannerImages.add(R.drawable.rice);
        bannerImages.add(R.drawable.odegaard);
        bannerImages.add(R.drawable.ae_nghe_tinh);

        // Thiết lập Adapter
        BannerAdapter adapter = new BannerAdapter(bannerImages);
        viewPagerBanner.setAdapter(adapter);

        // Tự động chuyển ảnh mỗi 3 giây
        sliderHandler = new Handler();
        viewPagerBanner.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 3000); // 3 giây
            }
        });
    }
    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPagerBanner.setCurrentItem((viewPagerBanner.getCurrentItem() + 1) % bannerImages.size());
        }
    };
}