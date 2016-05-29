
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
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
      sair();   

    }
      
       
    public void Querie2(int mes){
        
        facturacao = Gerevendas.getHipermercado().getFaturacao();
        gestaofilial = Gerevendas.getHipermercado().getGestfilial();
        int clientes=gestaofilial.getClientesMes(mes);
        int vendas =  facturacao.vendasMensais(mes);
        System.out.println("Total de vendas no mes "+mes+": "+vendas);
        System.out.println("Total de clientes que compraram no mes "+mes+": "+clientes);
        sair();   

        
    }
    
    public void Querie3(String cliente){
        gestaofilial = Gerevendas.getHipermercado().getGestfilial();
        
        Cliente cli = new Cliente(cliente);
        
        TrioCliComProFat  tcpf = gestaofilial.getClienteParaCadaMes(cli);
        System.out.println(tcpf.toString());
        sair();
                    
    }
     
    public void Querie4(String produto){
        gestaofilial = Gerevendas.getHipermercado().getGestfilial();
        
        Produto prod = new Produto(produto);
        
        TrioProdCompCliFat  tcpf = gestaofilial.getProdutoParaCadaMes(prod);
        System.out.println(tcpf.toString());
        sair();   
    }
        
    
    public void Querie5(String cliente){
    
    
        gestaofilial = Gerevendas.getHipermercado().getGestfilial();
        
        Cliente cli = new Cliente(cliente);
        
        TreeSet<ParCliProdsComprados>  pcpc = gestaofilial.listaDeProdutos(cli);
         System.out.println(pcpc.toString());
        sair();
    }
    
    
    public void Querie6(int X){
    facturacao = Gerevendas.getHipermercado().getFaturacao();
     gestaofilial = Gerevendas.getHipermercado().getGestfilial();
    int i=0;
    TreeSet<ParCliProdsComprados>  pcpc = facturacao.listaDeXProdutos();
   
    Iterator<ParCliProdsComprados> iterator = pcpc.iterator();
        while (iterator.hasNext() && i<X) {
            ParCliProdsComprados pc=iterator.next();
            System.out.println(pc.toString() + "Clientes Distintos: " + gestaofilial.quantidadeDeCompradores(pc.getProdutos()) + "\n");
             i++;

            }
            sair();

    }
    
    public void Querie7(){
    
    gestaofilial = Gerevendas.getHipermercado().getGestfilial();
    int i=0;
    TreeSet<ParCliProdsComprados>  pcpc1 = gestaofilial.maioresCompradoresFilial1();
    TreeSet<ParCliProdsComprados>  pcpc2 = gestaofilial.maioresCompradoresFilial2();
    TreeSet<ParCliProdsComprados>  pcpc3 = gestaofilial.maioresCompradoresFilial3();

    System.out.println("Três Maiores Compradores da Filial 1: ");
    Iterator<ParCliProdsComprados> iterator = pcpc1.iterator();
        while (iterator.hasNext() && i<3) {
            ParCliProdsComprados pc=iterator.next();
            System.out.println("Clientes : " + pc.getProdutos() + "\n" + "Valor Gasto: " + pc.getTotal()  + "\n");
             i++;

            }
   
    System.out.println("Três Maiores Compradores da Filial 2: ");
    System.out.println();

    i=0;
    Iterator<ParCliProdsComprados> iterator2 = pcpc2.iterator();
        while (iterator2.hasNext() && i<3) {
            ParCliProdsComprados pc=iterator2.next();
            System.out.println("Clientes : " + pc.getProdutos() + "\n" + "Valor Gasto: " + pc.getTotal()  + "\n");
             i++;

            }
        
    System.out.println("Três Maiores Compradores da Filial 3: ");
    System.out.println();
    i=0;
    Iterator<ParCliProdsComprados> iterator3 = pcpc3.iterator();
        while (iterator3.hasNext() && i<3) {
            ParCliProdsComprados pc=iterator3.next();
            System.out.println("Clientes : " + pc.getProdutos() + "\n" + "Valor Gasto: " + pc.getTotal()  + "\n");
             i++;

            }
    
        sair();
        
    
    }
    
    public void Querie8(int X){
    
    gestaofilial = Gerevendas.getHipermercado().getGestfilial();
    int i=0;
    TreeSet<ParCliProdsComprados>  pcpc = gestaofilial.compradoresProdutosDiferentes();
   
    Iterator<ParCliProdsComprados> iterator = pcpc.iterator();
        while (iterator.hasNext() && i<X) {
            ParCliProdsComprados pc=iterator.next();
            System.out.println("Cliente: " + pc.getProdutos() + "\n" + "Numero de Produtos Comprados: "+pc.getTotal() + "\n");
            i++;

            }
            sair();
    }
    
    public void Querie9(String produto, int X){
    
        gestaofilial = Gerevendas.getHipermercado().getGestfilial();
        
        Produto pro = new Produto(produto);
        int i=0;
         TreeSet<ParCliProdsComprados>  pcpc = gestaofilial.listaDeClientes(pro.clone());
   
    Iterator<ParCliProdsComprados> iterator = pcpc.iterator();
        while (iterator.hasNext() && i<X) {
            ParCliProdsComprados pc=iterator.next();
            System.out.println("Cliente: " + pc.getProdutos() + "\n" + "Valor: "+pc.getTotal() + "\n");
             i++;

            }
        sair();
    }
    
    
    private static void sair(){
        System.out.println("Prima Enter para sair");
        String c=Input.lerString();
        while(c.endsWith("\n")){
            c = Input.lerString();
        }
        
        
    }

    
}