/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;



/**
 *
 * @author José
 */
public class Queries {
    
    private ArrayList<Venda> Vendas;

    
   // Mostra as Vendas feitas na Filial 2
    
    public ArrayList Querie1(){
      ArrayList newVendas = new ArrayList();
      Venda venda = new Venda();
      int filial=2;
      for (Venda vendas: Vendas) {   
       if (vendas.getFilial()==filial){
           newVendas.add(vendas);
       }
      }
       return newVendas;
    }
      
       
    static void Querie2(){
        
        
    }
    
    static void Querie3(){
        
        
    }
     
    static void Querie4(){
        
        
    }

    
}
