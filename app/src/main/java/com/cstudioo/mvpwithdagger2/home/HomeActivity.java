package com.cstudioo.mvpwithdagger2.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.cstudioo.mvpwithdagger2.R;
import com.cstudioo.mvpwithdagger2.util.Constant;

/**
 * Created by cstudioo on 13/02/17.
 */

public class HomeActivity extends AppCompatActivity {

    private TextView tvWelcome;

    private String nickName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        nickName = getIntent().getStringExtra(Constant.PASS_TO_HOME_USER);

        tvWelcome = (TextView) findViewById(R.id.activity_home_tv_welcome);

        tvWelcome.setText("Welcome " + nickName);
    }
}
