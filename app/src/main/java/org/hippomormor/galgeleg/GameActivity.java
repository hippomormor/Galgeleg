package org.hippomormor.galgeleg;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends Activity implements View.OnClickListener {
    LogicHandler logicHandler;
    private TextView inputView;
    Button restartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        logicHandler = new LogicHandler(this);
        restartButton = (Button) findViewById(R.id.restartButton);
        inputView = (TextView) findViewById(R.id.inputText);
        inputView.setOnClickListener(this);
        restartButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == inputView && inputView.getText().length() > 0) {
            logicHandler.checkAnswer();
            InputMethodManager inputMethodManager = (InputMethodManager)
                   view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        } else if (view == restartButton)
            logicHandler.restart();
    }
}
