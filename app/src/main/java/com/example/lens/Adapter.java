package com.example.lens;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

//메인에서 슬라이드 하기 위함

public class Adapter extends FragmentStateAdapter {

    public int mCount;

    public Adapter(FragmentActivity frag, int count) {
        super(frag);
        mCount = count;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        int index = getRealPosition(position);

        if (index == 0) return new Slide1();
            else if (index == 1) return new Slide2();
            else return new Slide3();
    }

    @Override
    public int getItemCount() {

        return 2000;
    }

    public int getRealPosition(int position) {
        return position % mCount;
    }

}