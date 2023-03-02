package com.example.lens;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private View drawerView;
    private ViewPager2 mPager;
    private FragmentStateAdapter pagerAdapter;
    private int num_page = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerView = (View) findViewById(R.id.drawer);


        drawerLayout.setDrawerListener(listener);
        drawerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                return true;
            }
        });

        ImageButton btn_menu = (ImageButton) findViewById(R.id.btn_menu);
        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                drawerLayout.openDrawer(drawerView);
            }
        });


        ImageButton btn_menu2 = (ImageButton) findViewById(R.id.btn_menu2);
        btn_menu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                drawerLayout.openDrawer(drawerView);
            }
    });

        ImageButton icon_search=(ImageButton) findViewById(R.id.icon_search);
        icon_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(intent);
            }
        });


        //투명렌즈로 이동
        ImageButton page_clear=(ImageButton) findViewById(R.id.page_clear);
        page_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ClearActivity.class);
                startActivity(intent);
            }
        });

        //네비게이션 메뉴에서 투명렌즈로 이동
        Button page_clear2=(Button) findViewById(R.id.page_clear2);
        page_clear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ClearActivity.class);
                startActivity(intent);
            }
        });

        //컬러렌즈로 이동
        ImageButton page_color=(ImageButton) findViewById(R.id.page_color);
        page_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ColorActivity.class);
                startActivity(intent);
            }
        });

        //네비게이션 메뉴에서 컬러렌즈로 이동
        Button page_color2=(Button) findViewById(R.id.page_color2);
        page_color2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ColorActivity.class);
                startActivity(intent);
            }
        });

        //렌즈액으로 이동
        ImageButton page_water=(ImageButton) findViewById(R.id.page_water);
        page_water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), WaterActivity.class);
                startActivity(intent);
            }
        });

        //네비게이션 메뉴에서 렌즈액으로 이동
        Button page_water2=(Button) findViewById(R.id.page_water2);
        page_water2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), WaterActivity.class);
                startActivity(intent);
            }
        });

        //후기로 이동
        Button page_community=(Button) findViewById(R.id.page_community);
        page_community.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CommActivity.class);
                startActivity(intent);
            }
        });

        //약국검색으로이동
        Button page_map=(Button) findViewById(R.id.page_map);
        page_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MapActivity.class);
                startActivity(intent);
            }
        });

        //메인에서 슬라이드
        mPager = findViewById(R.id.viewpager);

        pagerAdapter = new Adapter(this, num_page);
        mPager.setAdapter(pagerAdapter);


        mPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);


        mPager.setCurrentItem(1000); //시작 지점
        mPager.setOffscreenPageLimit(4); //최대 이미지 수

        mPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if (positionOffsetPixels == 0) {
                    mPager.setCurrentItem(position);
                }

            }
        });


    }//OnCreate


            DrawerLayout.DrawerListener listener = new DrawerLayout.DrawerListener() {
                @Override
                public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

                }

                @Override
                public void onDrawerOpened(@NonNull View drawerView) {

                }

                @Override
                public void onDrawerClosed(@NonNull View drawerView) {

                }

                @Override
                public void onDrawerStateChanged(int newState) {

                }
            };

   /* private class CustomAdapter extends ArrayAdapter<String> {
        private ArrayList<String> items;

        public CustomAdapter(Context context, int textViewResourceId, ArrayList<String> objects) {
            super(context, textViewResourceId, objects);
            this.items = objects;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.activity_listview_item, null);
            }

            // ImageView 인스턴스
            ImageView imageView = (ImageView)v.findViewById(R.id.imageView);

            // 리스트뷰의 아이템에 이미지를 변경한다.
            if("Seoul".equals(items.get(position)))
                imageView.setImageResource(R.drawable.image_clear2);
            else if("Busan".equals(items.get(position)))
                imageView.setImageResource(R.drawable.image_all);
            else if("Daegu".equals(items.get(position)))
                imageView.setImageResource(R.drawable.image_glass);
            else if("Jeju".equals(items.get(position)))
                imageView.setImageResource(R.drawable.image_color);


            TextView textView = (TextView)v.findViewById(R.id.textView);
            textView.setText(items.get(position));

            final String text = items.get(position);
            Button button = (Button)v.findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                }
            });

            return v;
        }

    }*/

        }
