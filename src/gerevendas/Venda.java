/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Asus
 */
public class Venda implements Serializable {
   String produto, cliente, PouN;
   int filial, quantidade, mes;
   double preco;
   
   public Venda(Venda v){
      produto = v.getProduto();
      cliente = v.getCliente();
      filial = v.getFilial();
      quantidade = v.getQuantidade();
      preco = v.getPreco();
      mes = v.getMes();
      PouN = v.getPouN();
   }
   
   public Venda(String p, double pre,int q, String PN, String c, int m, int f ){
       produto = p;
       cliente = c;
       filial = f;
       quantidade = q;
       mes = m;
       preco = pre;
       PouN = PN;
   }

    public String getProduto() {
        return produto;
    }

    public String getCliente() {
        return cliente;
    }

    public int getFilial() {
        return filial;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public String getPouN() {
        return PouN;
    }

    public int getMes() {
        return mes;
    }
    
    @Override
    public String toString() {
        return "Venda{" + "produto=" + produto + ", cliente=" + cliente + ", filial=" + filial + ", quantidade=" + quantidade + ", preco=" + preco + ", PouN=" + PouN + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Venda other = (Venda) obj;
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (this.filial != other.filial) {
            return false;
        }
        if (this.quantidade != other.quantidade) {
            return false;
        }
        if (Double.doubleToLongBits(this.preco) != Double.doubleToLongBits(other.preco)) {
            return false;
        }
        if (this.PouN != other.PouN) {
            return false;
        }
        return true;
    }
   
   @Override
    public Venda clone() throws CloneNotSupportedException{
        return new Venda(this);
    }
   
}
