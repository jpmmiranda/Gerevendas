/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Classe que compara dois produtos.
 * 
 *
 * @author Rui Machado, Jose Lima, Jose Mirra, Joao Miranda
 */
public class ComparatorCodigoProduto implements Comparator<Produto>, Serializable {
    
    /**
     * Método de comparação
     * @param c1 Produto a comparar
     * @param c2 Produto a comparar
     * @return Valor comparativo entre c1 e c2
     */
    
    @Override
    public int compare(Produto c1, Produto c2) {
        return c1.getCodigo().compareTo(c2.getCodigo());
    }
}
