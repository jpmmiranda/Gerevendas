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
 * @author Rui
 */
public class Produto implements Serializable {
     
    private String codigo;

    /* Construtores */
    
    public Produto(){
        codigo="";
    }
    
    
    public Produto(String cod) {
        codigo = cod;
    }

    public Produto(Produto produto) {
        codigo = produto.getCodigo();
    }
    
    /*Getter*/

    public String getCodigo() {
        return codigo;
    }
    
    /*Setter*/

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
     /*
    Metodos
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Produto prod = (Produto) obj;
        return this.codigo.equals(prod.codigo);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    
    @Override
    public Produto clone() {
        return new Produto(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Codigo Produto= ").append(codigo);
        return sb.toString();
    }

     public int compareTo(Produto c) {
        return this.codigo.compareTo(c.getCodigo());
    }
}
