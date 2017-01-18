package com.example.tomal.serviceappdemo.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.tomal.serviceappdemo.R;
import com.example.tomal.serviceappdemo.adapter.CurrencyRecycleViewAdapter;
import com.example.tomal.serviceappdemo.util.DividerItemDecoration;
import com.example.tomal.serviceappdemo.util.RecyclerItemClickListener;

import java.util.ArrayList;


public class SetCurrencyDialogFragmentGgs extends DialogFragment implements View.OnClickListener {
    private RecyclerView currencyRecycleView;
    private ArrayList<String>currencyList;
    private CurrencyRecycleViewAdapter currencyRecycleViewAdapter;
    private Button doneButton;

    private OnFragmentInteractionListener mListener;

    public SetCurrencyDialogFragmentGgs() {
        // Required empty public constructor
    }


    public static SetCurrencyDialogFragmentGgs newInstance() {
        SetCurrencyDialogFragmentGgs fragment = new SetCurrencyDialogFragmentGgs();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        currencyList=new ArrayList<>();
        for (int i=0; i<50; i++){
            currencyList.add("Australia(AUD)");
        }

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_set_currency_dialog_fragment_ggs, container, false);
        currencyRecycleView=(RecyclerView)root.findViewById(R.id.currency_recycle_view);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        currencyRecycleView.setLayoutManager(layoutManager);
        currencyRecycleViewAdapter=new CurrencyRecycleViewAdapter(this.currencyList);
        currencyRecycleView.setAdapter(currencyRecycleViewAdapter);
        doneButton=(Button)root.findViewById(R.id.currency_done_button);
        doneButton.setOnClickListener(this);
        getDialog().requestWindowFeature(STYLE_NO_TITLE);
        setCancelable(false);


        return root;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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
        if (v==doneButton){
            dismiss();
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
