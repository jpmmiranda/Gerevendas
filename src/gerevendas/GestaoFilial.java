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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe que implementa o módulo de Gestão Filial
 *
 * @author Rui Machado, Jose Lima, Jose Mirra, Joao Miranda
 */
public class GestaoFilial implements Serializable {
    
    private HashMap<Cliente,InfoCliente> comprasDoCliente;
    private HashMap<Produto,InfoProduto> comprasDeProduto;
    private HashMap<Cliente,Double> compradoresFilial1;
    private HashMap<Cliente,Double> compradoresFilial2;
    private HashMap<Cliente,Double> compradoresFilial3;
    
    
    
   /**
     * Construtor Vazio
     */
    public GestaoFilial() {
        this.comprasDoCliente = new HashMap<>();
        this.comprasDeProduto = new HashMap<>();
        this.compradoresFilial1=new HashMap<>();
        this.compradoresFilial2=new HashMap<>();
        this.compradoresFilial3=new HashMap<>();

    }
    
    /**
     * Construtor Parametrizado
     * @param comprasDoCliente Map a ser colocado em comprasDoCliente
     * @param comprasDeProduto Map a ser colocado em comprasDProduto
     * @param compras1 Map a ser colocado em compradoresFilial1
     * @param compras2 Map a ser colocado em compradoresFilial2
     * @param compras3 Map a ser colocado em compradoresFilial3
     */
    public GestaoFilial(HashMap<Cliente, InfoCliente> comprasDoCliente, HashMap<Produto, InfoProduto> comprasDeProduto,HashMap<Cliente, Double> compras1,HashMap<Cliente, Double> compras2,HashMap<Cliente, Double> compras3) {
        this.comprasDoCliente = comprasDoCliente;
        this.comprasDeProduto = comprasDeProduto;
        this.compradoresFilial1=compras1;
        this.compradoresFilial2=compras2;
        this.compradoresFilial3=compras3;
    }

     /**
     * Construtor de Cópia
     * @param gf Objecto a ser Copiado
     */
     public GestaoFilial(GestaoFilial gf) {
        this.comprasDoCliente = gf.getComprasDoCliente();
        this.comprasDeProduto = gf.getComprasDeProduto();
        this.compradoresFilial1=gf.getCompradoresFilial1();
        this.compradoresFilial2=gf.getCompradoresFilial2();
        this.compradoresFilial3=gf.getCompradoresFilial3();
    }

    /**
     * 
     * @return Map de ComprasDoCliente
     */   
    public HashMap<Cliente,InfoCliente> getComprasDoCliente() {
        return comprasDoCliente;
    }
    
    /**
     * 
     * @return Map de ComprasDeProduto
     */   
    public HashMap<Produto,InfoProduto> getComprasDeProduto() {
        return comprasDeProduto;
    }
  
    /**
     * 
     * @return Map de CompradoresFilial1
     */   
    private HashMap<Cliente, Double> getCompradoresFilial1() {
        return compradoresFilial1;
    }

    /**
     * 
     * @return Map de CompradoresFilial2
     */   
    private HashMap<Cliente, Double> getCompradoresFilial2() {
        return compradoresFilial2;
    }

    /**
     * 
     * @return Map de CompradoresFilial3
     */   
    private HashMap<Cliente, Double> getCompradoresFilial3() {
        return compradoresFilial3;
    }

     /**
     * Actualiza ComprasDoCliente
     *
     * @param comprasDoCliente compras do cliente a actualizar
     */
    public void setComprasDoCliente(HashMap<Cliente,InfoCliente> comprasDoCliente) {
        this.comprasDoCliente = comprasDoCliente;
    }
    
    /**
     * Actualiza ComprasDeProduto
     *
     * @param comprasDeProduto compras de produto a actualizar
     */
    public void setComprasDeProduto(HashMap<Produto,InfoProduto> comprasDeProduto) {
        this.comprasDeProduto = comprasDeProduto;
    }
    
     /**
     * Actualiza CompradoresFilial1
     *
     * @param compradoresFilial1 compradores da filial 1 a actualizar
     */
    public void setCompradoresFilial1(HashMap<Cliente, Double> compradoresFilial1) {
        this.compradoresFilial1 = compradoresFilial1;
    }
    
    /**
     * Actualiza CompradoresFilial2
     *
     * @param compradoresFilial2 compradores da filial 2 a actualizar
     */
    public void setCompradoresFilial2(HashMap<Cliente, Double> compradoresFilial2) {
        this.compradoresFilial2 = compradoresFilial2;
    }
    
