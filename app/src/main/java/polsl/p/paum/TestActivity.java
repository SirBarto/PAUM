package polsl.p.paum;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import java.util.Random;

public class TestActivity extends Logic {

    int rand = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        createGui();

        startTest = findViewById(R.id.startTestbutton);
        startTest.setOnClickListener(this);
    }

    void displaySymbol(int tempAlphabet) {
        Log.v("int  tempalphabet", String.valueOf(tempAlphabet));
        Log.v("test alphabet", alphabet[tempAlphabet]);
        CompareDisplaytextView.setText(alphabet[tempAlphabet]);
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.menubutton:
                startActivity(new Intent(TestActivity.this, MainActivity.class));
                break;
            case R.id.startTestbutton:
                rand = learningModeStart();
                break;
        }

        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i].getId() == v.getId()) {
                buttons[i].setEnabled(true);
                if (buttons[i].isPressed()) {
                    buttons[i].setBackgroundColor(getResources().getColor(R.color.colorButtonPressed));
                    tempCode[i] = Integer.toString(1);
                    buttons[i].setClickable(false);
                    break;
                } else if (!buttons[i].isPressed()) {
                    buttons[i].setBackgroundColor(getResources().getColor(R.color.colorButtonFocused));
                    tempCode[i] = Integer.toString(0);
                    break;
                }

                for (int a = 0; a <= tempCode.length; a++)
                    if (a == i) {
                        tempCode[a] = tempCode[i];
                    }
            }
        }

        tempCode2 = tempCode[0] + tempCode[1] + tempCode[2] + tempCode[3] + tempCode[4] + tempCode[5];
        Log.v("tempCode2: ", tempCode2);

        if (CompareDisplaytextView.isPressed())
            compare(tempCode2, rand);
    }

    private int learningModeStart() {
        Random rand = new Random();
        int maxrand = alphabet.length;
        int randNumber = rand.nextInt(maxrand);
        playSampleOfCharsList(randNumber);
        displaySymbol(randNumber);
        return randNumber;
    }

    void compare(String tempCode, int randNumberCompare) {
        for (int i = 0; i < BrailleAndAlphabet.length; i++) {
            for (int j = 0; j < BrailleAndAlphabet[i].length; j++) {
                Log.v("compare i:", String.valueOf(i));
                Log.v("compare j:", String.valueOf(j));

                if (BrailleAndAlphabet[i][j].equals(tempCode)) {
                    if (j == randNumberCompare) {
                        playCommunicate(2);
                        CompareDisplaytextView.setBackgroundColor(getResources().getColor(R.color.colorGood));
                    } else {
                        playCommunicate(1);
                        CompareDisplaytextView.setBackgroundColor(getResources().getColor(R.color.colorBad));
                    }
                }
                defaultButton();
                //CompareDisplaytextView.setBackgroundColor(getResources().getColor(R.color.colorButtonFocused));
            }
        }
    }

}
