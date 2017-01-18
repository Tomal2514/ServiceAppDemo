package com.example.tomal.serviceappdemo.activity;

import android.app.FragmentManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tomal.serviceappdemo.R;
import com.example.tomal.serviceappdemo.fragment.SetCurrencyDialogFragmentGgs;

public class SetCurrenCyActivityGgs extends AppCompatActivity implements View.OnClickListener,SetCurrencyDialogFragmentGgs.OnFragmentInteractionListener {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_curren_cy_ggs);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v==button){
            FragmentManager fm = getFragmentManager();
            SetCurrencyDialogFragmentGgs dialogFragment = SetCurrencyDialogFragmentGgs.newInstance();
            dialogFragment.show(getSupportFragmentManager(),this.getClass().getName());
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
