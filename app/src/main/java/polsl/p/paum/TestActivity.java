package polsl.p.paum;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    MediaPlayer player;

    int[] songsList = {R.raw.a, R.raw.b, R.raw.c, R.raw.d, R.raw.e, R.raw.f, R.raw.g, R.raw.h, R.raw.i,
            R.raw.j, R.raw.k, R.raw.l, R.raw.m, R.raw.n, R.raw.o, R.raw.p, R.raw.q, R.raw.r, R.raw.s,
            R.raw.t, R.raw.u, R.raw.v, R.raw.w, R.raw.x, R.raw.y, R.raw.z};

    int[] komunikat = {R.raw.chosen, R.raw.negative, R.raw.positive};

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

    @SuppressWarnings("FieldCanBeLocal")
    private Button b11, b22, b33, b44, b55, b66, b77, b88;
    int rand = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        b11 = findViewById(R.id.button11);
        b22 = findViewById(R.id.button22);
        b33 = findViewById(R.id.button33);

        b44 = findViewById(R.id.button44);
        b55 = findViewById(R.id.button55);
        b66 = findViewById(R.id.button66);

        b77 = findViewById(R.id.button77);
        b88 = findViewById(R.id.button88);
        textView = findViewById(R.id.textView33);

        b11.setOnClickListener(this);
        b22.setOnClickListener(this);
        b33.setOnClickListener(this);

        b44.setOnClickListener(this);
        b55.setOnClickListener(this);
        b66.setOnClickListener(this);

        b77.setOnClickListener(this);
        b88.setOnClickListener(this);

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
            player = MediaPlayer.create(this, songsList[indexSong]);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }

        player.start();
    }

    public void play2(int indexSong) {
        if (player == null) {
            player = MediaPlayer.create(this, komunikat[indexSong]);
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
            case R.id.button11:
                b11.setEnabled(true);
                if (b11.isPressed()) {
                    b11.setBackgroundColor(getResources().getColor(R.color.colorButtonPressed));
                    tempCode[0] = Integer.toString(1);
                    b11.setClickable(false);
                    break;
                } else if (!b11.isPressed()) {
                    b11.setBackgroundColor(getResources().getColor(R.color.colorButtonFocused));
                    tempCode[0] = Integer.toString(0);
                    break;
                }
                break;
            case R.id.button22:
                b22.setEnabled(true);
                if (b22.isPressed()) {
                    b22.setBackgroundColor(getResources().getColor(R.color.colorButtonPressed));
                    tempCode[1] = Integer.toString(1);
                    b22.setClickable(false);
                    break;
                } else if (!b22.isPressed()) {
                    b22.setBackgroundColor(getResources().getColor(R.color.colorButtonFocused));
                    tempCode[1] = Integer.toString(0);
                    break;
                }
                break;
            case R.id.button33:
                b33.setEnabled(true);
                if (b33.isPressed()) {
                    b33.setBackgroundColor(getResources().getColor(R.color.colorButtonPressed));
                    tempCode[2] = Integer.toString(1);
                    b33.setClickable(false);
                    break;
                } else if (!b33.isPressed()) {
                    b33.setBackgroundColor(getResources().getColor(R.color.colorButtonFocused));
                    tempCode[2] = Integer.toString(0);
                    break;
                }
                break;
            case R.id.button44:
                b44.setEnabled(true);
                if (b44.isPressed()) {
                    b44.setBackgroundColor(getResources().getColor(R.color.colorButtonPressed));
                    tempCode[3] = Integer.toString(1);
                    b44.setClickable(false);
                    break;
                } else if (!b44.isPressed()) {
                    b44.setBackgroundColor(getResources().getColor(R.color.colorButtonFocused));
                    tempCode[3] = Integer.toString(0);
                    break;
                }
                break;
            case R.id.button55:
                b55.setEnabled(true);
                if (b55.isPressed()) {
                    b55.setBackgroundColor(getResources().getColor(R.color.colorButtonPressed));
                    tempCode[4] = Integer.toString(1);
                    b55.setClickable(false);
                    break;
                } else if (!b55.isPressed()) {
                    b55.setBackgroundColor(getResources().getColor(R.color.colorButtonFocused));
                    tempCode[4] = Integer.toString(0);
                    break;
                }
                break;
            case R.id.button66:
                b66.setEnabled(true);
                if (b66.isPressed()) {
                    b66.setBackgroundColor(getResources().getColor(R.color.colorButtonPressed));
                    tempCode[5] = Integer.toString(1);
                    b66.setClickable(false);
                    break;
                } else if (!b66.isPressed()) {
                    b66.setBackgroundColor(getResources().getColor(R.color.colorButtonFocused));
                    tempCode[5] = Integer.toString(0);
                    break;
                }
                break;
            case R.id.button77:
                startActivity(new Intent(TestActivity.this, MainActivity.class));
                break;
            case R.id.button88:
                rand = learningModeStart();
                break;
        }

        tempCode2 = tempCode[0] + tempCode[1] + tempCode[2] + tempCode[3] + tempCode[4] + tempCode[5];
        Log.v("tempCode2: ", tempCode2);

        if (textView.isPressed())
            compare(tempCode2, rand);
    }

    private int learningModeStart() {
        Random rand = new Random();
        int maxrand = alphabet.length;
        int randNumber = rand.nextInt(maxrand);
        play(randNumber);
        displaySymbol(randNumber);
        return randNumber;
    }

    private void defaultButton() {
            for (int i = 0; i < tempCode.length; i++) {
                tempCode[i] = "0";
            }
            
            b11.setPressed(false);
            b11.clearFocus();
            b11.setBackgroundColor(getResources().getColor(R.color.colorButtonFocused));
            b11.setClickable(true);

            b22.setPressed(false);
            b22.clearFocus();
            b22.setBackgroundColor(getResources().getColor(R.color.colorButtonFocused));
            b22.setClickable(true);

            b33.setPressed(false);
            b33.clearFocus();
            b33.setBackgroundColor(getResources().getColor(R.color.colorButtonFocused));
            b33.setClickable(true);

            b44.setPressed(false);
            b44.clearFocus();
            b44.setBackgroundColor(getResources().getColor(R.color.colorButtonFocused));
            b44.setClickable(true);

            b55.setPressed(false);
            b55.clearFocus();
            b55.setBackgroundColor(getResources().getColor(R.color.colorButtonFocused));
            b55.setClickable(true);

            b66.setPressed(false);
            b66.clearFocus();
            b66.setBackgroundColor(getResources().getColor(R.color.colorButtonFocused));
            b66.setClickable(true);

            textView.setBackgroundColor(getResources().getColor(R.color.colorButtonFocused));

    }

    void compare(String tempCode, int randNumberCompare) {
        for (int i = 0; i < BrailleAndAlphabet.length; i++) {
            for (int j = 0; j < BrailleAndAlphabet[i].length; j++) {
                Log.v("compare i:", String.valueOf(i));
                Log.v("compare j:", String.valueOf(j));

                if (BrailleAndAlphabet[i][j].equals(tempCode)) {
                    if (j == randNumberCompare) {
                        play2(2);
                        textView.setBackgroundColor(getResources().getColor(R.color.colorGood));
                    }
                } else {
                    play2(1);
                    textView.setBackgroundColor(getResources().getColor(R.color.colorBad));
                }
            }
            defaultButton();
        }
    }

}
