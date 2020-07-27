package com.example.intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Arts_Activity extends AppCompatActivity {

    private TextView tv_title, tv_description, tv_category;
    private ImageView iv_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arts_);

        tv_title = (TextView) findViewById(R.id.tvtitle);
        tv_description = (TextView) findViewById(R.id.tvDescription);
        tv_category = (TextView) findViewById(R.id.tvCategory);
        iv_image = (ImageView) findViewById(R.id.iv_arts);

        Intent intent = getIntent();
        String title = intent.getExtras().getString("Title");
        String description = intent.getExtras().getString("Description");
        String category = intent.getExtras().getString("Category");
        int thumbnail = intent.getExtras().getInt("Thumbnail");

        tv_title.setText(title);
        tv_description.setText(description);
        tv_category.setText(category);
        iv_image.setImageResource(thumbnail);
    }
}