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
    
   // Mostra Os codigos dos produtos nao vendidos
    
    public void Querie1(){
      this.Vendas=new ArrayList<>();
      ArrayList<String> Produtos = new ArrayList<>();
      for (Venda venda: Vendas) {   
       if (venda.getQuantidade()==0){
           Produtos.add(venda.getProduto().getCodigo());
       }
      }
       System.out.println(Vendas.size());
       System.out.println(Produtos);
       System.out.println(Vendas);
    }
      
       
    static void Querie2(){
        
        
    }
    
    static void Querie3(){
        
        
    }
     
    static void Querie4(){
        
        
    }

    
}