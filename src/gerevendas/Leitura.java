/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.System.out;
import java.util.ArrayList;

/**
 *
 * @author Rui
 */
public class Leitura {
    
   
    
    public Leitura(){}

    
    static void lerVendas() throws  IOException, CloneNotSupportedException {
        String linha;
        Hipermercado hiper = Gerevendas.getHipermercado();

                 Venda v;

         BufferedReader in = null;
            try {
                in = new BufferedReader(new FileReader("Vendas_3M.txt"));
            } catch (FileNotFoundException ex) {
                    System.out.println("Ficheiro não existe");
            }
       
            while ((linha = in.readLine())!= null) {
                
                
                
         
        String[] partes = linha.split(" ");
        Produto pro = new Produto(partes[0]);
        double preco = Double.parseDouble(partes[1]);
        int quantidade = Integer.parseInt(partes[2]);
        String PouN = partes[3];
        Cliente cliente = new Cliente(partes[4]);
        int mes = Integer.parseInt(partes[5]);
        int filial = Integer.parseInt(partes[6]);
        if(verificaVenda(pro,preco,quantidade,PouN,cliente,mes,filial)){
                v = new Venda(pro, preco, quantidade, PouN, cliente, mes, filial);
                hiper.insereVendaValida(v.clone());
        }else{
                //hiper.insereVendaInvalida(v);
        } 
                
                
                
            
        /*linhas = readLinesWithBuff("Vendas_1M.txt");
        parseAllLinhas(linhas);*/
    }
  }

    static void lerProdutos() {
        ArrayList<String> codigos = new ArrayList<>();
        Hipermercado hiper = Gerevendas.getHipermercado();
                
        codigos = readLinesWithBuff("Produtos.txt");
        for(String cod : codigos){
            Produto pro = new Produto(cod);
             hiper.insereProduto(pro);
          }
        //hiper.imprimeProdutos();
    }

    static void lerClientes() {
        
        ArrayList<String> codigos = new ArrayList<>();
        Hipermercado hiper = Gerevendas.getHipermercado();
        
        codigos = readLinesWithBuff("Clientes.txt");
        for(String cod : codigos){
                Cliente cli = new Cliente(cod);
                hiper.insereCliente(cli);
        }
        //hiper.imprimeClientes();
    }
    
     /*public static int parseLinhaVenda(String linha,int i) throws CloneNotSupportedException {
        Hipermercado hiper = Gerevendas.getHipermercado();
         Venda v = null;
         
        String[] partes = linha.split(" ");
        Produto pro = new Produto(partes[0]);
        double preco = Double.parseDouble(partes[1]);
        int quantidade = Integer.parseInt(partes[2]);
        String PouN = partes[3];
        Cliente cliente = new Cliente(partes[4]);
        int mes = Integer.parseInt(partes[5]);
        int filial = Integer.parseInt(partes[6]);
        if(verificaVenda(pro,preco,quantidade,PouN,cliente,mes,filial)){
                v = new Venda(pro, preco, quantidade, PouN, cliente, mes, filial);
                i++;
                hiper.insereVendaValida(v);
        }else{
            
                //hiper.insereVendaInvalida(v);
        }
        
       return i;
    }
    
    
     public static void parseAllLinhas(ArrayList<String> linhas) throws CloneNotSupportedException {
        int i=0;
         for (String s : linhas) {
             i=parseLinhaVenda(s,i);
        }
         System.out.println(i);
    }*/
     
     
    public static ArrayList<String> readLinesWithBuff(String fich) {
        ArrayList<String> linhas = new ArrayList<>();
        BufferedReader inStream = null;
        String linha = null;
        try {
            inStream = new BufferedReader(new FileReader(fich));
            while ((linha = inStream.readLine()) != null) {
                linhas.add(linha);
            }
        } catch (IOException e) {
            out.println(e.getMessage());
            return null;
        };
        return linhas;
    }
    
    
    public static boolean verificaVenda(Produto pro,double preco,int quantidade,String PouN,Cliente cliente,int mes,int filial) {
        Hipermercado hiper = Gerevendas.getHipermercado();
        Boolean r=false;
        
        if(hiper.existeCliente(cliente)){
            if(hiper.existeProduto(pro)){
                if(preco>=0.0 && quantidade>=0) r=true;
            }
        }
        
        
        return r;

    }
    
}
