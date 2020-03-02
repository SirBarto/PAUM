package polsl.p.paum;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Logic {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.buttonLearning).setOnClickListener(this);
        findViewById(R.id.buttonTestM).setOnClickListener(this);
        
        playCommunicate(3);
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
                stopPlayer();
                startActivity(new Intent(this, LearningActivity.class));
                finish();
                break;
            case R.id.buttonTestM:
                stopPlayer();
                startActivity(new Intent(this, TestActivity.class));
                finish();
                break;
        }
    }
    
}
