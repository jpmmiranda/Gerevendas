/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.TreeSet;

/**
 *
 * @author Rui
 */
public class GestaoFilial implements Serializable {
    
    private HashMap<Cliente,InfoCliente> comprasDoCliente;
    private HashMap<Produto,InfoProduto> comprasDeProduto;
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
    
    
    public GestaoFilial(HashMap<Cliente, InfoCliente> comprasDoCliente, HashMap<Produto, InfoProduto> comprasDeProduto,HashMap<Cliente, Double> compras1,HashMap<Cliente, Double> compras2,HashMap<Cliente, Double> compras3) {
        this.comprasDoCliente = comprasDoCliente;
        this.comprasDeProduto = comprasDeProduto;
        this.compradoresFilial1=compras1;
        this.compradoresFilial2=compras2;
        this.compradoresFilial3=compras3;
    }

     public GestaoFilial(GestaoFilial gf) {
        this.comprasDoCliente = gf.getComprasDoCliente();
        this.comprasDeProduto = gf.getComprasDeProduto();
        this.compradoresFilial1=gf.getCompradoresFilial1();
        this.compradoresFilial2=gf.getCompradoresFilial2();
        this.compradoresFilial3=gf.getCompradoresFilial3();
    }

    /*Getters*/
    public HashMap<Cliente,InfoCliente> getComprasDoCliente() {
        return comprasDoCliente;
    }

    public HashMap<Produto,InfoProduto> getComprasDeProduto() {
        return comprasDeProduto;
    }
  
    private HashMap<Cliente, Double> getCompradoresFilial1() {
        return compradoresFilial1;
    }

    private HashMap<Cliente, Double> getCompradoresFilial2() {
        return compradoresFilial2;
    }

    private HashMap<Cliente, Double> getCompradoresFilial3() {
        return compradoresFilial3;
    }

    /*Setters*/

    public void setComprasDoCliente(HashMap<Cliente,InfoCliente> comprasDoCliente) {
        this.comprasDoCliente = comprasDoCliente;
    }

    public void setComprasDeProduto(HashMap<Produto,InfoProduto> comprasDeProduto) {
        this.comprasDeProduto = comprasDeProduto;
    }
    

    public void setCompradoresFilial1(HashMap<Cliente, Double> compradoresFilial1) {
        this.compradoresFilial1 = compradoresFilial1;
    }

    public void setCompradoresFilial2(HashMap<Cliente, Double> compradoresFilial2) {
        this.compradoresFilial2 = compradoresFilial2;
    }

    public void setCompradoresFilial3(HashMap<Cliente, Double> compradoresFilial3) {
        this.compradoresFilial3 = compradoresFilial3;
    }
    
    /* Métodos */

    void adicionaComprasCliente(Venda v) throws CloneNotSupportedException {
      
      int filial = v.getFilial();
      double d;
      if(filial==1){
           
             d=v.getPreco()*v.getQuantidade();
             this.compradoresFilial1.put(v.getCliente().clone(), d);
      }else if(filial==2){
             d=v.getPreco()*v.getQuantidade();
             this.compradoresFilial2.put(v.getCliente().clone(), d);
      } else{
             d=v.getPreco()*v.getQuantidade();
             this.compradoresFilial3.put(v.getCliente().clone(), d);
      }
          
      this.comprasDoCliente.get(v.getCliente()).adicionaInfo(v.clone());
                    
    }
    
    
    
    void adicionaClienteInicial(Cliente cli) throws CloneNotSupportedException{
        InfoCliente ic = new InfoCliente();
        this.comprasDoCliente.put(cli.clone(), ic);
       

    }

    void adicionaProdutoInicial(Produto pro) {
        InfoProduto ip = new InfoProduto();
        this.comprasDeProduto.put(pro.clone(), ip);
    }
    
