package com.example.dinesh.timestables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView TimesTablesListView;

    public void generateTimesTables (int timesTables){

        ArrayList<String> timesTablesContent = new ArrayList<String>();

        for (int i=1;i<=10;i++){
            timesTablesContent.add(Integer.toString(i*timesTables));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,timesTablesContent);

        TimesTablesListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar TimesTablesSeekBar = (SeekBar) findViewById(R.id.TimesTablesSeekBar);

         TimesTablesListView = (ListView) findViewById(R.id.TimesTablesListView);

        TimesTablesSeekBar.setMax(20);

        TimesTablesSeekBar.setProgress(10);

        TimesTablesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int min =1;
                int timesTables;

                if(progress<min){
                    timesTables= min;
                    TimesTablesSeekBar.setProgress(min);
                }
                else{
                    timesTables= progress;
                }

                generateTimesTables(timesTables);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

       generateTimesTables(10);

    }
}
