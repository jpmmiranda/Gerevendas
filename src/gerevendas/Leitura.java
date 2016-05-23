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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static void lerProdutos() {
        ArrayList<String> codigos = new ArrayList<>();
        Hipermercado hiper = Gerevendas.getHipermercado();
                
        codigos = readLinesWithBuff("Produtos.txt");
        for(String cod : codigos){
             hiper.insereProduto(cod);
          }
    }

    static void lerClientes() {
        
        ArrayList<String> codigos = new ArrayList<>();
        Hipermercado hiper = Gerevendas.getHipermercado();
        
        codigos = readLinesWithBuff("Clientes.txt");
        for(String cod : codigos){
                hiper.insereCliente(cod);
        }
    }
    
    /*
    
     public static ArrayList<Venda> parseAllLinhas(ArrayList<String> linhas) {
        Venda venda;
        ArrayList<Venda> vendas = new ArrayList<>();
        for (String s : linhas) {
            venda = parseLinhaVenda(s);
            vendas.add(venda);
        }
        return vendas;
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
}
