package com.example.myapplication3;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupButton(R.id.btnC, R.raw.note_c);
        setupButton(R.id.btnD, R.raw.note_d);
        setupButton(R.id.btnE, R.raw.note_e);
        setupButton(R.id.btnF, R.raw.note_f);
        setupButton(R.id.btnG, R.raw.note_g);
        setupButton(R.id.btnA, R.raw.note_a);
        setupButton(R.id.btnB, R.raw.note_b);

        setupButton(R.id.btnCSharp, R.raw.note_c_sharp);
        setupButton(R.id.btnDSharp, R.raw.note_d_sharp);
        setupButton(R.id.btnFSharp, R.raw.note_f_sharp);
        setupButton(R.id.btnGSharp, R.raw.note_g_sharp);
        setupButton(R.id.btnASharp, R.raw.note_a_sharp);


    }

    private void setupButton(int buttonId, int soundResourceId) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(view -> playSound(soundResourceId));
    }

    private void playSound(int soundResourceId) {

        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }

        mediaPlayer = MediaPlayer.create(this, soundResourceId);
        mediaPlayer.start();

        mediaPlayer.setOnCompletionListener(mp -> {
            mp.release();
            mediaPlayer = null;
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
