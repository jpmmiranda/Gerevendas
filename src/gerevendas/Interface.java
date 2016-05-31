/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.io.IOException;
import java.io.Serializable;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Rui
 */
public class Interface implements Serializable{

    
    private static int initCli;
    private static int initPro;
    private static int initVendas;

   
   
    
    
    private Interface() {
        
        initCli=0;
        initPro=0;
        initVendas=0;
    }
    
    public static void printMenu() throws CloneNotSupportedException, IOException, ClassNotFoundException {
        
        int opcao;
        boolean r = true;
        
        while(r){
        System.out.println("################## GEREVENDAS ##################");
	System.out.println("# 1. Ler Ficheiros.                            #");
	System.out.println("# 2. Consultas Estatisticas.                   #");
        System.out.println("# 3. Consultas Interactivas.                   #");
        System.out.println("# 4. Carregar/Guardar Ficheiros Objecto        #");
	System.out.println("# 0. Sair                                      #");
	System.out.println("################################################");
        System.out.print(">");
        opcao = Input.lerInt();
        switch (opcao) {
            case 0:
                System.exit(0);
                break;
            case 1:
                menuLerFicheiros();
                r = false;
                break;
            case 2:
                printEstatisticas();
                r = false;
                break;
            case 3:
                printQueries();
                r = false;
                break;
            case 4:
                menuCarregarGuardar();
                r = false;
                break;
            default:
                break;
        }
        }
   }
    
    public static void menuLerFicheiros() throws CloneNotSupportedException, IOException, ClassNotFoundException{
	int r = 0, n = 0;

	printInicializar();
	r = Input.lerInt();
            switch(r){
			case 1:
				if(initVendas == 1){
				        Crono.start();
                                        limpaEcra();
					Leitura.lerClientes();
					initCli = 1;
					initVendas = 0;
                                        Crono.stop();
                                        System.out.println("Tempo: " + Crono.print() ); 
					menuLerFicheiros();
				}
				else{
                                        Crono.start();

					limpaEcra();
					Leitura.lerClientes();
					initCli = 1;
                                        Crono.stop();
                                        System.out.println("Tempo: " + Crono.print() );    
					menuLerFicheiros();
				}
				break;
			case 2:
				if(initVendas == 1){
                                        Crono.start();

					limpaEcra();
					Leitura.lerProdutos();
					initPro = 1;
					initVendas = 0;
                                        Crono.stop();
                                        System.out.println("Tempo: " + Crono.print() ); 
                    			menuLerFicheiros();

				}
				else{   Crono.start();

					limpaEcra();
					Leitura.lerProdutos();
					initPro = 1;
                                        Crono.stop();
                                        System.out.println("Tempo: " + Crono.print() );
                                        menuLerFicheiros();

				}
				break;
			case 3:
				if(initCli == 0 || initPro == 0){
					limpaEcra();
					System.out.print("Tem que inicializar clientes e produtos primeiro.\n");
					menuLerFicheiros();					
				}
				else{
                                    Crono.start();
					limpaEcra();
					Leitura.lerVendas();
					initVendas = 1;
                                        Crono.stop();
                    System.out.println("Tempo: " + Crono.print() );
					menuLerFicheiros();
				}
				break;
			case 4:
                                Crono.start();

				limpaEcra();
				Leitura.lerClientes();
				initCli = 1;
				Leitura.lerProdutos();
				initPro = 1;
				Leitura.lerVendas();
				initVendas = 1;
                                Crono.stop();
                                System.out.println("Tempo: " + Crono.print() );
			        menuLerFicheiros();
                                                    

				break;
			case 0:
				limpaEcra();
				printMenu();
				r = 0;
				break;
			default:				
				System.out.print("Opção inválida.\n");
				menuLerFicheiros();
		}
}
	
   

    
    
    
    
