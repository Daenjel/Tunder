package com.daenjel.tunder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ImageAdapter extends PagerAdapter {

    private ArrayList<Integer> ImageArray;
    private Context context;
    private String Myname[],Myoccupy[];
    private int Myage[];
    private LayoutInflater inflater;
    public ImageAdapter(Context context,ArrayList<Integer> ImageArray,String [] myname,int[] myage,String[]myoccupy){
        this.context = context;
        this.ImageArray = ImageArray;
        this.Myname = myname;
        this.Myage = myage;
        this.Myoccupy = myoccupy;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return ImageArray.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = inflater.inflate(R.layout.cardview,container,false);
        ImageView imageView = view.findViewById(R.id.image);
        TextView name = view.findViewById(R.id.txtname);
        TextView age = view.findViewById(R.id.txtage);
        TextView occupy = view.findViewById(R.id.occupation);

        imageView.setImageResource(ImageArray.get(position));
        name.setText(Myname[position]);
        age.setText(String.valueOf(Myage[position]));
        occupy.setText(Myoccupy[position]);
        container.addView(view);
        return  view;
    }
}
