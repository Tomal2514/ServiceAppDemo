package com.example.tomal.serviceappdemo.activity;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.example.tomal.serviceappdemo.R;
import com.example.tomal.serviceappdemo.fragment.CreateServiceOptionalFragmentGgs;

public class MainActivityGgs extends AppCompatActivity implements CreateServiceOptionalFragmentGgs.OnFragmentInteractionListener{
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ggs_activity_main);

        initialize();


        if (savedInstanceState==null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container_frame_layout, CreateServiceOptionalFragmentGgs.newInstance(), MainActivityGgs.class.getName())
                    .commit();
        }


    }



    private void initialize(){
        toolbar=(Toolbar)findViewById(R.id.ggs_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ggs_main_menu, menu);//Menu Resource, Menu
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
