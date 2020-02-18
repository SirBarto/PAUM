package polsl.p.paum;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LearningActivity extends AppCompatActivity implements View.OnClickListener {

    MediaPlayer player;

    int[] sampleOfCharsList = {R.raw.a, R.raw.b, R.raw.c, R.raw.d, R.raw.e, R.raw.f, R.raw.g, R.raw.h, R.raw.i,
            R.raw.j, R.raw.k, R.raw.l, R.raw.m, R.raw.n, R.raw.o, R.raw.p, R.raw.q, R.raw.r, R.raw.s,
            R.raw.t, R.raw.u, R.raw.v, R.raw.w, R.raw.x, R.raw.y, R.raw.z};

    String[] tempCode = new String[6];

    String tempCode2 = "000000";

    String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H",
            "I", "J", "K", "L", "M", "N", "O",
            "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z"};

    String[][] BrailleAndAlphabet = {
            {"100000", "101000", "110000", "110100", "100100", "111000", "111100", "101100",
                    "011000", "011100", "100010", "101010", "110010", "110110", "100110",
                    "111010", "111110", "101110", "011010", "011110", "100011", "101011",
                    "011101", "110011", "110111", "100111"},
            {"A", "B", "C", "D", "E", "F", "G", "H",
                    "I", "J", "K", "L", "M", "N", "O",
                    "P", "Q", "R", "S", "T", "U", "V",
                    "W", "X", "Y", "Z"}
    };

    TextView textView;

    private Button b1, b2, b3, b4, b5, b6, b7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);

        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);

        b7 = findViewById(R.id.button7);

        textView = findViewById(R.id.textView3);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);

        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);

        b7.setOnClickListener(this);

        textView.setOnClickListener(this);

        for (int i = 0; i < tempCode.length; i++) {
            tempCode[i] = "0";
        }
    }

    void displaySymbol(int tempAlphabet) {
        Log.v("int  tempalphabet", String.valueOf(tempAlphabet));
        Log.v("test alphabet", alphabet[tempAlphabet]);
        textView.setText(alphabet[tempAlphabet]);
    }

    public void play(int indexSong) {
        if (player == null) {
            player = MediaPlayer.create(this, sampleOfCharsList[indexSong]);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }

        player.start();
    }

    public void pause() {
        if (player != null) {
            player.pause();
        }
    }

    public void stop() {
        stopPlayer();
    }

    private void stopPlayer() {
        if (player != null) {
            player.release();
            player = null;
            //Toast.makeText(this, "MediaPlayer released", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                b1.setEnabled(true);
                if (b1.isPressed()) {
                    b1.setBackgroundColor(getResources().getColor(R.color.colorButtonPressed));
                    tempCode[0] = Integer.toString(1);
                    b1.setClickable(false);
                    break;
                } else if (!b1.isPressed()) {
                    b1.setBackgroundColor(getResources().getColor(R.color.colorButtonFocused));
                    tempCode[0] = Integer.toString(0);
                    break;
                }
                break;
            case R.id.button2:
                b2.setEnabled(true);
                if (b2.isPressed()) {
                    b2.setBackgroundColor(getResources().getColor(R.color.colorButtonPressed));
                    tempCode[1] = Integer.toString(1);
                    b2.setClickable(false);
                    break;
                } else if (!b2.isPressed()) {
                    b2.setBackgroundColor(getResources().getColor(R.color.colorButtonFocused));
                    tempCode[1] = Integer.toString(0);
                    break;
                }
                break;
            case R.id.button3:
                b3.setEnabled(true);
                if (b3.isPressed()) {
                    b3.setBackgroundColor(getResources().getColor(R.color.colorButtonPressed));
                    tempCode[2] = Integer.toString(1);
                    b3.setClickable(false);
                    break;
                } else if (!b3.isPressed()) {
                    b3.setBackgroundColor(getResources().getColor(R.color.colorButtonFocused));
                    tempCode[2] = Integer.toString(0);
                    break;
                }
                break;
            case R.id.button4:
                b4.setEnabled(true);
                if (b4.isPressed()) {
                    b4.setBackgroundColor(getResources().getColor(R.color.colorButtonPressed));
                    tempCode[3] = Integer.toString(1);
                    b4.setClickable(false);
                    break;
                } else if (!b4.isPressed()) {
                    b4.setBackgroundColor(getResources().getColor(R.color.colorButtonFocused));
                    tempCode[3] = Integer.toString(0);
                    break;
                }
                break;
            case R.id.button5:
                b5.setEnabled(true);
                if (b5.isPressed()) {
                    b5.setBackgroundColor(getResources().getColor(R.color.colorButtonPressed));
                    tempCode[4] = Integer.toString(1);
                    b5.setClickable(false);
                    break;
                } else if (!b5.isPressed()) {
                    b5.setBackgroundColor(getResources().getColor(R.color.colorButtonFocused));
                    tempCode[4] = Integer.toString(0);
                    break;
                }
                break;
            case R.id.button6:
                b6.setEnabled(true);
                if (b6.isPressed()) {
                    b6.setBackgroundColor(getResources().getColor(R.color.colorButtonPressed));
                    tempCode[5] = Integer.toString(1);
                    b6.setClickable(false);
                    break;
                } else if (!b6.isPressed()) {
                    b6.setBackgroundColor(getResources().getColor(R.color.colorButtonFocused));
                    tempCode[5] = Integer.toString(0);
                    break;
                }
                break;
            case R.id.button7:
                startActivity(new Intent(LearningActivity.this, MainActivity.class));
                break;
        }

        tempCode2 = tempCode[0] + tempCode[1] + tempCode[2] + tempCode[3] + tempCode[4] + tempCode[5];
        Log.v("tempCode2: ", tempCode2);

        if (textView.isPressed())
            compare(tempCode2);
    }

    private void defaultButton() {
            for (int i = 0; i < tempCode.length; i++) {
                tempCode[i] = "0";
            }
            b1.setPressed(false);
            b1.clearFocus();
            b1.setBackgroundColor(getResources().getColor(R.color.colorButtonFocused));
            b1.setClickable(true);

            b2.setPressed(false);
            b2.clearFocus();
            b2.setBackgroundColor(getResources().getColor(R.color.colorButtonFocused));
            b2.setClickable(true);

            b3.setPressed(false);
            b3.clearFocus();
            b3.setBackgroundColor(getResources().getColor(R.color.colorButtonFocused));
            b3.setClickable(true);

            b4.setPressed(false);
            b4.clearFocus();
            b4.setBackgroundColor(getResources().getColor(R.color.colorButtonFocused));
            b4.setClickable(true);

            b5.setPressed(false);
            b5.clearFocus();
            b5.setBackgroundColor(getResources().getColor(R.color.colorButtonFocused));
            b5.setClickable(true);

            b6.setPressed(false);
            b6.clearFocus();
            b6.setBackgroundColor(getResources().getColor(R.color.colorButtonFocused));
            b6.setClickable(true);

    }

    void compare(String tempCode) {
        for (int i = 0; i < BrailleAndAlphabet.length; i++) {
            for (int j = 0; j < BrailleAndAlphabet[i].length; j++) {
                Log.v("compare i:", String.valueOf(i));
                Log.v("compare j:", String.valueOf(j));

                if (BrailleAndAlphabet[i][j].equals(tempCode)) {
                    displaySymbol(j);
                    play(j);
                    break;
                }
            }
            defaultButton();
        }
    }

}