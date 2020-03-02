package polsl.p.paum;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

public abstract class Logic extends AppCompatActivity implements View.OnClickListener {

    MediaPlayer player; //TODO other class

    Button startTest, menubutton;
    Button[] buttons;
    TextView CompareDisplaytextView;

    int[] communicate = {R.raw.chosen, R.raw.negative, R.raw.positive, R.raw.menuglowne};

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

    void createGui() {
        buttons = new Button[6];

        for (int i = 0; i < buttons.length; i++) {
            String buttonID = "button" + (i + 1);

            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            buttons[i] = ((Button) findViewById(resID));
            buttons[i].setOnClickListener(this);
        }

        menubutton = findViewById(R.id.menubutton);
        menubutton.setOnClickListener(this);

        CompareDisplaytextView = findViewById(R.id.textView3);
        CompareDisplaytextView.setOnClickListener(this);

        Arrays.fill(tempCode, "0");
    }

    void defaultButton() {
        Arrays.fill(tempCode, "0");

        for (Button button : buttons) {
            button.setPressed(false);
            button.clearFocus();
            button.setBackgroundColor(getResources().getColor(R.color.colorButtonFocused));
            button.setClickable(true);
        }
    }

    public void pause(View v) {
        if (player != null) {
            player.pause();
        }
    }

    public void stop(View v) {
        stopPlayer();
    }

    public void playCommunicate(int indexCommunicate) {
        if (player == null) {
            player = MediaPlayer.create(this, communicate[indexCommunicate]);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }
        player.start();
    }

    public void playSampleOfCharsList(int indexSong) {
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

    public void stopPlayer() {
        if (player != null) {
            player.release();
            player = null;
            //Toast.makeText(this, "MediaPlayer released", Toast.LENGTH_SHORT).show();
        }
    }

}
