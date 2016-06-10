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
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe InfoCliente
 *
 * @author Rui Machado, Jose Lima, Jose Mirra, Joao Miranda
 */
public class InfoCliente implements Serializable {
    
    private Map<Produto, InfoProdutoComprado> clienteCompras; // Cada cliente tem os seus produtos
    private int[] totalgasto;
    private int[] comprasMesN;
    private int[] comprasMesP;

    /**
     * Construtor Vazio
     */
    public InfoCliente(){
        this.clienteCompras=new TreeMap<>(new ComparatorCodigoProduto());
        this.comprasMesN=new int[12];
        this.comprasMesP=new int[12];
        this.totalgasto=new int[12];
    }
    
     /**
     * Construtor Parametrizado
     * @param clienteCompras Map clienteCompras    
     * @param compraN compras normais
     * @param compraP compras promocao
     * @param tg total gasto
     */
    public InfoCliente(TreeMap<Produto, InfoProdutoComprado> clienteCompras, int[] compraN,int[] compraP,int[] tg) {
        this.clienteCompras = clienteCompras;
        this.comprasMesN=compraN.clone();
        this.comprasMesP=compraP.clone();
        this.totalgasto=tg.clone();

    }
    
    /**
     * Construtor de Cópia
     * @param ic Objecto a ser Copiado
     * @throws java.lang.CloneNotSupportedException
     */
    public InfoCliente(InfoCliente ic) throws CloneNotSupportedException{
        this.clienteCompras=ic.getClienteCompras();
        this.comprasMesN=ic.getComprasMesN();
        this.comprasMesP=ic.getComprasMesP();
        this.totalgasto=ic.getTotalgasto();
    }
    
    
    /**
     * Retorna total de produtos comprados em determinado mes
     * @param mes Mes a ser utilizado na procura
     * @return total de produtos comprados em determinado mes
     */
     public int getProdutosCliente(int mes) {
         int r = 0;
         for(InfoProdutoComprado ipc : clienteCompras.values()){
         
             if(ipc.totalComprasMes(mes)!=0) r++;
         
         }
        return r;
    }

    /**
     * 
     * @return Compras em modo N
     */
    public int[] getComprasMesN() {
        return comprasMesN.clone();
    }

    /**
     * 
     * @return Compras em Modo P
     */
    public int[] getComprasMesP() {
        return comprasMesP.clone();
    }
  

