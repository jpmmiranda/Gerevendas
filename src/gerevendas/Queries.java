
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;



/**
 *
 * @author José
 */
public class Queries {
  
 
    public static CatalogoClientes catalogoClientes;
    public static CatalogoProdutos catalogoProdutos;
    public static Facturacao facturacao;
    public static GestaoFilial gestaofilial;
    
    
   // Mostra Os codigos dos produtos nao vendidos
    
    public void Querie1(){
      gestaofilial = Gerevendas.getHipermercado().getGestfilial();
      
      ArrayList ProdutosNaoComprados = gestaofilial.getProdutosNaoComprados();
      Collections.sort(ProdutosNaoComprados);
      System.out.println(ProdutosNaoComprados.size());
      System.out.println(ProdutosNaoComprados.toString());
    }
      
       
    public void Querie2(int mes){
        
        facturacao = Gerevendas.getHipermercado().getFaturacao();
        gestaofilial = Gerevendas.getHipermercado().getGestfilial();
        int clientes=gestaofilial.getClientesMes(mes);
        int vendas =  facturacao.vendasMensais(mes);
        System.out.println("Total de compras no mes "+mes+"->"+vendas);
        System.out.println("Total de clientes que compraram no mes "+mes+"->"+clientes);
        
        
    }
    
    public void Querie3(String cliente){
         gestaofilial = Gerevendas.getHipermercado().getGestfilial();
        
        Cliente cli = new Cliente(cliente);
        
        TrioComProFat  tcpf = gestaofilial.getClienteParaCadaMes(cli);
        System.out.println(tcpf.toString());
                    
    }
     
    public void Querie4(){
        
        
    }

    
}