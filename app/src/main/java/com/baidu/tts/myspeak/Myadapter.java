package com.baidu.tts.myspeak;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baidu.tts.myspeak.Fruit;
import com.baidu.tts.myspeak.R;

import java.util.List;

public class Myadapter extends ArrayAdapter<Fruit> {
    int resourceid;
    public Myadapter(Context context, int textViewResourceid, List<Fruit> objects){
        super(context,textViewResourceid,objects);
        resourceid=textViewResourceid;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Fruit fruit=getItem(position);
        View view;
        if(convertView==null) {
            view = LayoutInflater.from((getContext())).inflate(resourceid, parent, false);
        }
        else{
            view=convertView;
        }
        ImageView fruitImage=(ImageView) view.findViewById(R.id.fruitimage);
        TextView fruitName=(TextView) view.findViewById(R.id.textname);
        fruitImage.setImageResource(fruit.getImageid());
        fruitName.setText(fruit.getName());
        return view;
    }
}