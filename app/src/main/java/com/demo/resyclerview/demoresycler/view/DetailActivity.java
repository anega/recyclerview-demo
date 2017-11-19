package com.demo.resyclerview.demoresycler.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.demo.resyclerview.demoresycler.R;

public class DetailActivity extends AppCompatActivity {
    private static final String EXTRA_DATE_AND_TIME = "EXTRA_DATE_AND_TIME";
    private static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    private static final String EXTRA_COLOR = "EXTRA_COLOR";

    private TextView dateAndTime;
    private TextView message;
    private View coloredBackground;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String dateAndTimeExtra = intent.getStringExtra(EXTRA_DATE_AND_TIME);
        String messageExtra = intent.getStringExtra(EXTRA_MESSAGE);
        int colorResourceExtra = intent.getIntExtra(EXTRA_COLOR, 0);

        dateAndTime = findViewById(R.id.tv_date_time_header);
        dateAndTime.setText(dateAndTimeExtra);

        message = findViewById(R.id.tv_message_body);
        message.setText(messageExtra);

        coloredBackground = findViewById(R.id.container_colored_background);
        coloredBackground.setBackgroundColor(ContextCompat.getColor(this, colorResourceExtra));
    }
}
