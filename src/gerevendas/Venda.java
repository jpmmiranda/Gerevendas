/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.io.Serializable;
import java.util.Objects;

/**
 * Classe Venda
 *
 * @author Rui Machado, Jose Lima, Jose Mirra, Joao Miranda
 */
public class Venda implements Serializable {   
   
   private Cliente cliente;
   private Produto produto;
   private String  PouN;
   private int filial, quantidade, mes;
   private double preco;
   
   
   
   /**
     * Construtor vazio
     */
   public Venda(){
       
        this.cliente = null;
        this.produto = null;
        this.preco = 0.0;
        this.quantidade = 0;
        this.mes = 0;
        this.PouN = "";
        this.filial=0;
   
   }
   
   /**
     * Construtor de cópia de uma instância da classe Venda
     *
     * @param v venda a ser copiado
     */
   public Venda(Venda v){
      produto = v.getProduto();
      cliente = v.getCliente();
      filial = v.getFilial();
      quantidade = v.getQuantidade();
      preco = v.getPreco();
      mes = v.getMes();
      PouN = v.getPouN();
   }
   
   /**
     * Construtor parametrizado 
     * @param p Produto da venda
     * @param pre Preco da venda
     * @param q Quantidade vendida
     * @param PN Modo de venda
     * @param c Cliente da venda
     * @param m Mes da venda
     * @param f Filial da venda
     * @throws java.lang.CloneNotSupportedException
     */
   public Venda(Produto p, double pre,int q, String PN, Cliente c, int m, int f ) throws CloneNotSupportedException{
       produto = p.clone();
       cliente = c.clone();
       filial = f;
       quantidade = q;
       mes = m;
       preco = pre;
       PouN = PN;
   }

    /**
     * 
     * @return Produto 
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * 
     * @return Cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * 
     * @return Filial
     */
    public int getFilial() {
        return filial;
    }

    /**
     * 
     * @return Quantidade 
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * 
     * @return Preço
     */
    public double getPreco() {
        return preco;
    }

    /**
     * 
     * @return Modo
     */
    public String getPouN() {
        return PouN;
    }

    /**
     * 
     * @return Mes
     */
    public int getMes() {
        return mes;
    }
    
    /**
     * Método toString
     * @return String construída
     */
    
    @Override
    public String toString() {
        StringBuilder st = new StringBuilder();
        st.append("Venda:");
        st.append("cliente=").append(cliente);
        st.append(", produto=").append(produto);
        st.append(", preço=").append(preco);
        st.append(", quantidade=").append(quantidade);
        st.append(", mes=").append(mes);
        st.append(", tipo=").append(PouN);
        st.append(", filial=").append(filial);
        return st.toString();    
    }

    /**
     * Teste de igualdade da instância actual com o parâmetro 
     * @param obj Objecto a ser testado
     * @return Igualdade entre a instância actual e o parâmetro obj
     */
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
    /**
     * 
     * @return HashCode de Cliente
     */
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
   
    /**
     * 
     * @return Novo objecto como cópia da instância actual
     * @throws java.lang.CloneNotSupportedException
     */
   @Override
    public Venda clone() throws CloneNotSupportedException{
        return new Venda(this);
    }
   
}
