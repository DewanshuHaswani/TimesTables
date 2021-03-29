package com.example.timestable;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        final ArrayList<Integer> number = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));

        final ArrayList<Integer> times = new ArrayList<Integer>();

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);

        seekBar.setMin(1);
        seekBar.setMax(10);


        final ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this,android.R.layout.simple_list_item_1,number);
        listView.setAdapter(arrayAdapter);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                times.clear();
                int i=0;
                int mutlipler;
                while(i<10){
                    Log.i("Hello",Integer.toString(i));
                    mutlipler = (i+1)*progress;
                    times.add(mutlipler);
                    i++;
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                arrayAdapter.clear();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                arrayAdapter.addAll(times);

            }
        });



    }
}