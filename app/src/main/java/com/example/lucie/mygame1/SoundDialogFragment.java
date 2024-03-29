package com.example.lucie.mygame1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/*
 Trida SoundDialogFragment
 Vytvari dialogove okno, umoznuje nastaveni hudby
 */

public class SoundDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.MyDialog);

        builder.setMessage(R.string.hudba)
                .setPositiveButton(R.string.ano, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        BackgroundSound.turnOnMusic();
                    }
                })
                .setNegativeButton(R.string.ne, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                       BackgroundSound.turnOffMusic();
                    }
                });
        return builder.create();
    }
}
