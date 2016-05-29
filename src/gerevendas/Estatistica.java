/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

/**
 *
 * @author Rui
 */


/*1.1.- Apresenta ao utilizador os dados referentes ao último ficheiro de vendas lido,
designadamente, nome do ficheiro, número total de registos de venda errados,
número total de produtos, total de diferentes produtos comprados, total de não
comprados, número total de clientes e total dos que realizaram compras, total de
clientes que nada compraram, total de compras de valor total igual a 0.0 e
facturação total.
1.2.- Apresenta em ecrã ao utilizador os números gerais respeitantes aos dados
actuais já registados nas estruturas, designadamente:
· Número total de compras por mês (não é a facturação);
· Facturação total por mês (valor total das compras/vendas) para cada filial e
o valor total global;
· Número de distintos clientes que compraram em cada mês (não interessa
quantas vezes o cliente comprou mas apenas quem de facto comprou);*/
public class Estatistica {
    
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
        this.totalComprasMes = totalComprasMes;
        this.totalFacturacaoFilial1 = totalFacturacaoFilial1;
        this.totalFacturacaoFilial2 = totalFacturacaoFilial2;
        this.totalFacturacaoFilial3 = totalFacturacaoFilial3;
        this.totalFacturacaoMensal = totalFacturacaoMensal;
        this.clientesDistintos = clientesDistintos;
    }
    
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

    public String getFicheiroVendas() {
        return ficheiroVendas;
    }

    public int getTotalRegistosErrados() {
        return totalRegistosErrados;
    }

    public int getTotalProdutos() {
        return totalProdutos;
    }

    public int getTotalProdutosDiferentes() {
        return totalProdutosDiferentes;
    }

    public int getTotalNaoComprados() {
        return totalNaoComprados;
    }

    public int getTotalClientes() {
        return totalClientes;
    }

    public int getTotalClientesCompradores() {
        return totalClientesCompradores;
    }

    public int getTotalClientesNaoCompradores() {
        return totalClientesNaoCompradores;
    }

    public int getTotalComprasZero() {
        return totalComprasZero;
    }

    public double getTotalFacturacao() {
        return totalFacturacao;
    }

    public int[] getTotalComprasMes() {
        return totalComprasMes.clone();
    }

    public double[] getTotalFacturacaoFilial1() {
        return totalFacturacaoFilial1.clone();
    }

    public double[] getTotalFacturacaoFilial2() {
        return totalFacturacaoFilial2.clone();
    }

    public double[] getTotalFacturacaoFilial3() {
        return totalFacturacaoFilial3.clone();
    }

    public double[] getTotalFacturacaoMensal() {
        return totalFacturacaoMensal.clone();
    }

    public int[] getClientesDistintos() {
        return clientesDistintos.clone();
    }

    public void setFicheiroVendas(String ficheiroVendas) {
        this.ficheiroVendas = ficheiroVendas;
    }

    public void setTotalRegistosErrados(int totalRegistosErrados) {
        this.totalRegistosErrados = totalRegistosErrados;
    }

    public void setTotalProdutos(int totalProdutos) {
        this.totalProdutos = totalProdutos;
    }

    public void setTotalProdutosDiferentes(int totalProdutosDiferentes) {
        this.totalProdutosDiferentes = totalProdutosDiferentes;
    }

    public void setTotalNaoComprados(int totalNaoComprados) {
        this.totalNaoComprados = totalNaoComprados;
    }

    public void setTotalClientes(int totalClientes) {
        this.totalClientes = totalClientes;
    }

    public void setTotalClientesCompradores(int totalClientesCompradores) {
        this.totalClientesCompradores = totalClientesCompradores;
    }

    public void setTotalClientesNaoCompradores(int totalClientesNaoCompradores) {
        this.totalClientesNaoCompradores = totalClientesNaoCompradores;
    }

    public void setTotalComprasZero(int totalComprasZero) {
        this.totalComprasZero = totalComprasZero;
    }

    public void setTotalFacturacao(double totalFacturacao) {
        this.totalFacturacao = totalFacturacao;
    }

    public void setTotalComprasMes(int mes,int total) {
        this.totalComprasMes[mes] = total;
    }

    public void setTotalFacturacaoFilial1(int mes,double totalFacturacaoFilial1) {
        this.totalFacturacaoFilial1[mes] = totalFacturacaoFilial1;
    }

    public void setTotalFacturacaoFilial2(int mes,double totalFacturacaoFilial2) {
        this.totalFacturacaoFilial2[mes] = totalFacturacaoFilial2;
    }

    public void setTotalFacturacaoFilial3(int mes,double totalFacturacaoFilial3) {
        this.totalFacturacaoFilial3[mes] = totalFacturacaoFilial3;
    }

    public void setTotalFacturacaoMensal(int mes,double totalFacturacao) {
        this.totalFacturacaoMensal[mes] = totalFacturacao;
    }

    public void setClientesDistintos(int mes,int clientesDistintos) {
        this.clientesDistintos[mes] = clientesDistintos;
    }
    
    public Estatistica clone() {
        return new Estatistica(this);
    }
    
    @Override
    public String toString() {
        
        StringBuilder s = new StringBuilder();
        s.append("Ficheiro lido: ");
        s.append(getFicheiroVendas());
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
        s.append("Faturação Mensal: \n");
        for(int i=0;i<12;i++){
            s.append(this.getTotalFacturacaoMensal()[i]).append(" ");
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
    
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if ((o == null) || (this.getClass() != o.getClass())) {
            return false;
        }
        Estatistica a = (Estatistica) o;

        return (this.totalClientes == a.getTotalClientes()&& this.totalProdutos == a.getTotalProdutos());
    }

    

    
    
    
    
    

}
