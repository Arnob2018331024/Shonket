package com.example.shonket.ui.gallery;

import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shonket.databinding.FragmentSentencesBinding;
import com.example.shonket.ui.gallery.placeholder.PlaceholderContent.PlaceholderItem;
//import com.example.shonket.ui.gallery.databinding.FragmentSentencesBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class SentenceRecyclerViewAdapter extends RecyclerView.Adapter<SentenceRecyclerViewAdapter.ViewHolder> {

    public List<String> mValues;

    public SentenceRecyclerViewAdapter(List<String> items) {
        mValues=items;
/*
        mValues.add("আমার নাম মধু");
        mValues.add("আমার দেশ বাংলাদেশ");
        mValues.add("বাংলাদেশ আমার ভালোবাসা");
        mValues.add("মিষ্টি খাওয়া ভালো");
        mValues.add("আমি ভাত খাই");
        mValues.add("আমার বাসা এখানে");
        mValues.add("পড়ালেখা আমার শত্রু");
        mValues.add("আমার ক্যাপ লাল");*/
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentSentencesBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Log.d("fahim", "onBindViewHolder: "+mValues.get(position));
        holder.mContentView.setText(mValues.get(position));
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public void setItem(ArrayList<String> sentences) {
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mContentView;
        public PlaceholderItem mItem;

        public ViewHolder(FragmentSentencesBinding binding) {
            super(binding.getRoot());
            mContentView = binding.content;
        }
        public void setItem(ArrayList<String> items){
            mValues=items;
            Log.d("abcdef", "setmItem: ");
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}