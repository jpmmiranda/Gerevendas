/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.System.out;
import java.util.ArrayList;

/**
 *
 * @author Rui
 */
public class Leitura {
    
     private static int Clientes = 0, Produtos = 0,Compras = 0, Preco0 = 0, Errados=0;
    
    public Leitura(){}

    
    static void lerVendas() throws  IOException, CloneNotSupportedException {
        String linha;
        Hipermercado hiper = Gerevendas.getHipermercado();
        int linhasValidas=0;
        int linhasInvalidas=0;
        Venda v;
        String fich="Vendas_1M.txt";
       /* BufferedReader in = null;
            try {
                in = new BufferedReader(new FileReader("Vendas_3M.txt"));
            } catch (FileNotFoundException ex) {
                 out.println(ex.getMessage());
            }*/
               ArrayList<String> codigos = new ArrayList<>();

        codigos = readLinesWithBuff(fich);
        for(String c : codigos){
      //  while ((linha = in.readLine())!= null) {
                 
            String[] partes = c.split(" ");
            Produto pro = new Produto(partes[0]);
            double preco = Double.parseDouble(partes[1]);
            int quantidade = Integer.parseInt(partes[2]);
            String PouN = partes[3];
            Cliente cliente = new Cliente(partes[4]);
            int mes = Integer.parseInt(partes[5]);
            int filial = Integer.parseInt(partes[6]);
            
            if(verificaVenda(pro,preco,quantidade,PouN,cliente,mes,filial)){
                    v = new Venda(pro, preco, quantidade, PouN, cliente, mes, filial);
                    if(preco==0) Preco0++;
                    hiper.insereVendaValida(v.clone());
                    Compras++;
            }else{
                    Errados++;
            } 
                
        }
        hiper.insereEstatistica(fich,Clientes,Produtos,Compras,Preco0,Errados);


  }

    static void lerProdutos() {
        ArrayList<String> codigos = new ArrayList<>();
        Hipermercado hiper = Gerevendas.getHipermercado();
                
        codigos = readLinesWithBuff("Produtos.txt");
        for(String cod : codigos){
            Produto pro = new Produto(cod);
             hiper.insereProduto(pro.clone());
             Produtos++;
          }
        
    }

    static void lerClientes() throws CloneNotSupportedException {
        
        ArrayList<String> codigos = new ArrayList<>();
        Hipermercado hiper = Gerevendas.getHipermercado();
        
        codigos = readLinesWithBuff("Clientes.txt");
        for(String cod : codigos){
                Cliente cli = new Cliente(cod);
                hiper.insereCliente(cli.clone());
                Clientes++;
        }
    }
    
    
     
     
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
        }
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
