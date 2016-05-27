/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Rui
 */
public class InfoProduto {
   private int UnidadesVendidas;
   private double TotalPago;
   private int compradoMes[];

   // private Set<Cliente> clientesComp;
   
    public InfoProduto(){
    
    this.UnidadesVendidas = 0;
    this.TotalPago = 0.0;
            this.compradoMes = new int[12];

  //  this.clientesComp=new HashSet<>();
    }
   
    public InfoProduto(int UnidadesVendidas, double TotalPago) {
        this.UnidadesVendidas = UnidadesVendidas;
        this.TotalPago = TotalPago;
   //     this.clientesComp=clientesCompradores;
    }

    public int getUnidadesVendidas() {
        return UnidadesVendidas;
    }

    public double getTotalPago() {
        return TotalPago;
    }

    void adicionaInfoProduto(double preco, int quant,int mes) {
        UnidadesVendidas++;
        TotalPago+=preco*quant;
        compradoMes[mes-1]++;
     //   clientesComp.add(cli.clone());
    }
   
    
   
   
}
