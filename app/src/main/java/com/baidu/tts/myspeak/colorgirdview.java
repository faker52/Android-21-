package  com.baidu.tts.myspeak;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;


import cn.sensingai.commonlib.BaseApplication;

public class colorgirdview extends AppCompatActivity {
    int colernum=6;
    Intent[] color=new Intent[colernum];
    baiduspeak speek=new baiduspeak();
    private GridView mGridView;
    private Color1 mProvinceAdapter;
    private String[] provinceNames = new String[]{"绿色","蓝色","青色","红色","粉色","黄色"};
    int cc= Color.parseColor("#1afa29");
    private int[] bgColor = new int[]{R.color.lvse,R.color.lanse,R.color.qingse,R.color.hongse,R.color.fengse,R.color.huangse};
    String TAG="hh";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.girdview);
        speek.narmalspeak(colorgirdview.this,"已进入颜色更改");
        initView();
        for (int i = 0; i < colernum; i++)
            color[i] = new Intent(colorgirdview.this, MainActivity.class);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
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
        mGridView.setOnTouchListener(new CommonOnTouchListener(new CommonOnTouchListener.CommonOnTouchCallback() {
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
            TextView et = v.findViewById(R.id.text);
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




    private void initView() {
        mGridView = (GridView) this.findViewById(R.id.grid_view);
        List<ProvinceBean> provinceBeanList = new ArrayList<>();
        for (int i = 0; i < provinceNames.length; i++) {
            ProvinceBean provinceBean = new ProvinceBean();
            provinceBean.setName(provinceNames[i]);
            provinceBean.setColor(bgColor[i]);
            provinceBeanList.add(provinceBean);
        }
        mProvinceAdapter = new Color1(this, provinceBeanList);
        mGridView.setAdapter(mProvinceAdapter);
    }



}
