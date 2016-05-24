/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.io.Serializable;
import java.util.Comparator;

/**
 *
 * @author Rui
 */
public class ComparatorCodigoProduto implements Comparator<Produto>, Serializable {
    @Override
    public int compare(Produto c1, Produto c2) {
        return c1.getCodigo().compareTo(c2.getCodigo());
    }
}
