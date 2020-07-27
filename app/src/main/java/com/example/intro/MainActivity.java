package com.example.intro;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.ivSplash);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        final FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.myanimation);
        imageView.startAnimation(animation);

        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    if (firebaseUser != null) {
                        sleep(4000);
                        Intent intent = new Intent(MainActivity.this, Succesfull_Login.class);
                        startActivity(intent);
                        finish();
                    } else {
                        sleep(4000);
                        Intent intent = new Intent(MainActivity.this, Login_Form.class);
                        startActivity(intent);
                        finish();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        myThread.start();


    }


}