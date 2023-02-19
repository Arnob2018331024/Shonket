package com.example.shonket.ui.gallery;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shonket.R;
import com.example.shonket.ui.gallery.placeholder.PlaceholderContent;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 */
public class Sentences extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    public  static ArrayList<String> sentences;
    public static RecyclerView recyclerView;
    public static SentenceRecyclerViewAdapter adapter;


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public Sentences() {
        sentences=new ArrayList<>();

        sentences.add("আমার নাম মধু");
        sentences.add("আমার দেশ বাংলাদেশ");
        sentences.add("বাংলাদেশ আমার ভালোবাসা");
        sentences.add("মিষ্টি খাওয়া ভালো");
        sentences.add("আমি ভাত খাই");
        sentences.add("আমার বাসা এখানে");
        sentences.add("পড়ালেখা আমার শত্রু");
        sentences.add("আমার ক্যাপ লাল");
        Log.d("khala", "Sentences: call hoise");
        //newInstance(1);
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static Sentences newInstance(int columnCount) {
        Sentences fragment = new Sentences();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setRetainInstance(false);
        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }


        Log.d("Arif", "onCreateView: oncreater vitore");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sentences_list, container, false);

        // Set the adapter
        Log.d("Arif", "onCreateView: ifer baire");
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            adapter=new SentenceRecyclerViewAdapter(sentences);
            Log.d("Arif", "onCreateView: ifer vitore");
            recyclerView.setAdapter(adapter);
        }
        return view;
    }



    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}