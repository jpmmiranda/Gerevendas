/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import static java.lang.System.out;
import java.util.ArrayList;

/**
 * Classe Leitura
 *
 * @author Rui Machado, Jose Lima, Jose Mirra, Joao Miranda
 */
public class Leitura implements Serializable {
    
     private static int Clientes = 0, Produtos = 0, Preco0 = 0, Errados=0;
    
  
   /**
     * Metodo responsavel pela leitura do ficheiro de vendas
     * @throws java.io.IOException
     * @throws java.lang.CloneNotSupportedException
     */
    public static void lerVendas() throws  IOException, CloneNotSupportedException {
       
        Hipermercado hiper = Gerevendas.getHipermercado();
      
        Venda v;
        String fich="Vendas_1M.txt";
      
        ArrayList<String> codigos;

        codigos = readLinesWithBuff(fich);
        for(String c : codigos){
     
            String[] partes = c.split(" ");
            Produto pro = new Produto(partes[0]);
            double preco = Double.parseDouble(partes[1]);
            int quantidade = Integer.parseInt(partes[2]);
            String PouN = partes[3];
            Cliente cliente = new Cliente(partes[4]);
            int mes = Integer.parseInt(partes[5]);
            int filial = Integer.parseInt(partes[6]);
            
            if(verificaVenda(pro,preco,quantidade,cliente)){
                v = new Venda(pro, preco, quantidade, PouN, cliente, mes, filial);
                if(preco==0) Preco0++;
                hiper.insereVendaValida(v.clone());
            }else{
                Errados++;
            }
            
        }
        hiper.insereEstatistica(fich,Clientes,Produtos,Preco0,Errados);


  }

    /**
    * Metodo responsavel pela leitura do ficheiro de produtos
    */
    public static void lerProdutos() {
        ArrayList<String> codigos;
        Hipermercado hiper = Gerevendas.getHipermercado();
                
        codigos = readLinesWithBuff("Produtos.txt");
        for(String cod : codigos){
            Produto pro = new Produto(cod);
             hiper.insereProduto(pro.clone());
             Produtos++;
          }
        
    }

    /**
    * Metodo responsavel pela leitura do ficheiro de clientes 
    * @throws java.lang.CloneNotSupportedException
    */
   public static void lerClientes() throws CloneNotSupportedException {
        
        ArrayList<String> codigos;
        Hipermercado hiper = Gerevendas.getHipermercado();
        
        codigos = readLinesWithBuff("Clientes.txt");
        for(String cod : codigos){
                Cliente cli = new Cliente(cod);
                hiper.insereCliente(cli.clone());
                Clientes++;
        }
    }
    
    
    /**
    * Metodo responsavel por ler linhas de ficheiro 
    */
     
    private static ArrayList<String> readLinesWithBuff(String fich) {
        ArrayList<String> linhas = new ArrayList<>();
        BufferedReader inStream ;
        String linha ;
        try {
            inStream = new BufferedReader(new FileReader(fich));
            while ((linha = inStream.readLine()) != null) {
                linhas.add(linha);
            }
        } catch (IOException e) {
            out.println(e.getMessage());
            return null;
        }
        return linhas;
    }
    
    /**
    * Metodo responsavel por verificar uma venda
    */
    private static boolean verificaVenda(Produto pro,double preco,int quantidade,Cliente cliente) {
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
