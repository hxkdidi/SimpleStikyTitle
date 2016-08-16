package com.map.dev;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyScrollView.OnScrollListener {

    private RelativeLayout container;
    private View level_view;
    private MyScrollView myScrollView;
    private RelativeLayout temp_layout;
    private RelativeLayout stick;
    private FullGridView gv;
    private FullGridView gv_1;
    private List<String> strings = new ArrayList<>();
    private List<String> strings_1 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        myScrollView = (MyScrollView) findViewById(R.id.myScrollView);
        container = (RelativeLayout) findViewById(R.id.container);
        temp_layout = (RelativeLayout) findViewById(R.id.temp_layout);
        stick = (RelativeLayout) findViewById(R.id.stick);
        level_view = findViewById(R.id.level_view);
        gv = (FullGridView) findViewById(R.id.gv);
        gv_1 = (FullGridView) findViewById(R.id.gv_1);
        myScrollView.setOnScrollListener(this);
        for (int i = 0; i < 20; i++) {
            strings.add(i + "");
        }

        for (int i = 0; i < 4; i++) {
            strings_1.add(i + "");
        }
        gv.setAdapter(new DevAdapter(this, strings));
        gv_1.setAdapter(new DevAdapter(this, strings_1));
    }

    private int layoutTop;

    @Override
    public void onScroll(int scrollY) {

        layoutTop = level_view.getBottom();//获取searchLayout的顶部位置
        if (scrollY >= layoutTop) {
            if (temp_layout.getParent() != stick) {
                container.removeView(temp_layout);
                stick.addView(temp_layout);
                stick.setVisibility(View.VISIBLE);
                stick.setBackgroundResource(R.color.colorAccent);
            }
        } else {
            if (temp_layout.getParent() != container) {
                stick.removeView(temp_layout);
                container.addView(temp_layout);
                stick.setBackgroundResource(R.color.background);
                stick.setVisibility(View.GONE);
            }
        }
    }
}
