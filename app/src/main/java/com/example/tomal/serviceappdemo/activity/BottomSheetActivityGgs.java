package com.example.tomal.serviceappdemo.activity;

import android.net.Uri;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tomal.serviceappdemo.R;
import com.example.tomal.serviceappdemo.fragment.AddServiceExperienceFragment;
import com.example.tomal.serviceappdemo.fragment.SelectBandBottomFragmentGgs;
import com.example.tomal.serviceappdemo.fragment.SetCurrencyDialogFragmentGgs;
import com.example.tomal.serviceappdemo.fragment.TutsPlusBottomSheetDialogFragment;

public class BottomSheetActivityGgs extends AppCompatActivity implements View.OnClickListener,SelectBandBottomFragmentGgs.OnFragmentInteractionListener {

    private BottomSheetBehavior mBottomSheetBehavior;
    private  BottomSheetDialogFragment bottomSheetDialogFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet_ggs);

        Button button1 = (Button) findViewById( R.id.button_1 );
        Button button2=(Button)findViewById(R.id.button_2);
        Button button3=(Button)findViewById(R.id.button_3);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

        button1.setOnClickListener(this);


        bottomSheetDialogFragment= new TutsPlusBottomSheetDialogFragment();

    }

    @Override
    public void onClick(View v) {
        switch( v.getId() ) {
            case R.id.button_1: {


                bottomSheetDialogFragment.show(getSupportFragmentManager(), BottomSheetActivityGgs.this.getClass().getName());


                break;
            }
            case R.id.button_2:{
                BottomSheetDialogFragment bottomSheetDialogFragment1=new AddServiceExperienceFragment();
                bottomSheetDialogFragment1.show(getSupportFragmentManager(),BottomSheetActivityGgs.this.getClass().getName());
                break;
            }
            case R.id.button_3:{
                BottomSheetDialogFragment bottomSheetDialogFragment2=new SelectBandBottomFragmentGgs();
                bottomSheetDialogFragment2.show(getSupportFragmentManager(),BottomSheetActivityGgs.this.getClass().getName());

                break;
            }
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
