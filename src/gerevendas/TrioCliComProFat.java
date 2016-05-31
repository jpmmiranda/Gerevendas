package gerevendas;

import java.io.Serializable;
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
public class TrioCliComProFat implements Serializable {
    
    private int Pdistintos[],Compras[];
    private double faturacao[];

    /**
     * Construtor Vazio
     */
    public TrioCliComProFat() {
       this.Pdistintos = new int[12];
        this.Compras = new int[12];
        this.faturacao = new double[12];
    }

    
   
    public TrioCliComProFat(TrioCliComProFat tcpc) {
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
    
    public double[] getFaturacao() {
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

    

    
    public TrioCliComProFat clone() {
        return new TrioCliComProFat(this);
    }
    
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((!(this.getClass().getSimpleName().equals(o.getClass().getSimpleName()))) || o == null) {
            return false;
        } else {
            TrioCliComProFat t = (TrioCliComProFat) o;
            return  this.Pdistintos.equals(t.getPDistintos()) && this.faturacao.equals(t.getFaturacao())  && this.Compras.equals(t.getCompras()) ;   }

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
            sb.append(this.Compras[i]).append("\n");
        }
        sb.append("\n");
        sb.append("Faturação  \n");
        for (int i = 0; i < 12; i++) {
            sb.append(this.faturacao[i]).append("€ \n ");
        }
        return sb.toString();
    }

    

}
