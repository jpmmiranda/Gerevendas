/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.io.Serializable;
import java.util.Objects;

/**
 * Classe Cliente
 *
 * @author Rui Machado, Jose Lima, Jose Mirra, Joao Miranda
 */
public class Cliente implements Serializable{
    private String codigo;

    /**
     * Construtor vazio
     */
   
    public Cliente() {
        codigo = "";
    }

    /**
     * Construtor parametrizado 
     * @param cod código de cliente
     */
    public Cliente(String cod) {
        codigo = cod;
    }

    /**
     * Construtor de cópia de uma instância da classe Cliente
     *
     * @param cliente cliente a ser copiado
     */
    public Cliente(Cliente cliente) {
        codigo = cliente.getCodigo();
    }

     /**
     * 
     * @return Código de Cliente 
     */
    
    public String getCodigo() {
        return codigo;
    }
    
    /**
     * Insere o Código de Cliente
     * @param codigo Código de Cliente
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    
    
    /**
     * 
     * @return HashCode de Cliente
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.codigo);
        return hash;
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
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Cliente cliente = (Cliente) obj;
        return this.codigo.equals(cliente.codigo);
    }

    /**
     * 
     * @return Novo objecto como cópia da instância actual
     * @throws java.lang.CloneNotSupportedException
     */
    @Override
    public Cliente clone() throws CloneNotSupportedException {
        return new Cliente(this);
    }
    /**
     * Método toString
     * @return String construída
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Codigo Cliente= ").append(codigo);
        return sb.toString();
    }
    
     /**
     * Método compara dois clientes
     * @param c Cliente a comparar
     * @return inteiro de comparação
     */
    public int compareTo(Cliente c) {
        return this.codigo.compareTo(c.getCodigo());
    }

}
