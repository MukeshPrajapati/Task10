package mukesh.com.task10_mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    private Button btn_playStop;
    private MediaPlayer mediaPlayer;
    private boolean flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Play Music");

        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.airtel_67qddo5j);
        btn_playStop = (Button)findViewById(R.id.btn_play_stop);


        btn_playStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying() && flag==true){
                    stopSong();
                }
                else if (flag == false){
                    playSong();
                }
            }
        });
    }

    public void playSong() {
        mediaPlayer.start();
        btn_playStop.setText("Stop");
        flag = true;
        /*try {
            mediaPlayer.prepare();
        } catch (IOException e) {
        }
        mediaPlayer.start();
        btn_playStop.setText("Stop");
        flag = true;*/
    }

    public void stopSong() {
        mediaPlayer.stop();
        btn_playStop.setText("Play");
        flag = false;
        try {
            mediaPlayer.prepare();
            btn_playStop.setText("Play");
        } catch (IOException e) {
            e.printStackTrace();
        }
       /* mediaPlayer.stop();
        btn_playStop.setText("Play");
        flag = false;*/
    }
}