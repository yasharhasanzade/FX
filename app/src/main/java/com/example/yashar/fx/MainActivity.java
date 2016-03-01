package com.example.yashar.fx;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.List;

/**
 * Created by yahsr on 2/29/2016.
 */
public class MainActivity extends Activity {
    private ViewPager viewPager;

    List<PersonData> list;

    @Override
    protected void onCreate(Bundle saveIntanceState) {
        super.onCreate(saveIntanceState);
        setContentView(R.layout.each_page_layout);

        this.list = PersonData.PersonDataGenerator.createPersonData();

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        PagerAdapter pagerAdapter = new CardPagerAdapter(this, list);
        viewPager.setOnPageChangeListener(new PageChangeListener());
        viewPager.setAdapter(pagerAdapter);
    }

    class PageChangeListener extends ViewPager.SimpleOnPageChangeListener{
        public void onPageSelected(int position){
            //page change operation!
        }
    }
}
