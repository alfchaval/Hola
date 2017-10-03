package com.example.usuario.hola;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtNombre, edtURL;
    private Button btnSaludar, btnNavegar;
    Intent intent;

    private static final String DATO = "DATO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNombre = (EditText)findViewById(R.id.edtNombre);
        edtURL = (EditText)findViewById(R.id.edtURL);
        btnSaludar = (Button)findViewById(R.id.btnSaludar);
        btnSaludar.setOnClickListener(this);
        btnNavegar = (Button)findViewById(R.id.btnNavegar);
        btnNavegar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnSaludar) {
            intent = new Intent (this, Segunda.class);
            intent.putExtra(DATO, edtNombre.getText().toString());
            startActivity(intent);
        }
        if(view == btnNavegar) {
            openWebPage(edtURL.getText().toString());
        }
    }

    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Error en la URL o navegador no instalado", Toast.LENGTH_SHORT).show();
        }
    }
}
