package com.tokio.module.core;

import com.tokio.module.utils.UtilidadIva;

public class Facutra {
	private int numero;
    private String concepto;
    private double importe;
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getConcepto() {
        return concepto;
    }
    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
    public double getImporte() {
        return importe;
    }
    public void setImporte(double importe) {
        this.importe = importe;
    }
    public double getImporteIVA() {
         
        return UtilidadIva.calcularIVA(this.importe);
    }
}
