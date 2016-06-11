/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerevendas;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;
import java.util.TreeSet;

/**
 * Classe que implementa a estrutura de dados de um Catálogo de Clientes
 *
 * @author Rui Machado, Jose Lima, Jose Mirra, Joao Miranda
 */
public class CatalogoClientes implements Serializable {

    private HashMap<Character,TreeSet<Cliente>> CatClientes;
    
    
    /**
     * Construtor vazio
     * 
     */
    
    public  CatalogoClientes(){
        this.CatClientes = new HashMap<>();
        for (Character c = 'A'; c <= 'Z'; c++) {
          this.CatClientes.put(c, new TreeSet<>(new ComparatorCodigoCliente()));
        }
    }
    
    /**
     * Construtor de cópia de uma instância da classe CatalogoClientes
     *
     * @param cc Catálogo a ser copiado
     * @throws java.lang.CloneNotSupportedException
     */
    
     public CatalogoClientes(CatalogoClientes cc) throws CloneNotSupportedException {
        this.CatClientes = cc.getCatClientes();
    }
    
    /**
     * 
     * @return Catálogo de Clientes existente no objecto
     * @throws java.lang.CloneNotSupportedException
     */
    public HashMap<Character, TreeSet<Cliente>> getCatClientes() throws CloneNotSupportedException {
        HashMap<Character, TreeSet<Cliente>> res = new HashMap<>();
        TreeSet<Cliente> aux;
        Character counter = 'A';
        for (TreeSet<Cliente> c : this.CatClientes.values()) {
            aux = new TreeSet<>();
            for (Cliente cli : c) {
                aux.add(cli.clone());
            }
            res.put(counter, aux);
            counter++;
        }
        return res;
    }
     
    /**
     * Método que adiciona um cliente ao catalogo
     *
     * @param cli Cliente a ser inserido
     * @throws java.lang.CloneNotSupportedException
     */
    
   public void adicionaCliente(Cliente cli) throws CloneNotSupportedException {
        String cod = cli.getCodigo();
        Character c= Character.toUpperCase(cod.charAt(0));
        this.CatClientes.get(c).add(cli.clone());
    }
   
   
   /**
     * Método que calcula total de clientes
     * @return total de clientes
     */
    public int totalClientes(){
    
        int r=0;
        for (Character c = 'A'; c <= 'Z'; c++) {
         r+= CatClientes.get(c).size();
        }
        return r;
    }
   
   /**
     * Método de verificação da existência de um Cliente no catálogo de Clientes
     * @param cli Código a ser verificado
     * @return Existência do Código
     */
    public boolean existeCliente(Cliente cli) {

        
        String cod = cli.getCodigo();
        Character c= Character.toUpperCase(cod.charAt(0));
        return this.CatClientes.get(c).contains(cli);
    }

      
    /**
     * Método hashcode
     * @return valor de hash
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.CatClientes);
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
        
        final CatalogoClientes other = (CatalogoClientes) obj;
        if (!Objects.equals(this.CatClientes, other.CatClientes)) {
            return false;
        }
        return true;
    }
    
    /**
     * Método clone
     * @return Uma nova instância de CatalogoClientes 
     * @throws java.lang.CloneNotSupportedException 
     */
    @Override
    public CatalogoClientes clone() throws CloneNotSupportedException {
        return new CatalogoClientes(this);
    }
    
    

}
    