    private static void printInicializar(){
    
	if(initPro == 1 && initCli == 1 && initVendas == 1){
		System.out.print("################## GEREVENDAS ##################\n");
		System.out.print("# 1. Reinicializar clientes.                   #\n");
		System.out.print("# 2. Reinicializar produtos.                   #\n");
		System.out.print("# 3. Reinicializar vendas.                     #\n");
		System.out.print("# 4. Reinicializar tudo.                       #\n");
		System.out.print("# 0. Voltar ao menu inicial.                   #\n");
		System.out.print("################################################\n");
		System.out.print(">");
		
	}
	else if(initPro == 1 && initCli == 1){
		System.out.print("################## GEREVENDAS ##################\n");
		System.out.print("# 1. Reinicializar clientes.                   #\n");
		System.out.print("# 2. Reinicializar produtos.                   #\n");
                System.out.print("# 3. Inicializar vendas.                       #\n");
		System.out.print("# 4. Inicializar tudo.                         #\n");
		System.out.print("# 0. Voltar ao menu inicial.                   #\n");
                System.out.print("################################################\n");
                System.out.print(">");
	}
	else if(initPro == 1){
		System.out.print("################## GEREVENDAS ##################\n");
                System.out.print("# 1. Inicializar clientes.                     #\n");
	        System.out.print("# 2. Reinicializar produtos.                   #\n");
	        System.out.print("# 3. Inicializar vendas. (Não disponivel)      #\n");
	        System.out.print("# 4. Inicializar tudo.                         #\n");
                System.out.print("# 0. Voltar ao menu inicial.                   #\n");
		System.out.print("################################################\n");
		System.out.print(">");
		
	}
	else if(initCli == 1){
		System.out.print("################## GEREVENDAS ##################\n");
		System.out.print("# 1. Reinicializar clientes.                   #\n");
		System.out.print("# 2. Inicializar produtos.                     #\n");
		System.out.print("# 3. Inicializar vendas. (Não disponivel)      #\n");
		System.out.print("# 4. Inicializar tudo.                         #\n");
		System.out.print("# 0. Voltar ao menu inicial.                   #\n");
		System.out.print("################################################\n");
		System.out.print(">");
	}
	else{
		System.out.print("################## GEREVENDAS ##################\n");
                System.out.print("# 1. Inicializar clientes.                     #\n");
		System.out.print("# 2. Inicializar produtos.                     #\n");
		System.out.print("# 3. Inicializar vendas. (Não disponivel)      #\n");
		System.out.print("# 4. Inicializar tudo.                         #\n");
		System.out.print("# 0. Voltar ao menu inicial.                   #\n");
		System.out.print("################################################\n");
		System.out.print(">");
	}

}

    
    
    public static void printEstatisticas() throws CloneNotSupportedException, IOException, ClassNotFoundException{
      
         
        int opcao;
        boolean r = true;
                Queries querie = new Queries();

        while(r){
            System.out.println("####################### GEREVENDAS #################################");
            System.out.println("  1. Dados gerais acerca do último ficheiro lido e estruturais     #");
            System.out.println("  0. Sair                                                          #");
            System.out.println("####################################################################");
            System.out.print(">");
            opcao = Input.lerInt();
            switch (opcao) {
                case 0:
                    printMenu();
                    break;
                case 1:
                    querie.querieEstat();
                    r = false;
                    break;
                default:
                    break;
            }
        }
}
    
