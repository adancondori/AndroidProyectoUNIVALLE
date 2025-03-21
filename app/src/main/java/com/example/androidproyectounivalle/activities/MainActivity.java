package com.example.androidproyectounivalle.activities;


import android.app.AlertDialog;
import android.os.Bundle;

import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import com.example.androidproyectounivalle.R;
import com.example.androidproyectounivalle.controllers.ControllerCajero;
import com.example.androidproyectounivalle.models.CuentaBancaria;

public class MainActivity extends AppCompatActivity {
    private Spinner spinnerCuentas;
    private EditText etMonto;
    private TextView tvResultado;
    private ControllerCajero controllerCajero;
    private ArrayList<CuentaBancaria> cuentasList = new ArrayList<>();
    private ArrayAdapter<String> spinnerAdapter;
    private ArrayList<String> cuentaNombres = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerCuentas = findViewById(R.id.spinnerCuentas);
        etMonto = findViewById(R.id.etMonto);
        tvResultado = findViewById(R.id.tvResultado);
        Button btnDepositar = findViewById(R.id.btnDepositar);
        Button btnVerSaldo = findViewById(R.id.btnVerSaldo);
        Button btnRetirar = findViewById(R.id.btnRetirar);

        controllerCajero = new ControllerCajero();
        cuentasList = controllerCajero.cuentaBancarias;

        for (CuentaBancaria cuenta : cuentasList) {
            cuentaNombres.add(cuenta.getTitular() + " - " + cuenta.getNroCuenta());
        }

        spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cuentaNombres);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCuentas.setAdapter(spinnerAdapter);

        btnDepositar.setOnClickListener(v -> {
            CuentaBancaria cuenta = getCuentaSeleccionada();
            String montoStr = etMonto.getText().toString();
            if (cuenta != null && !montoStr.isEmpty()) {
                double monto = Double.parseDouble(montoStr);
                cuenta.depositar(monto);
                tvResultado.setText("Depósito exitoso. Nuevo saldo: " + cuenta.getSaldo());
            } else {
                tvResultado.setText("Error: monto inválido.");
            }
        });

        btnRetirar.setOnClickListener(v -> {
            CuentaBancaria cuenta = getCuentaSeleccionada();
            String montoStr = etMonto.getText().toString();
            if (cuenta != null && !montoStr.isEmpty()) {
                double monto = Double.parseDouble(montoStr);
                if (cuenta.getSaldo() >= monto) {
                    cuenta.retirar(monto);
                    tvResultado.setText("Retiro exitoso. Nuevo saldo: " + cuenta.getSaldo());
                } else {
                    tvResultado.setText("Saldo insuficiente para el retiro.");
                }
            } else {
                tvResultado.setText("Error: monto inválido.");
            }
        });

        btnVerSaldo.setOnClickListener(v -> {
            CuentaBancaria cuenta = getCuentaSeleccionada();
            if (cuenta != null) {
                tvResultado.setText("Saldo actual: " + cuenta.getSaldo());
            }
        });

        Button btnAgregarCuenta = findViewById(R.id.btnAgregarCuenta);
        btnAgregarCuenta.setOnClickListener(v -> mostrarDialogoAgregarCuenta());
    }

    private CuentaBancaria getCuentaSeleccionada() {
        int pos = spinnerCuentas.getSelectedItemPosition();
        return cuentasList.get(pos);
    }

    private void mostrarDialogoAgregarCuenta() {
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_cuenta, null);

        EditText etTitular = dialogView.findViewById(R.id.etTitular);
        EditText etSaldo = dialogView.findViewById(R.id.etSaldo);
        EditText etNroCuenta = dialogView.findViewById(R.id.etNroCuenta);

        new AlertDialog.Builder(this)
            .setTitle("Nueva Cuenta")
            .setView(dialogView)
            .setPositiveButton("Agregar", (dialog, which) -> {
                String titular = etTitular.getText().toString().trim();
                String saldoStr = etSaldo.getText().toString().trim();
                String nroCuenta = etNroCuenta.getText().toString().trim();

                if (titular.isEmpty() || saldoStr.isEmpty() || nroCuenta.isEmpty()) {
                    Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
                    return;
                }

                double saldo = Double.parseDouble(saldoStr);

                CuentaBancaria nuevaCuenta = new CuentaBancaria(titular, saldo, nroCuenta);
                cuentasList.add(nuevaCuenta);
                cuentaNombres.add(titular + " - " + nroCuenta);
                spinnerAdapter.notifyDataSetChanged();

                Toast.makeText(this, "Cuenta agregada exitosamente", Toast.LENGTH_SHORT).show();
            })
            .setNegativeButton("Cancelar", null)
            .create()
            .show();
    }

}