
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;



/**
 * Classe Queries
 *
 * @author Rui Machado, Jose Lima, Jose Mirra, Joao Miranda
 */
public class Queries {
  
 
    public static CatalogoClientes catalogoClientes;
    public static CatalogoProdutos catalogoProdutos;
    public static Facturacao facturacao;
    public static GestaoFilial gestaofilial;
    public static Estatistica estatistica;
  
    
    /**
     * Metodo guarda dados em ficheiro objecto
     * @param input Nome do ficheiro
    */
    public void guardaDados(String input){
    
            String ficheiro;
            try {
                Hipermercado hiper = Gerevendas.getHipermercado();

                 if (input.equals("")) ficheiro = "hipermercado.dat";
                 else ficheiro = input;
                
                Crono.start();
                hiper.guardaObj(ficheiro);
                Crono.stop();              
                System.out.println("Tempo " + Crono.print());
                sair(); 
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
    
    }
    
    
    /**
     * Metodo carrega dados de ficheiro objecto
     * @param input Nome do ficheiro
    */
    public void carregaDados(String input) throws IOException, ClassNotFoundException{
    
      
        String ficheiro;
        
            Hipermercado hiper = Gerevendas.getHipermercado();           
           if (input.equals("")) ficheiro = "hipermercado.dat";
           else ficheiro = input;
            Crono.start();
             Gerevendas.setHipermercado(hiper.carregaObj(ficheiro));
            Crono.stop();
            System.out.println("Tempo " + Crono.print());
            sair();
          
    
    }
    
    /**
     * Metodo Query estatistica
    */
    public void querieEstat(){
      
      Crono.start();
      estatistica = Gerevendas.getHipermercado().getEstatistica();
      Crono.stop();
      System.out.println("Tempo: " + Crono.print() );
      saiTempos();
      System.out.println(estatistica.toString());
      sair(); 
    
    }
   /**
     * Metodo Query 1
    */
  
    public void Querie1(){
       Crono.start();
      gestaofilial = Gerevendas.getHipermercado().getGestfilial();
      int aux=0;
      ArrayList<String> ProdutosNaoComprados = gestaofilial.getProdutosNaoComprados();
      Collections.sort(ProdutosNaoComprados);
      Crono.stop();
      System.out.println("Tempo: " + Crono.print() );
      saiTempos(); 
      printQuerie1(ProdutosNaoComprados,aux,aux,ProdutosNaoComprados.size());
     

    }
      
   /**
     * Metodo Query 2
     * @param mes Mes usado para resolução da query
    */
    public void Querie2(int mes){
        Crono.start(); 
        facturacao = Gerevendas.getHipermercado().getFaturacao();
        gestaofilial = Gerevendas.getHipermercado().getGestfilial();
        int clientes=gestaofilial.getClientesMes(mes);
        int vendas =  facturacao.vendasMensais(mes);
        Crono.stop();
        System.out.println("Tempo: " + Crono.print() );
        saiTempos();
        System.out.println("Total de vendas no mes "+mes+": "+vendas);
        System.out.println("Total de clientes que compraram no mes "+mes+": "+clientes);
        sair();   

        
    }
    
    /**
     * Metodo Query 3
     * @param cliente Cliente usado para resolução da query
    */
    public void Querie3(String cliente){
        
        Crono.start();
        gestaofilial = Gerevendas.getHipermercado().getGestfilial();
        
        Cliente cli = new Cliente(cliente);
        
        TrioCliComProFat  tcpf = gestaofilial.getClienteParaCadaMes(cli);
         Crono.stop();
        System.out.println("Tempo: " + Crono.print() );
        saiTempos();
        System.out.println(tcpf.toString());
        sair();
                    
    }
    
    /**
     * Metodo Query 4
     * @param produto Produto usado para resolução da query
    */
    public void Querie4(String produto){
        
        Crono.start();  
        gestaofilial = Gerevendas.getHipermercado().getGestfilial();
        
        Produto prod = new Produto(produto);
        
        TrioProdCompCliFat  tcpf = gestaofilial.getProdutoParaCadaMes(prod);
         Crono.stop();
         System.out.println("Tempo: " + Crono.print() );
        saiTempos();
        System.out.println(tcpf.toString());
        sair();   
    }
        
     /**
     * Metodo Query 5
     * @param cliente Cliente usado para resolução da query
    */
    public void Querie5(String cliente){
    
        Crono.start();
        int tamanho,aux=0;
        gestaofilial = Gerevendas.getHipermercado().getGestfilial();
        
        Cliente cli = new Cliente(cliente);
        
        TreeSet<ParCliProdsComprados>  pcpc = gestaofilial.listaDeProdutos(cli);
         Crono.stop();
        System.out.println("Tempo: " + Crono.print() );
        saiTempos();
         ArrayList<ParCliProdsComprados> imprime = new ArrayList<>(pcpc);
        tamanho = imprime.size();
        printQuerie5(imprime,aux,aux,tamanho);
    }
    
     /**
     * Metodo Query 6
     * @param X Valor usado para resolução da query
    */
    public void Querie6(int X){
        Crono.start(); 
        
        facturacao = Gerevendas.getHipermercado().getFaturacao();
        gestaofilial = Gerevendas.getHipermercado().getGestfilial();

        int tamanho,aux=0;
        ArrayList<Integer> compradores = new ArrayList<>();
        ArrayList<ParCliProdsComprados> pcpc = facturacao.listaDeXProdutos(X);
        
        pcpc.forEach( (v) ->  {
           compradores.add(gestaofilial.quantidadeDeCompradores(v.getProdutos()));
        });      
            
       Crono.stop();
       System.out.println("Tempo: " + Crono.print() );
       saiTempos();
       tamanho=pcpc.size();
       printQuerie6(pcpc,compradores,aux,aux,tamanho);
      
    }
    
     /**
     * Metodo Query 7
    */
    public void Querie7(){
        
         Crono.start();
        gestaofilial = Gerevendas.getHipermercado().getGestfilial();
        int i=0;
        TreeSet<ParCliProdsComprados>  pcpc1 = gestaofilial.maioresCompradoresFilial1();
        TreeSet<ParCliProdsComprados>  pcpc2 = gestaofilial.maioresCompradoresFilial2();
        TreeSet<ParCliProdsComprados>  pcpc3 = gestaofilial.maioresCompradoresFilial3();
         Crono.stop();
        System.out.println("Tempo: " + Crono.print() );
        saiTempos();
        System.out.println("Três Maiores Compradores da Filial 1: ");
        Iterator<ParCliProdsComprados> iterator = pcpc1.iterator();
            while (iterator.hasNext() && i<3) {
                ParCliProdsComprados pc=iterator.next();
                System.out.println("Clientes : " + pc.getProdutos() + "\n" + "Valor Gasto: " + pc.getTotal()  + "\n");
                 i++;

                }

        System.out.println("Três Maiores Compradores da Filial 2: ");
        System.out.println();

        i=0;
        Iterator<ParCliProdsComprados> iterator2 = pcpc2.iterator();
            while (iterator2.hasNext() && i<3) {
                ParCliProdsComprados pc=iterator2.next();
                System.out.println("Clientes : " + pc.getProdutos() + "\n" + "Valor Gasto: " + pc.getTotal()  + "\n");
                 i++;

                }

        System.out.println("Três Maiores Compradores da Filial 3: ");
        System.out.println();
        i=0;
        Iterator<ParCliProdsComprados> iterator3 = pcpc3.iterator();
            while (iterator3.hasNext() && i<3) {
                ParCliProdsComprados pc=iterator3.next();
                System.out.println("Clientes : " + pc.getProdutos() + "\n" + "Valor Gasto: " + pc.getTotal()  + "\n");
                 i++;

                }

            sair();
        
    
    }
    
     /**
     * Metodo Query 8
     * @param X Valor usado para resolução da query
    */
    public void Querie8(int X){
        
         Crono.start();
        gestaofilial = Gerevendas.getHipermercado().getGestfilial();
        int tamanho,aux=0;
        
        ArrayList<ParCliProdsComprados>  pcpc = gestaofilial.compradoresProdutosDiferentes(X);
        Crono.stop();
         System.out.println("Tempo: " + Crono.print() );
         saiTempos();
         tamanho=pcpc.size();
        printQuerie8(pcpc,aux,aux,tamanho);
    }
    
     /**
     * Metodo Query 9
     * @param produto Produto usado para resolução da query
     * @param X Valor usado para resolução da query
    */
    public void Querie9(String produto, int X){
        
         Crono.start();
        gestaofilial = Gerevendas.getHipermercado().getGestfilial();
        
        Produto pro = new Produto(produto);
        int tamanho;
        int aux=0;
        ArrayList<ParCliProdsComprados>  pcpc = gestaofilial.listaDeClientes(pro.clone(),X);
        Crono.stop();
        System.out.println("Tempo: " + Crono.print() );
        saiTempos();
        tamanho = pcpc.size();
        printQuerie9(pcpc,aux,aux,tamanho);

      
    }
    
    /**
     * Metodo responsavel pelo output do resultado da query 1
     * @param pcpc Lista de produtos
     * @param contador Valor usado para a impressao dos resultados
     * @param index Valor usado para a impressao dos resultados
     * @param tamanho Tamanho da lista
    */
     private void printQuerie1(ArrayList<String> pcpc, int contador, int index,int tamanho){
	int n,i ;
        gestaofilial = Gerevendas.getHipermercado().getGestfilial();

	System.out.println("########################## GEREVENDAS ##########################\n");
        
        for (i=0;i < 10 && index < tamanho; i++){
            System.out.println("Produto: " + pcpc.get(index) + "\n");
	    contador++;
	    index++;
            
	}		
        System.out.println("# Total:  " + tamanho +"                                           #\n");
	System.out.println("################################################################\n");
	System.out.println("# 1. Continuar.                                                #\n");
	System.out.println("# 2. Retroceder.                                               #\n");
	System.out.println("# 0. Sair.                                                     #\n");
	System.out.println("################################################################\n");
	System.out.println(">");
	n = Input.lerInt();
	if(n > 0){
		if(n == 1 && contador != tamanho){
			printQuerie1(pcpc, contador, index++,tamanho);
		}
		else if(n == 1 && contador ==tamanho){
			System.out.println("Impossível continuar.\n");
			printQuerie1(pcpc, contador-i, index-i,tamanho);
		}
		else if(n == 2 && (contador-10) > 0){
			printQuerie1(pcpc, contador-20, index-20,tamanho);
		}
		else if(n == 2 && (contador-10) <= 0){
			System.out.println("Impossível retroceder.\n");
			printQuerie1(pcpc, 0, 0,tamanho);
		}
		else if(n == 0){
			sair();
		}
		else{
			System.out.println("Comando inválido\n");
			printQuerie1(pcpc, contador-i, index-i,tamanho);
		}
	}
    } 
    
    /**
     * Metodo responsavel pelo output do resultado da query 5
     * @param pcpc Lista de ParCliProdsComprados
     * @param contador Valor usado para a impressao dos resultados
     * @param index Valor usado para a impressao dos resultados
     * @param tamanho Tamanho da lista
    */
     private void printQuerie5(ArrayList<ParCliProdsComprados> pcpc, int contador, int index,int tamanho){
	int n , i;
        gestaofilial = Gerevendas.getHipermercado().getGestfilial();

	System.out.println("########################## GEREVENDAS ##########################\n");
        
        for (i=0;i < 10 && index < tamanho; i++){
            System.out.println("Produto: " + pcpc.get(index).getProdutos() + "\n" + "Quantidade: "+ pcpc.get(index).getTotal() + "\n");
	    contador++;
	    index++;
            
	}			
	System.out.print("################################################################\n");
	System.out.print("# 1. Continuar.                                                #\n");
	System.out.print("# 2. Retroceder.                                               #\n");
	System.out.print("# 0. Sair.                                                     #\n");
	System.out.print("################################################################\n");
	System.out.print(">");
	n = Input.lerInt();
	if(n > 0){
		if(n == 1 && contador != tamanho){
			printQuerie5(pcpc, contador, index++,tamanho);
		}
		else if(n == 1 && contador ==tamanho){
			System.out.println("Impossível continuar.\n");
			printQuerie5(pcpc, contador-i, index-i,tamanho);
		}
		else if(n == 2 && (contador-10) > 0){
			printQuerie5(pcpc, contador-20, index-20,tamanho);
		}
		else if(n == 2 && (contador-10) <= 0){
			System.out.println("Impossível retroceder.\n");
			printQuerie5(pcpc, 0, 0,tamanho);
		}
		else if(n == 0){
			sair();
		}
		else{
			System.out.println("Comando inválido\n");
			printQuerie5(pcpc, contador-i, index-i,tamanho);
		}
	}
 }
    
    /**
     * Metodo responsavel pelo output do resultado da query 6
     * @param pcpc Lista de ParCliProdsComprados
     * @param cp Lista de inteiros
     * @param contador Valor usado para a impressao dos resultados
     * @param index Valor usado para a impressao dos resultados
     * @param tamanho Tamanho da lista
    */
   private void printQuerie6(ArrayList<ParCliProdsComprados> pcpc,ArrayList<Integer> cp, int contador, int index,int tamanho){
	int n , i;
        gestaofilial = Gerevendas.getHipermercado().getGestfilial();

	System.out.println("########################## GEREVENDAS ##########################\n");
        
        for (i=0;i < 10 && index < tamanho; i++){
            System.out.println(pcpc.get(index).toString() + "Clientes Distintos: " + cp.get(index) + "\n");
	    contador++;
	    index++;
	}			
	System.out.print("################################################################\n");
	System.out.print("# 1. Continuar.                                                #\n");
	System.out.print("# 2. Retroceder.                                               #\n");
	System.out.print("# 0. Sair.                                                     #\n");
	System.out.print("################################################################\n");
	System.out.print(">");
	n = Input.lerInt();
	if(n > 0){
		if(n == 1 && contador != tamanho){
			printQuerie6(pcpc,cp, contador, index++,tamanho);
		}
		else if(n == 1 && contador == tamanho){
			System.out.println("Impossível continuar.\n");
			printQuerie6(pcpc,cp, contador-i, index-i,tamanho);
		}
		else if(n == 2 && (contador-20) >= 0){
			printQuerie6(pcpc,cp, contador-20, index-20,tamanho);
		}
		else if(n == 2 && (contador-20) <= 0){
			System.out.println("Impossível retroceder.\n");
			printQuerie6(pcpc,cp, 0, 0,tamanho);
		}
		else if(n == 0){
			sair();
		}
		else{
			System.out.println("Comando inválido\n");
			printQuerie6(pcpc,cp, contador-i, index-i,tamanho);
		}
	}
}
    /**
     * Metodo responsavel pelo output do resultado da query 8
     * @param pcpc Lista de ParCliProdsComprados
     * @param contador Valor usado para a impressao dos resultados
     * @param index Valor usado para a impressao dos resultados
     * @param tamanho Tamanho da lista
    */
     void printQuerie8(ArrayList<ParCliProdsComprados> pcpc, int contador, int index,int tamanho){
	int n , i;

	System.out.println("########################## GEREVENDAS ##########################\n");
        
        for (i=0;i < 10 && index < tamanho; i++){
            System.out.println("Cliente: " + pcpc.get(index).getProdutos() + "\n" + "Numero de Produtos Comprados: "+ pcpc.get(index).getTotal() + "\n");
	    contador++;
	    index++;
            
	}			
	System.out.print("################################################################\n");
	System.out.print("# 1. Continuar.                                                #\n");
	System.out.print("# 2. Retroceder.                                               #\n");
	System.out.print("# 0. Sair.                                                     #\n");
	System.out.print("################################################################\n");
	System.out.print(">");
	n = Input.lerInt();
	if(n > 0){
		if(n == 1 && contador !=tamanho){
			printQuerie8(pcpc, contador, index++,tamanho);
		}
		else if(n == 1 && contador == tamanho){
			System.out.println("Impossível continuar.\n");
			printQuerie8(pcpc, contador-i, index-i,tamanho);
		}
		else if(n == 2 && (contador-20) >= 0){
			printQuerie8(pcpc, contador-20, index-20,tamanho);
		}
		else if(n == 2 && (contador-20) <= 0){
			System.out.println("Impossível retroceder.\n");
			printQuerie8(pcpc, 0, 0,tamanho);
		}
		else if(n == 0){
			sair();
		}
		else{
			System.out.println("Comando inválido\n");
			printQuerie8(pcpc, contador-i, index-i,tamanho);
		}
	}
}
    
    /**
     * Metodo responsavel pelo output do resultado da query 6
     * @param pcpc Lista de ParCliProdsComprados
     * @param contador Valor usado para a impressao dos resultados
     * @param index Valor usado para a impressao dos resultados
     * @param tamanho Tamanho da lista
    */
   private void printQuerie9(ArrayList<ParCliProdsComprados> pcpc, int contador, int index,int tamanho){
	int n , i;

	System.out.println("########################## GEREVENDAS ##########################\n");
        
        for (i=0;i < 10 && index <tamanho ; i++){
            System.out.println("Cliente: " + pcpc.get(index).getProdutos() + "\n" + "Valor: "+ pcpc.get(index).getTotal() + "\n");
	    contador++;
	    index++;
            
	}			
	System.out.print("################################################################\n");
	System.out.print("# 1. Continuar.                                                #\n");
	System.out.print("# 2. Retroceder.                                               #\n");
	System.out.print("# 0. Sair.                                                     #\n");
	System.out.print("################################################################\n");
	System.out.print(">");
	n = Input.lerInt();
	if(n > 0){
		if(n == 1 && contador != tamanho){
			printQuerie9(pcpc, contador, index++,tamanho);
		}
		else if(n == 1 && (contador == tamanho)){
			System.out.println("Impossível continuar.\n");
			printQuerie9(pcpc, contador-i, index-i,tamanho);
		}
		else if(n == 2 && (contador-20) >= 0){
			printQuerie9(pcpc, contador-20, index-20,tamanho);
		}
		else if(n == 2 && (contador-20) <= 0){
			System.out.println("Impossível retroceder.\n");
			printQuerie9(pcpc, 0, 0,tamanho);
		}
		else if(n == 0){
			sair();
		}
		else{
			System.out.println("Comando inválido\n");
			printQuerie9(pcpc, contador-i, index-i,tamanho);
		}
	}
}
    /**
     * Metodo voltar ao menu 
    */
    private static void sair(){
        System.out.println("Prima Enter para sair");
        String c=Input.lerString();
        while(c.endsWith("\n")){
            c = Input.lerString();
        }
   
    }

    /**
     * Metodo sai da apresentacao dos tempos
    */
    private static void saiTempos(){
        System.out.println("Prima Enter para apresentar resultados");
        String c=Input.lerString();
        while(c.endsWith("\n")){
            c = Input.lerString();
        }
   
    }
}