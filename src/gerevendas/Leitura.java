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
    
   
    
    public Leitura(){}

    
    static void lerVendas() {
        ArrayList<String> linhas = new ArrayList<>();
        ArrayList<Venda> vendas = new ArrayList<>();

        Hipermercado hiper = Gerevendas.getHipermercado();
        
        linhas = readLinesWithBuff("Vendas_1M.txt");
        vendas = parseAllLinhas(linhas);
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
    
     public static Venda parseLinhaVenda(String linha) {
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
                hiper.insereVendaValida(v);

        }else{
                hiper.insereVendaInvalida(v);
        }
        
       return v;
    }
    
    
     public static ArrayList<Venda> parseAllLinhas(ArrayList<String> linhas) {
        Venda venda;
        ArrayList<Venda> vendas = new ArrayList<>();
        for (String s : linhas) {
            venda = parseLinhaVenda(s);
            vendas.add(venda);
        }
        return vendas;
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
        };
        return linhas;
    }
    
    
    public static boolean verificaVenda(Produto pro,double preco,int quantidade,String PouN,Cliente cliente,int mes,int filial) {
        Hipermercado hiper = Gerevendas.getHipermercado();
        Boolean r=false;
        
        if(hiper.getClientes().existeCliente(cliente)){
            if(hiper.getProdutos().existeProduto(pro)){
                if(preco>=0.0 && quantidade>=0) r=true;
            }
        }
        
        
        return r;

    }
    
}
