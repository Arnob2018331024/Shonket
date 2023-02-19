package com.example.shonket.ui.gallery;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shonket.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Senteancelist#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Senteancelist extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ArrayList<String> sentences;
    RecyclerView recyclerView;
    SentenceAdapter adapter;
    public Senteancelist() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Senteancelist.
     */
    // TODO: Rename and change types and number of parameters
    public static Senteancelist newInstance(String param1, String param2) {
        Senteancelist fragment = new Senteancelist();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sentences=new ArrayList<>();

        sentences.add("আমার নাম মধু");
        sentences.add("আমার দেশ বাংলাদেশ");
        sentences.add("বাংলাদেশ আমার ভালোবাসা");
        sentences.add("মিষ্টি খাওয়া ভালো");
        sentences.add("আমি ভাত খাই");
        sentences.add("আমার বাসা এখানে");
        sentences.add("পড়ালেখা আমার শত্রু");
        sentences.add("আমার ক্যাপ লাল");
        Log.d("Arif", "onCreateView: oncreater vitore");


        recyclerView=getActivity().findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        adapter=new SentenceAdapter(sentences,getContext());
        recyclerView.setAdapter(adapter);
        LinearLayoutManager manger=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manger);
        ///adapter.setItem(sentences);
        //adapter.notifyDataSetChanged();
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_senteancelist, container, false);
    }
}