    /**
     * 
     * @return Map de clienteCompras
     * @throws java.lang.CloneNotSupportedException
     */
    public TreeMap<Produto, InfoProdutoComprado> getClienteCompras() throws CloneNotSupportedException {
        
    TreeMap<Produto,InfoProdutoComprado> res = new TreeMap<>();
         clienteCompras.forEach( (k,v) ->  {
        try {
            res.put(k.clone(), v.clone());
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(InfoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    });
        return res;
    }

   /**
     * Calcula Numero de compras em determinada mês, modo Normal
     * @param i Mês Para efectuar a pesquisa
     * @return Numero de compras em determinada mês
     */
    
    public int getComprasMesNindice(int i) {
        return comprasMesN[i-1];
    }
    
   /**
     * Calcula Numero de compras em determinada mês, modo Promocao
     * @param i Mês Para efectuar a pesquisa
     * @return Numero de compras em determinada mês
     */
    
     public int getComprasMesPindice(int i) {
        return comprasMesP[i-1];
    }

   /**
     * Calcula total gasto em determinado mes
     * @param mes Mês Para efectuar a pesquisa
     * @return total gasto em determinado mes
     */
    
    public int getTotalgasto(int mes) {
        return totalgasto[mes-1];
    }
    
    /**
     *  * @return total gasto 
     */
    
   private int[] getTotalgasto() {
    return totalgasto.clone();
   }

    /**
     * Calcula lista com produto e unidades vendidas 
     * @return Lista com ParCliProdsComprados
     */
     
    
    public TreeSet<ParCliProdsComprados> getCodigoProduto(){
      TreeSet<ParCliProdsComprados> cod;
      cod = new TreeSet<>(new ComparatorProdutosEQuantidade());
      
      
      clienteCompras.forEach( (k, v) ->  {
          ParCliProdsComprados pcpc=new ParCliProdsComprados();
          pcpc.adicionaTotal(v.getUnidadesVendidas());
          pcpc.adicionaProduto(k.getCodigo());
          try {      
              cod.add(pcpc.clone());
          } catch (CloneNotSupportedException ex) {
              Logger.getLogger(InfoCliente.class.getName()).log(Level.SEVERE, null, ex);
          }
         });

        return cod;
    }
    
    /**
     * Verifica se existe um produto nas compras do cliente
     * @param p Produto a procurar
     * @return True se existe, false em caso contrário
     */
    public boolean existeProduto(Produto p){
        return clienteCompras.containsKey(p);
    }
    
    /**
     * Actualiza compras de cliente
     * @param clienteCompras Cliente compras a actualizar
    */

    public void setClienteCompras(TreeMap<Produto, InfoProdutoComprado> clienteCompras) {
        this.clienteCompras = new TreeMap<>(new ComparatorCodigoProduto());

           clienteCompras.forEach( (k,v) ->  {

                try {
                    this.clienteCompras.put(k.clone(), v.clone());
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(GestaoFilial.class.getName()).log(Level.SEVERE, null, ex);
                }
               });
    }

  
    
    
     /**
     * Adiciona info de cliente
     * @param v Venda onde serão recolhidos os dados
     * @throws java.lang.CloneNotSupportedException
     */
    
      public void adicionaInfo(Venda v) throws CloneNotSupportedException {
        
        String PouN = v.getPouN();
        int mes=v.getMes();
        double preco=v.getPreco();
        int quantidade=v.getQuantidade();
        if(PouN.equals("N")){
            comprasMesN[mes-1]++;
        }else{
            comprasMesP[mes-1]++;
        }
       totalgasto[mes-1]+=preco*quantidade;
        if(!clienteCompras.containsKey(v.getProduto())){
           this.clienteCompras.put(v.getProduto().clone(),new InfoProdutoComprado());
        }
         this.clienteCompras.get(v.getProduto()).adicionaInfoProduto(preco,quantidade,mes,PouN);
       
        
    }
    
    /**
     * Calcula compradores distintos num dado mês, para um dado produto
     * @param mes Mês a procurar
     * @param p Produto a procurar
     * @return compradores distintos num dado mês, para um dado produto
     */
    public int calculaDistintos(int mes,Produto p) {
        int r=0;
        if(clienteCompras.containsKey(p)){
            
            InfoProdutoComprado ipc;
            ipc = clienteCompras.get(p);
            if(ipc.totalComprasMes(mes)!=0) r++; 
        }
        return r;
    }

    /**
     * @return Numero de compras 
     */
    public int quantidadeDeProdDistintos(){
        return clienteCompras.size();
    }   
    
    /**
     * Calcula dinheiro gasto num dado produto
     * @param p Produto a procurar
     * @return Dinheiro gasto num dado produto
     */
    public int gastoNoProduto(Produto p){
    
        int gasto;
        
        gasto=(int)clienteCompras.get(p).getTotalPago();
        return gasto;
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
        final InfoCliente other = (InfoCliente) obj;
        if (!Objects.equals(this.clienteCompras, other.clienteCompras)) {
            return false;
        }
        if (!Arrays.equals(this.totalgasto, other.totalgasto)) {
            return false;
        }
        if (!Arrays.equals(this.comprasMesN, other.comprasMesN)) {
            return false;
        }
        if (!Arrays.equals(this.comprasMesP, other.comprasMesP)) {
            return false;
        }
        return true;
    }
    
    /**
     *
     * @return Novo Objecto como cópia da instância Actual
     * @throws java.lang.CloneNotSupportedException
     */
    @Override
    public InfoCliente clone() throws CloneNotSupportedException {
        return new InfoCliente(this);
    }

   
   
  
}
