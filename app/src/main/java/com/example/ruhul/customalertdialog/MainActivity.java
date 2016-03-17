package com.example.ruhul.customalertdialog;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button buttonAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         buttonAlert = (Button) findViewById(R.id.buttonClickForAlert);

        //make the dialog visible
        buttonAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setTitle("Pin Checker!!");
                dialog.setContentView(R.layout.custom_alert_dialog);
                dialog.show();

                /*
                * As we are calling an external dialog xml file here,so e should provide a
                * reference of that xml file.
                *
                *
                * */
               Button buttonOk = (Button) dialog.findViewById(R.id.buttonOk);
               final Button buttonCancel = (Button) dialog.findViewById(R.id.buttonCancel);
               final EditText editTextGetPin = (EditText) dialog.findViewById(R.id.editTextPinNumber);


                    //ok button of dialog
                    buttonOk.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            String pin = editTextGetPin.getText().toString();
                            Toast.makeText(getApplicationContext(), "Pin Is :" + pin, Toast.LENGTH_LONG).show();
                            dialog.cancel();
                        }
                    });

                //cancel button of dialog
                buttonCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });

            }
        });
    }
}
