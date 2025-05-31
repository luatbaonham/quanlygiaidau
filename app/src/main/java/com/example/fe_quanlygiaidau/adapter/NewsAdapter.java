package com.example.fe_quanlygiaidau.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fe_quanlygiaidau.R;
import com.example.fe_quanlygiaidau.model.News;

import java.util.List;

public class NewsAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<News> listNews;


    public NewsAdapter(Context context, int layout, List<News> listNews) {
        this.context = context;
        this.layout = layout;
        this.listNews = listNews;
    }

    @Override
    public int getCount() {
        if(listNews!=null){
            return listNews.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view =inflater.inflate(layout,null);

        ImageView imageView = view.findViewById(R.id.imageView2);
        TextView textView = view.findViewById(R.id.textView2);
        News news = listNews.get(i);
        imageView.setImageResource(news.getHinh());
        textView.setText(news.getTitle());
        return view;
    }
}
