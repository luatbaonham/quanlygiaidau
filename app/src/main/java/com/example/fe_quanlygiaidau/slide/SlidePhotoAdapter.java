package com.example.fe_quanlygiaidau.slide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.fe_quanlygiaidau.R;

import java.util.List;

public class SlidePhotoAdapter extends PagerAdapter {

    private Context context;

    private List<SlidePhoto> slidePhotoList;

    public SlidePhotoAdapter(Context context, List<SlidePhoto> SlidePhotos) {
        this.context = context;
        this.slidePhotoList = SlidePhotos;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_slide, container, false);

        ImageView imageView = view.findViewById(R.id.slideImage);
        TextView textView = view.findViewById(R.id.slideText);

        SlidePhoto slide = slidePhotoList.get(position);

        imageView.setImageResource(slide.getResource());
        textView.setText(slide.getText());

        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        if(slidePhotoList != null){
            return slidePhotoList.size();
        }

        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
