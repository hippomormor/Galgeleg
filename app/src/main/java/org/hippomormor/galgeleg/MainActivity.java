package org.hippomormor.galgeleg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button startButton;
    private Button quitButton;

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
    public void onClick(View view) {
        if (view == startButton) {
            Intent start = new Intent(this, GameActivity.class);
            startActivity(start);
        } else if (view == quitButton)
            System.exit(0);
    }
}
