package com.baidu.tts.myspeak;
import android.content.Context;
import android.media.MediaSync;
import android.util.Log;

import com.baidu.tts.client.SpeechSynthesizeBag;
import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.TtsMode;
import com.baidu.tts.client.SpeechSynthesizerListener;


import java.util.List;

public class baiduspeak{
    SpeechSynthesizerListener listener=new MessageListener();
    String AppId = "16824690";
    String AppKey = "PIjaMSjdhORdnSkvhurCA6sz";
    String AppSecret = "m6lMDgc1gyj6CeGm9ujOkNlFziPf6i6o";
    SpeechSynthesizer mSpeechSynthesizer = SpeechSynthesizer.getInstance();
    private static final String TAG = "Speek";

public void narmalspeak(Context context,String text){
        mSpeechSynthesizer.setSpeechSynthesizerListener(listener);
        mSpeechSynthesizer.setContext(context);
        mSpeechSynthesizer.setAppId(AppId);
        mSpeechSynthesizer.setApiKey(AppKey, AppSecret);
        mSpeechSynthesizer.auth(TtsMode.ONLINE);
        mSpeechSynthesizer.setParam(SpeechSynthesizer.PARAM_SPEAKER, "0");
        mSpeechSynthesizer.setParam(SpeechSynthesizer.PARAM_VOLUME, "9");
        mSpeechSynthesizer.setParam(SpeechSynthesizer.PARAM_SPEED, "5");
        mSpeechSynthesizer.setParam(SpeechSynthesizer.PARAM_PITCH, "5");
        mSpeechSynthesizer.initTts(TtsMode.ONLINE);
        mSpeechSynthesizer.stop();
        mSpeechSynthesizer.speak(text);
}

    private void print(String message) {
        Log.i(TAG, message);
    }
    private void checkResult(int result, String method) {
        if (result != 0) {
            print("error code :" + result + " method:" + method + ", 错误码文档:http://yuyin.baidu.com/docs/tts/122 ");
        }
    }
   // public  void stop(){
   // mSpeechSynthesizer.stop();
   // }


}
