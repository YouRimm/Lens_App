package com.example.lens;


import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;

import android.widget.TabHost;


public class ColorActivity extends TabActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        TabHost tabHost=getTabHost();

        TabHost.TabSpec tabSpec1=tabHost.newTabSpec("TAG1").setIndicator("아큐브 디파인 프레쉬 헤이즐");
        tabSpec1.setContent(R.id.color_explain1);
        tabHost.addTab(tabSpec1);

        TabHost.TabSpec tabSpec2=tabHost.newTabSpec("TAG2").setIndicator("오렌즈 아이라이터 블랙");
        tabSpec2.setContent(R.id.color_explain2);
        tabHost.addTab(tabSpec2);


        tabHost.setCurrentTab(0);


    }//onCreate
}