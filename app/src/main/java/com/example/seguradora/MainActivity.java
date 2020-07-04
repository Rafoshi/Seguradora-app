package com.example.seguradora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public final static String EXTRA_MESSAGE_NAME = "com.example.seguradora.MESSAGE";
    public final static String EXTRA_MESSAGE_RG = "com.example.seguradora.RG";
    public final static String EXTRA_MESSAGE_VALOR = "com.example.seguradora.VALUE";

    private Spinner spinner;
    String spinnerSelected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.plan_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
        String choice = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(getApplicationContext(), choice, Toast.LENGTH_LONG).show();
        spinnerSelected = choice;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void Cadastrar(View v) {
        EditText txtNome = findViewById(R.id.editText);
        String nome = txtNome.getText().toString();
        EditText RG = findViewById(R.id.editNumber);
        String rg = RG.getText().toString();

        String valor = "0";

        if (spinnerSelected.equals("Iron")) {
            valor = "300";
        } else if (spinnerSelected.equals("Gold")) {
            valor = "500";
        } else if (spinnerSelected.equals("Platinum")) {
            valor = "600";
        } else if (spinnerSelected.equals("Diamond")) {
            valor = "700";
        }

        Intent intend = new Intent(this, FinalActivity.class);

        intend.putExtra(EXTRA_MESSAGE_NAME, nome);
        intend.putExtra(EXTRA_MESSAGE_RG, rg);
        intend.putExtra(EXTRA_MESSAGE_VALOR, valor);

        startActivity(intend);
    }
}