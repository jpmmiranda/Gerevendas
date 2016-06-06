/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

/**
 * Classe que capta excepçoes de inexistencia de Cliente
 * @author Rui Machado, Jose Lima, Jose Mirra, Joao Miranda
 */
public class ClienteNaoExisteExcepcao extends Exception{

     /**
     * Construtor Vazio
     */
    public ClienteNaoExisteExcepcao(){
        super();
    }
    /**
     * Construtor Parametrizado
     * @param cod Código do "nao" cliente que activou a excepção
     */
    public ClienteNaoExisteExcepcao(String cod){
        super(cod);
    }
}

