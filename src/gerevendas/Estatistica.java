/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;


/**
 * Estrutura de dados relacionada com as estatisticas
 *
 * @author Rui Machado, Jose Lima, Jose Mirra, Joao Miranda
 */

public class Estatistica implements Serializable {
    
    private String ficheiroVendas;
    private int totalRegistosErrados;
    private int totalProdutos;
    private int totalProdutosDiferentes;
    private int totalNaoComprados;
    private int totalClientes;
    private int totalClientesCompradores;
    private int totalClientesNaoCompradores;
    private int totalComprasZero;
    private double totalFacturacao;
    private int[] totalComprasMes;
    private double[] totalFacturacaoFilial1;
    private double[] totalFacturacaoFilial2;
    private double[] totalFacturacaoFilial3;
    private double[] totalFacturacaoMensal;
    private int[] clientesDistintos;
    
    /**
     * Construtor Vazio
     */
    public Estatistica(){
    
        ficheiroVendas=" ";
         totalRegistosErrados=0;
         totalProdutos=0;
         totalProdutosDiferentes=0;
         totalNaoComprados=0;
         totalClientes=0;
         totalClientesCompradores=0;
         totalClientesNaoCompradores=0;
         totalComprasZero=0;
         totalFacturacao=0.0;
         totalComprasMes = new int[12];
         totalFacturacaoFilial1=new double[12];
         totalFacturacaoFilial2=new double[12];
         totalFacturacaoFilial3=new double[12];
         totalFacturacaoMensal=new double[12];
         clientesDistintos=new int[12];
    
    }

    /**
     * Construtor Parametrizado
     *
     * @param ficheiroVendas Nome ficheiro de vendas
     * @param totalRegistosErrados Numero total de linhas invalidas
     * @param totalProdutos Numero total de produtos
     * @param totalProdutosDiferentes Numero total de diferentes produtos comprados
     * @param totalNaoComprados Numero total de produtos não comprados
     * @param totalClientes Numero total de clientes
     * @param totalClientesCompradores Numero total de cliente que efecturam compras
     * @param totalClientesNaoCompradores Numero total de cliente que não efecturam compras
     * @param totalComprasZero Total de vendas com valor 0.0
     * @param totalFacturacao Total Facturado
     * @param totalComprasMes Total de compras efectuadas em cada mês
     * @param totalFacturacaoFilial1 Valor facturado na filial 1
     * @param totalFacturacaoFilial2 Valor facturado na filial 2
     * @param totalFacturacaoFilial3 Valor facturado na filial 3
     * @param totalFacturacaoMensal Valor facturado em cada mês
     * @param clientesDistintos Total de clientes distintos mensalmente
     */
    public Estatistica(String ficheiroVendas, int totalRegistosErrados, int totalProdutos, int totalProdutosDiferentes, int totalNaoComprados, int totalClientes, int totalClientesCompradores, int totalClientesNaoCompradores, int totalComprasZero, double totalFacturacao, int[] totalComprasMes, double[] totalFacturacaoFilial1, double[] totalFacturacaoFilial2, double[] totalFacturacaoFilial3, double[] totalFacturacaoMensal, int[] clientesDistintos) {
        this.ficheiroVendas = ficheiroVendas;
        this.totalRegistosErrados = totalRegistosErrados;
        this.totalProdutos = totalProdutos;
        this.totalProdutosDiferentes = totalProdutosDiferentes;
        this.totalNaoComprados = totalNaoComprados;
        this.totalClientes = totalClientes;
        this.totalClientesCompradores = totalClientesCompradores;
        this.totalClientesNaoCompradores = totalClientesNaoCompradores;
        this.totalComprasZero = totalComprasZero;
        this.totalFacturacao = totalFacturacao;
        this.totalComprasMes = totalComprasMes.clone();
        this.totalFacturacaoFilial1 = totalFacturacaoFilial1.clone();
        this.totalFacturacaoFilial2 = totalFacturacaoFilial2.clone();
        this.totalFacturacaoFilial3 = totalFacturacaoFilial3.clone();
        this.totalFacturacaoMensal = totalFacturacaoMensal.clone();
        this.clientesDistintos = clientesDistintos.clone();
    }
    
