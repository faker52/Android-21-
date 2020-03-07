
package  com.baidu.tts.myspeak;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;



public class CommonOnTouchListener implements View.OnTouchListener {

    /**
     * 自定义回调接口
     */
    private CommonOnTouchListener.CommonOnTouchCallback mCallback;

    public CommonOnTouchListener(CommonOnTouchListener.CommonOnTouchCallback callback) {
        super();
        this.mCallback = callback;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        boolean intercept = false;
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mCallback.onActionDown(event);
                break;
            case MotionEvent.ACTION_MOVE:
                int dx = (int) event.getX();
                int dy = (int) event.getRawY();
                //获取当前触摸到的View
                final View touchedView = getTouchTarget(v, dx, dy);
                mCallback.onActionMove(event,touchedView);
                break;
            case MotionEvent.ACTION_UP:
                mCallback.onActionUp(event);
                break;
        }
        return intercept;
    }


    public interface CommonOnTouchCallback {
        void onActionDown(MotionEvent event);
        void onActionMove(MotionEvent event, View view);
        void onActionUp(MotionEvent event);
    }


    //根据坐标返回触摸到的View
    private View getTouchTarget(View rootView, int x, int y) {
        View targetView = null;
        // 判断view是否可以聚焦
        ArrayList<View> touchableViews = rootView.getTouchables();
        for (View touchableView : touchableViews){
            if (isTouchPointInView(touchableView, x, y)){
                targetView = touchableView;
                break;
            }
        }
        return targetView;
    }


    /**
     * 该方法检测一个点击事件是否落入在一个View内，换句话说，检测这个点击事件是否发生在该View上。
     *
     * @param view
     * @param x
     * @param y
     * @return
     */
    private boolean isTouchPointInView(View view, float x, float y) {
        if (view == null) {
            return false;
        }

        int[] location = new int[2];
        view.getLocationOnScreen(location);

        int left = location[0];
        int top = location[1];

        int right = left + view.getMeasuredWidth();
        int bottom = top + view.getMeasuredHeight();

        if (y >= top && y <= bottom && x >= left && x <= right) {
            return true;
        }

        return false;
    }



}
