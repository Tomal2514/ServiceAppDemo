package com.example.tomal.serviceappdemo.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.tomal.serviceappdemo.R;
import com.example.tomal.serviceappdemo.adapter.SelectBrandRecycleViewAdapter;
import com.example.tomal.serviceappdemo.util.DividerItemDecoration;
import com.example.tomal.serviceappdemo.util.EditTextBackEvent;
import com.example.tomal.serviceappdemo.util.RecyclerItemClickListener;
import com.example.tomal.serviceappdemo.util.ResizeWidthAnimation;

import java.util.ArrayList;


public class SelectBandBottomFragmentGgs extends BottomSheetDialogFragment implements View.OnClickListener, RecyclerItemClickListener.OnItemClickListener,
View.OnFocusChangeListener{
    private ArrayList<String>brands;
    private SearchView searchView;
    private CheckedTextView checkedTextView;
    private OnFragmentInteractionListener mListener;
    private RecyclerView selectBrandRecycleView;
    private RelativeLayout searchRelativeLayout;
    private BottomSheetBehavior bottomSheetBehavior;
    private static int selectedPosition=-1;
    private EditTextBackEvent searchEditText;

    public SelectBandBottomFragmentGgs() {
        // Required empty public constructor
    }

    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        View contentView=View.inflate(getContext(), R.layout.fragment_select_band_bottom_fragment_ggs, null);
        dialog.setContentView(contentView);

        brands=new ArrayList<>();
        for (int i=0; i<50; i++)
            brands.add("Toyota");



        selectBrandRecycleView=(RecyclerView)contentView.findViewById(R.id.select_brand_recycle_view);
        selectBrandRecycleView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(),this));
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        selectBrandRecycleView.setLayoutManager(layoutManager);

        this.selectBrandRecycleView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        selectBrandRecycleView.setAdapter(new SelectBrandRecycleViewAdapter(this.brands,selectedPosition));

        searchRelativeLayout=(RelativeLayout)contentView.findViewById(R.id.search_relative_layout);

        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) ((View) contentView.getParent()).getLayoutParams();
        final CoordinatorLayout.Behavior behavior = params.getBehavior();
        bottomSheetBehavior= (BottomSheetBehavior) behavior;
        searchEditText=(EditTextBackEvent) contentView.findViewById(R.id.search_edit_text);
        searchEditText.setOnEditTextImeBackListener(new EditTextBackEvent.EditTextImeBackListener() {
            @Override
            public void onImeBack(EditTextBackEvent ctrl, String text) {
                System.out.println(ctrl+" "+text);
                final RelativeLayout.LayoutParams lparams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                searchEditText.setLayoutParams(lparams);
                searchEditText.setGravity(Gravity.CENTER);
               searchEditText.clearFocus();
            }
        });
        searchEditText.setOnClickListener(this);
        searchRelativeLayout.setOnClickListener(this);
        searchEditText.setOnFocusChangeListener(this);

    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



    @Override
    public void onClick(View v) {
        if (v==searchRelativeLayout || v==searchEditText){
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            searchEditText.getLayoutParams().width=1000;
            System.out.println(searchEditText.getLayoutParams());
            final RelativeLayout.LayoutParams lparams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            searchEditText.setLayoutParams(lparams);
            searchEditText.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
            searchEditText.requestFocus();


        }

    }

    @Override
    public void onItemClick(View view, int position) {
        System.out.println("Clicke+ "+position);

        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        selectedPosition=position;

    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (v==searchEditText){
            if (hasFocus) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                final RelativeLayout.LayoutParams lparams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                searchEditText.setLayoutParams(lparams);
                searchEditText.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
            }
        }

    }




    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
