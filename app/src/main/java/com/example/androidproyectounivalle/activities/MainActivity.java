package com.example.androidproyectounivalle.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.androidproyectounivalle.R;
import com.example.androidproyectounivalle.controllers.ControllerCajero;
import com.example.androidproyectounivalle.models.CuentaBancaria;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public TextInputEditText etMonto;
    public TextView tvResultado;
    public Spinner spinnerCuentas;
    public ArrayAdapter spinnerAdapter;
    public ArrayList<String> cuentaNombres = new ArrayList<>();
    public ControllerCajero controllerCajero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        controllerCajero = new ControllerCajero();
        init();
    }

    public void init(){
        spinnerCuentas = findViewById(R.id.spinnerCuentas);
        etMonto = findViewById(R.id.etMonto);
        tvResultado = findViewById(R.id.tvResultado);
        Button btnDepositar = findViewById(R.id.btnDepositar);
        Button btnRetirar = findViewById(R.id.btnRetirar);
        Button btnVerSaldo = findViewById(R.id.btnVerSaldo);
        Button btnAgregarCuenta = findViewById(R.id.btnAgregarCuenta);

        for (CuentaBancaria cuentas: controllerCajero.cuentaBancarias) {
            cuentaNombres.add(cuentas.getTitular() + " - "+ cuentas.getNroCuenta());
        }

        spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cuentaNombres);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCuentas.setAdapter(spinnerAdapter);
        btnDepositar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String monto = etMonto.getText().toString();
                CuentaBancaria cuentaSelecionada = getCuentaSelecionada();
                cuentaSelecionada.depositar(Double.parseDouble(monto));
                Toast.makeText(MainActivity.this,"Saldo agredo",Toast.LENGTH_LONG).show();
            }
        });

        btnRetirar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnVerSaldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CuentaBancaria cuentaSelecionada = getCuentaSelecionada();
                tvResultado.setText(cuentaSelecionada.mostrarSaldo());
            }
        });
        btnAgregarCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private CuentaBancaria getCuentaSelecionada() {
        int pos = spinnerCuentas.getSelectedItemPosition();
        return controllerCajero.cuentaBancarias.get(pos);
    }
}