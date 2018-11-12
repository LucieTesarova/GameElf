package com.example.lucie.mygame1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class SoundDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Chces mit zapnutou hudbu?")
                .setPositiveButton("ANO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        BackgroundSound.turnOnMusic();
                    }
                })
                .setNegativeButton("NE", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                       BackgroundSound.turnOffMusic();
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
