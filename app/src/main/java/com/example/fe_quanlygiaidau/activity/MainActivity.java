package com.example.fe_quanlygiaidau.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.example.fe_quanlygiaidau.R;
import com.example.fe_quanlygiaidau.adapter.ViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPager;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        viewPager.setUserInputEnabled(false);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), getLifecycle());
        viewPager.setAdapter(adapter);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_home:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.nav_tran_dau:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.nav_results:
                    viewPager.setCurrentItem(2);
                    return true;
                case R.id.nav_cau_thu_noi_bat:
                    viewPager.setCurrentItem(3);
                    return true;
            }
            return false;
        });

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected( int position) {
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
            }
        });
    }
}