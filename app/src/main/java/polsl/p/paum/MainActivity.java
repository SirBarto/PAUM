package polsl.p.paum;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.buttonLearning).setOnClickListener(this);
        findViewById(R.id.buttonTestM).setOnClickListener(this);

        play();
    }

    public void play() {
        if (player == null) {
            player = MediaPlayer.create(this, R.raw.menuglowne);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }

        player.start();
    }

    public void pause(View v) {
        if (player != null) {
            player.pause();
        }
    }

    public void stop(View v) {
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
            case R.id.buttonLearning:
                startActivity(new Intent(this, SecondActivity.class));
                finish();
                break;
            case R.id.buttonTestM:
                startActivity(new Intent(this, TestActivity.class));
                finish();
                break;
        }
    }

}