    /**
     * Actualiza CompradoresFilial3
     *
     * @param compradoresFilial3 compradores da filial 3 a actualizar
     */
    public void setCompradoresFilial3(HashMap<Cliente, Double> compradoresFilial3) {
        this.compradoresFilial3 = compradoresFilial3;
    }
    
    /**
     * Adiciona compra de cliente
     *
     * @param v Venda de onde serão retirados os dados da inserção
     * @throws java.lang.CloneNotSupportedException
     */

    public void adicionaComprasCliente(Venda v) throws CloneNotSupportedException {
      
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
    
    /**
     * Adiciona cliente
     *
     * @param cli Cliente a ser adicionado
     * @throws java.lang.CloneNotSupportedException
     */
    
    public void adicionaClienteInicial(Cliente cli) throws CloneNotSupportedException{
        InfoCliente ic = new InfoCliente();
        this.comprasDoCliente.put(cli.clone(), ic);
       

    }

    /**
     * Adiciona produto
     *
     * @param pro Produto a ser adicionado
     * @throws java.lang.CloneNotSupportedException
     */
    public void adicionaProdutoInicial(Produto pro) throws CloneNotSupportedException {
        InfoProduto ip = new InfoProduto();
        this.comprasDeProduto.put(pro.clone(), ip);
    }
    
    /**
     * Adiciona vendas de produto
     *
     * @param v Venda de onde serão retirados os dados da inserção
     * @throws java.lang.CloneNotSupportedException
     */
    
    public void adicionaComprasDeProduto(Venda v) throws CloneNotSupportedException {
       
      
        double preco=v.getPreco();
        int quantidade=v.getQuantidade();
        int mes = v.getMes();
        this.comprasDeProduto.get(v.getProduto()).adicionaInfoProduto(preco,quantidade,mes);

    }
    
    /**
     * @return Total de Clientes Compradores  
     */
    public int getTotalDeClientesCompradores(){
    
        return comprasDoCliente.size();
    }
    
    /**
     * @return Total de produtos diferentes vendidos  
     */  
    public int getTotalProdutosDiferentesComprados(){
        int r=0;
        
        for(InfoProduto ip : comprasDeProduto.values()){
            if(ip.getUnidadesVendidas()!=0) r++;
        }
        return r;
    }
    
    
    
    /**
     * Calcula número de compradores em determindado mês
     * @param mes Mês de onde será calculado os compradores
     * @return Total de compradores em determinada mês  
     */
    public int compradoresMes(int mes) {
        int res=0;
        for (InfoCliente ic : this.comprasDoCliente.values()) {
            
                if (ic.getComprasMesPindice(mes+1)+ic.getComprasMesNindice(mes+1) != 0) {
                    res++;
                }
            }
        
        return res;
    }
    
     /**
     * Calcula total produtos não vendidos (Apoio Query 1)
     * @return Total de produtos não vendidos 
     */
    
    public ArrayList<String> getProdutosNaoComprados (){
        ArrayList <String> Produtos = new ArrayList<>();
        
         comprasDeProduto.forEach( (k,v) ->  {
            
            if (v.getUnidadesVendidas()==0){
                Produtos.add(k.getCodigo());
            }
           });
        
        return Produtos;
    }
    
    
    
     /**
     * Calcula de clientes distintos num dado mês (Apoio Query 2)
     * @param mes Mês a ser calculado o valor.
     * @return Total de clientes distintos
     */
      public int getClientesMes(int mes){
        int totClientes=0;
        for(InfoCliente ic:comprasDoCliente.values()){
            if(ic.getComprasMesNindice(mes)!=0 ||ic.getComprasMesPindice(mes)!=0 ){
                totClientes++;
            }
        }
        
        return totClientes;
    }
    
    
     /**
     * Calcula número de compras, número de produtos e total gasto, de um dado cliente, mensalmente (Apoio Query 3)
     * @param c Cliente
     * @return TrioCliComProFat com os dados recolhidos
     * @throws gerevendas.ClienteNaoExisteExcepcao
     * @throws java.lang.CloneNotSupportedException
     */
      
    public TrioCliComProFat getClienteParaCadaMes(Cliente c) throws ClienteNaoExisteExcepcao, CloneNotSupportedException{
    
        if (!(this.comprasDoCliente.containsKey(c))) {
            throw new ClienteNaoExisteExcepcao(c.getCodigo());
        } else {
            int mes,comprasCliente;
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
    }
      
    /**
     * Calcula número de vendas, número de clientes e total facturado, de um dado produto, mensalmente (Apoio Query 4)
     * @param p Produto
     * @return TrioProdCompCliFat com os dados recolhidos
     * @throws gerevendas.ProdutoNaoExisteExcepcao
     * @throws java.lang.CloneNotSupportedException
     */
      
    public TrioProdCompCliFat getProdutoParaCadaMes(Produto p)throws ProdutoNaoExisteExcepcao, CloneNotSupportedException{
         
        if (!(this.comprasDeProduto.containsKey(p))) {
            throw new ProdutoNaoExisteExcepcao(p.getCodigo());
         } else {
            int mes,comprasProduto;
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
    }
    
    
     /**
     * Calcula lista de produtos comprados por um dado cliente (Apoio Query 5)
     * @param c Cliente
     * @return lista de produtos comprados por um dado cliente
     * @throws gerevendas.ClienteNaoExisteExcepcao
     */
    
    public TreeSet<ParCliProdsComprados> listaDeProdutos(Cliente c) throws ClienteNaoExisteExcepcao{
       
        if (!(this.comprasDoCliente.containsKey(c))) {
            throw new ClienteNaoExisteExcepcao(c.getCodigo());
        } else {
            TreeSet<ParCliProdsComprados> cod;
            InfoCliente ic = comprasDoCliente.get(c);
            cod=(TreeSet<ParCliProdsComprados>) ic.getCodigoProduto().clone();

            return cod;
        } 
    }
    
    /**
     * Calcula quantidade de compradores para determinado produto (Apoio Query 6)
     * @param pro Codigo de Produto
     * @return quantidade de compradores para um dado codigo de produto
     * @throws java.lang.CloneNotSupportedException
     */
    
    public int quantidadeDeCompradores(String pro) throws CloneNotSupportedException{
       int r=0;
       InfoCliente ic;
       Produto p = new Produto(pro);
       for(Cliente cli: comprasDoCliente.keySet()){
           ic=comprasDoCliente.get(cli);
           if(ic.existeProduto(p.clone())) r++;
       }
        return r;
    } 
    
    
    
    
    
     /**
     * Calcula lista dos maiores compradores para a filial 1(Apoio Query 7)
     * @return lista dos maiores compradores para a filial 1
     */
    
    public TreeSet<ParCliProdsComprados> maioresCompradoresFilial1(){
       TreeSet<ParCliProdsComprados> clientes=new TreeSet<>(new ComparatorProdutosEQuantidade());
       
       compradoresFilial1.forEach( (Cliente k,Double v) ->  {
              ParCliProdsComprados pcpc = new ParCliProdsComprados();
                    pcpc.adicionaProduto(k.getCodigo());
                    pcpc.adicionaTotal(v.intValue());
           try {
               clientes.add(pcpc.clone());
           } catch (CloneNotSupportedException ex) {
               Logger.getLogger(GestaoFilial.class.getName()).log(Level.SEVERE, null, ex);
           }
            
           });
    
    return clientes;
    } 
    
     /**
     * Calcula lista dos maiores compradores para a filial 2(Apoio Query 7)
     * @return lista dos maiores compradores para a filial 2
     */
     public TreeSet<ParCliProdsComprados> maioresCompradoresFilial2(){
       TreeSet<ParCliProdsComprados> clientes=new TreeSet<>(new ComparatorProdutosEQuantidade());
       
       compradoresFilial2.forEach( (Cliente k,Double v) ->  {
              ParCliProdsComprados pcpc = new ParCliProdsComprados();
              pcpc.adicionaProduto(k.getCodigo());
              pcpc.adicionaTotal(v.intValue());
           try {
               clientes.add(pcpc.clone());
           } catch (CloneNotSupportedException ex) {
               Logger.getLogger(GestaoFilial.class.getName()).log(Level.SEVERE, null, ex);
           }
            
           });
        
        
    return clientes;
    } 
   
    /**
     * Calcula lista dos maiores compradores para a filial 3(Apoio Query 7)
     * @return lista dos maiores compradores para a filial 3
     */
     public TreeSet<ParCliProdsComprados> maioresCompradoresFilial3(){
       TreeSet<ParCliProdsComprados> clientes=new TreeSet<>(new ComparatorProdutosEQuantidade());
       
       compradoresFilial3.forEach( (Cliente k,Double v) ->  {
              ParCliProdsComprados pcpc = new ParCliProdsComprados();
              pcpc.adicionaProduto(k.getCodigo());
              pcpc.adicionaTotal(v.intValue());
           try {
               clientes.add(pcpc.clone());
           } catch (CloneNotSupportedException ex) {
               Logger.getLogger(GestaoFilial.class.getName()).log(Level.SEVERE, null, ex);
           }
            
           });
        
    return clientes;
    } 
    
    /**
     * Calcula lista com X compradores de produtos diferentes(Apoio Query 8)
     * @param X Tamanho maximo da lista
     * @return lista de ParCliProdsComprados com a informação desejada
     * @throws java.lang.CloneNotSupportedException
     */
    
    public ArrayList<ParCliProdsComprados> compradoresProdutosDiferentes(int X) throws CloneNotSupportedException{
         TreeSet<ParCliProdsComprados> clientes=new TreeSet<>(new ComparatorProdutosEQuantidade());
         ArrayList<ParCliProdsComprados> clientesFinal=new ArrayList<>();
         ArrayList<ParCliProdsComprados> clientesAux=new ArrayList<>();

         comprasDoCliente.forEach( (k, v) ->  {
              InfoCliente ip = v;
              int total = ip.quantidadeDeProdDistintos();
              ParCliProdsComprados pcpc = new ParCliProdsComprados();
              pcpc.adicionaProduto(k.getCodigo());
              pcpc.adicionaTotal(total);
             try {
                 clientes.add(pcpc.clone());
             } catch (CloneNotSupportedException ex) {
                 Logger.getLogger(GestaoFilial.class.getName()).log(Level.SEVERE, null, ex);
             }
            
           });
       
        clientes.forEach( (v) ->  {  
             try {
                 clientesAux.add(v.clone());
             } catch (CloneNotSupportedException ex) {
                 Logger.getLogger(GestaoFilial.class.getName()).log(Level.SEVERE, null, ex);
             }
        });
        
        for(int i=0;i<X && i<clientesAux.size();i++)
            clientesFinal.add(clientesAux.get(i).clone());
        
         
    return clientesFinal;
    }
    
 
    
    /**
     * Calcula lista com X clientes que mais compraram determinado produto (Apoio Query 9)
     * @param pro Produto de quem se calculará os seus compradores
     * @param X Tamanho maximo da lista
     * @return lista de ParCliProdsComprados com a informação desejada
     * @throws gerevendas.ProdutoNaoExisteExcepcao
     * @throws java.lang.CloneNotSupportedException
     */
    public ArrayList<ParCliProdsComprados> listaDeClientes(Produto pro,int X) throws ProdutoNaoExisteExcepcao, CloneNotSupportedException {
    
        if (!(this.comprasDeProduto.containsKey(pro))) {
            throw new ProdutoNaoExisteExcepcao(pro.getCodigo());
        } else {    
            TreeSet<ParCliProdsComprados> clientes=new TreeSet<>(new ComparatorProdutosEQuantidade());
            ArrayList<ParCliProdsComprados> clientesFinal=new ArrayList<>();
            ArrayList<ParCliProdsComprados> clientesAux=new ArrayList<>();

             comprasDoCliente.forEach( (k, v) ->  {
                 InfoCliente ic = v;
                try {
                    if(ic.existeProduto(pro.clone())) {
                        ParCliProdsComprados pcpc = new ParCliProdsComprados();
                        pcpc.adicionaProduto(k.getCodigo());
                        pcpc.adicionaTotal(ic.gastoNoProduto(pro.clone()));
                        try {
                            clientes.add(pcpc.clone());
                        } catch (CloneNotSupportedException ex) {
                            Logger.getLogger(GestaoFilial.class.getName()).log(Level.SEVERE, null, ex);
                        }            
                    }
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(GestaoFilial.class.getName()).log(Level.SEVERE, null, ex);
                }
               });
            clientes.forEach( (v) ->  {  
                try {
                    clientesAux.add(v.clone());
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(GestaoFilial.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

            for(int i=0;i<X && i<clientesAux.size();i++)
                clientesFinal.add(clientesAux.get(i).clone());


        return clientesFinal;
        
        }
    }
    
    
    /**
     * Teste de igualdade da instância actual com o parâmetro 
     * @param o Objecto a ser testado
     * @return Igualdade entre a instância actual e o parâmetro obj
     */
    
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

   /**
     *
     * @return Hashcode
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.comprasDoCliente);
        hash = 97 * hash + Objects.hashCode(this.comprasDeProduto);
        return hash;
    }
     
     /**
     *
     * @return Novo Objecto como cópia da instância Actual
     * @throws java.lang.CloneNotSupportedException
     */
    @Override
    public GestaoFilial clone() throws CloneNotSupportedException {
        return new GestaoFilial(this);
    }

   


  
    
}