    void adicionaComprasDeProduto(Venda v) throws CloneNotSupportedException {
       
      
        double preco=v.getPreco();
        int quantidade=v.getQuantidade();
        int mes = v.getMes();
        this.comprasDeProduto.get(v.getProduto()).adicionaInfoProduto(preco,quantidade,mes);

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
    
    
    
    
    public int compradoresMes(int mes) {
        int res=0;
        for (InfoCliente ic : this.comprasDoCliente.values()) {
            
                if (ic.getComprasMesPindice(mes+1)+ic.getComprasMesNindice(mes+1) != 0) {
                    res++;
                }
            }
        
        return res;
    }
    /*--------------------------- Metodos de apoio a Queries -----------------*/
    
    /* Querie 1*/
    
    public ArrayList<String> getProdutosNaoComprados (){
        ArrayList <String> Produtos = new ArrayList<>();
        
         comprasDeProduto.forEach( (k,v) ->  {
            
            if (v.getUnidadesVendidas()==0){
                Produtos.add(k.getCodigo());
            }
           });
        
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
      
    public TrioCliComProFat getClienteParaCadaMes(Cliente c){
    
            int mes,comprasCliente=0;
            TrioCliComProFat tccpf = new TrioCliComProFat();
            InfoCliente ic = this.comprasDoCliente.get(c);
            for (mes = 1; mes <= 12; mes++) {
                comprasCliente=ic.getComprasMesNindice(mes)+ic.getComprasMesPindice(mes);
                tccpf.adicionaDistintos(ic.getProdutosCliente(mes), mes);
                tccpf.adicionaFaturacao(ic.getTotalgasto(mes), mes);
                tccpf.adicionaCompras(comprasCliente, mes);
            }
            return tccpf.clone();
        }
      
     /*Query 4*/
      
    public TrioProdCompCliFat getProdutoParaCadaMes(Produto p){
    
            int mes,comprasProduto=0;
            TrioProdCompCliFat tpccf = new TrioProdCompCliFat();
            InfoProduto ip = this.comprasDeProduto.get(p);
            int r[]=new int [12];
            for(InfoCliente ic : comprasDoCliente.values()){
                for(mes=1;mes<=12;mes++){
                    if(ic.calculaDistintos(mes,p)!=0) r[mes-1]++;
                }
            
            }
            for (mes = 1; mes <= 12; mes++) {
                comprasProduto=ip.getCompradoMesIndice(mes);
                tpccf.adicionaClientesDistintos(r[mes-1], mes);
                tpccf.adicionaFaturacao(ip.getTotalPagoMesIndice(mes), mes);
                tpccf.adicionaCompras(comprasProduto, mes);
            }
            return tpccf.clone();
        }
    
    
    
    /*Query 5 */
    
    public TreeSet<ParCliProdsComprados> listaDeProdutos(Cliente c){
       TreeSet<ParCliProdsComprados> cod;
        InfoCliente ic = comprasDoCliente.get(c);
        cod=(TreeSet<ParCliProdsComprados>) ic.getCodigoProduto().clone();
   
        return cod;
    } 
    
    
    /*Query6*/
    
    public int quantidadeDeCompradores(String pro){
       int r=0;
       InfoCliente ic;
       Produto p = new Produto(pro);
       for(Cliente cli: comprasDoCliente.keySet()){
           ic=comprasDoCliente.get(cli);
           if(ic.existeProduto(p.clone())) r++;
       }
        return r;
    } 
    
    
    
    
    
    /*Querie 7 */
    
    public TreeSet<ParCliProdsComprados> maioresCompradoresFilial1(){
       TreeSet<ParCliProdsComprados> clientes=new TreeSet<>(new ComparatorProdutosEQuantidade());
       
       compradoresFilial1.forEach( (Cliente k,Double v) ->  {
              ParCliProdsComprados pcpc = new ParCliProdsComprados();
                    pcpc.adicionaProduto(k.getCodigo());
                    pcpc.adicionaTotal(v.intValue());
                    clientes.add(pcpc);
            
           });
    
    return clientes;
    } 
    
    
     public TreeSet<ParCliProdsComprados> maioresCompradoresFilial2(){
       TreeSet<ParCliProdsComprados> clientes=new TreeSet<>(new ComparatorProdutosEQuantidade());
       
       compradoresFilial2.forEach( (Cliente k,Double v) ->  {
              ParCliProdsComprados pcpc = new ParCliProdsComprados();
              pcpc.adicionaProduto(k.getCodigo());
              pcpc.adicionaTotal(v.intValue());
              clientes.add(pcpc);
            
           });
        
        
    return clientes;
    } 
   
     
      public TreeSet<ParCliProdsComprados> maioresCompradoresFilial3(){
       TreeSet<ParCliProdsComprados> clientes=new TreeSet<>(new ComparatorProdutosEQuantidade());
       
       compradoresFilial3.forEach( (Cliente k,Double v) ->  {
              ParCliProdsComprados pcpc = new ParCliProdsComprados();
              pcpc.adicionaProduto(k.getCodigo());
              pcpc.adicionaTotal(v.intValue());
              clientes.add(pcpc);
            
           });
        
    return clientes;
    } 
    
    /*Querie 8*/
    
    
    public ArrayList<ParCliProdsComprados> compradoresProdutosDiferentes(int X){
         TreeSet<ParCliProdsComprados> clientes=new TreeSet<>(new ComparatorProdutosEQuantidade());
         ArrayList<ParCliProdsComprados> clientesFinal=new ArrayList<>();
         ArrayList<ParCliProdsComprados> clientesAux=new ArrayList<>();

         comprasDoCliente.forEach( (k, v) ->  {
              InfoCliente ip = v;
              int total = ip.quantidadeDeProdDistintos();
              ParCliProdsComprados pcpc = new ParCliProdsComprados();
              pcpc.adicionaProduto(k.getCodigo());
              pcpc.adicionaTotal(total);
              clientes.add(pcpc);
            
           });
       
        clientes.forEach( (v) ->  {  
            clientesAux.add(v.clone());
        });
        
        for(int i=0;i<X && i<clientesAux.size();i++)
            clientesFinal.add(clientesAux.get(i).clone());
        
         
    return clientesFinal;
    }
    
    /* Querie 9 */
    
    
    public ArrayList<ParCliProdsComprados> listaDeClientes(Produto pro,int X) {
        
        TreeSet<ParCliProdsComprados> clientes=new TreeSet<>(new ComparatorProdutosEQuantidade());
        ArrayList<ParCliProdsComprados> clientesFinal=new ArrayList<>();
        ArrayList<ParCliProdsComprados> clientesAux=new ArrayList<>();
        
         comprasDoCliente.forEach( (k, v) ->  {
             InfoCliente ic = v;
             if(ic.existeProduto(pro.clone())) {
                  ParCliProdsComprados pcpc = new ParCliProdsComprados();
                  pcpc.adicionaProduto(k.getCodigo());                  
                  pcpc.adicionaTotal(ic.gastoNoProduto(pro.clone()));
                  clientes.add(pcpc);  
             }            
           });
        clientes.forEach( (v) ->  {  
            clientesAux.add(v.clone());
        });
        
        for(int i=0;i<X && i<clientesAux.size();i++)
            clientesFinal.add(clientesAux.get(i).clone());
        
         
    return clientesFinal;
        
    }
    
    
    
    
    
    @Override
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
