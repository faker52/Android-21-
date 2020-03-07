package com.baidu.tts.myspeak;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import cn.sensingai.commonlib.BaseApplication;

public class secondactivity extends AppCompatActivity {


    List<Fruit> function=new ArrayList<>();
    baiduspeak speek=new baiduspeak();
    Intent rule,color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);
        speek.narmalspeak(secondactivity.this,"已进入设置");
        Intent intent=getIntent();
        ListView listview =(ListView) findViewById(R.id.listview);
        inital();
        Myadapter adapter=new Myadapter(secondactivity.this,R.layout.text,function);
        listview.setAdapter(adapter);
        rule=new Intent(secondactivity.this,Rule.class);
        color=new Intent(secondactivity.this,colorgirdview.class);
       listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id){
           Fruit fruit=function.get(position);
           if(position==0){
               startActivity(rule);}
           if(position==1)
               startActivity(color);
       }});
        listview.setOnTouchListener(new CommonOnTouchListener(new CommonOnTouchListener.CommonOnTouchCallback() {
            @Override
            public void onActionDown(MotionEvent event ) {

            }
            @Override
            public void onActionMove(MotionEvent event,View view) {
                nativeSpeak(getItemName(view));
            }
            @Override
            public void onActionUp(MotionEvent event) {

            }
        }));




    }



    private String mMenuName="";//功能菜单名称
    private String mEmptyArea="";//空白区域

    private String getItemName(View v) {
        if (v != null ) {
            TextView et = v.findViewById(R.id.textname);
            String menuName1 = et.getText().toString();
            if (!mMenuName.equals(menuName1)) {
                mMenuName = menuName1;
                if (BaseApplication.mBDTts != null) BaseApplication.mBDTts.stop();
                mEmptyArea = "";
                return mMenuName;
            }
        } else {
            mMenuName = "";
            if (TextUtils.isEmpty(mEmptyArea)) {
                mEmptyArea = NewsConatant.EMPTY_AREA;
                return mEmptyArea;
            }
        }
        return "-1";
    }

    private void nativeSpeak(String text) {
        if (!"-1".equals(text)) {
            speek.narmalspeak(this,text);
        }
    }


    public void inital(){
        Fruit cc=new Fruit("游戏规则",R.drawable.guize);
        Fruit cc1=new Fruit("背景颜色",R.drawable.yanse);
        function.add(cc);
        function.add(cc1);
    }

}
