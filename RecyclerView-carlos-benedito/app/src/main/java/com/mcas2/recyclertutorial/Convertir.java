package com.mcas2.recyclertutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Convertir extends AppCompatActivity {

    EditText editTextCantidad;
    RecyclerView recyclerView;
    int selectedPosition;
    Button btnConvertir;
    String selectedCurrency;
    double factorConversion = 1.0;
    Switch switchAumento;
    TextView mostrar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertir);

        selectedCurrency = getIntent().getStringExtra("currency");
        recyclerView = findViewById(R.id.rvEventos);

        selectedPosition = getIntent().getIntExtra("position", -1);
        int imageId = getIntent().getIntExtra("imageId", -1);

        if (selectedPosition != -1) {
            String[] conversionRates = getResources().getStringArray(R.array.event_price);
            factorConversion = Double.parseDouble(conversionRates[selectedPosition]);
        }

        ImageView imageView = findViewById(R.id.yourImageViewId);
        imageView.setImageResource(imageId);
        editTextCantidad = findViewById(R.id.editTextCantidad);
        btnConvertir = findViewById(R.id.btnConvertir);
        switchAumento = findViewById(R.id.vipSwitch);
        mostrar = findViewById(R.id.mostrar);

        btnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertirDivisa();
            }
        });
    }

    private void convertirDivisa() {
        String cantidadEurosStr = editTextCantidad.getText().toString();

        if (cantidadEurosStr.isEmpty()) {
            Toast.makeText(this, "Ingrese una cantidad en euros", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double cantidadEuros = Double.parseDouble(cantidadEurosStr);
            double cantidadConvertida = cantidadEuros * factorConversion;

            if (!switchAumento.isChecked()) {
                mostrar.setText("Conversion: " + (cantidadConvertida + (cantidadConvertida * 0.2)));
            } else {
                mostrar.setText("Conversion VIP: " + cantidadConvertida);
            }

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Ingrese una cantidad válida", Toast.LENGTH_SHORT).show();
        }
    }


    public void salir(View view) {
        Intent nIntent = new Intent(Convertir.this, MainActivity.class);
        startActivity(nIntent);
    }
}
