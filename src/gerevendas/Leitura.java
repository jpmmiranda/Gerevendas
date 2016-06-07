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
    
     private static int Preco0 = 0, Errados=0;
    
  
   /**
     * Metodo responsavel pela leitura do ficheiro de vendas
     * @throws java.io.IOException
     * @throws java.lang.CloneNotSupportedException
     */
    public static void lerVendas() throws  IOException, CloneNotSupportedException {
       
        Hipermercado hiper = Gerevendas.getHipermercado();
      
        Venda v;
        String fich="Vendas_3M.txt";
      
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
            
            if(verificaVenda(pro.clone(),preco,quantidade,cliente.clone())){
                v = new Venda(pro.clone(), preco, quantidade, PouN, cliente.clone(), mes, filial);
                if(preco==0) Preco0++;
                hiper.insereVendaValida(v.clone());
            }else{
                Errados++;
            }
            
        }
        hiper.insereEstatistica(fich,Preco0,Errados);


  }

    /**
    * Metodo responsavel pela leitura do ficheiro de produtos
     * @throws java.lang.CloneNotSupportedException
    */
    public static void lerProdutos() throws CloneNotSupportedException {
        ArrayList<String> codigos;
        Hipermercado hiper = Gerevendas.getHipermercado();
                
        codigos = readLinesWithBuff("Produtos.txt");
        for(String cod : codigos){
            Produto pro = new Produto(cod);
             hiper.insereProduto(pro.clone());

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
    private static boolean verificaVenda(Produto pro,double preco,int quantidade,Cliente cliente) throws CloneNotSupportedException {
        Hipermercado hiper = Gerevendas.getHipermercado();
        Boolean r=false;
        
        if(hiper.existeCliente(cliente.clone())){
            if(hiper.existeProduto(pro.clone())){
                if(preco>=0.0 && quantidade>=0) r=true;
            }
        }
        
        
        return r;

    }
    
    
    
    
}
