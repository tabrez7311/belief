package com.example.tabish.belief;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (!prefs.getBoolean("firstTime", false)) {
            // <---- run your one time code here

            setContentView(R.layout.welcome);

            // mark first time has runned.
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstTime", true);
            editor.apply();
        }
        else {
            setContentView(R.layout.activity_main);
        }

    }

    /*for menu
    private int group1Id=1;

    int settingId=Menu.FIRST;

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        menu.add(group1Id,settingId,settingId,"Settings");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                Intent intent = new Intent(MainActivity.this, Settin.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    */

    public void getStarted(View view) {
                Intent myIntent = new Intent(view.getContext(), MainActivity.class);
                startActivity(myIntent);

    }
    public void fakeCall(View view){
Intent intent = new Intent(MainActivity.this,FakeCall.class);
        startActivity(intent);
    }

    public void siren(View view){

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.sirensound);
        mp.start();

        findViewById(R.id.SirenButton).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                if(!mp.isPlaying())
                {
                    mp.start();
                }
                else{
                    mp.seekTo(0);
                    mp.pause();

                }
            }
        });
    }


}
