package com.example.yashar.fx;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yahsr on 2/29/2016.
 */
public class CardPagerAdapter extends PagerAdapter {
    LayoutInflater _inflater = null;
    List<PersonData> list;
    private TextView nameview;
    private ImageView charview;

    public CardPagerAdapter(Context context,List<PersonData> list){
        super();
        _inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.list = list;
    }

    public Object instantiateItem(ViewGroup container,int position){
        LinearLayout layout = (LinearLayout)_inflater.inflate(R.layout.top_layout,null);

        nameview = (TextView)layout.findViewById(R.id.word);
        nameview.setText(list.get(position).getName());

        charview = (ImageView)layout.findViewById(R.id.img);
        charview.setImageResource(list.get(position).getRes());

        container.addView(layout);
        return layout;
    }

    public void destroyItem(ViewGroup container,int position,Object object){
        container.removeView((View) object);
    }

    public int getCount(){
        return list.size();
    }

    public boolean isViewFromObject(View view,Object obj){
        return view.equals(obj);
    }
}


class PersonData{
    private String name;
    private int res;

    public PersonData(String name,int res){
        this.name=name;
        this.res=res;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public int getRes(){
        return res;
    }

    public void setRes(int res){
        this.res=res;
    }

    public static class PersonDataGenerator{
        public static List<PersonData> createPersonData(){
            List<PersonData> res = new ArrayList<PersonData>();

            res.add(new PersonData("Frank Peter",R.mipmap.tf_fh));
            res.add(new PersonData("Leon Martin",R.mipmap.ic_launcher));


            return res;
        }
    }
}