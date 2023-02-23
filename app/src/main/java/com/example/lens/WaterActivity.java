package com.example.lens;


import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;


public class WaterActivity extends TabActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);


        TabHost tabHost=getTabHost();

        TabHost.TabSpec tabSpec1=tabHost.newTabSpec("TAG1").setIndicator("옵티프리 익스프레스");
        tabSpec1.setContent(R.id.water_explain1);
        tabHost.addTab(tabSpec1);

        TabHost.TabSpec tabSpec2=tabHost.newTabSpec("TAG2").setIndicator("리뉴");
        tabSpec2.setContent(R.id.water_explain2);
        tabHost.addTab(tabSpec2);


        tabHost.setCurrentTab(0);


    }//onCreate
}