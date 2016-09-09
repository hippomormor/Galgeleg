package org.hippomormor.galgeleg;

import android.annotation.SuppressLint;
import android.provider.Settings;
import android.widget.ImageView;
import android.widget.TextView;

public class LogicHandler {

    private Logic logic;
    TextView resultView;
    TextView infoView;
    TextView inputText;
    ImageView imageView;
    GameActivity gameActivity;

    public LogicHandler(GameActivity gameActivity) {
        logic = new Logic();
        this.gameActivity = gameActivity;
        infoView = (TextView) gameActivity.findViewById(R.id.infoView);
        inputText = (TextView) gameActivity.findViewById(R.id.inputText);
        resultView = (TextView) gameActivity.findViewById(R.id.resultView);
        imageView = (ImageView) gameActivity.findViewById(R.id.imageView);
    }

    public String getAnswer(){
        return logic.getOrdet();
    }

    @SuppressLint("SetTextI18n")
    public void restart() {
        logic.nulstil();
        resultView.setText(logic.getSynligtOrd());
        infoView.setText("Gæt et bogstav..");
        imageView.setImageResource(R.drawable.hang);
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

                    switch (logic.getAntalForkerteBogstaver()) {
                        case 0:  imageView.setImageResource(R.drawable.hang);
                            break;
                        case 1:  imageView.setImageResource(R.drawable.hang0);
                            break;
                        case 2:  imageView.setImageResource(R.drawable.hang1);
                            break;
                        case 3:  imageView.setImageResource(R.drawable.hang2);
                            break;
                        case 4:  imageView.setImageResource(R.drawable.hang3);
                            break;
                        case 5:  imageView.setImageResource(R.drawable.hang4);
                            break;
                        case 6:  imageView.setImageResource(R.drawable.hang5);
                            break;
                        case 7:  imageView.setImageResource(R.drawable.hang6);
                            break;
                    }
                    System.out.println(logic.getAntalForkerteBogstaver());
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
