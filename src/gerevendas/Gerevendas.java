/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

/**
 *
 * @author Rui
 */
public class Gerevendas {
    
    public static Hipermercado hipermercado;

    public static void main(String[] args) {
        hipermercado = new Hipermercado();
        Interface.printMenu();
    }

    
    public static Hipermercado getHipermercado() {
        return hipermercado;
    }
     
}
