package com.anwesome.ui.switchbuttondemo;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.anwesome.ui.switchbutton.SwitchButtonGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SwitchButtonGroup switchButtonGroup = new SwitchButtonGroup(this);
        switchButtonGroup.addAction("RED", new SwitchButtonGroup.OnSelectListener() {
            @Override
            public void onSelect() {
                Toast.makeText(MainActivity.this,"RED",Toast.LENGTH_SHORT).show();
            }
        });
        switchButtonGroup.addAction("GREEN",new SwitchButtonGroup.OnSelectListener() {
            @Override
            public void onSelect() {
                Toast.makeText(MainActivity.this, "GREEN", Toast.LENGTH_SHORT).show();
            }
        });
        switchButtonGroup.addAction("BLUE",new SwitchButtonGroup.OnSelectListener() {
                @Override
                public void onSelect() {
                    Toast.makeText(MainActivity.this, "BLUE", Toast.LENGTH_SHORT).show();
                }
        });
        switchButtonGroup.show(400);
    }
}
