package com.example.lucie.mygame1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayResponse extends Activity {

    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_response);
        textView = findViewById(R.id.response);
        button = findViewById(R.id.buttonPotvrdit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GameQuestion.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        String response = intent.getStringExtra("odkaz");
        textView.setText(response);
    }
}
