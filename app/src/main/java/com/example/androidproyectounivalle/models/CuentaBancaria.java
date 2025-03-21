package com.example.androidproyectounivalle.models;

public class CuentaBancaria {
//    titular`, `saldo`, `nroCuenta`
    private String titular = "";
    private Double saldo = 0.0;
    private String nroCuenta = "";

    public CuentaBancaria(String titular, Double saldo, String nroCuenta) {
        this.titular = titular;
        this.saldo = saldo;
        this.nroCuenta = nroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(String nroCuenta) {
        this.nroCuenta = nroCuenta;
    }
//    `depositar(double monto)`, `retirar(double monto)`, `mostrarSaldo()`**.
    public void depositar(double monto){
        saldo = saldo + monto;
    }

    public void retirar(double monto){ //saldo = 1000 y monto = 100
        if (saldo > monto) {
            saldo = saldo - monto;
        } else {
            System.out.println("Saldo insuficiente");
        }
    }
    public String mostrarSaldo(){
        System.out.println("Tu saldo es: " +saldo);
        return titular + " Tu saldo es: " + saldo;
    }
}

