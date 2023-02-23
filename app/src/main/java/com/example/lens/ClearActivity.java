package com.example.lens;


import android.app.TabActivity;

import android.os.Bundle;
import android.widget.TabHost;


public class ClearActivity extends TabActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clear);


        TabHost tabHost=getTabHost();

        TabHost.TabSpec tabSpec1=tabHost.newTabSpec("TAG1").setIndicator("아큐브 모이스트");
        tabSpec1.setContent(R.id.clear_explain1);
        tabHost.addTab(tabSpec1);

        TabHost.TabSpec tabSpec2=tabHost.newTabSpec("TAG2").setIndicator("아큐브 비타");
        tabSpec2.setContent(R.id.clear_explain2);
        tabHost.addTab(tabSpec2);

        TabHost.TabSpec tabSpec3=tabHost.newTabSpec("TAG3").setIndicator("오렌즈 워터파인");
        tabSpec3.setContent(R.id.clear_explain3);
        tabHost.addTab(tabSpec3);


        tabHost.setCurrentTab(0);



    }//onCreate
}
