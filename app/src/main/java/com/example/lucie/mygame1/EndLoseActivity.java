package com.example.lucie.mygame1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class EndLoseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_lose);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        Toast.makeText(getApplicationContext(), "Otevrena endLoseActivity", Toast.LENGTH_LONG).show();
    }
}
