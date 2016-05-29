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
public class ParCliProdsComprados {
    
    private int total=0;
    private String produto;

    /**
     * Construtor Vazio
     */
    public ParCliProdsComprados() {
       this.produto = "";
        this.total = 0;
    }

    
   
    public ParCliProdsComprados(ParCliProdsComprados pcpc) {
         this.produto = pcpc.getProdutos();
        this.total = pcpc.getTotal();
        
    }

    public int getTotal() {
        return total;
    }

    public String getProdutos() {
        return produto;
    }

    
  
    
    public void adicionaProduto(String Produto) {
        this.produto=Produto;
   
    }

    public void adicionaTotal(int total) {
        this.total=total;
   
    }
    
    
    
    
    public ParCliProdsComprados clone() {
        return new ParCliProdsComprados(this);
    }
    
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((!(this.getClass().getSimpleName().equals(o.getClass().getSimpleName()))) || o == null) {
            return false;
        } else {
           ParCliProdsComprados t = (ParCliProdsComprados) o;
            return  (this.total == t.getTotal()&& produto.equals(t.getProdutos())) ;
    }
    }

    

   
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

       
        sb.append("Produto : ").append(produto).append("\n");
        
        
        
        sb.append("Numero Total: ").append(getTotal()).append("\n");
       
        return sb.toString();
    }

    
}
