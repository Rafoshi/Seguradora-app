package com.example.seguradora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        Bundle extras = getIntent().getExtras();
        String nome = null;
        String rg = null;
        TextView resultado = findViewById(R.id.textView2);
        if(extras != null) {
            nome = extras.getString(MainActivity.EXTRA_MESSAGE_NAME);
            rg = extras.getString(MainActivity.EXTRA_MESSAGE_RG);
            String valor = extras.getString(MainActivity.EXTRA_MESSAGE_VALOR);

            String txt = String.format("Olá %s de Rg Nº %s seu plano custa R$ %s ", nome,rg,valor);

            resultado.setText(txt);

        }
    }
}