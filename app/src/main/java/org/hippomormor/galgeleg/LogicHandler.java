package org.hippomormor.galgeleg;

import android.annotation.SuppressLint;
import android.widget.TextView;

public class LogicHandler {

    private Logic logic;
    TextView resultView;
    TextView infoView;
    TextView inputText;
    GameActivity gameActivity;

    public LogicHandler(GameActivity gameActivity) {
        logic = new Logic();
        this.gameActivity = gameActivity;
        infoView = (TextView) gameActivity.findViewById(R.id.infoView);
        inputText = (TextView) gameActivity.findViewById(R.id.inputText);
        resultView = (TextView) gameActivity.findViewById(R.id.resultView);
    }

    public String getAnswer(){
        return logic.getOrdet();
    }

    @SuppressLint("SetTextI18n")
    public void restart() {
        logic.nulstil();
        resultView.setText(logic.getSynligtOrd());
        infoView.setText("Gæt et bogstav..");
        inputText.setEnabled(true);
    }

    @SuppressLint("SetTextI18n")
    public void checkAnswer() {

        if (!logic.erSpilletSlut()) {
            resultView.setText(logic.getSynligtOrd());

            CharSequence answer = inputText.getText();
            inputText.setText("");

            if (logic.getBrugteBogstaver().contains(answer.toString())) {
                infoView.setText("Allerede brugt!");
            } else {
                logic.gætBogstav(answer.toString());

                if (!logic.erSidsteBogstavKorrekt()) {
                    infoView.setText("Forkert!");
                } else {
                    infoView.setText("Korrekt!");
                }
                resultView.setText(logic.getSynligtOrd());
            }
            if (logic.erSpilletTabt()) {
                infoView.setText("Spillet er slut og du har tabt");
                resultView.setText(logic.getOrdet());
                inputText.setEnabled(false);

            } else if (logic.erSpilletVundet()) {
                infoView.setText("Spillet er slut og du har vundet");
                resultView.setText(logic.getOrdet());
                inputText.setEnabled(false);
            }
        }
    }
}
