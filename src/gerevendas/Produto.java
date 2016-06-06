/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.io.Serializable;
import java.util.Objects;

/**
 * Classe Produto
 *
 * @author Rui Machado, Jose Lima, Jose Mirra, Joao Miranda
 */
public class Produto implements Serializable {
     
    private String codigo;

    /**
     * Construtor vazio
     */
    
    public Produto(){
        codigo="";
    }
    
    /**
     * Construtor parametrizado 
     * @param cod código de produto
     */
    public Produto(String cod) {
        codigo = cod;
    }

    /**
     * Construtor de cópia de uma instância da classe Produto
     *
     * @param produto produto a ser copiado
     */
    public Produto(Produto produto) {
        codigo = produto.getCodigo();
    }
    
     /**
     * 
     * @return Código de Produto
     */

    public String getCodigo() {
        return codigo;
    }
    
    /**
     * Insere o Código de Produto
     * @param codigo Código de Produto
     */

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
        Produto prod = (Produto) obj;
        return this.codigo.equals(prod.codigo);
    }

    /**
     * 
     * @return HashCode de Produto
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    /**
     * 
     * @return Novo objecto como cópia da instância actual
     * @throws java.lang.CloneNotSupportedException
     */
    @Override
    public Produto clone() throws CloneNotSupportedException {
        return new Produto(this);
    }

    /**
     * Método toString
     * @return String construída
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Codigo Produto= ").append(codigo);
        return sb.toString();
    }
    
    /**
     * Método compara dois produtos
     * @param c Produto a comparar
     * @return inteiro de comparação
     */
     public int compareTo(Produto c) {
        return this.codigo.compareTo(c.getCodigo());
    }
}
