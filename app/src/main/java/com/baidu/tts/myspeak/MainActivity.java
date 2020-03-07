package com.baidu.tts.myspeak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;

import cn.sensingai.commonlib.BaseApplication;

import static com.baidu.tts.f.c.c;
import static com.baidu.tts.f.c.v;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout mContainer;
    Button play;
    Button get;
    Button stop_get;
    Button replay;
    Button shezhi;
    int peo_Count=0;//玩家抓牌数
    Chess[] chess=new Chess[53];
    int com_Count=0;//电脑抓牌数
    int com_point=0;//电脑点数
    int peo_point=0;//玩家点数
    int index=1;
    int HEIGHT;
    int turn=0;//0为电脑回合，1为玩家回合
    int SIDE;//扑克的大小
    private static final String TAG = "Speek";
    baiduspeak speek=new baiduspeak();
    LinearLayout lly;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            mContainer = findViewById(R.id.container);
            play = findViewById(R.id.play);
            get = findViewById(R.id.get);
            stop_get = findViewById(R.id.stop_get);
            replay = findViewById(R.id.replay);
            shezhi=findViewById(R.id.shezhi);
            play.setOnClickListener(MainActivity.this);
            get.setOnClickListener(MainActivity.this);
            stop_get.setOnClickListener(MainActivity.this);
            replay.setOnClickListener(MainActivity.this);
            shezhi.setOnClickListener(MainActivity.this);
            lly=findViewById(R.id.container);
            setcolor();
            getPingMuSize(MainActivity.this);
            play.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {

                        if(event.getAction() == MotionEvent.ACTION_DOWN){
                            speek.narmalspeak(MainActivity.this,"开始游戏");
                        }else if(event.getAction() == MotionEvent.ACTION_UP) {
                        }


                        return false;

                    }});
            get.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    if(event.getAction() == MotionEvent.ACTION_DOWN){
                        speek.narmalspeak(MainActivity.this,"抓牌");
                    }else if(event.getAction() == MotionEvent.ACTION_UP) {
                    }


                    return false;

                }});
            stop_get.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    if(event.getAction() == MotionEvent.ACTION_DOWN){
                        speek.narmalspeak(MainActivity.this,"停止抓牌");
                    }else if(event.getAction() == MotionEvent.ACTION_UP) {
                    }


                    return false;

                }});
            replay.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    if(event.getAction() == MotionEvent.ACTION_DOWN){
                        speek.narmalspeak(MainActivity.this,"重新开始");
                    }else if(event.getAction() == MotionEvent.ACTION_UP) {
                    }


                    return false;

                }});
            shezhi.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    if(event.getAction() == MotionEvent.ACTION_DOWN){
                        speek.narmalspeak(MainActivity.this,"设置");
                    }else if(event.getAction() == MotionEvent.ACTION_UP) {
                    }


                    return false;

                }});
            initial();
            random();

        }

    }


    public  void getPingMuSize(Context mContext) { int densityDpi = mContext.getResources().getDisplayMetrics().densityDpi;
        float scaledDensity = mContext.getResources().getDisplayMetrics().scaledDensity;
        float density = mContext.getResources().getDisplayMetrics().density;
        float xdpi = mContext.getResources().getDisplayMetrics().xdpi;
        float ydpi = mContext.getResources().getDisplayMetrics().ydpi;
        int width = mContext.getResources().getDisplayMetrics().widthPixels;
        int height = mContext.getResources().getDisplayMetrics().heightPixels;


        SIDE=width/3;
        HEIGHT=height/3*2;

    }


    public void initial(){
        String id;
        for(int i=1;i<=4;i++){
            for(int j=1;j<=13;j++){
                id="p"+i+"a"+j;
                chess[13*(i-1)+j]=new Chess(i,j,id);

            }
        }
    }
    //初始化类

    public void random() {
        Chess temp;
        for (int i = 1; i < 53; i++) {

            int a = (int) (Math.random() * 52);
            if(a==0) continue;
            temp = chess[a];
            chess[a] = chess[1];
            chess[1] = temp;
        }
    }


    public boolean onTouchEvent(MotionEvent event){
        float x = event.getX();
        float y = event.getY();
        try
        {

            switch(event.getAction())
            {
                case MotionEvent.ACTION_DOWN: {
                    if (y>= 0 && y< 990) {
                        if (turn == 0) {
                            speek.narmalspeak(this, "游戏还没开始，点击左下方开始按钮开始游戏");
                        }
                        if (turn == 1) {

                            speek.narmalspeak(this, "电脑抓取" + com_Count + "张牌");
                        }
                        if (turn == 3) {

                            speek.narmalspeak(this, "电脑的点数为" + com_point);
                        }
                        break;
                    }
                    if ( y>= 990 &&  y< 1760) {
                        if (turn == 0) {
                            speek.narmalspeak(this, "游戏还没开始，点击左下方开始按钮开始游戏");
                        }
                        if (turn == 1) {
                            speek.narmalspeak(this, "玩家抓取" + peo_Count + "张牌"+",玩家的点数是"+peo_point);
                        }
                        if (turn == 3) {
                            speek.narmalspeak(this, "玩家的点数为" + peo_point);
                        }
                        break;
                    }
                    if(y>=2046&&x>=0&&x<=276){
                        speek.narmalspeak(this, "点击开始游戏");
                    }
                }
            }
            return  true;
        }
        catch(Exception e)
        {
            Log.v("touch", e.toString());
            return false;
        }
    }

    //洗牌；
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.play:
                Toast.makeText(MainActivity.this, "开始按钮被点击", Toast.LENGTH_SHORT).show();
                if(turn==0) com_get(v);
                else Toast.makeText(MainActivity.this, "不是电脑回合", Toast.LENGTH_SHORT).show();
                break;
            case R.id.get:
                Toast.makeText(MainActivity.this, "抓牌按钮被点击", Toast.LENGTH_SHORT).show();
                if(peo_Count>=5){
                    Toast.makeText(MainActivity.this, "抓牌数量已达到上线", Toast.LENGTH_SHORT).show();
                    speek.narmalspeak(this, "抓牌数量已达到上线");
                    break;
                }
                if(turn==1) peo_get(v);
                else Toast.makeText(MainActivity.this, "不是你的回合", Toast.LENGTH_SHORT).show();
                break;
            case R.id.stop_get:
                Toast.makeText(MainActivity.this, "停止抓牌按钮被点击", Toast.LENGTH_SHORT).show();
                if(turn!=3&&peo_Count!=0)stop_get(v);
                else Toast.makeText(MainActivity.this, "无法点击停止抓牌", Toast.LENGTH_SHORT).show();
                break;
            case R.id.replay:
                Toast.makeText(MainActivity.this, "重新开始按钮被点击", Toast.LENGTH_SHORT).show();
                replay();
                break;
            case R.id.shezhi:
                Intent intent=new Intent(MainActivity.this,secondactivity.class);
               //String colorCode = "#ffffff";
                startActivity(intent);
               //lly.setBackgroundColor(Color.parseColor(colorCode));
                break;
        }
    }










    public void com_get(View view) {
        for(int i=0;i<5;i++) {
            if(com_point>16) break;
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(R.drawable.rear2);//图片资源
            com_point=chess[index].nums+com_point;
            index++;
            com_Count++;
            turn=1;
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(SIDE,SIDE);
            if(i==0) params.leftMargin=-SIDE/6;
            else params.leftMargin=-(SIDE/2);
            mContainer.addView(imageView,params);
            if(com_point>21){com_point=-1;break;}

        }
        if(com_Count==5&&com_point!=-1) com_point=21;
        speek.narmalspeak(this, "电脑已抓取" + com_Count + "张牌");
    }
    public void peo_get(View view) {
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(chess[index].getId()); //图片资源
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(SIDE,SIDE);
        if(peo_Count==0)
        {
            params.leftMargin=-((com_Count+1)*(SIDE/2));
            peo_Count++;
        }
        else{
            params.leftMargin=-(SIDE/2);
            peo_Count++;
        }
        peo_point=chess[index].nums+peo_point;
        index++;
        params.topMargin=1000;
        mContainer.addView(imageView,params);
        speek.narmalspeak(this, "玩家抓取" + peo_Count + "张牌"+",玩家的点数是"+peo_point);

    }

    public void stop_get(View view) {
        for(int i=1;i<=com_Count;i++) {
            ImageView imageView = new ImageView(this);
            //imageView.setLayoutParams(new LinearLayout.LayoutParams(250, 250));  //设置图片宽高
            imageView.setImageResource(chess[i].getId());//图片资源
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(SIDE,SIDE);
            if(i==1) params.leftMargin=-(peo_Count*(SIDE/2)+SIDE/2);
            else params.leftMargin=-(SIDE/2);
            turn=3;
            if(peo_point>21) peo_point=-1;
            mContainer.addView(imageView,params);
        }
        victory();
    }

        public void replay(){
        peo_point=0;
        com_point=0;
        peo_Count=0;
        com_Count=0;
        index=1;
        turn=0;
        random();
        mContainer.removeAllViews();
        speek.narmalspeak(this,"游戏已重置");
        }

    public void victory(){
        if(peo_point>com_point) {
            Toast.makeText(MainActivity.this, com_point+"玩家获胜"+peo_point, Toast.LENGTH_SHORT).show();
            speek.narmalspeak(this,"玩家的点数为" + peo_point+"，电脑的点数为" + com_point+"，玩家获胜");
        }
        if(peo_point<com_point) {
            Toast.makeText(MainActivity.this, com_point+"电脑获胜"+peo_point, Toast.LENGTH_SHORT).show();
            speek.narmalspeak(this,"玩家的点数为" + peo_point+"，电脑的点数为" + com_point+"，电脑获胜");
        }
        if(peo_point==com_point) {
            Toast.makeText(MainActivity.this, com_point+"平局"+peo_point, Toast.LENGTH_SHORT).show();
            speek.narmalspeak(this,"玩家的点数为" + peo_point+"，电脑的点数为" + com_point+"，平局");
        }
    }


    public  void setcolor(){
        intent=getIntent();
        String color=intent.getStringExtra("color");
        if(color==null){
           color="#1afa29";
        }
        else
        {lly.setBackgroundColor(Color.parseColor(color));
        speek.narmalspeak(MainActivity.this,"已更改");
        }
    }



    private String mMenuName="";//功能菜单名称
    private String mEmptyArea="";//空白区域

    private String getItemName(View v) {
        if (v != null ) {
            Button et = v.findViewById(v.getId());
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

}
