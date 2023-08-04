package com.axb.littlerocket;

import static android.os.SystemClock.sleep;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button mStartRocketButton;
    private Button mStopRocketButton;
    public static int OVERLAY_PERMISSION_REQ_CODE = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 初始化布局文件中的View
        initView();
    }

    /**
     * 初始化布局文件中的View
     */
    private void initView() {
        mStartRocketButton = (Button) findViewById(R.id.start_rocket);
        mStopRocketButton = (Button) findViewById(R.id.stop_rocket);
        mStartRocketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RocketService.class);
                startService(intent);
                //finish();
            }
        });
        mStopRocketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(MainActivity.this, RocketService.class));
                //finish();
            }
        });
    }

}
