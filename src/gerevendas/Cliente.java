/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.util.Objects;

/**
 *
 * @author Rui
 */
public class Cliente {
    private String codigo;

    /*Construtores*/
   
    public Cliente() {
        codigo = "";
    }

    
    public Cliente(String cod) {
        codigo = cod;
    }

    public Cliente(Cliente cliente) {
        codigo = cliente.getCodigo();
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
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

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
        Cliente cliente = (Cliente) obj;
        return this.codigo.equals(cliente.codigo);
    }

    
    @Override
    public Cliente clone() {
        return new Cliente(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Codigo Cliente= ").append(codigo);
        return sb.toString();
    }
    
    public int compareTo(Cliente c) {
        return this.codigo.compareTo(c.getCodigo());
    }

}
