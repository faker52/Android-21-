package com.baidu.tts.myspeak;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Color extends AppCompatActivity {

    int colernum=6;
    Intent[] color=new Intent[colernum];
    List<Fruit> select=new ArrayList<>();
    baiduspeak speak=new baiduspeak();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);
        Intent intent = getIntent();
        initial();
        Myadapter adapter = new Myadapter(Color.this, R.layout.text2, select);
        ListView listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(adapter);
        for (int i = 0; i < colernum; i++)
            color[i] = new Intent(Color.this, MainActivity.class);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = select.get(position);
                if (position == 0) {
                    color[0].putExtra("color", "#1afa29");
                    color[0].setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(color[0]);
                }
                if (position == 1) {
                    color[1].putExtra("color", "#1296db");
                    color[1].setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(color[1]);
                }
                if (position == 2) {
                    color[2].putExtra("color", "#13227a");
                    color[2].setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(color[2]);
                }
                if (position == 3) {
                    color[3].putExtra("color", "#d81e06");
                    color[3].setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(color[3]);
                }
                if (position == 4) {
                    color[4].putExtra("color", "#d4237a");
                    color[4].setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(color[4]);
                }
                if (position == 5) {
                    color[5].putExtra("color", "#f4ea2a");
                    color[5].setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(color[5]);
                }

            }
        });


    }


    public void initial(){
        Fruit[] cc=new Fruit[colernum];
        cc[0]=new Fruit("绿色",R.drawable.c1afa29);
        cc[1]=new Fruit("蓝色",R.drawable.c1296db);
        cc[2]=new Fruit("青色",R.drawable.c13227a);
        cc[3]=new Fruit("红色",R.drawable.cd81e06);
        cc[4]=new Fruit("粉色",R.drawable.cd4237a);
        cc[5]=new Fruit("黄色",R.drawable.cf4ea2a);
        for(int i=0;i<colernum;i++){
            select.add(cc[i]);
        }
    }
}