    /**
     * Construtor de cópia de uma instância da classe Estatistica
     *
     * @param e Estatistica a ser copiada
     */
    public Estatistica(Estatistica e){
    
        ficheiroVendas=e.getFicheiroVendas();
         totalRegistosErrados=e.getTotalRegistosErrados();
         totalProdutos=e.getTotalProdutos();
         totalProdutosDiferentes=e.getTotalProdutosDiferentes();
         totalNaoComprados=e.getTotalNaoComprados();
         totalClientes=e.getTotalClientes();
         totalClientesCompradores=e.getTotalClientesCompradores();
         totalClientesNaoCompradores=e.getTotalClientesNaoCompradores();
         totalComprasZero=e.getTotalComprasZero();
         totalFacturacao=e.getTotalFacturacao();
         totalComprasMes = e.getTotalComprasMes();
         totalFacturacaoFilial1=e.getTotalFacturacaoFilial1();
         totalFacturacaoFilial2=e.getTotalFacturacaoFilial2();
         totalFacturacaoFilial3=e.getTotalFacturacaoFilial3();
         totalFacturacaoMensal=e.getTotalFacturacaoMensal();
         clientesDistintos=e.getClientesDistintos();
    
    }

    /**
     *
     * @return Nome de ficheiro de vendas
     */
    
    public String getFicheiroVendas() {
        return ficheiroVendas;
    }

     /**
     *
     * @return Total de registos errados
     */
    public int getTotalRegistosErrados() {
        return totalRegistosErrados;
    }

     /**
     *
     * @return Total de produtos 
     */
    public int getTotalProdutos() {
        return totalProdutos;
    }

     /**
     *
     * @return Total de produtos diferentes comprados
     */
    
    public int getTotalProdutosDiferentes() {
        return totalProdutosDiferentes;
    }

     /**
     *
     * @return Total de produtos nao comprados
     */
    
    public int getTotalNaoComprados() {
        return totalNaoComprados;
    }

     /**
     *
     * @return Total de clientes 
     */
    public int getTotalClientes() {
        return totalClientes;
    }
    
    /**
     *
     * @return Total de clientes que efecturam compras
     */
    public int getTotalClientesCompradores() {
        return totalClientesCompradores;
    }

     /**
     *
     * @return Total de clientes que não efecturam compras
     */
    public int getTotalClientesNaoCompradores() {
        return totalClientesNaoCompradores;
    }

     /**
     *
     * @return Total de compras com valor 0.0 
     */
    public int getTotalComprasZero() {
        return totalComprasZero;
    }

     /**
     *
     * @return Total facturado
     */
    public double getTotalFacturacao() {
        return totalFacturacao;
    }

     /**
     *
     * @return Total de compras efectuadas mensalmente
     */
    public int[] getTotalComprasMes() {
        return totalComprasMes.clone();
    }
    
    /**
     *
     * @return Total facturado na filial 1
     */
    public double[] getTotalFacturacaoFilial1() {
        return totalFacturacaoFilial1.clone();
    }

    /**
     *
     * @return Total facturado na filial 2
     */
    public double[] getTotalFacturacaoFilial2() {
        return totalFacturacaoFilial2.clone();
    }

    /**
     *
     * @return Total facturado na filial 3
     */
    public double[] getTotalFacturacaoFilial3() {
        return totalFacturacaoFilial3.clone();
    }

    /**
     *
     * @return Total facturado mensalmente
     */
    public double[] getTotalFacturacaoMensal() {
        return totalFacturacaoMensal.clone();
    }

    /**
     *
     * @return Total de compradores clientes distintos mensalmente
     */
    public int[] getClientesDistintos() {
        return clientesDistintos.clone();
    }

    /**
     * Insere Nome de ficheiro de vendas
     *
     * @param ficheiroVendas Nome de ficheiro de vendas
     */
    public void setFicheiroVendas(String ficheiroVendas) {
        this.ficheiroVendas = ficheiroVendas;
    }
    
     /**
     * Insere numero de registos errados
     *
     * @param totalRegistosErrados numero de registos errados
     */
    public void setTotalRegistosErrados(int totalRegistosErrados) {
        this.totalRegistosErrados = totalRegistosErrados;
    }

     /**
     * Insere total de produtos
     *
     * @param totalProdutos totalidade de produtos
     */
    
    public void setTotalProdutos(int totalProdutos) {
        this.totalProdutos = totalProdutos;
    }

    /**
     * Insere total de diferentes produtos comprados
     *
     * @param totalProdutosDiferentes totalidade de produtos diferentes comprados
     */
    public void setTotalProdutosDiferentes(int totalProdutosDiferentes) {
        this.totalProdutosDiferentes = totalProdutosDiferentes;
    }

    /**
     * Insere total de  produtos não comprados
     *
     * @param totalNaoComprados totalidade de produtos não comprados
     */
    public void setTotalNaoComprados(int totalNaoComprados) {
        this.totalNaoComprados = totalNaoComprados;
    }
    
