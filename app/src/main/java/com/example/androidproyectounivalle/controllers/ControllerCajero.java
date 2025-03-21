package com.example.androidproyectounivalle.controllers;

import com.example.androidproyectounivalle.models.CuentaBancaria;

import java.util.ArrayList;
import java.util.Scanner;

public class ControllerCajero {
    public ArrayList<CuentaBancaria> cuentaBancarias = new ArrayList<>();

    public ControllerCajero() {
        crearCuentas();
    }

    public void crearCuentas() {
        cuentaBancarias.add(new CuentaBancaria("Didier Flores", 5000.0,"1201"));
        cuentaBancarias.add(new CuentaBancaria("Abigail Barrientos", 10000.0,"1202"));
        cuentaBancarias.add(new CuentaBancaria("Andrez Fernandez", 100.0,"1203"));
    }

    public void realizarDeposito(String monto) {
        CuentaBancaria bancaria = buscarCuenta(monto);
        if (bancaria != null){
            System.out.print("Ingrese monto: ");
            bancaria.depositar(Double.parseDouble(monto));
        } else {
            System.out.println("Error al depositar");
        }
    }

    public CuentaBancaria buscarCuenta(String nroCuenta){
        System.out.print("Ingrese el nro de cuenta: ");
        for (CuentaBancaria bancaria: cuentaBancarias) {
            if (bancaria.getNroCuenta().equals(nroCuenta)){
                return bancaria;
            }
        }
        System.out.println("Cuenta no encontrada!!!!!");
        return null;
    }

    public void verSaldo(String nroCuenta) {
        CuentaBancaria bancaria = buscarCuenta(nroCuenta);
        bancaria.mostrarSaldo();
    }
}
