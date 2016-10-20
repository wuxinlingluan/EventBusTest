package com.github.eventbustest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static com.github.eventbustest.R.id.tv2;

public class SecondActivity extends AppCompatActivity {

    private TextView tv;
    private TextView tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        EventBus.getDefault().register(this);
        tv = (TextView) findViewById(R.id.tv1);
        tv3 = (TextView) findViewById(R.id.tv3);

    }

    public void start(View view) {
        EventBus.getDefault().post(new MessageEvent("逝者如斯夫","不舍昼夜"));
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getEvent(MessageEvent mes){
        tv.setText(mes.password);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
