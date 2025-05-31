package com.example.fe_quanlygiaidau.layout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.fe_quanlygiaidau.R;
import com.example.fe_quanlygiaidau.model.News;

public class NewsActivity extends AppCompatActivity {

    TextView title,text;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_news);
        title = findViewById(R.id.textViewNewsTitle);
        text = findViewById(R.id.textViewNewsText);
        imageView = findViewById(R.id.imageViewNewsImg);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        Intent intent =getIntent();
        Bundle bundle = intent.getBundleExtra("News");
        News news = (News) bundle.getSerializable("new");
        title.setText(news.getTitle());
        text.setText(news.getText());
        imageView.setImageResource(news.getHinh());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void clickQuayLai(View view) {
        finish();
    }
}