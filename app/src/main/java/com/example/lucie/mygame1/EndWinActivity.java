package com.example.lucie.mygame1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class EndWinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_win);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        Toast.makeText(getApplicationContext(), "Otevrena endWinActivity", Toast.LENGTH_LONG).show();
    }
}
