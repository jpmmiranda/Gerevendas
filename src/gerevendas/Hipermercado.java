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
import java.util.Scanner;

/**
 *
 * @author Asus
 */
public class Hipermercado {

    /**
     * @param args the command line arguments
     */
    public static Venda parseLinhaVenda(String linha) {
        Venda v;
        try{
        String[] partes = linha.split(" ");
        String produto = partes[0];
        double preco = Double.parseDouble(partes[1]);
        int quantidade = Integer.parseInt(partes[2]);
        String PouN = partes[3];
        String cliente = partes[4];
        int mes = Integer.parseInt(partes[5]);
        int filial = Integer.parseInt(partes[6]);
        v = new Venda(produto, preco, quantidade, PouN, cliente, mes, filial);
        }catch(NumberFormatException | NullPointerException exc) {return null;}
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

    public static void mainMenu() {
        int opcao, menu = 1;
        ArrayList<String> linhas = new ArrayList<>();
        ArrayList<Venda> vendas = new ArrayList<>();
        while (menu == 1) {
            out.print("1. Ler 1 milhão.\n2. Ler 3 milhões.\n3. Ler 5 milhões.\n0. Sair.\n>");
            opcao = Input.lerInt();
            switch (opcao) {
                case 1:
                    linhas = new ArrayList<>();
                    Crono.start();
                    linhas = readLinesWithBuff("C:\\Users\\Asus\\Documents\\NetBeansProjects\\Gerevendas\\src\\Vendas_1M.txt");
                    vendas = parseAllLinhas(linhas);
                    Crono.stop();
                    out.println("Tempo: " + Crono.print() + "Linhas: " + linhas.size());
                    break;
                case 2:
                    linhas = new ArrayList<>();
                    vendas = new ArrayList<>();
                    Crono.start();
                    linhas = readLinesWithBuff("C:\\Users\\Asus\\Documents\\NetBeansProjects\\Gerevendas\\src\\Vendas_3M.txt");
                    vendas = parseAllLinhas(linhas);
                    Crono.stop();
                    out.println("Tempo: " + Crono.print() + "Linhas: " + linhas.size());
                    break;
                case 3:
                    linhas = new ArrayList<>();
                    vendas = new ArrayList<>();
                    Crono.start();
                    linhas = readLinesWithBuff("C:\\Users\\Asus\\Documents\\NetBeansProjects\\Gerevendas\\src\\Vendas_5M.txt");
                    vendas = parseAllLinhas(linhas);
                    Crono.stop();
                    out.println("Tempo: " + Crono.print() + "Linhas: " + linhas.size());
                    break;
                case 0:
                    menu = 0;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        mainMenu();
    }

}
