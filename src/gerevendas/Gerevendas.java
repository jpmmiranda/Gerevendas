/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.io.IOException;
import java.io.Serializable;

/**
 * Classe Inicial
 *
 * @author Rui Machado, Jose Lima, Jose Mirra, Joao Miranda
 */
public class Gerevendas implements Serializable {
    
    private static Hipermercado hipermercado;

    /**
     * Método Main
     *
     * @param args Argumentos passados na linha de comando
     * @throws java.lang.CloneNotSupportedException
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     * @throws gerevendas.ClienteNaoExisteExcepcao
     * @throws gerevendas.ProdutoNaoExisteExcepcao
     */
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException, ClienteNaoExisteExcepcao, ProdutoNaoExisteExcepcao {
        hipermercado = new Hipermercado();
        Interface.printMenu();
    }

    /**
     * 
     * @return Retorna Hipermercado
     */
    public static Hipermercado getHipermercado() {
        return hipermercado;
    }
    
    /**
     * Insere Hipermercado
     * @param aHipermercado Hipermercado a inserir
     */
    public static void setHipermercado(Hipermercado aHipermercado) {
        hipermercado = aHipermercado;
    }
     
}
