package com.example.tomal.serviceappdemo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.tomal.serviceappdemo.R;

import java.util.ArrayList;

/**
 * Created by tomal on 1/18/17.
 */

public class SelectBrandRecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<String>brands;
    private int selectedPosition;

    public SelectBrandRecycleViewAdapter(ArrayList<String>brands,int selectedPosition){
        this.brands=brands;
        this.selectedPosition=selectedPosition;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        RecyclerView.ViewHolder vh;

        // Inflate the custom layout
        View productView = inflater.inflate(R.layout.select_brand_single_item_ggs, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(productView);
        vh=viewHolder;



        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final SelectBrandRecycleViewAdapter.ViewHolder viewHolder= (ViewHolder) holder;

        viewHolder.getTextView().setText(this.brands.get(position));
        if (this.selectedPosition==position) {
            viewHolder.getImageView().setVisibility(View.VISIBLE);
            viewHolder.itemView.setBackgroundColor(Color.parseColor("#f2f2f2"));

        }else {
            viewHolder.getImageView().setVisibility(View.GONE);
            viewHolder.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }

    }

    @Override
    public int getItemCount() {
        return this.brands.size();
    }



    public  class ViewHolder extends RecyclerView.ViewHolder {



        private TextView textView;
        private ImageView imageView;




        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.brand_title_row_item_text_view);
            imageView=(ImageView)itemView.findViewById(R.id.selected_mark_image_view);



        }

        public TextView getTextView() {
            return textView;
        }
        public ImageView getImageView() {
            return imageView;
        }
    }
}