    public static void printQueries() throws CloneNotSupportedException, IOException, ClassNotFoundException{
          
        int opcao;
        boolean r = true;
        Queries querie = new Queries();
        Scanner linha = new Scanner(System.in);
        String Cliente;
        int valor;
        while(r){
            System.out.println("################################################################################## GEREVENDAS ##################################################################################");
            System.out.println("  1. Lista ordenada alfabeticamente com os códigos dos produtos nunca comprados e o seu respectivo total;");
            System.out.println("  2. Dado um mês válido, determinar o número total global de vendas realizadas e o número total de clientes distintos que as fizeram;");
            System.out.println("  3. Dado um código de cliente, determinar, para cada mês, quantas compras fez, quantos produtos distintos comprou e quanto gastou no total.");
            System.out.println("  4. Dado o código de um produto existente, determinar, mês a mês, quantas vezes foi comprado, por quantos clientes diferentes e o total facturado");
            System.out.println("  5. Dado o código de um cliente determinar a lista de códigos de produtos que mais comprou (e quantos), ordenada por ordem decrescente de quantidade e, para quantidades iguais, por ordem alfabética dos códigos;");
            System.out.println("  6. Determinar o conjunto dos X produtos mais vendidos em todo o ano (em número de unidades vendidas) indicando o número total de distintos clientes que o compraram (X é um inteiro dado pelo utilizador);");
            System.out.println("  7. Determinar, para cada filial, a lista dos três maiores compradores em termos de dinheiro facturado;");
            System.out.println("  8. Determinar os códigos dos X clientes (sendo X dado pelo utilizador) que compraram mais produtos diferentes (não interessa a quantidade nem o valor), indicando quantos, sendo o critério de ordenação a ordem decrescente do número de produtos;");
            System.out.println("  9. Dado o código de um produto que deve existir, determinar o conjunto dos X clientes que mais o compraram e, para cada um, qual o valor gasto (ordenação cf. 5);");
            System.out.println("  0. Sair ");
            System.out.println("################################################################################################################################################################################");
            System.out.print(">");
            opcao = Input.lerInt();
            switch (opcao) {
                case 0:
                    printMenu();
                    break;
                case 1:
                    querie.Querie1();
                    printQueries();
                    r = false;
                    break;
                case 2:
                    System.out.println("Insira um mês");
                    int mes= Input.lerInt();
                    if(mes>=1 && mes<=12){
                       querie.Querie2(mes);
                    }else{
                    System.out.println("Mês invalido, insira mês entre 1 e 12");

                    }
                    printQueries();
                    r = false;
                    break;
                 case 3:
                    System.out.println("Insira um Cliente");
                    Cliente= linha.next();
                    
                       querie.Querie3(Cliente);
                   
                    
                    printQueries();
                    r = false;
                    break;
                 case 4:
                    System.out.println("Insira um Produto");
                    String Produto= linha.next();
                    
                       querie.Querie4(Produto);
                   
                    
                    printQueries();
                    r = false;
                    break;
               case 5:
                    System.out.println("Insira um Cliente");
                     Cliente= linha.next();
                    
                       querie.Querie5(Cliente);
                   
                    
                    printQueries();
                    r = false;
                    break;
              case 6:
                    System.out.println("Insira um valor");
                     valor= linha.nextInt();
                    
                       querie.Querie6(valor);
                   
                    
                    printQueries();
                    r = false;
                    break;
              case 7:
                    
                   querie.Querie7();
                   
                    
                    printQueries();
                    r = false;
                    break;
             case 8:
                   System.out.println("Insira um valor");
                   valor= linha.nextInt();
                    
                   querie.Querie8(valor);
                    
                    printQueries();
                    r = false;
                    break;
             case 9:
                    System.out.println("Insira um Produto");
                    Produto= linha.next();
                    System.out.println("Insira um valor");
                    valor= linha.nextInt();
                    querie.Querie9(Produto,valor);
                    printQueries();
                    r = false;
                    break;
                default:
                    break;
            }
            }
    }

 private static void menuCarregarGuardar() throws CloneNotSupportedException, IOException, ClassNotFoundException {

        int opcao;
        boolean r = true;
        Queries querie = new Queries();
        String input;
        while(r){
            System.out.println("####################### GEREVENDAS #################################");
            System.out.println("  1.Guardar  Ficheiro objecto                                      #");
            System.out.println("  2.Carregar Ficheiro objecto                                      #");
            System.out.println("  0. Sair                                                          #");
            System.out.println("####################################################################");
            System.out.print(">");
            opcao = Input.lerInt();
            switch (opcao) {
                case 0:
                    printMenu();
                    break;
                case 1:
                    System.out.println("Insira o nome do ficheiro a gravar(Prima Enter para hipermercado.dat): ");
                    input = Input.lerString();
                    querie.guardaDados(input);
                    r = false;
                    menuCarregarGuardar();
                    break;
                case 2:
                    System.out.println("Insira o nome do ficheiro a carregar(Prima Enter para hipermercado.dat): ");
                    input = Input.lerString();
                    querie.carregaDados(input);
                    r = false;
                    menuCarregarGuardar();
                    break;    
                default:
                    break;
            }
        }
    }

    private static void limpaEcra(){
        System.out.print("\033");//Nao funciona
    }

}

     

