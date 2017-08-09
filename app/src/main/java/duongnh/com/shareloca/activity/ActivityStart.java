package duongnh.com.shareloca.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import duongnh.com.shareloca.PublicMethob;
import duongnh.com.shareloca.R;

/**
 * Created by Admin on 8/5/2017.
 */

public class ActivityStart extends Activity implements View.OnClickListener {
    private LinearLayout llSplash;
    private RelativeLayout llStart;
    private Handler handler;
    private TextView tvSkip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        handler = new Handler();
        initUI();
        binData();
        initEven();

    }

    private void initEven() {
        tvSkip.setOnClickListener(this);
    }

    private void binData() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                PublicMethob.animationShowDown(ActivityStart.this, llStart);
            }
        }, 1500);

    }

    private void initUI() {
        llSplash = (LinearLayout) findViewById(R.id.ll_splash);
        llStart = (RelativeLayout) findViewById(R.id.ll_start);
        tvSkip = (TextView) findViewById(R.id.tv_skip);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(ActivityStart.this, ActivityLogin.class);
        startActivity(intent);
    }
}
