package com.example.tomal.serviceappdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.tomal.serviceappdemo.R;

import java.util.ArrayList;

/**
 * Created by tomal on 1/16/17.
 */

public class CurrencyRecycleViewAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    private ArrayList<String>currencyList;
    public int mSelectedItem = -1;

    public CurrencyRecycleViewAdapter(ArrayList<String>currencyList){
        this.currencyList=currencyList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        RecyclerView.ViewHolder vh;

            // Inflate the custom layout
            View productView = inflater.inflate(R.layout.set_currency_single_row, parent, false);

            // Return a new holder instance
            ViewHolder viewHolder = new ViewHolder(productView);
            vh=viewHolder;



        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final CurrencyRecycleViewAdapter.ViewHolder viewHolder=(CurrencyRecycleViewAdapter.ViewHolder)holder;


        viewHolder.getRadioButton().setText(this.currencyList.get(position));
        viewHolder.getRadioButton().setChecked(position == mSelectedItem);


    }

    @Override
    public int getItemCount() {
        return this.currencyList.size();
    }


    public  class ViewHolder extends RecyclerView.ViewHolder {



        private RadioButton radioButton;




        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            radioButton = (RadioButton) itemView.findViewById(R.id.currency_radio_button);

            radioButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mSelectedItem = getAdapterPosition();
                    notifyItemRangeChanged(0, currencyList.size());
                }
            });

        }

        public RadioButton getRadioButton() {
            return radioButton;
        }
    }
}
