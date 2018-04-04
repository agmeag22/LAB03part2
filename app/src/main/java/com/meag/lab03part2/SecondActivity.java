package com.meag.lab03part2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent callingIntent = getIntent();
        String intentAction = callingIntent.getAction();
        String intentType = callingIntent.getType();
        if (Intent.ACTION_SEND.equals(intentAction) && intentType != null) {
            if (intentType.equals("text/plain")) {
                handleReceivedText(callingIntent);
            }

        }
    }
    public void regresar(View v){
        Intent abrir=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(abrir);
    }
    public void handleReceivedText(Intent intent){
        TextView texto=findViewById(R.id.textfieldback);
        String intentText=intent.getStringExtra(Intent.EXTRA_TEXT);
        if(intentText!=null){
            texto.setText(intentText);
        }
    }


}
