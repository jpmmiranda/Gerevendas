/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Rui
 */
public class GestaoFilial {
    
    private HashMap<Cliente,InfoCliente> comprasDoCliente;
    private HashMap<Produto,InfoProduto> comprasDeProduto; // NAo sei se sera necessario!!!
    //int clientesDistintos[][]
    private HashMap<Cliente,Double> compradoresFilial1;
    private HashMap<Cliente,Double> compradoresFilial2;
    private HashMap<Cliente,Double> compradoresFilial3;
    
    
    
    /*Construtor*/
    public GestaoFilial() {
        this.comprasDoCliente = new HashMap<>();
        this.comprasDeProduto = new HashMap<>();
        this.compradoresFilial1=new HashMap<>();
        this.compradoresFilial2=new HashMap<>();
        this.compradoresFilial3=new HashMap<>();

    }
    
    
    public GestaoFilial(HashMap<Cliente, InfoCliente> comprasDoCliente, HashMap<Produto, InfoProduto> comprasDeProduto) {
        this.comprasDoCliente = comprasDoCliente;
        this.comprasDeProduto = comprasDeProduto;
    }

     public GestaoFilial(GestaoFilial gf) {
        this.comprasDoCliente = gf.getComprasDoCliente();
        this.comprasDeProduto = gf.getComprasDeProduto();
    }

    /*Getters*/
    public HashMap<Cliente,InfoCliente> getComprasDoCliente() {
        return comprasDoCliente;
    }

    public HashMap<Produto,InfoProduto> getComprasDeProduto() {
        return comprasDeProduto;
    }
     
    /*Setters*/

    public void setComprasDoCliente(HashMap<Cliente,InfoCliente> comprasDoCliente) {
        this.comprasDoCliente = comprasDoCliente;
    }

    public void setComprasDeProduto(HashMap<Produto,InfoProduto> comprasDeProduto) {
        this.comprasDeProduto = comprasDeProduto;
    }
    
     /* Métodos */
    
    
    void adicionaComprasCliente(Venda v) throws CloneNotSupportedException {
      
      int filial = v.getFilial();
      double d;
      if(filial==1){
             d=this.compradoresFilial1.get(v.getCliente());
             d+=v.getPreco()*v.getQuantidade();
      }else if(filial==2){
          d=this.compradoresFilial2.get(v.getCliente());
              d+=v.getPreco()*v.getQuantidade();
      } else{
             d=this.compradoresFilial3.get(v.getCliente());
             d+=v.getPreco()*v.getQuantidade();
      }
          
      this.comprasDoCliente.get(v.getCliente()).adicionaInfo(v.clone());
                    
    }
    
    
    
    void adicionaClienteInicial(Cliente cli) throws CloneNotSupportedException{
        InfoCliente ic = new InfoCliente();
        this.comprasDoCliente.put(cli.clone(), ic);
        this.compradoresFilial1.put(cli.clone(), 0.0);
        this.compradoresFilial2.put(cli.clone(), 0.0);
        this.compradoresFilial3.put(cli.clone(), 0.0);

    }

    void adicionaProdutoInicial(Produto pro) {
        InfoProduto ip = new InfoProduto();
        this.comprasDeProduto.put(pro.clone(), ip);
    }
    
    void adicionaComprasDeProduto(Venda v) throws CloneNotSupportedException {
       
        //if(comprasDeProduto.containsKey(v.getProduto())){
        
        
      //  if(!this.comprasDoCliente.get(c).existeProduto(p))
     

        
        double preco=v.getPreco();
        int quantidade=v.getQuantidade();
        int mes = v.getMes();
        this.comprasDeProduto.get(v.getProduto()).adicionaInfoProduto(preco,quantidade,mes);

        //}
    }
    
    public int getTotalDeClientesCompradores(){
    
        return comprasDoCliente.size();
    }
    
       
    public int getTotalProdutosDiferentesComprados(){
        int r=0;
        
        for(InfoProduto ip : comprasDeProduto.values()){
            if(ip.getUnidadesVendidas()!=0) r++;
        }
        return r;
    }
    
    /*--------------------------- Metodos de apoio a Queries -----------------*/
    
    /* Querie 1*/
    
    public ArrayList getProdutosNaoComprados (){
        ArrayList <String> Produtos = new ArrayList<>();
        for (Map.Entry<Produto, InfoProduto> ip : comprasDeProduto.entrySet()){
            if (ip.getValue().getUnidadesVendidas()==0){
                Produtos.add(ip.getKey().getCodigo());
            }
        }
        return Produtos;
    }
    
    
    
    
    
    
    
    
    /* Querie 2*/
    
      public int getClientesMes(int mes){
        int totClientes=0;
        for(InfoCliente ic:comprasDoCliente.values()){
            if(ic.getComprasMesNindice(mes)!=0 ||ic.getComprasMesPindice(mes)!=0 ){
                totClientes++;
            }
        }
        
        return totClientes;
    }
    
    /*Querie 3*/
      
    public TrioComProFat getClienteParaCadaMes(Cliente c){
    
            int mes,comprasCliente=0;
            TrioComProFat tab = new TrioComProFat();
            InfoCliente ic = this.comprasDoCliente.get(c);
            for (mes = 1; mes <= 12; mes++) {
                comprasCliente=ic.getComprasMesNindice(mes)+ic.getComprasMesNindice(mes);
                tab.adicionaDistintos(ic.getProdutosCliente(mes), mes);
                tab.adicionaFaturacao(ic.getTotalgasto(mes), mes);
                tab.adicionaCompras(comprasCliente, mes);
            }
            return tab.clone();
        }
      
     /*Querie 4*/
      
    public TrioComProFat getProdutoParaCadaMes(Produto p){
    
            int mes,comprasProduto=0;
            TrioComProFat tab = new TrioComProFat();
            InfoProduto ip = this.comprasDeProduto.get(p);
            for (mes = 1; mes <= 12; mes++) {
                comprasProduto=ip.getCompradoMesIndice(mes);
                tab.adicionaClientesDistintos(ip.getProdutosCliente(mes), mes);
                tab.adicionaFaturacao((float) ip.getTotalPagoMesIndice(mes), mes);
                tab.adicionaCompras(comprasProduto, mes);
            }
            return tab.clone();
        }
    
    
     public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if ((o == null) || (this.getClass() != o.getClass())) {
            return false;
        }
        final GestaoFilial other = (GestaoFilial) o;
        return this.comprasDoCliente.keySet().containsAll(other.comprasDoCliente.keySet())
                && this.comprasDoCliente.values().containsAll(other.comprasDoCliente.values())
                && this.comprasDeProduto.keySet().containsAll(other.comprasDeProduto.keySet())
                && this.comprasDeProduto.values().containsAll(other.comprasDeProduto.values());
      }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.comprasDoCliente);
        hash = 97 * hash + Objects.hashCode(this.comprasDeProduto);
        return hash;
    }
     
    @Override
    public GestaoFilial clone() throws CloneNotSupportedException {
        return new GestaoFilial(this);
    }


  
    
}
