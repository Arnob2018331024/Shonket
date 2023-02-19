package com.example.shonket.ui.gallery;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.shonket.MainActivity;
import com.example.shonket.R;
import com.example.shonket.databinding.FragmentGalleryBinding;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import javax.security.auth.callback.Callback;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    TabLayout tabLayout;
    ViewPager viewPager;
    RecyclerView recyclerView;
    SentenceAdapter adapter;
    ArrayList<String>  sentences;
    public static WebView wv;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);
        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        wv=binding.webview;
        WebSettings webSettings=wv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setAllowUniversalAccessFromFileURLs(true);
        wv.setWebViewClient(new Callback());
        webSettings.setAllowContentAccess(true);
        webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        wv.loadUrl("file:///android_asset/mobileavatar/index5.html");

        Log.d("Arnob", "Galleryr vitore");
        handleRV();
        handleTV();

       /* MyPagerAdapter adapter = new MyPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(new SL(), "First Tab");

        viewPager = binding.viewPager;
        viewPager.setAdapter(adapter);

        tabLayout= binding.tabLayout;
        tabLayout.setupWithViewPager(viewPager);*/


        return root;
    }


    void handleRV(){

        Log.d("Arif", "onCreateView: oncreater vitore");

        recyclerView=binding.galleryrecylerview;
        recyclerView.setHasFixedSize(true);
        adapter=new SentenceAdapter(sentences,getContext());
        recyclerView.setAdapter(adapter);
        LinearLayoutManager manger=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manger);
        loadSentence();


    }

    void  handleTV(){
        tabLayout=binding.tabLayout;
        TabLayout.Tab tab1 = tabLayout.newTab().setText("Sentences");
        TabLayout.Tab tab2 = tabLayout.newTab().setText("Alphabets");
        TabLayout.Tab tab3 = tabLayout.newTab().setText("Digits");
        tabLayout.addTab(tab1);
        tabLayout.addTab(tab2);
        tabLayout.addTab(tab3);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.d("Arnob", "onTabSelected: "+tab.getText());
                if(tab.getText()=="Sentences"){
                    loadSentence();
                }
                else if(tab.getText()=="Digits"){
                    loadDigits();
                }
                else{
                    loadCharacters();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private  class Callback extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view,String url){
            return false;
        }
    }
    public static void play(String sentence){
        wv.loadUrl("javascript:playenglish('".concat(sentence).concat("')"));
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("Arif", "onDestroyView: ");
        //MainActivity.nc.popBackStack();
        //binding = null;
    }
    void loadSentence(){
        sentences=new ArrayList<>();
        sentences.add("আমার নাম মধু");
        sentences.add("আমার দেশ বাংলাদেশ");
        sentences.add("বাংলাদেশ আমার ভালোবাসা");
        sentences.add("মিষ্টি খাওয়া ভালো");
        sentences.add("আমি ভাত খাই");
        sentences.add("আমার বাসা এখানে");
        sentences.add("পড়ালেখা আমার শত্রু");
        sentences.add("আমার ক্যাপ লাল");
        adapter.setSenteces(sentences);
        adapter.notifyDataSetChanged();

    }
    void loadDigits(){
        sentences=new ArrayList<>();
        sentences.add("০");
        sentences.add("১");
        sentences.add("২");
        sentences.add("৩");
        sentences.add("৪");
        sentences.add("৫");
        sentences.add("৬");
        sentences.add("৭");
        sentences.add("৮");
        sentences.add("৯");
        sentences.add("১০");
        sentences.add("১৫");
        sentences.add("১৬");
        sentences.add("২৬");

        adapter.setSenteces(sentences);
        adapter.notifyDataSetChanged();
    }
    void loadCharacters(){
        sentences=new ArrayList<>();

        sentences.add("অ");
        sentences.add("আ");
        sentences.add("ই");
        sentences.add("ঈ");
        sentences.add("উ");
        sentences.add("ঊ");
        sentences.add("ঋ");
        sentences.add("এ");
        sentences.add("ঐ");
        sentences.add("ও");
        sentences.add("ঔ");
        sentences.add("ক");
        sentences.add("খ");
        sentences.add("গ");
        sentences.add("ঘ");
        sentences.add("চ");
        sentences.add("ছ");
        sentences.add("জ");
        sentences.add("ঝ");
        sentences.add("ট");
        sentences.add("ঠ");
        sentences.add("ড");
        sentences.add("ড়");
        sentences.add("ঢ");
        sentences.add("ঢ়");
        sentences.add("ণ");
        sentences.add("ত");
        sentences.add("ৎ");
        sentences.add("থ");
        sentences.add("দ");
        sentences.add("ধ");
        sentences.add("ন");
        sentences.add("প");
        sentences.add("ফ");
        sentences.add("ব");
        sentences.add("ভ");
        sentences.add("ম");
        sentences.add("য");
        sentences.add("য়");
        sentences.add("র");
        sentences.add("ল");
        sentences.add("শ");
        sentences.add("ষ");
        sentences.add("স");
        sentences.add("হ");

        sentences.add("ং");
        sentences.add("ঃ");

        sentences.add("ঁ");
        sentences.add("া");
        sentences.add("ি");
        sentences.add("ী");
        sentences.add("ু");
        sentences.add("ূ");
        sentences.add("ৃ");
        sentences.add("ে");
        sentences.add("ৈ");
        sentences.add("ো");
        sentences.add("ৌ");
        adapter.setSenteces(sentences);

        adapter.notifyDataSetChanged();
    }
}