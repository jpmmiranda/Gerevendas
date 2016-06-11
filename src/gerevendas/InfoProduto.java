/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe InfoProduto
 *
 * @author Rui Machado, Jose Lima, Jose Mirra, Joao Miranda
 */
public class InfoProduto implements Serializable{
     
   private Map<Produto, InfoProdutoComprado> produtoCompras;
   private int UnidadesVendidas;
   private int compradoMes[];
   private double TotalPagoMes[];

   /**
     * Construtor Vazio
     */
    public InfoProduto(){
    this.produtoCompras=new TreeMap<>(new ComparatorCodigoProduto());
    this.UnidadesVendidas = 0;
    this.TotalPagoMes =new double [12];
    this.compradoMes = new int[12];

    }
   /**
     * Construtor Parametrizado
     * @param produtoCompras  Map produto compras 
     * @param UnidadesVendidas  Unidades vendidas 
     * @param TotalPagoMes  Total pago mensalmente
     * @param compradoMes  Unidades compradas mensalmente
     */
    public InfoProduto(TreeMap<Produto, InfoProdutoComprado> produtoCompras,int UnidadesVendidas,double[] TotalPagoMes,int[] compradoMes) {
        this.produtoCompras=produtoCompras;
        this.UnidadesVendidas = UnidadesVendidas;
        this.TotalPagoMes = TotalPagoMes.clone();
        this.compradoMes =compradoMes.clone();
    }
    
     /**
     * Construtor de Cópia
     * @param ip Objecto a ser Copiado
     * @throws java.lang.CloneNotSupportedException
     */
     public InfoProduto(InfoProduto ip) throws CloneNotSupportedException{
        this.produtoCompras=ip.getProdutoCompras();
        this.UnidadesVendidas=ip.getUnidadesVendidas();
        this.TotalPagoMes=ip.getTotalPagoMes();
        this.compradoMes=ip.getCompradoMes();
        
        
    }
     
    /**
     *
     * @return Map de produtoCompras
     * @throws java.lang.CloneNotSupportedException
     */
    public TreeMap<Produto, InfoProdutoComprado> getProdutoCompras() throws CloneNotSupportedException {
        
    TreeMap<Produto,InfoProdutoComprado> res = new TreeMap<>();
         produtoCompras.forEach( (k,v) ->  {
        try {
            res.put(k.clone(), v.clone());
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(InfoProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    });
        return res;
    }

    /**
     * 
     * @return Unidades Vendidas
     */
    public int getUnidadesVendidas() {
        return UnidadesVendidas;
    }

    /**
     * 
     * @return Total pago
     */
     public  double[] getTotalPagoMes() {
        return TotalPagoMes.clone();
    }
     
     /**
     * 
     * @param i Mês
     * @return Total pago num dado mes
     */
     public double getTotalPagoMesIndice(int i) {
        return TotalPagoMes[i-1];
    }
    
     /**
     * 
     * @return Total vendas 
     */
    public  int[] getCompradoMes(){
        return compradoMes.clone();
    }
    
    /**
     * 
     * @param i Mês
     * @return Total vendas num dado mes
     */
    public int getCompradoMesIndice(int i){
        return compradoMes[i-1];
    }

     /**
     * Adiciona info de produto
     * @param preco Preco da venda
     * @param quant Quantidade vendida
     * @param mes Mes em que foi vendido
     */
   public  void adicionaInfoProduto(double preco, int quant,int mes) {
        UnidadesVendidas++;
        compradoMes[mes-1]+=quant;
        TotalPagoMes[mes-1]+=preco*quant;
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
        final InfoProduto other = (InfoProduto) obj;
        if (!Objects.equals(this.produtoCompras, other.produtoCompras)) {
            return false;
        }
        if (this.UnidadesVendidas != other.UnidadesVendidas) {
            return false;
        }
       
        if (!Arrays.equals(this.compradoMes, other.compradoMes)) {
            return false;
        }
        if (!Arrays.equals(this.TotalPagoMes, other.TotalPagoMes)) {
            return false;
        }
        return true;
    }
    
    /**
     * Método hashcode
     * @return valor de hash
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.produtoCompras);
        hash = 47 * hash + this.UnidadesVendidas;
        hash = 47 * hash + Arrays.hashCode(this.compradoMes);
        hash = 47 * hash + Arrays.hashCode(this.TotalPagoMes);
        return hash;
    }

    /**
     *
     * @return Novo Objecto como cópia da instância Actual
     * @throws java.lang.CloneNotSupportedException
     */
    @Override
    public InfoProduto clone() throws CloneNotSupportedException {
        return new InfoProduto(this);
    }
   
    
   
   
}
