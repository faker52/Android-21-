package com.baidu.tts.myspeak;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Rule extends AppCompatActivity {
    TextView responseText;
    baiduspeak speek=new baiduspeak();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rule);
        Intent intent=getIntent();
        responseText=(TextView) findViewById(R.id.responetext);
        String x="电脑抓牌后，玩家进行抓牌，扑克牌上点数大者获胜，若大于21，则点数为-1，若抓取扑克数目等于五张且点数不到21，则点数直接变为21";
        responseText.setText(x);
        speek.narmalspeak(Rule.this,x);
    }
}