    /**
     * Insere total clientes
     *
     * @param totalClientes totalidade de clientes
     */

    public void setTotalClientes(int totalClientes) {
        this.totalClientes = totalClientes;
    }

    /**
     * Insere total clientes compradores
     *
     * @param totalClientesCompradores totalidade de clientes compradores
     */
    public void setTotalClientesCompradores(int totalClientesCompradores) {
        this.totalClientesCompradores = totalClientesCompradores;
    }

    /**
     * Insere total clientes não compradores
     *
     * @param totalClientesNaoCompradores totalidade de clientes não compradores
     */
    public void setTotalClientesNaoCompradores(int totalClientesNaoCompradores) {
        this.totalClientesNaoCompradores = totalClientesNaoCompradores;
    }

    /**
     * Insere total de compras a 0.0
     *
     * @param totalComprasZero totalidade de compras a 0.0
     */
    public void setTotalComprasZero(int totalComprasZero) {
        this.totalComprasZero = totalComprasZero;
    }

    /**
     * Insere total facturado
     *
     * @param totalFacturacao Valor facturado
     */
    public void setTotalFacturacao(double totalFacturacao) {
        this.totalFacturacao = totalFacturacao;
    }

    /**
     * Insere total de compras mensais
     *
     * @param mes mes da compra/venda
     * @param total valor da compra/venda
     */
    public void setTotalComprasMes(int mes,int total) {
        this.totalComprasMes[mes] = total;
    }

    /**
     * Insere total facturado mensal na filial 1
     *
     * @param mes mes da compra/venda
     * @param totalFacturacaoFilial1 valor da compra/venda
     */
    public void setTotalFacturacaoFilial1(int mes,double totalFacturacaoFilial1) {
        this.totalFacturacaoFilial1[mes] = totalFacturacaoFilial1;
    }
    
    /**
     * Insere total facturado mensal na filial 2
     *
     * @param mes mes da compra/venda
     * @param totalFacturacaoFilial2 valor da compra/venda
     */
    public void setTotalFacturacaoFilial2(int mes,double totalFacturacaoFilial2) {
        this.totalFacturacaoFilial2[mes] = totalFacturacaoFilial2;
    }

    /**
     * Insere total facturado mensal na filial 3
     *
     * @param mes mes da compra/venda
     * @param totalFacturacaoFilial3 valor da compra/venda
     */
    public void setTotalFacturacaoFilial3(int mes,double totalFacturacaoFilial3) {
        this.totalFacturacaoFilial3[mes] = totalFacturacaoFilial3;
    }

    /**
     * Insere total facturado mensalmente 
     *
     * @param mes mes da compra/venda
     * @param totalFacturacao valor da compra/venda
     */
    public void setTotalFacturacaoMensal(int mes,double totalFacturacao) {
        this.totalFacturacaoMensal[mes] = totalFacturacao;
    }

    /**
     * Insere numero de compradores distintos mensais
     *
     * @param mes mes da compra/venda
     * @param clientesDistintos número de clientes distintos
     */
    public void setClientesDistintos(int mes,int clientesDistintos) {
        this.clientesDistintos[mes] = clientesDistintos;
    }
    
    /**
     * Método clone
     * @return Uma nova instância de Estatistica
     * @throws java.lang.CloneNotSupportedException
     */
    @Override
    public Estatistica clone() throws CloneNotSupportedException {
        return new Estatistica(this);
    }
    
