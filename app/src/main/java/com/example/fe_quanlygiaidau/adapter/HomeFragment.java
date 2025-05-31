package com.example.fe_quanlygiaidau.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.fe_quanlygiaidau.R;
import com.example.fe_quanlygiaidau.adapter.NewsAdapter;
import com.example.fe_quanlygiaidau.layout.NewsActivity;
import com.example.fe_quanlygiaidau.model.News;
import com.example.fe_quanlygiaidau.slide.SlidePhoto;
import com.example.fe_quanlygiaidau.slide.SlidePhotoAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    private ViewPager viewPager;
    private List<SlidePhoto> mlListSlidePhotos;
    private CircleIndicator circleIndicator;
    private SlidePhotoAdapter slidePhotoAdapter;
    private GridView gridView;
    private List<News> listNews;
    private NewsAdapter newsAdapter;
    private Timer timer;
    private Button button;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_home,container,false);

        gridView = view.findViewById(R.id.gvHinhAnh);
        listNews = listNews();
        newsAdapter = new NewsAdapter(getContext(),R.layout.item_news,listNews);
        gridView.setAdapter(newsAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                News news = listNews.get(position);
                Intent intent = new Intent(getActivity(),NewsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("new",news);
                intent.putExtra("News", bundle);
                startActivity(intent);
            }
        });
        viewPager =  view.findViewById(R.id.viewPager);
        circleIndicator = view.findViewById(R.id.circle_indicator);
        mlListSlidePhotos = listSlidePhoto();

        slidePhotoAdapter = new SlidePhotoAdapter(getContext(),mlListSlidePhotos);
        viewPager.setAdapter(slidePhotoAdapter);

        autoSlide();

        circleIndicator.setViewPager(viewPager);
        slidePhotoAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());


//        button = view.findViewById(R.id.button);
//        button.setOnClickListener((v) -> {clickCallApi();});



        // Inflate the layout for this fragment
        return view;
    }

