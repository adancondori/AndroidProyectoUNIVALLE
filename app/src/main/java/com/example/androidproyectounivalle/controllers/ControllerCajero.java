package com.example.androidproyectounivalle.controllers;
import com.example.androidproyectounivalle.models.CuentaBancaria;

import java.util.ArrayList;

public class ControllerCajero {
    public ArrayList<CuentaBancaria> cuentaBancarias;

    public ControllerCajero() {
        cuentaBancarias = new ArrayList<>();
        crearCuentas();
    }

    private void crearCuentas() {
        cuentaBancarias.add(new CuentaBancaria("Didier Flores", 5000.0, "1201"));
        cuentaBancarias.add(new CuentaBancaria("Abigail Barrientos", 10000.0, "1202"));
        cuentaBancarias.add(new CuentaBancaria("Andrez Fernandez", 100.0, "1203"));
    }

    public CuentaBancaria buscarCuentaPorNumero(String nroCuenta) {
        for (CuentaBancaria cuenta : cuentaBancarias) {
            if (cuenta.getNroCuenta().equals(nroCuenta)) {
                return cuenta;
            }
        }
        return null;
    }

    public ArrayList<CuentaBancaria> getCuentas() {
        return cuentaBancarias;
    }

    public boolean depositar(String nroCuenta, double monto) {
        CuentaBancaria cuenta = buscarCuentaPorNumero(nroCuenta);
        if (cuenta != null) {
            cuenta.depositar(monto);
            return true;
        }
        return false;
    }

    public boolean retirar(String nroCuenta, double monto) {
        CuentaBancaria cuenta = buscarCuentaPorNumero(nroCuenta);
        if (cuenta != null && cuenta.getSaldo() >= monto) {
            cuenta.retirar(monto);
            return true;
        }
        return false;
    }

    public Double obtenerSaldo(String nroCuenta) {
        CuentaBancaria cuenta = buscarCuentaPorNumero(nroCuenta);
        return (cuenta != null) ? cuenta.getSaldo() : null;
    }
}