     /**
     * 
     * @return String representativa dos dados da classe
     */
    @Override
    public String toString() {
        
        StringBuilder s = new StringBuilder();
        s.append("Ficheiro lido: ");
        s.append(getFicheiroVendas());
        s.append("\n");
        s.append("Total de registos errados: ");
        s.append(getTotalRegistosErrados());
        s.append("\n");
        s.append("Total de produtos:");
        s.append(getTotalProdutos());
        s.append("\n");        
        s.append("Total de produtos comprados:");
        s.append(getTotalProdutosDiferentes());
        s.append("\n");
        s.append("Total de produtos não comprados:");
        s.append(getTotalNaoComprados());
        s.append("\n");
        s.append("Total de clientes:");
        s.append(getTotalClientes());
        s.append("\n");
        s.append("Total de clientes que realizaram compras:");
        s.append(getTotalClientesCompradores());
        s.append("\n");
        s.append("Total de clientes que não realizaram compras:");
        s.append(getTotalClientesNaoCompradores());
        s.append("\n");
        s.append("Total de compras de valor zero:");
        s.append(getTotalComprasZero());
        s.append("\n");
        s.append("Total de faturação:");
        s.append(getTotalFacturacao());
        s.append("\n");
        s.append("Número de Compras Mensal: \n");
        for(int i=0;i<12;i++){
            s.append(this.getTotalComprasMes()[i]).append(" ");
        }
        s.append("\n");
        s.append("Clientes Compradores em cada Mês: \n");
        for(int i=0;i<12;i++){
            s.append(this.getClientesDistintos()[i]).append(" ");
        }
        s.append("\n");
        s.append("Facturação Mensal Filial 1: \n");
        for(int i=0;i<12;i++){
            s.append(this.getTotalFacturacaoFilial1()[i]).append(" ");
        }
        s.append("\n");
        s.append("Facturação Mensal Filial 2: \n");
        for(int i=0;i<12;i++){
            s.append(this.getTotalFacturacaoFilial2()[i]).append(" ");
        }
         s.append("\n");
        s.append("Facturação Mensal Filial 3: \n");
        for(int i=0;i<12;i++){
            s.append(this.getTotalFacturacaoFilial3()[i]).append(" ");
        }
         s.append("\n");
        s.append("Facturação Mensal global: \n");
        for(int i=0;i<12;i++){
            s.append(this.getTotalFacturacaoMensal()[i]).append(" ");
        }
        s.append("\n");
        return s.toString();
    }
  
    /**
     * Método hashcode
     * @return valor de hash
     */
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.ficheiroVendas);
        hash = 29 * hash + this.totalRegistosErrados;
        hash = 29 * hash + this.totalProdutos;
        hash = 29 * hash + this.totalProdutosDiferentes;
        hash = 29 * hash + this.totalNaoComprados;
        hash = 29 * hash + this.totalClientes;
        hash = 29 * hash + this.totalClientesCompradores;
        hash = 29 * hash + this.totalClientesNaoCompradores;
        hash = 29 * hash + this.totalComprasZero;
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.totalFacturacao) ^ (Double.doubleToLongBits(this.totalFacturacao) >>> 32));
        hash = 29 * hash + Arrays.hashCode(this.totalComprasMes);
        hash = 29 * hash + Arrays.hashCode(this.totalFacturacaoFilial1);
        hash = 29 * hash + Arrays.hashCode(this.totalFacturacaoFilial2);
        hash = 29 * hash + Arrays.hashCode(this.totalFacturacaoFilial3);
        hash = 29 * hash + Arrays.hashCode(this.totalFacturacaoMensal);
        hash = 29 * hash + Arrays.hashCode(this.clientesDistintos);
        return hash;
    }
    
    

    /**
     * Teste de igualdade da instância actual com o parâmetro 
     * @param obj Objecto a ser testado
     * @return Igualdade entre a instância actual e o parâmetro obj
     */

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estatistica other = (Estatistica) obj;
        if (!Objects.equals(this.ficheiroVendas, other.ficheiroVendas)) {
            return false;
        }
        if (this.totalRegistosErrados != other.totalRegistosErrados) {
            return false;
        }
        if (this.totalProdutos != other.totalProdutos) {
            return false;
        }
        if (this.totalProdutosDiferentes != other.totalProdutosDiferentes) {
            return false;
        }
        if (this.totalNaoComprados != other.totalNaoComprados) {
            return false;
        }
        if (this.totalClientes != other.totalClientes) {
            return false;
        }
        if (this.totalClientesCompradores != other.totalClientesCompradores) {
            return false;
        }
        if (this.totalClientesNaoCompradores != other.totalClientesNaoCompradores) {
            return false;
        }
        if (this.totalComprasZero != other.totalComprasZero) {
            return false;
        }
        if (Double.doubleToLongBits(this.totalFacturacao) != Double.doubleToLongBits(other.totalFacturacao)) {
            return false;
        }
        if (!Arrays.equals(this.totalComprasMes, other.totalComprasMes)) {
            return false;
        }
        if (!Arrays.equals(this.totalFacturacaoFilial1, other.totalFacturacaoFilial1)) {
            return false;
        }
        if (!Arrays.equals(this.totalFacturacaoFilial2, other.totalFacturacaoFilial2)) {
            return false;
        }
        if (!Arrays.equals(this.totalFacturacaoFilial3, other.totalFacturacaoFilial3)) {
            return false;
        }
        if (!Arrays.equals(this.totalFacturacaoMensal, other.totalFacturacaoMensal)) {
            return false;
        }
        if (!Arrays.equals(this.clientesDistintos, other.clientesDistintos)) {
            return false;
        }
        return true;
    }

}
