/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

/**
 * Classe que capta excepçoes de inexistencia de Produto
 * @author Rui Machado, Jose Lima, Jose Mirra, Joao Miranda
 */
public class ProdutoNaoExisteExcepcao extends Exception{
     /**
     * Construtor Vazio
     */
    public ProdutoNaoExisteExcepcao(){
        super();
    }
    /**
     * Construtor Parametrizado
     * @param cod Código do "nao" produto que activou a excepção
     */
    public ProdutoNaoExisteExcepcao(String cod){
        super(cod);
    }
}