//    private void clickCallApi() {
//        ApiService.apiService.getListGiaiDau().enqueue(new Callback<List<Giaidau>>() {
//            @Override
//            public void onResponse(Call<List<Giaidau>> call, Response<List<Giaidau>> response) {
//                if (response.isSuccessful() && response.body() != null) {
//                    List<Giaidau> giaiDauList = response.body();
//                    for (Giaidau giaiDau : giaiDauList) {
//                        Log.d("GiaiDau", "Tournament: " + giaiDau.getTenGiaiDau() + ", Start Date: " + giaiDau.getTenToChuc());
//                    }
//                    Toast.makeText(getContext(), "Fetched " + giaiDauList.size() + " tournaments", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(getActivity(), "Failed to fetch tournaments", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Giaidau>> call, Throwable t) {
//                Log.e("GiaiDau", "Error: " + t.getMessage());
//                Toast.makeText(getContext(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }

    private List<SlidePhoto> listSlidePhoto(){
        List<SlidePhoto> list = new ArrayList<>();
        list.add(new SlidePhoto(R.drawable.anhdoituyenanh, "ĐỘI TUYỂN ANH TẬP HỢP LÊN TUYỂN"));
        list.add(new SlidePhoto(R.drawable.anhdoituyenduc, "ĐỘI TUYỂN ĐỨC QUYẾT TÂM VÔ ĐỊCH NATION LEAGUE"));
        list.add(new SlidePhoto(R.drawable.anhvietnamvodich, "ĐỘI TUYỂN VIỆT NAM VÔ ĐỊCH ASEAN"));
        list.add(new SlidePhoto(R.drawable.anhdoituyennuvietnam, "ĐỘI TUYỂN NỮ VIỆT NAM QUYẾT TÂM Ở VÒNG LOẠI CHÂU Á"));
        return list;
    }

    private void autoSlide(){
        if(mlListSlidePhotos == null || mlListSlidePhotos.isEmpty() || viewPager==null){
            return;
        }
        if(timer==null){
            timer = new Timer();
        }
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        int currentItem = viewPager.getCurrentItem();
                        int totalIterm = mlListSlidePhotos.size();
                        if(currentItem<totalIterm){
                            currentItem++;
                            viewPager.setCurrentItem(currentItem);
                        }
                        if(currentItem==totalIterm){
                            viewPager.setCurrentItem(0);
                        }
                    }
                });
            }
        },500,3000);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(timer !=null){
            timer.cancel();
            timer = null;
        }
    }
    private List<News> listNews(){
        List<News> list = new ArrayList<>();
        list.add(new News(R.drawable.new1,"UEFA takes firm stance on unauthorised ticketing ahead of finals","In view of the upcoming UEFA club competition finals, UEFA warns fans not to purchase tickets on the secondary market, from unauthorised third parties, websites, agencies or from touts. Such tickets may be cancelled by UEFA at any time and fans are likely to be refused entry or be ejected from the stadium. In addition, fans may not receive the tickets which they have purchased from these unauthorised third parties.\n" +
                "\n" +
                "UEFA reminds fans that ticket sales to the general public and fans of the teams who have reached the UEFA club competition finals are carried out exclusively via UEFA.com.\n" +
                "\n" +
                "Tickets issued for the UEFA club competition finals are 100% digital and made available exclusively through the official UEFA Mobile Tickets App, which includes several security features that aim to combat unauthorised ticket sales through a secure digital mobile ticket solution such as:\n" +
                "\n" +
                "- Ticket transferability rules and restrictions have been implemented for the General Public and each finalist club.\n" +
                "\n" +
                "- Sharing of accounts is not permitted in the UEFA Mobile Tickets App. Only the phone used to download the mobile tickets will be able to access the stadium.\n" +
                "\n" +
                "- Screenshots of mobile tickets are not valid tickets. Anyone attempting to enter the stadium with such screenshots will be refused entry.\n" +
                "\n" +
                "- Paper tickets and print-at-home tickets are not valid tickets.\n" +
                "\n" +
                "UEFA actively enforces its ticketing terms and conditions, including by monitoring the internet, and will take action (including cancelling tickets) where breaches of its terms and conditions are identified. Tickets for the upcoming UEFA club competition finals have already been cancelled in this respect and further cancellations are likely to follow.\n" +
                "\n" +
                "Fans are also strongly advised not to travel to the stadiums without tickets as entrance to the stadium is only authorised upon presentation of a valid ticket."));

        list.add(new News(R.drawable.new2,"UEFA Executive Committee to meet in Bilbao","The UEFA Executive Committee will hold its next meeting in Bilbao, Spain, on Wednesday 21 May from 10:00 to 13:00 CET, ahead of this season’s UEFA Europa League final between Tottenham Hotspur and Manchester United FC, which will take place at San Mamés Stadium in Bilbao the same evening.\n" +
                "\n" +
                "The main items on the agenda of the Executive Committee meeting are:\n" +
                "\n" +
                "• UEFA EURO 2028 competition matters\n" +
                "\n" +
                "• Club beneﬁts programme for 2024–28 distribution principles\n" +
                "\n" +
                "• UEFA men’s Under-17 and Under-19 competition regulations 2025/26\n" +
                "\n" +
                "• UEFA women’s Under-17 and Under-19 competition regulations 2025/26\n" +
                "\n" +
                "• UEFA Super Cup regulations 2025/26\n" +
                "\n" +
                "• Standing Facilities Observer Programme – update\n" +
                "\n" +
                "• UEFA committee reports\n" +
                "\n" +
                "Note to media\n" +
                "\n" +
                "The decision regarding the appointments of hosts for the 2027 UEFA Champions League final and the 2027 UEFA Women's Champions League final has been postponed for operational reasons until the next UEFA Executive Committee meeting in September.\n" +
                "\n" +
                "No press conference is planned after the UEFA Executive Committee meeting. Decisions from this meeting will be communicated in a media release."));
        list.add(new News(R.drawable.new3,"Ambition, action and accountability at UEFA Women's EURO 2025","UEFA Women's EURO 2025 in Switzerland represents a landmark opportunity not only to elevate women's football but also to demonstrate how major sporting events can be organised with social and environmental sustainability at their core.That was the message at the UEFA Respect Forum 2025, where key figures involved in the tournament's organisation presented a range of strategies and initiatives designed to make the event inclusive, engaging and record-breaking.\n" +
                "\n" +
                "Held at the Stadion Letzigrund in Zurich – one of the host venues – forum participants heard from tournament director Doris Keller about how UEFA Women's EURO 2025 is already surpassing expectations."));
        list.add(new News(R.drawable.new4,"Football’s impact beyond the game: UEFA Respect Forum 2025 in Zurich","Held at Letzigrund Stadium in Zurich, Switzerland – one of the venues for UEFA Women’s EURO 2025 – the second edition of the Forum focused on the powerful connection between football and sustainability. It was designed to inspire, activate and accelerate collective action across the European game to advance social and environmental sustainability in all its dimensions.\n" +
                "\n" +
                "Highlighting UEFA’s strategic approach to sustainability, the Respect Forum brought together more than 250 key stakeholders from national associations, clubs, partners, leagues, players and other actors in and beyond football, reflecting an increasingly broad and diverse community united by a shared purpose. Together, they explored innovative solutions to reduce risks, build resilience and create value.In his opening address, Michele Uva, director of UEFA’s social and environmental sustainability division, encouraged attendees not just to react to sustainability trends but to \"anticipate and lead\" them, being the drivers of change.\n" +
                "\n" +
                "He stressed the need to embed sustainability in football’s DNA and to generate concrete impact through shared ownership of a common goal, with the Respect Forum playing a role in inspiring and spreading awareness across the football ecosystem. Dominique Blanc, the president of the Swiss Football Association, and Claudius Schäfer, the president of European Leagues and CEO of the Swiss Football League, also gave opening speeches.\n" +
                "\n" +
                "Uva's call to action on the importance of transformation in sustainability was echoed by Cristina Saccà, consumer marketing and sponsorship Europe senior vice-president at Mastercard, and UEFA vice-president Laura McAllister, who emphasised UEFA’s long-term strategic investment in sustainability from 2021 to 2030. Both noted that commercial partners are increasingly interested in collaborating around \"mutual values\", highlighting sustainability’s growing strategic relevance."));



        return  list;
    }

}