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
public class InfoProdutoFacturacao {
    
    
   int totalVendidas; /* Total de unidades vendidas de cada produto*/
   int[][] unidadesVendidas; /* Unidades vendidas cada mes de cada tipo*/
   double[][] faturado; /*valor de cada mes e tipo*/
   double[][] totalFaturado; /*preco*quant*/
   double[][] totalFatFilial1;
   double[][] totalFatFilial2;
   double[][] totalFatFilial3;
   int[][] totalUniFilial1;
   int[][] totalUniFilial2;
   int[][] totalUniFilial3;

   
   /*Construtores*/
     
    public InfoProdutoFacturacao() {
        
        this.totalVendidas = 0;
        this.unidadesVendidas =new int[12][2];
        this.faturado = new double[12][2];
        this.totalFaturado = new double[12][2];
        this.totalFatFilial1 = new double[12][2];
        this.totalFatFilial2 = new double[12][2];
        this.totalFatFilial3 = new double[12][2];
        this.totalUniFilial1 = new int[12][2];
        this.totalUniFilial2 = new int[12][2];
        this.totalUniFilial3 = new int[12][2];
        

    }
    
    public InfoProdutoFacturacao(int totalVendidas, int[][] unidadesVendidas, double[][] faturado, double[][] totalFaturado, double[][] totalFatFilial1, double[][] totalFatFilial2, double[][] totalFatFilial3, int[][] totalUniFilial1, int[][] totalUniFilial2, int[][] totalUniFilial3) {
        
        this.totalVendidas = totalVendidas;
        this.unidadesVendidas = unidadesVendidas;
        this.faturado = faturado;
        this.totalFaturado = totalFaturado;
        this.totalFatFilial1 = totalFatFilial1;
        this.totalFatFilial2 = totalFatFilial2;
        this.totalFatFilial3 = totalFatFilial3;
        this.totalUniFilial1 = totalUniFilial1;
        this.totalUniFilial2 = totalUniFilial2;
        this.totalUniFilial3 = totalUniFilial3;
        
    }
   
   
    public InfoProdutoFacturacao(InfoProdutoFacturacao ipf) {
        this.totalVendidas = ipf.getTotalVendidas();
        this.totalFaturado = ipf.getTotalFaturado();
        this.faturado = ipf.getFaturado();
        this.totalFatFilial1 = ipf.getTotalFatFilial1();
        this.totalFatFilial2 = ipf.getTotalFatFilial2();
        this.totalFatFilial3 = ipf.getTotalFatFilial3();
        this.totalUniFilial1 = ipf.getTotalUniFilial1();
        this.totalUniFilial2 = ipf.getTotalUniFilial2();
        this.totalUniFilial3 = ipf.getTotalUniFilial3();

                
    }
    
    
    
    /*Getters*/
    
    public int getTotalVendidas() {
        return totalVendidas;
    }

    public int[][] getUnidadesVendidas() {
        return unidadesVendidas.clone();
    }

    public double[][] getFaturado() {
        return faturado.clone();
    }

    public double[][] getTotalFaturado() {
        return totalFaturado.clone();
    }

    public double[][] getTotalFatFilial1() {
        return totalFatFilial1.clone();
    }

    public double[][] getTotalFatFilial2() {
        return totalFatFilial2.clone();
    }

    public double[][] getTotalFatFilial3() {
        return totalFatFilial3.clone();
    }

    public int[][] getTotalUniFilial1() {
        return totalUniFilial1.clone();
    }

    public int[][] getTotalUniFilial2() {
        return totalUniFilial2.clone();
    }

    public int[][] getTotalUniFilial3() {
        return totalUniFilial3.clone();
    }
    
        /*Setters*/

    public void setTotalVendidas(int totalVendidas) {
        this.totalVendidas = totalVendidas;
    }

    public void setUnidadesVendidas(int[][] unidadesVendidas) {
        this.unidadesVendidas = unidadesVendidas.clone();
    }

    public void setFaturado(double[][] faturado) {
        this.faturado = faturado.clone();
    }

    public void setTotalFaturado(double[][] totalFaturado) {
        this.totalFaturado = totalFaturado.clone();
    }

    public void setTotalFatFilial1(double[][] totalFatFilial1) {
        this.totalFatFilial1 = totalFatFilial1.clone();
    }

    public void setTotalFatFilial2(double[][] totalFatFilial2) {
        this.totalFatFilial2 = totalFatFilial2.clone();
    }

    public void setTotalFatFilial3(double[][] totalFatFilial3) {
        this.totalFatFilial3 = totalFatFilial3.clone();
    }

    public void setTotalUniFilial1(int[][] totalUniFilial1) {
        this.totalUniFilial1 = totalUniFilial1.clone();
    }

    public void setTotalUniFilial2(int[][] totalUniFilial2) {
        this.totalUniFilial2 = totalUniFilial2.clone();
    }

    public void setTotalUniFilial3(int[][] totalUniFilial3) {
        this.totalUniFilial3 = totalUniFilial3.clone();
    }

    
    void alteraInfo(Venda ven) {
        
    }
    
     @Override
    public InfoProdutoFacturacao clone() throws CloneNotSupportedException {
        return new InfoProdutoFacturacao(this);
    }

    void incrementaTotalVendidas(int quantidade) {
        this.totalVendidas+=quantidade;
    }

    void incrementaUnidadesVendidas(String PouN, int mes, int quantidade) {
        if(PouN.equals("N")){
            
            this.unidadesVendidas[mes-1][0]+=quantidade;
        }else{
            this.unidadesVendidas[mes-1][1]+=quantidade;

        }
    }

    void incrementaFaturado(String PouN, int mes, double preco) {
            if(PouN.equals("N")){

                       this.faturado[mes-1][0]+=preco;
                   }else{
                       this.faturado[mes-1][1]+=preco;

                   }
    
    }

    void incrementaTotalFaturado(String PouN, int mes, double preco,int quantidade) {
        
         if(PouN.equals("N")){

                       this.totalFaturado[mes-1][0]+=preco*quantidade;
        }else{
                       this.totalFaturado[mes-1][1]+=preco*quantidade;

                   }
        
    }

    void incrementaTotaisFilial(String PouN, int mes, double preco, int quantidade, int filial) {

        if(PouN.equals("N")){
            if(filial==1){
            
                 this.totalFatFilial1[mes-1][0]+=preco*quantidade;
                 this.totalUniFilial1[mes-1][0]+=quantidade;
                 
            }else if(filial==2){
                
                 this.totalFatFilial2[mes-1][0]+=preco*quantidade;
                 this.totalUniFilial2[mes-1][0]+=quantidade;
            
            
            }else{
                 this.totalFatFilial3[mes-1][0]+=preco*quantidade;
                 this.totalUniFilial3[mes-1][0]+=quantidade;
            }
        }else{
            if(filial==1){
            
                 this.totalFatFilial1[mes-1][1]+=preco*quantidade;
                 this.totalUniFilial1[mes-1][1]+=quantidade;
                 
            }else if(filial==2){
                
                 this.totalFatFilial2[mes-1][1]+=preco*quantidade;
                 this.totalUniFilial2[mes-1][1]+=quantidade;
            
            
            }else{
                 this.totalFatFilial3[mes-1][1]+=preco*quantidade;
                 this.totalUniFilial3[mes-1][1]+=quantidade;
            }
        }
    }

}