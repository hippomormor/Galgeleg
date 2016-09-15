package org.hippomormor.galgeleg;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;

public class OptionsActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{
    private Switch soundSwitch, musicSwitch, onlineSwitch;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        soundSwitch = (Switch) findViewById(R.id.switchSound);
        musicSwitch = (Switch) findViewById(R.id.switchMusic);
        onlineSwitch = (Switch) findViewById(R.id.switchOnline);
        mp = MediaPlayer.create(this, R.raw.music);
        soundSwitch.setOnCheckedChangeListener(this);
        musicSwitch.setOnCheckedChangeListener(this);
        onlineSwitch.setOnCheckedChangeListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.ok) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if (compoundButton == musicSwitch) {
            if (isChecked) {
                mp.setLooping(true);
                mp.start();
            } else
                mp.stop();
        }
    }
}
