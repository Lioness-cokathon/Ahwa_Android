package com.threehundred.ahwa_android;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TabLayout main_tabLayout;
    TimeTableFragment timeTableFragment;
    MyInfoFragment myInfoFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timeTableFragment = new TimeTableFragment();
        myInfoFragment = new MyInfoFragment();
        main_tabLayout = findViewById(R.id.main_tabLayout);
        getFragmentManager().beginTransaction().add(R.id.main_framelayout, timeTableFragment).commit();

        main_tabLayout.addTab(main_tabLayout.newTab().setText("시간표"));
        main_tabLayout.addTab(main_tabLayout.newTab().setText("내 정보"));
        main_tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();

                Fragment selected = null;

                if (position == 0) {
                    selected = timeTableFragment;

                    getFragmentManager().beginTransaction().replace(R.id.main_framelayout, selected).commit();
                } else if (position == 1) {
                    selected = myInfoFragment;
                    getFragmentManager().beginTransaction().replace(R.id.main_framelayout, selected).commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
