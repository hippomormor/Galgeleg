package org.hippomormor.galgeleg;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button startButton, quitButton;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = (Button) findViewById(R.id.startButton);
        quitButton = (Button) findViewById(R.id.quitButton);
        startButton.setOnClickListener(this);
        quitButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.options) {
            Intent start = new Intent(this, OptionsActivity.class);
            startActivity(start);
        } else if (item.getItemId() == R.id.quit)
            System.exit(0);
        else
            return super.onOptionsItemSelected(item);
        return true;
    }

    @Override
    public void onClick(View view) {
        if (view == startButton) {
            Intent start = new Intent(this, GameActivity.class);
            startActivity(start);
        } else if (view == quitButton)
            System.exit(0);
    }
}
