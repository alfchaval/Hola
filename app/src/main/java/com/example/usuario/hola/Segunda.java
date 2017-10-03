package com.example.usuario.hola;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Segunda extends AppCompatActivity {

    private TextView txvSaludo;

    private static final String DATO = "DATO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        txvSaludo = (TextView)findViewById(R.id.txvSaludo);
        Intent intent = this.getIntent();
        txvSaludo.setText("Hola " + intent.getStringExtra(DATO));
    }

}
