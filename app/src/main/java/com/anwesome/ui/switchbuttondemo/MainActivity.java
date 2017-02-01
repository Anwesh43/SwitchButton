package com.anwesome.ui.switchbuttondemo;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.anwesome.ui.switchbutton.SwitchButtonGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SwitchButtonGroup switchButtonGroup = new SwitchButtonGroup(this);
        switchButtonGroup.addAction("RED");
        switchButtonGroup.addAction("GREEN");
        switchButtonGroup.addAction("BLUE");
        switchButtonGroup.show(400);
    }
}
