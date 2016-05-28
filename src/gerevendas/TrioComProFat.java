package gerevendas;

import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rui
 */
public class TrioComProFat {
    
    private int Pdistintos[], Compras[];
    private float faturacao[];

    /**
     * Construtor Vazio
     */
    public TrioComProFat() {
       this.Pdistintos = new int[12];
        this.Compras = new int[12];
        this.faturacao = new float[12];
    }

    
   
    public TrioComProFat(TrioComProFat tcpc) {
         this.Pdistintos = tcpc.getPDistintos();
        this.Compras = tcpc.getCompras();
        this.faturacao = tcpc.getFaturacao();
    }

    public int[] getCompras() {
        return this.Compras.clone();
    }

    public int[] getPDistintos() {
        return this.Pdistintos.clone();
    }

    public float[] getFaturacao() {
        return this.faturacao.clone();
    }
    
    public void adicionaDistintos(int qtd, int mes) {
        this.Pdistintos[mes - 1] = qtd;
    }

    public void adicionaFaturacao(float fat, int mes) {
        this.faturacao[mes - 1] = fat;
    }
    
    public void adicionaCompras(int nCompras, int mes) {
        this.Compras[mes - 1] = nCompras;
    }

    

    
    public TrioComProFat clone() {
        return new TrioComProFat(this);
    }
    
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((!(this.getClass().getSimpleName().equals(o.getClass().getSimpleName()))) || o == null) {
            return false;
        } else {
            TrioComProFat t = (TrioComProFat) o;
            return  this.Pdistintos.equals(t.getPDistintos()) && this.faturacao.equals(t.getFaturacao())  && this.Compras.equals(t.getCompras());
        }

    }

    

   
    public String toString() {
        StringBuilder sb = new StringBuilder();

       
        sb.append("Produtos Distintos \n");
        for (int i = 0; i < 12; i++) {
            sb.append(this.Pdistintos[i]).append(" \n");
        }
        sb.append("\n");
        sb.append("Numero de Compras \n");
        for (int i = 0; i < 12; i++) {
            sb.append(this.Compras[i]).append("\n ");
        }
        sb.append("\n");
        sb.append("Faturação  \n");
        for (int i = 0; i < 12; i++) {
            sb.append(this.faturacao[i]).append("€ \n ");
        }
        return sb.toString();
    }

}
