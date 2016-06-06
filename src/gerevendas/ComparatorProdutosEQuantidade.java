/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Classe que permitirá a ordenação de ParCliProdsComprados
 * @author Rui Machado, Jose Lima, Jose Mirra, Joao Miranda
 */
public class ComparatorProdutosEQuantidade implements Comparator<ParCliProdsComprados>,Serializable{
    
    /**
     * Método de comparação 
     * @param o1 ParCliProdsComprados a comparar
     * @param o2 ParCliProdsComprados a comparar
     * @return Valor comparativo entre o1 e o2
     */
    @Override
    public int compare(ParCliProdsComprados o1, ParCliProdsComprados o2) {
        float tot1=o1.getTotal();
        float tot2=o2.getTotal();
        if(tot1==0){
            return 0;
        }
        if(tot1<tot2){
            return 1;
        }
        if(tot1>tot2){
            return -1;
        }
        if(tot2==tot1){
            return o1.getProdutos().compareTo(o2.getProdutos());
        }
        return 0;
    }
}
