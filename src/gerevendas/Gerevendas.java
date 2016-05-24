/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.io.IOException;

/**
 *
 * @author Rui
 */
public class Gerevendas {
    
    public static Hipermercado hipermercado;

    public static void main(String[] args) throws CloneNotSupportedException, IOException {
        hipermercado = new Hipermercado();
        Interface.printMenu();
    }

    
    public static Hipermercado getHipermercado() {
        return hipermercado;
    }
     
}
