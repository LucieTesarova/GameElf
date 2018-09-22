package com.example.lucie.mygame1;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class GameResponse extends Activity {

    private RadioButton ano;
    private RadioButton ne;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameresponse);

        ano = findViewById(R.id.radiobuttonano);
        ne = findViewById(R.id.radiobuttonne);

    }

    public void onRadioButtonClicked(View v) {
        boolean checked = ((RadioButton) v).isChecked();

        switch (v.getId()) {
            case R.id.radiobuttonano:
                if (checked) {
                    Toast.makeText(this, "ano", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.radiobuttonne:
                if (checked) {
                    Toast.makeText(this, "ne", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
