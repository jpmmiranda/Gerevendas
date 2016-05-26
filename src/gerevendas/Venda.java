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
   
   private Cliente cliente;
   private Produto produto;
   private String  PouN;
   private int filial, quantidade, mes;
   private double preco;
   
   
   
   /*Construtores*/
   public Venda(){
       
        this.cliente = null;
        this.produto = null;
        this.preco = 0.0;
        this.quantidade = 0;
        this.mes = 0;
        this.PouN = "";
        this.filial=0;
   
   }
   
   
   public Venda(Venda v){
      produto = v.getProduto();
      cliente = v.getCliente();
      filial = v.getFilial();
      quantidade = v.getQuantidade();
      preco = v.getPreco();
      mes = v.getMes();
      PouN = v.getPouN();
   }
   
   public Venda(Produto p, double pre,int q, String PN, Cliente c, int m, int f ){
       produto = p;
       cliente = c;
       filial = f;
       quantidade = q;
       mes = m;
       preco = pre;
       PouN = PN;
   }

    /*Getters*/
    public Produto getProduto() {
        return produto;
    }

    public Cliente getCliente() {
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
    
    /*Metodos*/
    
    @Override
    public String toString() {
        StringBuilder st = new StringBuilder();
        st.append("Venda{");
        st.append("cliente=").append(cliente);
        st.append(", produto=").append(produto);
        st.append(", preço=").append(preco);
        st.append(", quantidade=").append(quantidade);
        st.append(", mes=").append(mes);
        st.append(", tipo=").append(PouN);
        st.append('}');
        return st.toString();    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Venda venda = (Venda) obj;
        return this.cliente.equals(venda.getCliente())
                && this.produto.equals(venda.getProduto())
                && (this.preco == venda.getPreco())
                && (this.quantidade == venda.getQuantidade())
                && (this.mes == venda.getMes())
                && (this.PouN.equals(venda.getPouN())
                && (this.filial == venda.getFilial()));
                
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.cliente);
        hash = 97 * hash + Objects.hashCode(this.produto);
        hash = 97 * hash + Objects.hashCode(this.PouN);
        hash = 97 * hash + this.filial;
        hash = 97 * hash + this.quantidade;
        hash = 97 * hash + this.mes;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.preco) ^ (Double.doubleToLongBits(this.preco) >>> 32));
        return hash;
    }
   
   @Override
    public Venda clone() throws CloneNotSupportedException{
        return new Venda(this);
    }
   
}
