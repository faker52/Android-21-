package com.baidu.tts.myspeak;

import android.content.Context;
import android.content.res.Resources;

import java.lang.reflect.Field;

class Chess {

    int type;
    int nums;
    String name;
    public Chess(int type,int nums,String name){
        this.type=type;
        this.nums=nums;
        this.name=name;
    }
    public int  getId(){
        Class mipmap = R.drawable.class;
        try {
            Field field = mipmap.getField(name);
            int resId = field.getInt(name);
            return resId;
        } catch (NoSuchFieldException e) {
            return 0;
        } catch (IllegalAccessException e) {
            return 0;
        }

    }


    public int getType(){
        return  type;
    }

    public int getNums(){
        return nums;
    }
}
