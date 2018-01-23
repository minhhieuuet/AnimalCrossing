package com.uet.minhhieu.animalcrossing;

import android.app.Dialog;
import android.media.Image;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView score;
    RadioButton check1,check2,check3;
    ImageButton play,replay,hint;
    int diem=100;
    SeekBar bar1,bar2,bar3;
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xuly();
        check1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    Toast.makeText(MainActivity.this, "Bạn đã chọn Mario!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        check2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    Toast.makeText(MainActivity.this, "Bạn đã chọn Pikachu!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        check3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    Toast.makeText(MainActivity.this, "Bạn đã chọn Pokemon!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        score.setText(diem+"");
        bar1.setEnabled(false);
        bar2.setEnabled(false);
        bar3.setEnabled(false);
        final CountDownTimer countDownTimer=new CountDownTimer(10000,10) {
            @Override
            public void onTick(long l) {
                int num=4;
                Random rand=new Random();
                int a1=rand.nextInt(num);
                int a2=rand.nextInt(num);
                int a3=rand.nextInt(num);
                //Who win

                if(bar1.getProgress()>=bar1.getMax())
                {
                    enableCheck();
                    this.cancel();
                    play.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Mario win!", Toast.LENGTH_SHORT).show();
                    if(check1.isChecked())
                    {
                        diem+=5;
                        Toast.makeText(MainActivity.this, "Chúc mừng bạn được cộng 5 điểm!", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        diem-=10;
                        Toast.makeText(MainActivity.this, "Rất tiếc bạn bị trừ 10 điểm!", Toast.LENGTH_SHORT).show();
                    }
                    score.setText(diem+"");
                }
                if(bar2.getProgress()>=bar2.getMax())
                {
                    enableCheck();
                    this.cancel();
                    play.setVisibility(View.VISIBLE);
                    if(check2.isChecked())
                    {
                        diem+=5;
                        Toast.makeText(MainActivity.this, "Chúc mừng bạn được cộng 5 điểm!", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        diem-=10;
                        Toast.makeText(MainActivity.this, "Rất tiếc bạn bị trừ 10 điểm!", Toast.LENGTH_SHORT).show();
                    }
                    score.setText(diem+"");
                    Toast.makeText(MainActivity.this, "Pikachu win!", Toast.LENGTH_SHORT).show();
                }
                if(bar3.getProgress()>=bar3.getMax())
                {
                    enableCheck();
                    this.cancel();
                    play.setVisibility(View.VISIBLE);
                    if(check3.isChecked())
                    {
                        diem+=5;
                        Toast.makeText(MainActivity.this, "Chúc mừng bạn được cộng 5 điểm!", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        diem-=10;
                        Toast.makeText(MainActivity.this, "Rất tiếc bạn bị trừ 10 điểm!", Toast.LENGTH_SHORT).show();
                    }
                    score.setText(diem+"");
                    Toast.makeText(MainActivity.this, "Pokemon win!", Toast.LENGTH_SHORT).show();
                }

                if(diem<=0)
                {

                    Toast.makeText(MainActivity.this, "Bạn đã thua cuộc!", Toast.LENGTH_SHORT).show();
                    diem=0;
                    score.setText(0+"");
                    play.setEnabled(false);
                    check1.setEnabled(false);
                    check2.setEnabled(false);
                    check3.setEnabled(false);
                }
                bar1.setProgress(bar1.getProgress()+a1);
                bar2.setProgress(bar2.getProgress()+a2);
                bar3.setProgress(bar3.getProgress()+a3);

            }

            @Override
            public void onFinish() {
                play.setVisibility(View.VISIBLE);
            }
        };

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check1.isChecked()||check2.isChecked()||check3.isChecked())
                {
                    play.setVisibility(View.INVISIBLE);
                    bar1.setProgress(0);
                    bar2.setProgress(0);
                    bar3.setProgress(0);
                    countDownTimer.start();
                    disableCheck();

                }
                else
                {
                    Toast.makeText(MainActivity.this, "Bạn cần chọn nhân vật!", Toast.LENGTH_SHORT).show();

                }


            }
        });

        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diem=100;
                score.setText(diem+"");
                bar1.setProgress(0);
                bar2.setProgress(0);
                bar3.setProgress(0);
                play.setEnabled(true);
            }
        });

        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    dialog=new Dialog(MainActivity.this);
                    dialog.setTitle("Hướng dẫn");
                    dialog.setContentView(R.layout.dialog);
                    dialog.show();
            }
        });
    }

    private void xuly()
    {
        score=(TextView) findViewById(R.id.textView);

        check1=(RadioButton) findViewById(R.id.radioButton1);
        check2=(RadioButton) findViewById(R.id.radioButton2);
        check3=(RadioButton)findViewById(R.id.radioButton3);

        bar1=(SeekBar) findViewById(R.id.seekBar1);
        bar2=(SeekBar) findViewById(R.id.seekBar2);
        bar3=(SeekBar) findViewById(R.id.seekBar3);

        play=(ImageButton) findViewById(R.id.imageButton);
        replay=(ImageButton)findViewById(R.id.imageButton2);
        hint=(ImageButton)findViewById(R.id.imageButton3);
    }
    private void enableCheck()
    {
        check1.setEnabled(true);
        check2.setEnabled(true);
        check3.setEnabled(true);
    }

    private void disableCheck()
    {
        check1.setEnabled(false);
        check2.setEnabled(false);
        check3.setEnabled(false);
    }

}
