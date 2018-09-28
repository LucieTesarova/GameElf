package com.example.lucie.mygame1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayResponse extends Activity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_response);
        textView = findViewById(R.id.response);

        Intent intent = getIntent();
        String response = intent.getStringExtra("odkaz");
        textView.setText(response);
    }
}
